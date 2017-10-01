import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class DESKeyGen {
    public static void main(String args[])
    {
        try
        {
            // File for writing output
            FileOutputStream keyFOS = new FileOutputStream("DESKeyFile");
            ObjectOutputStream keyOOS = new ObjectOutputStream(keyFOS);

            // Generate random AES key
            KeyGenerator keygen = KeyGenerator.getInstance("DES");
            SecretKey desKey = keygen.generateKey();
            keyOOS.writeObject(desKey);

            System.out.println("DES key generated and written to file: DESKeyFile");

            keyOOS.close();
            keyFOS.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
