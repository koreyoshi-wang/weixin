/**
 * 
 */
package com.wang.controller;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wang.entity.UserEntity;
import com.wang.service.UserService;

/**
 * @author wang
 */
@Controller
@RequestMapping("/user")
public class UserController{
	@Resource
	private UserService userService;
	
	@ResponseBody
	//@RequestMapping(value="/login", method = RequestMethod.POST)
	@RequestMapping(value="/login")
	public Map<String,Object> login( HttpServletRequest request, HttpServletResponse response, UserEntity user){
		Map<String,Object> map = new HashMap<String,Object>();
		System.out.println(user.toString());
		boolean loginResult = userService.isExist(user);
		UserEntity user1 = (UserEntity) userService.getById(UserEntity.class, "1");
		System.out.println(user1.getUsername());
		//获取Session  
        HttpSession session = request.getSession();  
        session.setAttribute("username", user1.getUsername());
		map.put("loginResult", loginResult);
		return map;
	}
}
