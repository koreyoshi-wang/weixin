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
import com.wang.entity.WeixinOauth2Token;
import com.wang.service.UserService;
import com.wang.util.WeixinUtil;

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
     // 用户同意授权后，能获取到code
        String code = request.getParameter("code");
        String state = request.getParameter("state");
        System.out.println("code:"+code);
        // 用户同意授权
        if (code != null && !"authdeny".equals(code)) {
            // 获取网页授权access_token
            WeixinOauth2Token weixinOauth2Token = WeixinUtil.getOauth2AccessToken("wx4240e73ac7d153c7", "83264065ef3fd932b81e7fcd24991cdb", code);
            // 网页授权接口访问凭证
            String accessToken = weixinOauth2Token.getAccessToken();
            // 用户标识
            String openId = weixinOauth2Token.getOpenId();

            // 设置要传递的参数
            map.put("state", state);
            map.put("accessToken", accessToken);
            map.put("openId", openId);
            System.out.println("openId:"+openId);
            request.getSession().setAttribute("state", state);
            request.getSession().setAttribute("accessToken", accessToken);
            request.getSession().setAttribute("openId", openId);
        }
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
