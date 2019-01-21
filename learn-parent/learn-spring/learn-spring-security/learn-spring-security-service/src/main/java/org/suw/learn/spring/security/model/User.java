/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.security.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

/**
 * @classname: User
 * @author: suwei
 * @description:
 * @date: created in 2018/12/17 : 1:59 PM
 * @modified
 **/
@Data
public class User implements UserDetails {
    private Long id;
    private String username;
    private String password;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
    private int age;
    private BigDecimal salary;

    //    @Setter(AccessLevel.NONE)
    private Collection<GrantedAuthority> authorities = new ArrayList<>();

    public User(Long id, String username, String password, int age, BigDecimal salary) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.salary = salary;
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return authorities;
    }

    public User(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void addRole(Role role) {
        authorities.add(role);
    }
}
