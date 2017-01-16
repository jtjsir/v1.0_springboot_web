package com.jing.springboot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author jingsir
 **
 *         采用注解形式
 */
@Mapper
public interface UserDao {

	@Insert("insert into user(name,age) VALUES(#{username},#{age})")
	public void insert(@Param("username") String username, @Param("age") int age);
}
