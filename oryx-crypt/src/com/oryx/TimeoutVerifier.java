/*
 * Copyright 2008 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.oryx;

import com.oryx.enums.KeyPurpose;
import com.oryx.exceptions.KeyczarException;
import com.oryx.exceptions.ShortSignatureException;
import com.oryx.interfaces.KeyczarReader;
import com.oryx.util.Base64Coder;
import com.oryx.util.Clock;
import com.oryx.util.SystemClock;
import com.oryx.util.Util;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/**
 * TimeoutVerifiers verify timeout signatures generated by
 * {@link TimeoutSigner} objects
 *
 * @author steveweis@gmail.com (Steve Weis)
 */
public class TimeoutVerifier {
    private Verifier verifier;
    private Clock clock = new SystemClock();

    TimeoutVerifier() {
        // Do nothing here.
    }

    /**
     * Initialize a new TimeoutVerifier with a KeyczarReader.
     * The corresponding key set must have a purpose
     * {@link KeyPurpose#VERIFY}.
     *
     * @param reader A reader to read keys from
     * @throws KeyczarException In the event of an IO error reading keys or if the
     *                          key set does not have the appropriate purpose.
     */
    public TimeoutVerifier(KeyczarReader reader) throws KeyczarException {
        setVerifier(new Verifier(reader));
    }

    /**
     * Initialize a new TimeoutVerifier with a key set location. This will
     * attempt to read the keys using a KeyczarFileReader. The corresponding
     * key set must have a purpose of
     * {@link KeyPurpose#VERIFY}.
     *
     * @param fileLocation Directory containing a key set
     * @throws KeyczarException In the event of an IO error reading keys or if the
     *                          key set does not have the appropriate purpose.
     */
    public TimeoutVerifier(String fileLocation) throws KeyczarException {
        setVerifier(new Verifier(fileLocation));
    }

    /**
     * Initialize a new TimeoutVerifier with a Verifier object.
     *
     * @param verifier Signer to be used for timeout signatures
     */
    public TimeoutVerifier(Verifier verifier) {
        setVerifier(verifier);
    }

    void setVerifier(Verifier verifier) {
        this.verifier = verifier;
    }

    /**
     * Allows a click to be injected for testing
     *
     * @param clock A clock to use for getting the current time
     */
    void setClock(Clock clock) {
        this.clock = clock;
    }

    /**
     * Verifies the timeout signature on the given String
     *
     * @param data      The data to verify the signature on
     * @param signature The signature to verify
     * @return Whether this is a valid signature
     * @throws KeyczarException If the signature is malformed or a JCE error
     *                          occurs.
     */
    public boolean verify(String data, String signature) throws KeyczarException {
        try {
            return verify(data.getBytes(Keyczar.DEFAULT_ENCODING),
                    Base64Coder.decodeWebSafe(signature));
        } catch (UnsupportedEncodingException e) {
            throw new KeyczarException(e);
        }
    }

    /**
     * Verifies a timeout signature on the given byte array of data
     *
     * @param data      The data to verify the signature on
     * @param signature The timeput signture to verify
     * @return Whether this is a valid signature
     * @throws KeyczarException If the signature is malformed or a JCE error
     *                          occurs.
     */
    public boolean verify(byte[] data, byte[] signature) throws KeyczarException {
        return verify(ByteBuffer.wrap(data), ByteBuffer.wrap(signature));
    }

    /**
     * Verify the timeout signature on the given data
     *
     * @param data
     * @param timeoutSignature
     * @return A boolean value indicating whether the timeout signature verified.
     * This will be false if the signature has expired.
     * @throws KeyczarException If the signature is malformed or a JCE error
     *                          occurs.
     */
    public boolean verify(ByteBuffer data, ByteBuffer timeoutSignature)
            throws KeyczarException {
        if (timeoutSignature.remaining() < Keyczar.HEADER_SIZE + Signer.TIMESTAMP_SIZE) {
            throw new ShortSignatureException(timeoutSignature.remaining());
        }
        byte[] header = new byte[Keyczar.HEADER_SIZE];
        timeoutSignature.get(header);

        // Get the timestamp and check that it has not expired
        byte[] timestamp = new byte[Signer.TIMESTAMP_SIZE];
        timeoutSignature.get(timestamp);
        long expirationTime = Util.toLong(timestamp);
        long now = clock.now();
        if (now > expirationTime) {
            return false;
        }

        ByteBuffer slicedSignature =
                ByteBuffer.allocate(Keyczar.HEADER_SIZE + timeoutSignature.remaining());
        slicedSignature.put(header);
        slicedSignature.put(timeoutSignature);
        slicedSignature.rewind();
        // The timeout is signed in a timeout signature. Prepend it to the data and
        // pass it to the parent implementation in Verfier
        ByteBuffer prependedData =
                ByteBuffer.allocate(Signer.TIMESTAMP_SIZE + data.remaining());
        prependedData.put(timestamp);
        prependedData.put(data);
        prependedData.rewind();
        return verifier.verify(prependedData, slicedSignature);
    }
}