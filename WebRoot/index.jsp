<%@page import="cn.bbs.dao.TieDao"%>
<%@page import="cn.bbs.entity.TieEntity"%>
<%@page import="cn.bbs.common.Utils"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    	int pageSize=10;//分页大小
    	int count=0;//总页数
    	int curPage=Utils.convetToInt(request.getParameter("page"), 1);
    	
    	TieDao tie=new TieDao();
    	tie.getPageCount(pageSize);
    	ArrayList<TieEntity> list=tie.getListByPage(pageSize, curPage);
    %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <title>中国第一论坛</title>
  	<link href="css/bbs.css" rel="stylesheet" type="text/css">
	<script src="js/jquery.js"></script>
	<script type="text/javascript" src="js/loginfrm.js"></script>
  </head>
  
  <body>
  <%@include file="partal/verCheck.jsp" %>
    <!-- 导航条 -->
    <div class="head">
    	<div class="head1">
    		<a href="add.jsp">发帖</a>
    		<a href="#">版务</a>
    		<a href="#">精华</a>
    		<a href="#">专题</a>
    		<a href="#">排行</a>
    	</div>
    </div>
    <!-- 文章列表 -->
    <%
    	if(list!=null)
    	for(TieEntity m:list){
    %>
    <div class="bbsline">
    	 <span class="biaoti">
    	 	<a href='view.jsp?id=<%=m.getTieId()%>'><%=m.getTieTitle() %></a>
    	 </span>
    	 <span class="right"><%=m.getTieDate() %></span>
    	 <br>
    	 简介：<%=m.getTieDesc() %>
    	 <span class="right">作者ID:<%=m.getUserName() %></span>
    </div>
    <%}%>
    <br/>
    <!-- 分页 -->
    <div class="pgs">
    	<div class="pg">
    <%
    	for(int i=1;i<=count;i++){
    		if(i==curPage){
    			out.print("<strong>"+i+"</strong>");
    		}else{
    		out.print("<a href='index.jsp?page="+i+"'>"+i+"</a>");
    		}
    	}
   	%>
   		</div>
	</div>
	<!-- 版权申明 -->
	<br/>
	<br/>
	<p class="pgs">Copyright © 2016 Strive.com All Rights Reserved | 蜀ICP备 13046642号-2</p>
  	<br/>
	<br/>
  </body>
</html>
