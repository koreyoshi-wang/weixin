package com.wang.service;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wang.entity.Article;
import com.wang.entity.Reply;
import com.wang.entity.UserEntity;
import com.wang.service.UserService;
import com.wang.util.WeixinUtil;

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
		//userService.save(user);
		/*Reply reply =  new Reply();
		reply.setMsgType(reply.NEWS);
		reply.setToUserName("23452345");
		reply.setFromUserName("235423452345");
		reply.setContent("图文消息测试");
		userService.save(reply);*/
		Reply reply1 =(Reply) userService.getById(Reply.class, "9025341b58479cc50158479ccad90000");
		/*Article ar = new Article();
		ar.setReply(reply1);
		ar.setTitle("图文消息测试title");
		ar.setDescription("图文消息测试description");
		ar.setUrl("asdfasdfasdfasd");
		userService.save(ar);*/
		Article ar1 = (Article) userService.getById(Article.class, "9025341b5847a494015847a49a1c0000");
		List<Article> list = new ArrayList<Article>();
		list.add(ar1);
		reply1.setArticles(list);
		String back = WeixinUtil.replyToXml(reply1);
		System.out.println(back);
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
