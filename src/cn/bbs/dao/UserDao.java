package cn.bbs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.bbs.entity.UserEntity;

public class UserDao {
	/**
	 * 新增
	 * @param entity
	 * @return
	 */
	public int save(UserEntity entity){
		String sql="insert into tbUser value(?,?,?)";
		return exc(sql, new Object[]{entity.getUserName(),entity.getUserPwd(),entity.getUserIco()});
	}
	/**
	 * 修改
	 * @param entity
	 * @return
	 */
	public int modify(UserEntity entity){
		String sql="update tbUser set userpwd=?,useric=? where username=?";
		return exc(sql, new Object[]{entity.getUserPwd(),entity.getUserIco(),entity.getUserName()});
	}
	/**
	 * 删除
	 * @param entity
	 * @return
	 */
	public int delete(String userName){
		String sql="delete from tbUser where username=?";
		return exc(sql, new Object[]{userName});
	}
	
	/**
	 * 根据用户名得到用户实体对象
	 * @param userName
	 * @return
	 */
	public UserEntity getUserByUsername(String userName){
		String sql="select username,userpwd,userico from tbUser where username=?";
		
		DbDao db=new DbDao();
		try {
			ResultSet rs = db.getData(sql, new Object[]{userName});
			if(rs.next()){
				return getEntity(rs);
			}
		} catch (Exception e) {
			System.err.println("my Ex:"+e.getMessage());
		}finally{
			db.dispose();
		}
		return null;
	}
	/**
	 * 根据用户名得到用户实体对象
	 * @param userName
	 * @return
	 */
	public UserEntity getUserByUsername(String userName,String userPwd){
		String sql="select username,userpwd,userico from tbUser where username=? and userpwd=?";
		
		DbDao db=new DbDao();
		try {
			ResultSet rs = db.getData(sql, new Object[]{userName,userPwd});
			if(rs.next()){
				return getEntity(rs);
			}
		} catch (Exception e) {
			System.err.println("my Ex:"+e.getMessage());
		}finally{
			db.dispose();
		}
		return null;
	}
	
	private int exc(String sql,Object[] obj){
		DbDao db=new DbDao();
		try{
			return db.executeSqlNoneRs(sql, obj);
		}catch (SQLException e) {
		}finally{
			db.dispose();
		}
		return -1;
	}
	private UserEntity getEntity(ResultSet rs){
		try{
			UserEntity entity=new UserEntity();
			entity.setUserIco(rs.getString("userico"));
			entity.setUserName(rs.getString("username"));
			entity.setUserPwd(rs.getString("userpwd"));
			
			return entity;
		}catch (Exception e) {System.err.println("my Ex:"+e.getMessage());}
		return null;		
	}
}
