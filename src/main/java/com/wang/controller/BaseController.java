/**
 * 
 */
package com.wang.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.wang.service.BaseService;

/**
 * @author wanfangg
 */
@Controller()
public class BaseController {
	@Resource
	private BaseService baseService;
	
	public void save(Object object){
		if (object != null){
			baseService.save(object);
		}
	}
	
	public void update(Object object){
		if (object != null){
			baseService.update(object);
		}
	}
	
	public void delete(Object object){
		if (object != null){
			baseService.delete(object);
		}
	}
	
	public Object getById(Class<?> c, String id){
			return baseService.getById(c, id);
	}
	
	public List<Object> getAll(Class<?> c){
		return baseService.getAll(c);
}
	
}
