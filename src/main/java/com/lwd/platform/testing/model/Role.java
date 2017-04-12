package com.lwd.platform.testing.model;

import org.springframework.security.core.GrantedAuthority;

public class Role extends ModelEntity implements GrantedAuthority {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthority() {
        return name;
    }
}
