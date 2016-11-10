package br.univel.cryptography;

/**
 * Created by felipefrizzo on 10/11/16.
 */
public interface AbstractCryptography {

    /**
     * Cryptography for password.
     *
     * @param password
     * @return
     */
    String createCryptography(String password);
}
