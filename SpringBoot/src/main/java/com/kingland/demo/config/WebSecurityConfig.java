/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */

package com.kingland.demo.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * WebSecurityConfigSecurity configuration
 * @description
 *
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * The user information Service
     */
    private UserDetailsService userService;
    /**
     * The user Service
     */
    public WebSecurityConfig(UserDetailsService userService) {
        this.userService = userService;
    }
    /**
     * Override configuration to filter static resources
     */
    @Override
    public void configure(WebSecurity webSecurity) throws Exception {
        // Allows access to all files in the/CSS directory
        webSecurity.ignoring().antMatchers("/css/**");
        webSecurity.ignoring().antMatchers("/public/**");
        webSecurity.ignoring().antMatchers("/favicon.ico", "/resources/**", "/error");
    }
    /**
     * Security policy configuration
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                // Some resources on the website need to be authorized
                .antMatchers("/*.html").permitAll()
                .antMatchers("/index").permitAll()
                // All requests except the above require authentication
                .anyRequest().authenticated().and()
                // Defines the login page to go to when a user is required to log in .loginPage("/login")
                .formLogin().loginPage("/login").defaultSuccessUrl("/index.html").permitAll().and()
                // Define the logout operation
                .logout().logoutSuccessUrl("/welcome").permitAll().and()
                // Disable CSRF, otherwise it may cause some errors
                .csrf().disable()
        ;
        // Disable caching
        httpSecurity.headers().cacheControl();
    }

    /**
     * Configure security authentication
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Use the database user information service password authentication using BCrypt encryption
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }
}

