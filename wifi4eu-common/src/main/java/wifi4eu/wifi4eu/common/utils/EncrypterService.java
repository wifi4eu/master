package wifi4eu.wifi4eu.common.utils;

import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@PropertySource("classpath:env.properties")
@Component
public class EncrypterService {

	private final Logger _log = LogManager.getLogger(EncrypterService.class);

	@Value("${secret.key.encryption}")
	private String secretKeyString;

	@Value("${azure.blob.storage.key}")
	private String azureCredentials;

	public byte[] encrypt(String textValue) throws GeneralSecurityException {
		return encryptAES(textValue);
	}

	public String decrypt(byte[] bytes) throws GeneralSecurityException {
		return decryptAES(bytes);
	}

	@Deprecated
	private byte[] encryptAES(String str) throws GeneralSecurityException {
		SecretKey key = getSecretKeyFromString();

		try {
			_log.debug("Initializing cipher");
			Cipher eCipher = Cipher.getInstance("AES");
			eCipher.init(Cipher.ENCRYPT_MODE, key);

			_log.debug("Encrypting key");
			byte[] utf8 = str.getBytes(StandardCharsets.UTF_8);
			byte[] enc = eCipher.doFinal(utf8);

			_log.debug("Encoding key");
			return Base64.encodeBase64(enc);
		} catch (GeneralSecurityException e) {
			_log.error("Failed in Encryption " + e.getMessage(), e);
			throw new GeneralSecurityException(e.getMessage(), e.getCause());
		}
	}

	@Deprecated
	private String decryptAES(byte[] bytes) throws GeneralSecurityException {
		SecretKey key = getSecretKeyFromString();
		Cipher dCipher = Cipher.getInstance("AES");
		dCipher.init(Cipher.DECRYPT_MODE, key);
		try {
			_log.debug("Decrypting key");
			byte[] dec = Base64.decodeBase64(bytes);
			byte[] utf8 = dCipher.doFinal(dec);

			return new String(utf8, StandardCharsets.UTF_8);
		} catch (GeneralSecurityException e) {
			_log.error("Failed in Decryption " + e.getMessage(), e);
			throw new GeneralSecurityException(e.getMessage(), e.getCause());
		}
	}

	private byte[] encryptAESCBC(String textValue) throws GeneralSecurityException {
		byte[] key = Base64.decodeBase64(secretKeyString);
		byte[] inputBytes = textValue.getBytes(StandardCharsets.UTF_8);
		int ivSize = 16;
		int keySize = 16;

		try {
			// Generating IV.
			byte[] iv = new byte[ivSize];
			SecureRandom random = new SecureRandom();
			random.nextBytes(iv);
			IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

			// Hashing key.
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			digest.update(key);
			byte[] keyBytes = new byte[keySize];
			System.arraycopy(digest.digest(), 0, keyBytes, 0, keyBytes.length);
			SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");

			// Encrypt.
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
			byte[] encrypted = cipher.doFinal(inputBytes);

			// Combine IV and encrypted part.
			byte[] encryptedIVAndText = new byte[ivSize + encrypted.length];
			System.arraycopy(iv, 0, encryptedIVAndText, 0, ivSize);
			System.arraycopy(encrypted, 0, encryptedIVAndText, ivSize, encrypted.length);

			return Base64.encodeBase64(encryptedIVAndText);
		} catch (GeneralSecurityException e) {
			_log.error("Failed in Encryption " + e.getMessage(), e);
			throw new GeneralSecurityException(e.getMessage(), e.getCause());
		}
	}

	private String decryptAESCBC(byte[] encryptedTextBytes) throws GeneralSecurityException {
		byte[] key = Base64.decodeBase64(secretKeyString);
		byte[] decodedInputBytes = Base64.decodeBase64(encryptedTextBytes);
		int ivSize = 16;
		int keySize = 16;

		try {
			// Extract IV.
			byte[] iv = new byte[ivSize];
			System.arraycopy(decodedInputBytes, 0, iv, 0, iv.length);
			IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

			// Extract encrypted part.
			int encryptedSize = decodedInputBytes.length - ivSize;
			byte[] encryptedBytes = new byte[encryptedSize];
			System.arraycopy(decodedInputBytes, ivSize, encryptedBytes, 0, encryptedSize);

			// Hash key.
			byte[] keyBytes = new byte[keySize];
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(key);
			System.arraycopy(md.digest(), 0, keyBytes, 0, keyBytes.length);
			SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");

			// Decrypt.
			Cipher cipherDecrypt = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipherDecrypt.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
			byte[] decrypted = cipherDecrypt.doFinal(encryptedBytes);

			return new String(decrypted, StandardCharsets.UTF_8);
		} catch (GeneralSecurityException e) {
			_log.error("Failed in Decryption " + e.getMessage(), e);
			throw new GeneralSecurityException(e.getMessage(), e.getCause());
		}
	}

	private SecretKey getSecretKeyFromString() {
		_log.debug("Decoding secret key");
		byte[] decodedKey = Base64.decodeBase64(secretKeyString);
		return new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
	}

	public String getAzureKeyStorage() {
		try {
			_log.debug("Decrypting azure blob storage credentials");
			byte[] b = azureCredentials.getBytes(StandardCharsets.UTF_8);
			return decryptAES(b);
		} catch (Exception e) {
			_log.error("Failed in Decryption " + e.getMessage(), e);
			return null;
		}
	}
	
	public String getDecodedValue(String value) {
		try {
			byte[] b = value.getBytes(StandardCharsets.UTF_8);
			return decrypt(b);
		} catch (Exception e) {
			_log.error("Failed in Decryption " + e.getMessage(), e);
			return null;
		}
	}
	
	public String getEncodedValue(String value) {
		try {
			byte[] b = encrypt(value);
			return new String(b, StandardCharsets.UTF_8);
		} catch (Exception e) {
			_log.error("Failed in Encryption " + e.getMessage(), e);
			return null;
		}
	}
}
