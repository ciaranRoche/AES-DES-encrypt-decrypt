import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.SecretKey;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DESECBDecrypt {
    public static void main(String args[])
    {
        try
        {
            // File containing secret AES key
            FileInputStream keyFIS = new FileInputStream("DESKeyFile");
            ObjectInputStream keyOIS = new ObjectInputStream(keyFIS);

            // Read in the AES key
            SecretKey desKey = (SecretKey) keyOIS.readObject();
            keyOIS.close();
            keyFIS.close();

            // Create AES cipher instance
            Cipher aesCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

            // Initialize the cipher for decryption
            aesCipher.init(Cipher.DECRYPT_MODE, desKey);

            // Read ciphertext from file and decrypt it
            FileInputStream fis = new FileInputStream("scrambled");
            BufferedInputStream bis = new BufferedInputStream(fis);
            CipherInputStream cis = new CipherInputStream(bis, aesCipher);

            StringBuffer plaintext = new StringBuffer();
            int c;
            while ((c = cis.read()) != -1)
                plaintext.append((char) c);
            cis.close();
            bis.close();
            fis.close();

            System.out.println("Plaintext: " + plaintext.toString());

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
