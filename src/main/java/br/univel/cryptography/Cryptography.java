package br.univel.cryptography;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

/**
 * Created by felipefrizzo on 10/11/16.
 */
public class Cryptography implements GenericCryptography {
    @Override
    public String createCryptography(final String password) {
        Objects.requireNonNull(password, "Password cannot be null");

        MessageDigest messageDigest;
        StringBuilder string = new StringBuilder();

        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(password.getBytes());

            byte[] digest = messageDigest.digest();
            for (byte b: digest) {
                string.append(String.format("%02x", b & 0xff));
            }

            return string.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
