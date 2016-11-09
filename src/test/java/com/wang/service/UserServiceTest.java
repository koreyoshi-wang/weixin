package com.wang.service;


import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wang.entity.UserEntity;
import com.wang.service.UserService;

@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {
	@Resource
	private UserService userService;
	@Test
	public void testIsExist(){
		UserEntity user = new UserEntity();
		user.setUsername("wang");
		user.setPassword("123456");
		System.out.println("test save");
		userService.save(user);
		System.out.println("test getAll");
		//UserEntity us = (UserEntity) userService.getById("402881eb583270f901583270fea30000");
		//System.out.println(us.getId());
		/*List<Object> list = userService.getAll(UserEntity.class);
		if (list.size()>=1){
			for(Object object : list){
				UserEntity u = (UserEntity)object;
				System.out.println(u.getUsername());
				u.setUsername("Test");
				userService.update(u);
			}
		}*/
	}

}
