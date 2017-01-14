package com.example.administrator.customproject.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class User {
    private String username;
    private String password;

    @Generated(hash = 2090636610)
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}