package br.univel.cryptography;

/**
 * Created by felipefrizzo on 10/11/16.
 */
public interface GenericCryptography {

    /**
     * Cryptography for password.
     *
     * @param password
     * @return the password encrypted
     */
    String createCryptography(String password);
}
