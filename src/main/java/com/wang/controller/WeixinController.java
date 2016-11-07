/**
 * 
 */
package com.wang.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.wang.entity.AccessToken;
import com.wang.entity.Menu;
import com.wang.entity.Reply;
import com.wang.util.WeixinUtil;

/**
 * @author wanfangg
 */
@Controller()
public class WeixinController {
	
	private static final String TOKEN = "koreyoshi";
	
	//微信公众平台验证url是否有效使用的接口
	@RequestMapping(value="/weixin",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String initWeixinURL(HttpServletRequest request){
		String echostr = request.getParameter("echostr");
		System.out.println("Get Request!");
		if (checkWeixinReques(request) && echostr != null) {
			System.out.println("success!");
			return echostr;
		}else{
			System.out.println("fail!");
			return "error";
		}
	}
	
	
	/**
	 * 根据token计算signature验证是否为weixin服务端发送的消息
	 */
	private static boolean checkWeixinReques(HttpServletRequest request){
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		if (signature != null && timestamp != null && nonce != null ) {
			String[] strSet = new String[] { TOKEN, timestamp, nonce };
			java.util.Arrays.sort(strSet);
			String key = "";
			for (String string : strSet) {
				key = key + string;
			}
			String pwd = WeixinUtil.sha1(key);
			return pwd.equals(signature);
		}else {
			return false;
		}
	}
	
	//接收微信公众号接收的消息，处理后再做相应的回复
		@RequestMapping(value="/weixin",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
		@ResponseBody
		public String replyMessage(HttpServletRequest request){
			//仅处理微信服务端发的请求
			if (checkWeixinReques(request)) {
				Map<String, String> requestMap = WeixinUtil.parseXml(request);
				System.out.println(requestMap.get("ToUserName"));
				Reply reply = new Reply();
				reply.setToUserName(requestMap.get("FromUserName"));
				reply.setFromUserName(requestMap.get("ToUserName"));
				reply.setCreateTime(new Date());
				reply.setMsgType(Reply.TEXT);
				reply.setContent("Send: \n"+requestMap.get("Content")+"\nReply: \nSuccess!");
				//将回复消息序列化为xml形式
				String back = WeixinUtil.replyToXml(reply);
				System.out.println(back);
				return back;
			}else{
				return "error";
			}
		}
		
		@RequestMapping(value="/weixintest")
		@ResponseBody
		public String tokenAndMenuTest(HttpServletRequest request){
			String s = "Call Failed!";
			// 第三方用户唯一凭证  
	        String appId = "wx16d6a8f6cd4bff6b";  
	        // 第三方用户唯一凭证密钥  
	        String appSecret = "7b9cb57cb9d3d9cc9f5066b8f293cb37";
	        // 调用接口获取access_token  
	        AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);
	        System.out.println(at.getToken());
	        Menu menu = WeixinUtil.getMenu();
	        if (null != at) {  
	            // 调用接口创建菜单  
	            int result = WeixinUtil.createMenu(menu, at.getToken());  
	  
	            // 判断菜单创建结果  
	            if (0 == result)  
	            	s = "菜单创建成功！" + JSONObject.toJSON(menu).toString();
	            else  
	            	s = "菜单创建失败，错误码：" + result;  
	        }
	        return s;
		}
	
}