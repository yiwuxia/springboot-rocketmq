package com.example.demo.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import com.example.demo.common.ResultBody;
import com.example.demo.mqdemo.Producer;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domin.User;
import com.example.demo.mapper.UserMapper;

@RestController
public class TestCon {
	
	@Autowired
	UserMapper userMapper;



	@Autowired
	private Producer producer;


	
	@RequestMapping("/api/users")
    public ResultBody getUser() {
		List<User> list =userMapper.getUser();
        return ResultBody.returnSuc(list);
    }

	@RequestMapping("/api/mq")
	public ResultBody testMq() {
		try {
			producer.send("lijin","push","中国send"+new Date());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (RemotingException e) {
			e.printStackTrace();
		} catch (MQClientException e) {
			e.printStackTrace();
		} catch (MQBrokerException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return ResultBody.returnSucMsg("success");
	}

}


