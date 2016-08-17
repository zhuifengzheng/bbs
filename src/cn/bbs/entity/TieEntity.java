package cn.bbs.entity;

import java.util.Date;

/**
 * 帖子的实体类
 */
public class TieEntity {
	  private int tieId;
	 private String tieTitle;
	 private String tieDesc;
	 private String tieContent;
	 private String userName;
	 private Date tieDate;
	 private int tieAtrr;
	public int getTieId() {
		return tieId;
	}
	public void setTieId(int tieId) {
		this.tieId = tieId;
	}
	public String getTieTitle() {
		return tieTitle;
	}
	public void setTieTitle(String tieTitle) {
		this.tieTitle = tieTitle;
	}
	public String getTieDesc() {
		return tieDesc;
	}
	public void setTieDesc(String tieDesc) {
		this.tieDesc = tieDesc;
	}
	public String getTieContent() {
		return tieContent;
	}
	public void setTieContent(String tieContent) {
		this.tieContent = tieContent;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getTieDate() {
		return tieDate;
	}
	public void setTieDate(Date tieDate) {
		this.tieDate = tieDate;
	}
	public int getTieAtrr() {
		return tieAtrr;
	}
	public void setTieAtrr(int tieAtrr) {
		this.tieAtrr = tieAtrr;
	}
}
