/*
 * Copyright (C) 2018 suwei1979@139.com. All Rights Reserved.
 */
package org.suw.learn.spring.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.suw.learn.spring.security.model.User;
import org.suw.learn.spring.security.service.RoleService;
import org.suw.learn.spring.security.service.UserService;

/**
 * @classname: UserRestController
 * @author: suwei
 * @description:
 * @date: created in 2018/12/17 : 1:55 PM
 * @modified
 **/
@RestController
public class UserRestController {

    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;


    /**
     * @return
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = userService.findAllUsers();
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping(value = "/user")
    public ResponseEntity<Void> createUser(User user, UriComponentsBuilder uriComponentsBuilder) {
        if (userService.isUserExist(user)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        userService.saveUser(user);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);

    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        User currentUser = userService.getUserById(id);
        if (currentUser == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentUser.setUsername(user.getUsername());
        currentUser.setPassword(user.getPassword());
        currentUser.setAge(user.getAge());
        currentUser.setSalary(user.getSalary());
        return new ResponseEntity<>(currentUser, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable("id") Long id) {
        System.out.println("Fetching & Deleting User with id " + id);
        User user = userService.getUserById(id);
        if (user == null) {
            System.out.println("Unable to delete. User with id " + id + " not found.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
