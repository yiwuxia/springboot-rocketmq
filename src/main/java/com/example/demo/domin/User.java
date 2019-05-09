package com.example.demo.domin;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("user")
public class User {
	
	/**
	 * 
	 * com.example.demo.core.EnumValueTypeHandler
	 */
	
	private int id;
	private MyType sex;
	private String username;
	private String city;
	 
	 
	
}
