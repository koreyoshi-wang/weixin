/**
 * 
 */
package com.wang.controller;

import java.util.Enumeration;
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
import org.springframework.web.servlet.ModelAndView;

import com.wang.entity.UserEntity;
import com.wang.entity.WeixinOauth2Token;
import com.wang.service.UserService;
import com.wang.util.WeixinUtil;

/**
 * @author wang
 */
@Controller
@RequestMapping(value = "/index")
public class IndexController {
	@Resource
	private UserService userService;

	// @ResponseBody
	// @RequestMapping(value="/login", method = RequestMethod.POST)
	@RequestMapping
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("Index");
		//ModelAndView modelAndView = new ModelAndView("index");
		ModelAndView modelAndView = new ModelAndView("weixin");
		// modelAndView.setViewName("login");
		map.put("test", "index");

		map.put("state", request.getSession().getAttribute("state"));
		map.put("accessToken", request.getSession().getAttribute("accessToken"));
		map.put("openId", request.getSession().getAttribute("openId"));
		modelAndView.addAllObjects(map);
		return modelAndView;
	}
}
