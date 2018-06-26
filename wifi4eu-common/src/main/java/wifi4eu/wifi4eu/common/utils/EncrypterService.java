package wifi4eu.wifi4eu.common.utils;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

@Configuration
@PropertySource("classpath:env.properties")
@Component
public class EncrypterService {

    private Cipher eCipher;
    private Cipher dCipher;

    @Value("${secret.key.encryption}")
    private String secretKeyString;

    @PostConstruct
    public void init() throws Exception{
        eCipher = dCipher = Cipher.getInstance("AES");
    }

    public byte[] encrypt(String str) throws Exception{
        SecretKey key = getSecretKeyFromString();
        eCipher.init(Cipher.ENCRYPT_MODE, key);
        try {
            byte[] utf8 = str.getBytes("UTF-8");
            byte[] enc = eCipher.doFinal(utf8);

            return Base64.encodeBase64(enc);
        } catch (Exception e) {
            System.out.println("Failed in Encryption");
        }
        return null;
    }

    public String decrypt(byte[] bytes) throws Exception{
        SecretKey key = getSecretKeyFromString();
        dCipher.init(Cipher.DECRYPT_MODE, key);
        try {
            byte[] dec = Base64.decodeBase64(bytes);

            byte[] utf8 = dCipher.doFinal(dec);

            return new String(utf8, "UTF-8");
        } catch (Exception e) {
            System.out.println("Failed in Decryption");
        }
        return null;
    }

    private SecretKey getSecretKeyFromString(){
        byte[] decodedKey = Base64.decodeBase64(secretKeyString);
        return new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
    }

}
