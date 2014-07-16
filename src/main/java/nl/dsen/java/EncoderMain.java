package nl.dsen.java;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

import java.io.File;

public class EncoderMain {

    public static void main(String[] args) {
        EncoderMain encoder = new EncoderMain();
        String encodedData = Base64.encodeBase64String(encoder.readFile());

        byte[] decodedData = Base64.decodeBase64(encodedData);

        encoder.writeFile(decodedData);
    }

    protected byte[] readFile() {
        try {
            return FileUtils.readFileToByteArray(new File(this.getClass().getResource("/sample.png").toURI()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected void writeFile(byte[] data) {
        String tmpDir = System.getProperty("java.io.tmpdir");
        try {
            FileUtils.writeByteArrayToFile(new File(tmpDir + "sample_out.png"), data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
