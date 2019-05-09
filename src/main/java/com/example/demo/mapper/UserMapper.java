package com.example.demo.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.domin.User;

@Repository
public interface UserMapper {
	
	List<User> getUser();
	

}
