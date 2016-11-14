/**
 * 
 */
package com.wang.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wang.service.BaseService;

/**
 * @author wanfangg
 */
@Transactional
@Service("baseService")
public class BaseServiceImpl implements BaseService {
	@Resource
	protected SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Object getById(Class<?> c, String id){
		return getSession().get(c, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getAll(Class<?> c){
		String hql = "from " + c.getSimpleName();
		Query query = getSession().createQuery(hql);
		if(query.list().size() >= 1){
			return query.list();
		} else {
			return null;
		}
	}
	
	@Override
	public void save(Object object){
		if (object != null){
			getSession().save(object);
		}
	}
	
	@Override
	public void update(Object object){
		if (object != null){
			getSession().update(object);
		}
	}
	
	@Override
	public void delete(Object object){
		if (object != null){
			getSession().delete(object);
		}
	}
	
}
