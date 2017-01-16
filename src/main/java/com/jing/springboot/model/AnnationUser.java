package com.jing.springboot.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author jingsir
 **
 *         采用jackson注解
 * 
 * @JsonFormat 序列化格式
 * @JsonIgnore 序列化忽略项
 * @JsonProperty 序列化设置别名
 */
public class AnnationUser {

	private String name;

	@JsonFormat(pattern = "yyyy年-MM月-dd日")
	private Date birthday;

	@JsonIgnore
	private int age;

	@JsonProperty("mail@:")
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
