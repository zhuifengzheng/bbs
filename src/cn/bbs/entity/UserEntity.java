package cn.bbs.entity;

/**
 * 用户实体类
 */
public class UserEntity {
	private String userName;
	private String userPwd;
	private String userIco;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserIco() {
		return userIco;
	}
	public void setUserIco(String userIco) {
		this.userIco = userIco;
	}
}
