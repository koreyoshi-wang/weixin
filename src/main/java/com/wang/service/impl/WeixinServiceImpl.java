/**
 * 
 */
package com.wang.service.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Service;

import com.wang.service.WeixinService;

/**
 * @author wanfangg
 */
@Service("weixinService")
public class WeixinServiceImpl extends BaseServiceImpl implements WeixinService {
	@Override
	public String getAccessToken(){
		String hql = "select token from AccessToken order by createDate desc";
		Query query = getSession().createQuery(hql);
		String accessToken = (String) query.list().get(0);
		return accessToken;
	}

}
