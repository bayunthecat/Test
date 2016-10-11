package com.lwd.platform.testing.config;

import com.lwd.platform.testing.service.StringHashProcessor;
import com.lwd.platform.testing.service.impl.PasswordHashProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PasswordHashExtractorConfiguration {

    private static final String HASH_ALGORITHM = "SHA-256";

    private static final int SALT_BYTES = 4;

    @Bean
    public StringHashProcessor getExtractor() {
        return new PasswordHashProcessor(SALT_BYTES, HASH_ALGORITHM);
    }
}
