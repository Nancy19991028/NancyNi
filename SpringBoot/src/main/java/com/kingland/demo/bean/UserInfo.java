/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */

package com.kingland.demo.bean;

import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User Entity class
 *Store and manage the information inside the system
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    /**
     * The user id
     */
    private int id;
    /**
     * The user name
     */
@NotNull
    private String username;
    /**
     * password
     */
    private String password;
    /**
     * role
     */
}

