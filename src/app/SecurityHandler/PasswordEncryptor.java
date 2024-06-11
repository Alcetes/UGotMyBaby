package app.SecurityHandler;

import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class PasswordEncryptor {

	private static final String SECRET_KEY = "secretkey12345";
	private static final String SALT = "salty"; // to ensure to have different encrypted data even with the same
												// plaintext

	public static String encryptPassword(String password) {
		try {
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
			KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALT.getBytes(), 65536, 256);
			SecretKey secretKey = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			byte[] iv = new byte[16];
			cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(iv));

			byte[] encryptedPassword = cipher.doFinal(password.getBytes());

			return Base64.getEncoder().encodeToString(encryptedPassword);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String decryptPassword(String encryptedPassword) {
		try {
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
			KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALT.getBytes(), 65536, 256);
			SecretKey secretKey = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			byte[] iv = new byte[16];
			cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(iv));

			byte[] decodedEncryptedPassword = Base64.getDecoder().decode(encryptedPassword);
			byte[] decryptedPassword = cipher.doFinal(decodedEncryptedPassword);

			return new String(decryptedPassword);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
		System.out.println(encryptPassword("azer1234"));
		System.out.println(decryptPassword(encryptPassword("azer1234")));
	}
}