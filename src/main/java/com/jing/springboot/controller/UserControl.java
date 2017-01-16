package com.jing.springboot.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jing.springboot.mapper.UserDao;

/**
 * @author jingsir
 **
 * 
 */
@RestController
@RequestMapping("/user")
public class UserControl {

	@Resource
	public UserDao userDao ;
	
	@RequestMapping(value = "/insert")
	public String insert(){
		userDao.insert("jing", 23);
		
		return "insert success" ;
	}
}
