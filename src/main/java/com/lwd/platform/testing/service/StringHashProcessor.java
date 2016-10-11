package com.lwd.platform.testing.service;

public interface StringHashProcessor {

    String hash(String string);

    boolean matches(String password, String hash);
}
