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

package com.oryx.enums;

/**
 * Encodes different possible uses of a key:
 * <ul>
 * <li>Decrypt and Encrypt,
 * <li>Encrypt Only,
 * <li>Sign and Verify,
 * <li>Verify Only, and
 * <li>Test.
 * </ul>
 * <p>
 * <p>JSON Representation currently supports these strings:
 * <ul>
 * <li>"DECRYPT_AND_ENCRYPT"
 * <li>"ENCRYPT"
 * <li>"SIGN_AND_VERIFY"
 * <li>"VERIFY"
 * </ul>
 *
 * @author steveweis@gmail.com (Steve Weis)
 * @author arkajit.dey@gmail.com (Arkajit Dey)
 */
public enum KeyPurpose {
    DECRYPT_AND_ENCRYPT("crypt"),
    ENCRYPT("encrypt"),
    SIGN_AND_VERIFY("sign"),
    VERIFY("verify"),
    TEST("test");

    private String name;

    private KeyPurpose(String s) {
        name = s;
    }

    public static KeyPurpose getPurpose(int value) {
        switch (value) {
            case 0:
                return DECRYPT_AND_ENCRYPT;
            case 1:
                return ENCRYPT;
            case 2:
                return SIGN_AND_VERIFY;
            case 3:
                return VERIFY;
            case 127:
                return TEST;
        }
        return null;
    }

    public static KeyPurpose getPurpose(String name) {
        if (name != null) {
            if (name.equalsIgnoreCase(DECRYPT_AND_ENCRYPT.getName())) {
                return DECRYPT_AND_ENCRYPT;
            } else if (name.equalsIgnoreCase(ENCRYPT.getName())) {
                return ENCRYPT;
            } else if (name.equalsIgnoreCase(SIGN_AND_VERIFY.getName())) {
                return SIGN_AND_VERIFY;
            } else if (name.equalsIgnoreCase(VERIFY.getName())) {
                return VERIFY;
            } else if (name.equalsIgnoreCase(TEST.getName())) {
                return TEST;
            }
        }
        return null;
    }

    String getName() {
        return name;
    }
}