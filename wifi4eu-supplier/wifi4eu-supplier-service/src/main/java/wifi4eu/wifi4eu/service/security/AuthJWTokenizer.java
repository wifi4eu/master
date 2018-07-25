package wifi4eu.wifi4eu.service.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class AuthJWTokenizer {

    private static final String secret;
    private static final Long expirationLapse = 300000L; //2 minutes
    //private static final Long expirationLapse = 7200000L; //2 hours

    public static final Logger logger = Logger.getLogger(AuthJWTokenizer.class);

    static{
        //It can be set externally, from file
        //Paths.get(String.valueOf(AuthJWTokenizer.class.getResource("/jwt.key")));
        secret = "WIFI4EU";
    }

    public static String encode(String userEmail) throws UnsupportedEncodingException {

        Date expiration = new Date(System.currentTimeMillis() + expirationLapse);

        String hashEmail = hashSHA512(userEmail);
        String hashDate = hashSHA512(String.valueOf(System.currentTimeMillis()));

        return Jwts.builder()
                .setSubject("users/token")
                .claim("email", hashEmail)
                .claim("date", hashDate)
                //Set token expiration to defined time
                .setExpiration(expiration)
                .signWith(
                        SignatureAlgorithm.HS512,
                        secret.getBytes("UTF-8")
                )
                .compact();
    }

    public static Claims decode(String hash) throws UnsupportedEncodingException {
        return Jwts.parser().setSigningKey(secret.getBytes("UTF-8"))
                .parseClaimsJws(hash).getBody();

    }

    public static String hashSHA512(String input){

        MessageDigest md;
        StringBuilder sb = new StringBuilder();
        try {
            md = MessageDigest.getInstance("SHA-512");
            md.update(input.getBytes());
            byte byteData[] = md.digest();

            for (byte byteD : byteData) {
                sb.append(Integer.toString((byteD & 0xff) + 0x100, 16).substring(1));
            }
        } catch (NoSuchAlgorithmException e) {
            logger.error(e.getMessage(), e);
        }

        return sb.toString();
    }
}
