package com.lwd.platform.testing.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lwd.platform.testing.util.constant.Const;

import javax.persistence.*;
import java.util.List;

@Entity
public class User extends ModelEntity {

    @Column
    private String email;

    @JsonProperty("password")
    @Column
    private String passwordHash;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = Const.Tables.UserRole.USER_ROLE, joinColumns = {
            @JoinColumn(name = Const.Tables.UserRole.USER_ID)
    }, inverseJoinColumns = {
            @JoinColumn(name = Const.Tables.UserRole.ROLE_ID)
    })
    private List<Role> roles;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
