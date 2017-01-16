package com.jing.springboot.jackson;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jing.springboot.model.AnnationUser;
import com.jing.springboot.model.User;

import junit.framework.TestCase;

/**
 * @author jingsir
 **
 * 
 */

public class JsonStrTest extends TestCase {

	public JsonStrTest() {
	}

	public void testJsonToStr() {
		User user = new User();
		try {
			user.setName("Lifeng");
			user.setAge(18);
			user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1998-10-1"));
			user.setEmail("lifengQA@163.com");
			ObjectMapper jsonMapper = new ObjectMapper();

			String userJson = jsonMapper.writeValueAsString(user);
			System.err.println("jackson将Object转为字符串: " + userJson);
		} catch (Exception e) {
			e.printStackTrace();
		}

		AnnationUser aUser = new AnnationUser();
		try {
			aUser.setAge(18);
			aUser.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1998-10-1"));
			aUser.setEmail("lifengQA@163.com");
			aUser.setName("Lifeng");
			System.err.println(new ObjectMapper().writeValueAsString(aUser));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testStrToJson() {
		String userStr = "{\"name\":\"Lifeng\",\"age\":18,\"birthday\":907171200000,\"email\":\"lifengQA@163.com\"}";
		ObjectMapper mapper = new ObjectMapper();
		try {
			User user = mapper.readValue(userStr, User.class);
			System.out.println(user.getEmail());
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
