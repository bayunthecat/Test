package com.lwd.platform.testing.service.impl;

import com.lwd.platform.testing.service.StringHashProcessor;
import org.apache.log4j.Logger;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PasswordHashProcessor implements StringHashProcessor {

    private static final Logger LOG = Logger.getLogger(PasswordHashProcessor.class);

    private int saltBytes;

    private SecureRandom secureRandom;

    private MessageDigest messageDigest;

    private static final Charset CHARSET = StandardCharsets.UTF_8;

    public PasswordHashProcessor(int saltBytes, String algorithmName) {
        this.saltBytes = saltBytes;
        messageDigest = constructMessageDigest(algorithmName);
        secureRandom = new SecureRandom();
    }

    @Override
    public String hash(String password) {
        byte[] salt = new byte[saltBytes];
        secureRandom.nextBytes(salt);
        return getHash(password) + new String(salt, CHARSET);
    }

    @Override
    public boolean matches(String password, String hash) {
        String currentHash = new String(messageDigest.digest(password.getBytes(CHARSET)), CHARSET);
        return hash.startsWith(currentHash);
    }

    private String getHash(String password) {
        return new String(messageDigest.digest(password.getBytes(CHARSET)), CHARSET);
    }

    private MessageDigest constructMessageDigest(String algorithmName) {
        try {
            return MessageDigest.getInstance(algorithmName);
        } catch (NoSuchAlgorithmException e) {
            LOG.error("Error initializing password hash processor: ", e);
        }
        return null;
    }
}
