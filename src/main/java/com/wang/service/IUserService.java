/**
 * 
 */
package com.wang.service;

import com.wang.entity.UserEntity;

/**
 * @author wang
 */
public interface IUserService extends BaseService {
	public boolean isExist(UserEntity user);

	/**
	 * @return
	 */
	public Object getById(String id);
}
