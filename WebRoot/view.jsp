
<%@page import="cn.bbs.dao.TieDao"%>
<%@page import="cn.bbs.entity.TieEntity"%>
<%@ page language="java" import="java.util.*,cn.bbs.common.Utils" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <link href="css/bbs.css" rel="stylesheet" type="text/css" />
    <script src="js/jquery.js"></script>
	<script type="text/javascript" src="js/loginfrm.js"></script>
	<script>
		$(function(){
			$("input[type='submit']").click(function(){
				var islogin="0";
				<%
					if(session.getAttribute("user")!=null){
						out.print("islogin=1;");
					}
				%>
				if(islogin=="1"){
				
				}else{
					alert("请先登录，再评论");
					return false;
				}
			});
		});
	</script>
  </head>
  
  <body>
     <%@include file="partal/verCheck.jsp" %>
   	<%
   		int id=0;
   		String mid=request.getParameter("id");
    	if(mid==null){
    		response.sendRedirect("index.jsp");
    	}else{
    		id=Integer.parseInt(mid);
    	}
		TieEntity entity=new TieDao().getTieById(id);
		if(entity!=null){
   	 %>
   	<div class="content">
   		<div class="bbsvivetop">
			<h2 class="titleview"><%=entity.getTieTitle()%></h2> 
			<span class="subtitleview">发表日期：<%=entity.getTieDate() %>
				<br>作者：<%=entity.getUserName() %></span>
		</div>
		<div class="bbscontent"><%=entity.getTieContent() %></div>
	</div>
	<%} %>
	<h3>发表回复：</h3><br/>
	<form name="f" action="/BBS/servlet/comment" method="post">
	<textarea name="content"  onselect="storeCaret();" onclick="storeCaret();" onkeyup="storeCaret();" rows="5" class="KL_textarea" style="width:99%; color:#999;">
	文明上网，健康回帖！<br/><h1>请先<a href="login.jsp">登录</a>，再回帖</h1>
	
	</textarea>

	<input type="hidden"  name="userid" value="session.getAttribute('userid')"/>
	<input type="hidden"  name="mid" value="mid"/>
	<input type="submit" value="提交"/>
	</form><br/>
	<h3>评论区：</h3><br/>
	<div class="bbsline">
    	 <span class="biaoti">这里是楼</span>
    	 <span class="right">用户ID:</span>
    	 <span class="right">时间：</span>
    	 <br>
    	 评论内容：
    </div>
  </body>
</html>
