/**
 * 
 */
package com.wang.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wanfangg
 */
@Table(name="accesstoken")
@Entity
public class AccessToken extends Root {  
	// 获取到的凭证  
    private String token;  
    // 凭证有效时间，单位：秒  
    private int expiresIn;  
	
	@Column(name = "TOKEN", nullable = false, length = 512)
    public String getToken() {  
        return token;  
    }  
  
    public void setToken(String token) {  
        this.token = token;  
    }  
    
    @Column(name = "EXPIRESIN", nullable = false)
    public int getExpiresIn() {  
        return expiresIn;  
    }  
  
    public void setExpiresIn(int expiresIn) {  
        this.expiresIn = expiresIn;  
    } 
    
}  