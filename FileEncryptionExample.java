import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
class FileEncryptionExample{
private static final String ALGORITHM = "AES";
private static final String TRANSFORMATION = "AES";
public void encryptFile(File inputFile, File outputFile, String password)
 throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException 
{
 doCrypto(Cipher.ENCRYPT_MODE, inputFile, outputFile, password);
}
public static void decryptFile(File inputFile, File outputFile, String password)
 throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException 
{
 doCrypto(Cipher.DECRYPT_MODE, inputFile, outputFile, password);
}
private static void doCrypto(int cipherMode, File inputFile, File outputFile, String password)
 throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException 
{
 try {
 SecretKey secretKey = generateKey(password);
 Cipher cipher = Cipher.getInstance(TRANSFORMATION);
 cipher.init(cipherMode, secretKey);
 FileInputStream inputStream = new FileInputStream(inputFile);
 byte[] inputBytes = new byte[(int) inputFile.length()];
 inputStream.read(inputBytes);
 byte[] outputBytes = cipher.doFinal(inputBytes);
 FileOutputStream outputStream = new FileOutputStream(outputFile);
 outputStream.write(outputBytes);
 inputStream.close();
 outputStream.close();
 
 //Delete the input file
 boolean isDeleted = inputFile.delete();
 if (isDeleted) {
 System.out.println();
 } else {
 System.out.println(".");
 }
 } catch (BadPaddingException | IllegalBlockSizeException e) {
 e.printStackTrace();
 }
}
private static SecretKey generateKey(String password) throws NoSuchAlgorithmException {
 byte[] passwordBytes = password.getBytes();
 MessageDigest sha = MessageDigest.getInstance("SHA-256");
 byte[] hashBytes = sha.digest(passwordBytes);
 byte[] keyBytes = new byte[16];
 System.arraycopy(hashBytes, 0, keyBytes, 0, keyBytes.length);
 SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, ALGORITHM);
 return secretKeySpec;
}
public void code(String a1,String b1,String P1)
{
 try {
 
 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
 //System.out.print("Enter the path of the file to encrypt: ");
 String inputFile = a1;
 //System.out.print("Enter the location to save the encrypted file: ");
 String encryptedFile = b1;
 //System.out.print("Enter the password: ");
 String password = P1;
 encryptFile(new File(inputFile), new File(encryptedFile), password);
 System.out.println("File encrypted successfully.");
 
// System.out.print("Enter the path of the file to decrypt: ");
 //String decryptedFile = x1;
//
 // System.out.print("Enter the location to save the decrypted file: ");
 // String outputFile = z1;
//
// decryptFile(new File(decryptedFile), new File(outputFile), password);
// System.out.println("File decrypted successfully.");
// 
 
 reader.close();
 } catch (IOException | NoSuchAlgorithmException | NoSuchPaddingException | 
InvalidKeyException e) {
 e.printStackTrace();
 }
}
public void code_1(String x1,String z1,String k1)
{
try {
 
 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
 String decryptedFile = x1;
//
 // System.out.print("Enter the location to save the decrypted file: ");
 String outputFile = z1;
 
 String pass=k1;
//
 decryptFile(new File(decryptedFile), new File(outputFile), pass);
 System.out.println("File decrypted successfully.");
 reader.close();
 } catch (IOException | NoSuchAlgorithmException | NoSuchPaddingException | 
InvalidKeyException e) {
 e.printStackTrace();
 }
}
}