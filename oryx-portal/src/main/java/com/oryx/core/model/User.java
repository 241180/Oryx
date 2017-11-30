package com.oryx.core.model;

import com.oryx.core.enums.EnumUserRole;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "system_user")
public class User {

    @Id
    @GeneratedValue
    private int id;

    private String email;
    private String name;
    private String enabled;
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private EnumUserRole role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnumUserRole getRole() {
        return role;
    }

    public void setRole(EnumUserRole role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }
}