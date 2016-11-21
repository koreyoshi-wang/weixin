/**
 * 
 */
package com.wang.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.wang.entity.AccessToken;
import com.wang.entity.Article;
import com.wang.entity.Menu;
import com.wang.entity.Message;
import com.wang.entity.Reply;
import com.wang.entity.TemplateData;
import com.wang.entity.WxTemplate;
import com.wang.util.WeixinUtil;

/**
 * @author wanfangg
 */
@Controller()
public class WeixinController extends BaseController {

	private static final String TOKEN = "koreyoshi";

	/**
	 * 微信公众平台验证url是否有效使用的接口
	 */
	@RequestMapping(value = "/weixin", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String initWeixinURL(HttpServletRequest request) {
		String echostr = request.getParameter("echostr");
		System.out.println("Get Request!");
		if (checkWeixinReques(request) && echostr != null) {
			System.out.println("success!");
			return echostr;
		} else {
			System.out.println("fail!");
			return "error";
		}
	}

	/**
	 * 根据token计算signature验证是否为weixin服务端发送的消息
	 */
	private static boolean checkWeixinReques(HttpServletRequest request) {
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		if (signature != null && timestamp != null && nonce != null) {
			String[] strSet = new String[] { TOKEN, timestamp, nonce };
			java.util.Arrays.sort(strSet);
			String key = "";
			for (String string : strSet) {
				key = key + string;
			}
			String pwd = WeixinUtil.sha1(key);
			return pwd.equals(signature);
		} else {
			return false;
		}
	}

	/**
	 * 接收微信公众号接收的消息，处理后再做相应的回复
	 */
	@RequestMapping(value = "/weixin", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String replyMessage(HttpServletRequest request) {
		// 仅处理微信服务端发的请求
		if (checkWeixinReques(request)) {
			Map<String, String> requestMap = WeixinUtil.parseXml(request);
			System.out.println(requestMap.get("ToUserName"));
			Message message = WeixinUtil.mapToMessage(requestMap);
			save(message);// 保存接受消息到数据库
			String type = message.getMsgType();
			if (type.equals(Message.TEXT)) {// 仅处理文本回复内容
				String content = message.getContent();// 消息内容
				String[] cs = content.split("_");// 消息内容都以下划线_分隔
				if (content.indexOf("messagetest") == -1){
					return "";
				}
			}
			// Reply reply = new Reply();
			Reply reply = (Reply) getById(Reply.class,
					"9025341b58479cc50158479ccad90000");
			reply.setToUserName(requestMap.get("FromUserName"));
			reply.setFromUserName(requestMap.get("ToUserName"));
			reply.setCreateTime(new Date());
			Article article = (Article) getById(Article.class,
					"9025341b5847a494015847a49a1c0000");
			List<Article> list = new ArrayList<Article>();
			list.add(article);
			reply.setArticleCount(list.size());
			reply.setArticles(list);
			update(reply);
			// reply.setMsgType(Reply.TEXT);
			reply.setContent("Send: \n" + requestMap.get("Content")
					+ "\nReply: \nSuccess!");
			// 将回复消息序列化为xml形式
			String back = WeixinUtil.replyToXml(reply);
			System.out.println(back);
			return "";
		} else {
			return "error";
		}
	}

	@RequestMapping(value = "/weixintest")
	@ResponseBody
	public String tokenAndMenuTest(HttpServletRequest request) {
		String s = "Call Failed!";
		String appId = "wx4240e73ac7d153c7";
		// 第三方用户唯一凭证密钥
		String appSecret = "83264065ef3fd932b81e7fcd24991cdb";
		// 第三方用户唯一凭证
		//String appId = "wx16d6a8f6cd4bff6b";
		// 第三方用户唯一凭证密钥
		//String appSecret = "7b9cb57cb9d3d9cc9f5066b8f293cb37";
		// 调用接口获取access_token
		AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);
		save(at);
		System.out.println(at.getToken());

		Menu menu = WeixinUtil.getMenu();
		if (null != at) { // 调用接口创建菜单 int
			int result = WeixinUtil.createMenu(menu, at.getToken());
			System.out.println(JSONObject.toJSON(menu).toString());
			// 判断菜单创建结果
			if (0 == result) {
				s = "菜单创建成功！" + JSONObject.toJSON(menu).toString();
			} else {
				s = "菜单创建失败，错误码：" + result;
			}
		}

		return s;
	}
	
	/**
     * 发送模板消息
     * appId 公众账号的唯一标识
     * appSecret 公众账号的密钥
     * openId 用户标识
     */
	@RequestMapping(value = "/weixintt")
	@ResponseBody
    public String send_template_message() {
		String appId = "wx4240e73ac7d153c7";
		// 第三方用户唯一凭证密钥
		String appSecret = "83264065ef3fd932b81e7fcd24991cdb";
		String openId = "o_W5exInU4B2MAq2pGmeXW1eNUCk";
        AccessToken token = WeixinUtil.getAccessToken(appId, appSecret);
        String access_token = token.getToken();
        String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+access_token;
        WxTemplate temp = new WxTemplate();
        temp.setUrl("http://weixin.qq.com");
        temp.setTouser(openId);
        temp.setTopcolor("#7b68ee");
        temp.setTemplate_id("xBGtuS5Ur2jjij3ydq5tb5i7abYXUcvqpIA_Q--R0SM");
        Map<String,TemplateData> m = new HashMap<String,TemplateData>();
        TemplateData first = new TemplateData();
        first.setColor("#743a3a");  
        first.setValue("工单关闭通知");  
        m.put("first", first);  
        TemplateData name = new TemplateData();  
        name.setColor("#ff0000");  
        name.setValue("XX门店");  
        m.put("addr", name);
        TemplateData code = new TemplateData();  
        code.setColor("#c4c400");  
        code.setValue("SD000000");  
        m.put("code", code);
        TemplateData wuliu = new TemplateData();  
        wuliu.setColor("#0000ff");  
        wuliu.setValue("2016年11月11日");  
        m.put("create", wuliu);
        TemplateData orderNo = new TemplateData();  
        orderNo.setColor("#000000");  
        orderNo.setValue("2016年11月11日");  
        m.put("close", orderNo);
        TemplateData remark = new TemplateData();  
        remark.setColor("#008000");  
        remark.setValue("***备注说明***");  
        m.put("Remark", remark);
        temp.setData(m);
        String jsonString = JSONObject.toJSON(temp).toString();
        JSONObject jsonObject = WeixinUtil.httpRequest(url, "POST", jsonString);
        System.out.println(jsonObject);
        int result = 0;
        if (null != jsonObject) {  
             if (0 != jsonObject.getInteger("errcode")) {  
                 result = jsonObject.getInteger("errcode");
                 System.out.println("错误 errcode:{} errmsg:{}"+jsonObject.getInteger("errcode")+jsonObject.getString("errmsg"));  
             }  
         }
        System.out.println("模板消息发送结果："+result);
        return "模板消息发送结果："+result;
    }
	

}