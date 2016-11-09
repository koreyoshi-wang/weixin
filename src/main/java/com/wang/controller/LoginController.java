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
import org.springframework.web.servlet.ModelAndView;

import com.wang.entity.UserEntity;
import com.wang.service.UserService;

/**
 * @author wang
 */
@Controller
@RequestMapping(value="/login")
public class LoginController{
	@Resource
	private UserService userService;
	
	@RequestMapping
	public ModelAndView  loginPage( HttpServletRequest request, HttpServletResponse response){
		Map<String,Object> map = new HashMap<String,Object>();
        ModelAndView modelAndView = new ModelAndView("login");
        //modelAndView.setViewName("login");
        map.put("test", "index");
        modelAndView.addAllObjects(map);
		return modelAndView;
	}
	
	@RequestMapping(value="/login")
	@ResponseBody
	public Map<String, Object> login( HttpServletRequest request, HttpServletResponse response, UserEntity user){
		Map<String,Object> map = new HashMap<String,Object>();
		System.out.println(user.toString());
		boolean loginResult = userService.isExist(user);
		//获取Session  
        HttpSession session = request.getSession();  
        String URL = (String)session.getAttribute("URL");
        UserEntity user1 = (UserEntity) userService.getById(UserEntity.class, "9025341b5843011b015843011fd10000");
        session.setAttribute("username", user1.getUsername());
        session.setAttribute("userId", user1.getId());
        map.put("URL", URL);
		System.out.println(loginResult);
		map.put("loginResult", loginResult);
		return map;
	}
	
	@RequestMapping("/logout")
    public String logout(HttpServletRequest request)
    {
        request.getSession().invalidate();
        request.getSession().setAttribute("url", null);
        return "redirect:/login";
    }
}
