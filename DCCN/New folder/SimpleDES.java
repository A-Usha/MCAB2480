import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.util.Base64;
import java.util.Scanner;

public class SimpleDES {

    public static void main(String[] args) {
        try {
            // 8-byte key for DES
            String keyString = "DESKey12";
            byte[] keyBytes = keyString.getBytes("UTF8");

            // Read message from user
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a message to encrypt  :  ");
            String message = scanner.nextLine();

            // Create key
            DESKeySpec desKeySpec = new DESKeySpec(keyBytes);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = keyFactory.generateSecret(desKeySpec);

            // Initialize cipher for encryption
            Cipher encryptCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            encryptCipher.init(Cipher.ENCRYPT_MODE, secretKey);

            // Encrypt the message
            byte[] encryptedBytes = encryptCipher.doFinal(message.getBytes("UTF8"));
            String encryptedBase64 = Base64.getEncoder().encodeToString(encryptedBytes);

            // Initialize cipher for decryption
            Cipher decryptCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            decryptCipher.init(Cipher.DECRYPT_MODE, secretKey);

            // Decrypt the message
            byte[] decryptedBytes = decryptCipher.doFinal(Base64.getDecoder().decode(encryptedBase64));
            String decryptedMessage = new String(decryptedBytes, "UTF8");

            // Output
            System.out.println("Encrypted Message : " + encryptedBase64);
            System.out.println("Decrypted Message : " + decryptedMessage);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

