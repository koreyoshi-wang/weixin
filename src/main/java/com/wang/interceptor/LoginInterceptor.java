/**
 * 
 */
package com.wang.interceptor;

import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
  
import org.springframework.web.servlet.HandlerInterceptor;  
import org.springframework.web.servlet.ModelAndView;   
/**
 * 登录认证的拦截器 
 * 
 * @author wanfangg
 */
public class LoginInterceptor implements HandlerInterceptor{  
  
    /** 
     * Handler执行完成之后调用这个方法 
     */  
    public void afterCompletion(HttpServletRequest request,  
            HttpServletResponse response, Object handler, Exception exc)  
            throws Exception {  
          
    }  
  
    /** 
     * Handler执行之后，ModelAndView返回之前调用这个方法 
     */  
    public void postHandle(HttpServletRequest request, HttpServletResponse response,  
            Object handler, ModelAndView modelAndView) throws Exception {  
    }  
  
    /** 
     * Handler执行之前调用这个方法 
     */  
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,  
            Object handler) throws Exception {  
        //获取请求的URL  
        String url = request.getRequestURI(); 
        if(url.contains(".js") || url.contains(".css") || url.contains(".html") || url.contains("images")){
        	return true;
        }
        System.out.println(url);
        if(url.indexOf("login")>=0 || url.indexOf("weixin/weixin")>=0 || url.indexOf("index")>=0){  
            return true;  
        }  
        //获取Session  
        HttpSession session = request.getSession();  
        String username = (String)session.getAttribute("username");   
        if(username != null){  
            return true;  
        } 
        if(url.indexOf("weixin/")>=0){  
        	session.setAttribute("URL", url); 
        }
        //不符合条件的，跳转到登录界面  
        response.sendRedirect(request.getContextPath() + "/login");  
          
        return false;
    }  
  
} 
