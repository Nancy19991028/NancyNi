/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.gradle.bean;


/**
 * User Entity class
 *Store and manage the information inside the system
 *
 */
public class UserInfo {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * The user id
     */
    private int id;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * The user name
     */

    private String username;
    /**
     * password
     */
    private String password;
    /**
     * role
     */
}