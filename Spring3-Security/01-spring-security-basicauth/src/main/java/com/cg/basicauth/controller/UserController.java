package com.cg.basicauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.basicauth.entity.UserInfo;
import com.cg.basicauth.service.UserService;

@RestController

public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/new")
	public String addNewUser(@RequestBody UserInfo userInfo){
        return userService.addUser(userInfo);
    }

}
