import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.InvalidKeyException;
import java.security.Key;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;

public class Myclass {

    public static void encryption()
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {

        try {
            Cipher cipher = Cipher.getInstance("AES");
            KeyGenerator keyg = KeyGenerator.getInstance("AES");
            Key key = keyg.generateKey();

            cipher.init(Cipher.ENCRYPT_MODE, key);

            CipherInputStream cipt = new CipherInputStream(
                    new FileInputStream(new File("D:\\CP JAVA\\a.jpg")), cipher);

            FileOutputStream fileip = new FileOutputStream(new File("D:\\CP JAVA\\encrypt.jpg"));

            int i;
            while ((i = cipt.read()) != -1) {
                fileip.write(i);

            }

            cipher.init(Cipher.DECRYPT_MODE, key);

            CipherInputStream ciptt = new CipherInputStream(
                    new FileInputStream(new File("D:\\CP JAVA\\encrypt.jpg")), cipher);

            FileOutputStream fileop = new FileOutputStream(new File("D:\\CP JAVA\\decrypt.jpg"));

            int j;
            while ((j = ciptt.read()) != -1) {
                fileop.write(j);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        try {
            Myclass.encryption();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}