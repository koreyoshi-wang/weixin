/**
 * 
 */
package com.wang.timer;

/**
 * @author wanfangg
 */
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wang.entity.AccessToken;
import com.wang.service.BaseService;
import com.wang.service.WeixinService;
import com.wang.util.WeixinUtil;

public class TimeStartServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    WeixinService service = (WeixinService) applicationContext.getBean("weixinService");
    
    public TimeStartServlet()
    {
        super();
    }
    
    public void init() throws ServletException
    {
    	System.out.println("启动时执行的任务");
    	// 第三方用户唯一凭证  
        String appId = "wx16d6a8f6cd4bff6b";  
        // 第三方用户唯一凭证密钥  
        String appSecret = "7b9cb57cb9d3d9cc9f5066b8f293cb37";
    	//AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);
        AccessToken at = new AccessToken();
        at.setToken("ertwertwert");
    	service.save(at);
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
			@Override
			public void run() {
		        // 调用接口获取access_token  
		        //AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);
		        //weixinService.save(at);
				System.out.println("需要执行的任务");
			}
		};
        //timer.schedule(task, 60*60*1000);
		timer.schedule(task,5000 ,6*1000);
    }
    
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException,
            IOException
    {
        
    }
    
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException
    {
        doGet(request, response);
    }
    
}
