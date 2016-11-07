/**
 * 
 */
package com.wang.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author wanfangg
 */
@Table(name="user")
@Entity
public class UserEntity extends Root {
	private String username;
	private String password;
	private boolean sex; // 默认为0；0表示男，1表示女
	
	@Column(name = "USERNAME", nullable = false, length = 20)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "PASSWORD", nullable = false, length = 32)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "SEX", nullable = false, length = 1)
	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "User [ \nid : " + super.getId() + "\nusername : " + this.username
				+ "\npassword : " + this.password + "\nsex : " + this.sex
				+ " ]";
	}

}
