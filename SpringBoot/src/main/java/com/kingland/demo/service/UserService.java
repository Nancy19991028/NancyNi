/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */

package com.kingland.demo.service;

import com.kingland.demo.bean.UserInfo;
import com.kingland.demo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class UserService implements UserDetailsService {
    /**
     * String constant, space
     */
    public static final String SPACE = " ";
    /**
     * The user Mapper
     */
    private final UserMapper userMapper;
    /**
     * Injection by constructor
     *
     * The user Mapper
     */
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
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
        // The log
        log.info("****** service, username : " + username);
        // If the user name is empty
        if (username == null || "".equals(username)) {
            // An exception is thrown
            throw new UsernameNotFoundException("Please enter the user name!");
        }
        // list For saving permissions
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        // Query user information by user name
        UserInfo UserInfo = userMapper.queryUserByName(username);
        if (null == UserInfo) {
            throw new UsernameNotFoundException("The user name does not exist!");
        }

        // The log
        log.info("****** service, role : " + list);
        // Returns a user object with permission information
        return new org.springframework.security.core.userdetails.User(UserInfo.getUsername(), UserInfo.getPassword(), list);
    }
}