package com.oryx;

import junit.framework.TestCase;
import org.junit.Test;
import com.oryx.interfaces.KeyczarReader;

import java.io.RandomAccessFile;

public class BadHashTest extends TestCase {
    private static final String TEST_DATA = "./testdata/badhash";
    private String input = "This is some test data";

    private final void testDecrypt(String subDir) throws Exception {
        testDecrypt(new KeyczarFileReader(testData(subDir)), subDir);
    }

    private String testData(String subDir) {
        return TEST_DATA + subDir;
    }

    private final void testDecrypt(KeyczarReader reader, String subDir)
            throws Exception {
        Crypter crypter = new Crypter(reader);
        RandomAccessFile activeInput =
                new RandomAccessFile(testData(subDir) + "/1.out", "r");
        String activeCiphertext = activeInput.readLine();
        activeInput.close();
        RandomAccessFile primaryInput =
                new RandomAccessFile(testData(subDir) + "/2.out", "r");
        String primaryCiphertext = primaryInput.readLine();
        primaryInput.close();
        String activeDecrypted = crypter.decrypt(activeCiphertext);
        assertEquals(input, activeDecrypted);
        String primaryDecrypted = crypter.decrypt(primaryCiphertext);
        assertEquals(input, primaryDecrypted);
    }

    @Test
    public final void testBadJavaHashAesDecrypt() throws Exception {
        testDecrypt("/aes-java-size");
    }

    @Test
    public final void testBadCppStrippedZerosAesDecrypt() throws Exception {
        testDecrypt("/aes-cpp-0");
    }
}
