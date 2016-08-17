package cn.bbs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import cn.bbs.entity.TieEntity;

public class TieDao {
	/**
	 * 新增
	 * @param entity
	 * @return
	 */
	public int save(TieEntity entity){
		String sql="insert into tbTie(tieTitle,tieDesc,tieContent,userName,tieDate,tieAttr) values(?,?,?,?,?,?)";
		return exc(sql, new Object[]{entity.getTieTitle(),entity.getTieDesc(),entity.getTieContent(),entity.getUserName(),entity.getTieDate(),entity.getTieAtrr()});
	}
	/**
	 * 修改
	 * @param entity
	 * @return
	 */
	public int modify(TieEntity entity){
		String sql="update tbTie set tieTitle=?,tieDesc=?,tieContent=?,userName=?,tieDate=?,tieAttr=? where tieId=?";
		return exc(sql, new Object[]{entity.getTieTitle(),entity.getTieDesc(),entity.getTieContent(),entity.getUserName(),entity.getTieDate(),entity.getTieAtrr(),entity.getTieId()});
	}
	/**
	 * 删除
	 * @param entity
	 * @return
	 */
	public int delete(int tieId){
		String sql="delete from tbTie where tieId=?";
		return exc(sql, new Object[]{tieId});
	}
	
	/**
	 * 根据编号得到实体对象
	 * @param userName
	 * @return
	 */
	public TieEntity getTieById(int tieId){
		String sql="select tieId,tieTitle,tieDesc,tieContent,userName,tieDate,tieAttr from tbTie where tieId=?";
		TieEntity entity=null;
		DbDao db=new DbDao();
		try {
			ResultSet rs = db.getData(sql, new Object[]{tieId});
			if(rs.next()){
				entity = getEntity(rs);
			}
			rs.close();
		} catch (Exception e) {
			System.err.println("my Ex:"+e.getMessage());
		}finally{
			db.dispose();
		}
		return entity;
	}
	
	/**
	 * 得到指定页的帖子
	 * @param pageSize 分页大小 
	 * @param curPage 当前页码
	 * @return
	 */
	public ArrayList<TieEntity> getListByPage(int pageSize,int curPage){
		String sql="select tieId,tieTitle,tieDesc,tieContent,userName,tieDate,tieAttr from tbTie limit "+((curPage-1)*pageSize)+","+pageSize;
		
		DbDao db=new DbDao();
		try {
			ResultSet rs=db.getData(sql);
			ArrayList<TieEntity> list=new ArrayList<TieEntity>();
			while(rs.next()){
				list.add(getEntity(rs));
			}
			rs.close();
			return list;
		} catch (SQLException e) {
			System.out.println("my Ex:"+e.getMessage());
		}finally{
			db.dispose();
		}
		return null;
	}
	
	/**
	 * 得到总页数
	 * @param pageSize 分页大小
	 * @return
	 */
	public int getPageCount(int pageSize){
		DbDao db=new DbDao();
		int pageCount=0;
		try {
			ResultSet rs=db.getData("select count(1) from tbTie");
			if(rs.next()){
				int recods=rs.getInt(1);
				pageCount=recods/pageSize+(recods%pageSize==0?0:1);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("my Ex:"+e.getMessage());
		}finally{
			db.dispose();
		}
		return pageCount;
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
	private TieEntity getEntity(ResultSet rs){
		try{
			TieEntity entity=new TieEntity();
			entity.setTieAtrr(Integer.parseInt(rs.getString("tieAttr")));
			entity.setTieContent(rs.getString("tieContent"));
			entity.setTieDate(new Date());
			entity.setTieDesc(rs.getString("tieDesc"));
			entity.setTieId(Integer.parseInt(rs.getString("tieId")));
			entity.setTieTitle(rs.getString("tieTitle"));
			entity.setUserName(rs.getString("userName"));
			
			return entity;
		}catch (Exception e) {System.err.println("my Ex:"+e.getMessage());}
		return null;		
	}
}
