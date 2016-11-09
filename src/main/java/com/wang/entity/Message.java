/**
 * 
 */
package com.wang.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 接收到的微信消息
 * 
 * @author wanfangg
 */
@Table(name = "message")
@Entity
public class Message extends Root implements Serializable{

	private static final long serialVersionUID = 1L;
	public static final String TEXT = "text";
	public static final String IMAGE = "image";
	public static final String LOCATION = "location";
	public static final String LINK = "link";
	public static final String EVENT = "event";
	
	// 开发者微信号  
    private String toUserName;  
    // 发送方帐号（一个OpenID）  
    private String fromUserName;  
    // 消息创建时间    
    private Date createTime;  
    // 消息类型（text/image/location/link）  
    private String msgType;  
    // 消息id，64位整型  
    private String msgId;
    
    // 消息内容 (文本消息专有)
    private String content;
    
    //图片链接 (图片消息专有)
    private String picUrl;
    
    // 消息标题 (链接消息专有) 
    private String title;  
    // 消息描述 (链接消息专有) 
    private String description;  
    // 消息链接  (链接消息专有)
    private String url;
    
    
    //地理位置纬度 Location_X(地理位置专有)
    private String locationX;
    //地理位置经度 Location_Y(地理位置专有)
    private String locationY;
    // 地图缩放大小  (地理位置专有)
    private String scale;  
    // 地理位置信息  (地理位置专有)
    private String label;
    
    //事件类型，subscribe(订阅)、unsubscribe(取消订阅)、CLICK(自定义菜单点击事件) （事件推送专有）
    private String event;
    //事件KEY值，与自定义菜单接口中KEY值对应（事件推送专有）
    private String eventKey;
    
    @Column(name = "TOUSERNAME", nullable = false)
	public String getToUserName() {
		return toUserName;
	}
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	
	@Column(name = "FROMUSERNAME", nullable = false)
	public String getFromUserName() {
		return fromUserName;
	}
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	
	@Column(name = "CREATETIME")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@Column(name = "MSGTYPE")
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	
	@Column(name = "MSGID")
	public String getMsgId() {
		return msgId;
	}
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	
	@Column(name = "CONTENT")
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Column(name = "PICURL")
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	
	@Column(name = "TITLE")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "URL")
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Column(name = "LOCATIONX")
	public String getLocationX() {
		return locationX;
	}
	public void setLocationX(String locationX) {
		this.locationX = locationX;
	}
	
	@Column(name = "LOCATIONY")
	public String getLocationY() {
		return locationY;
	}
	public void setLocationY(String locationY) {
		this.locationY = locationY;
	}
	
	@Column(name = "SCALE")
	public String getScale() {
		return scale;
	}
	public void setScale(String scale) {
		this.scale = scale;
	}
	
	@Column(name = "LABEL")
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	@Column(name = "EVENT")
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	
	@Column(name = "EVENTKEY")
	public String getEventKey() {
		return eventKey;
	}
	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}
    
}