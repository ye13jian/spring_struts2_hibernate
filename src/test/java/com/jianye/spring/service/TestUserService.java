package com.jianye.spring.service;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.jianye.spring.entity.UserInfoSsh;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring.xml",
		"classpath:spring/spring-hibernate.xml"})
public class TestUserService {
	
	private static final Logger logger = Logger.getLogger(TestUserService.class);
	
	@Autowired
	private UserService userService;

	@Test
	public void testSave() {
		UserInfoSsh userInfo = new UserInfoSsh();
		userInfo.setName("jianye");
		userInfo.setAge(25);
		userInfo.setTelephone("13696527039");
		userService.save(userInfo);
		logger.info(JSON.toJSON(userInfo));
	}

}
