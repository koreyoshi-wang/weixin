/**
 * 
 */
package com.wang.service.impl;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wang.entity.UserEntity;
import com.wang.service.UserService;

/**
 * @author wang
 */
@Transactional
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl implements UserService {
	

	@Override
	public boolean isExist(UserEntity user) {
		Session session = getSession();
		String hql = "from UserEntity where username =? and password = ?";
		Query query = session.createQuery(hql);
		query.setString(0, user.getUsername());
		query.setString(1, user.getPassword());
		if (query.list().size() >= 1) {
			return true;
		}
		return false;
	}
	
	@Override
	public Object getById(String id){
		Session session = getSession();
		String hql = "from UserEntity where id =?";
		Query query = session.createQuery(hql);
		query.setString(0, id);
	return query.list().get(0);
	}

}
