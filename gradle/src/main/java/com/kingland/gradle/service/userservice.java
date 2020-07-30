/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */

package com.kingland.gradle.service;


import com.kingland.gradle.bean.UserInfo;
import com.kingland.gradle.mapper.usermapper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * UserService
 *
 * @version 1.0
 *
 * @description
 */
@Service
public class userservice implements UserDetailsService {
    /**
     * String constant, space
     */
    public static final String SPACE = " ";
    /**
     * The user Mapper
     */
    private final usermapper usermapper;
    /**
     * Injection by constructor
     *
     * The user Mapper
     */
    public userservice(usermapper userMapper) {
        this.usermapper = userMapper;
    }
    /**
     * rewrite loadUserByUsername methods
     *
     * The user name
     * The user information
     * UsernameNotFoundException exception
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // If the user name is empty
        if (username == null || "".equals(username)) {
            // An exception is thrown
            throw new UsernameNotFoundException("Please enter the user name!");
        }
        // list For saving permissions
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        // Query user information by user name
        UserInfo UserInfo = usermapper.queryUserByName(username);
        if (null == UserInfo) {
            throw new UsernameNotFoundException("The user name does not exist!");
        }
        // Returns a user object with permission information
        return new org.springframework.security.core.userdetails.User(UserInfo.getUsername(), UserInfo.getPassword(), list);
    }
}