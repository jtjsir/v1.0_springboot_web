package com.jing.springboot.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jing.springboot.model.User;

/**
 * @author jingsir
 **
 * @RestController=@Controller+@ResponseBody
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloWorldControl {

	public HelloWorldControl() {
	}

	@RequestMapping(value = "/")
	public String hello() {
		return "hello world";
	}

	@RequestMapping(value = "/freemarker")
	public ModelAndView helloFreemarker(HttpServletRequest request) {
		ModelAndView indexView = new ModelAndView("index");
		indexView.addObject("hello", "hello springboot!");

		User user = new User() ;
		try {
			user.setName("Lifeng");
			user.setAge(18);
			user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1998-10-1"));
			user.setEmail("lifengQA@163.com");
			ObjectMapper jsonMapper = new ObjectMapper() ;
			
			String userJson = jsonMapper.writeValueAsString(user) ;
//			System.err.println("jackson将Object转为字符串: " + userJson);
			indexView.addObject("user", user) ;
			request.getSession(true).setAttribute("requestAttr", "webValue");
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("hello", "springboot hello!");
		//组装成json
		return indexView;
	}
}
 