package cn.bbs.dao;

import java.sql.*;

public class DbDao {
	private Connection connection;
	private Statement statement;
	private PreparedStatement ps;
	/**
	 * 加载数据库驱动
	 * */
	public DbDao(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();//打印异常
		}
	}
	
	/**
	 * 与数据库建立连接
	 * */
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mybbs","root","123456");
	}
	/**
	 * 执行查询操作
	 * */
	public ResultSet getData(String sql) throws SQLException{
			connection=getConnection();
			statement=connection.createStatement();
			return statement.executeQuery(sql);
	}
	/**
	 * 执行查询操作
	 * */
	public ResultSet getData(String sql,Object[] objs) throws SQLException{
			connection=getConnection();
			ps=connection.prepareStatement(sql);
			if(objs!=null && objs.length>0){
				for(int i=1;i<=objs.length;i++){
					ps.setObject(i, objs[i-1]);
				}
			}
			return ps.executeQuery();
	}
	/**
	 * 执行增删改操作
	 * */
	public int executeSqlNoneRs(String sql) throws SQLException{
			connection=getConnection();
			statement=connection.createStatement();
			return statement.executeUpdate(sql);
	}
	
	/**
	 * 执行增删改操作
	 * */
	public int executeSqlNoneRs(String sql,Object[] objs) throws SQLException{
			connection=getConnection();
			ps=connection.prepareStatement(sql);
			if(objs!=null && objs.length>0){
				for(int i=1;i<=objs.length;i++){
					ps.setObject(i, objs[i-1]);
				}
			}
			return ps.executeUpdate();
	}
	/**
	 * 关闭连接
	 * */
	public void dispose(){
		try{
			if (statement!=null)
				statement.close();
			if (ps!=null)
				ps.close();
			if (connection!=null)
				connection.close();
		}catch(Exception e){}
	}
}
