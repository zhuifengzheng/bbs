package cn.bbs.entity;

import java.util.Date;

/**
 * 评论实体类
 * @author strive.he
 * @date 2016-7-29
 */
public class CommentEntity {
	private int cId;
	private  String userName;
	private Date cDate;
	private String content;
	private int tId;
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getcDate() {
		return cDate;
	}
	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	
}
