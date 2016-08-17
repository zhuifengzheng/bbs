<%@ page language="java" import="java.util.*,cn.bbs.common.Utils" pageEncoding="UTF-8"%>
  <!-- 登录窗口 -->
    <div id="myloginfrm">
    	<h4>用户登录</h4>
    	<table>
    		<tr>
    		<td>用户名：</td>
    		<td><input type="text" name="username" /></td>
    		<td width="50"></td>
    		</tr>
    		<tr>
    		<td>密码：</td>
    		<td><input type="password" name="userpwd" /></td>
    		<td></td>
    		</tr>
    		<tr>
    			<td>
    			</td>
    			<td colspan="2">
    			<input type="button" value="登录"><input type="button" value="取消">
    			<label id="msg">数据请求中,请稍后...</label>
    			</td>
    		</tr>
    	</table>
    </div>
    
    <!-- 头部菜单 -->
    <div class="bbsline">
    <%
    	if(session.getAttribute("user")==null){
     %>
    	 <span class="biaoti">下午好，游客</span>
    	 <span class="right">
    	 	<a href="reg.jsp">注册</a>
    		<a href="javascript:void(0)">登录</a>
    <%
    	}else{
    		out.print(Utils.getHello()+"，"+session.getAttribute("user").toString());
    	}
     %>
    	</span>
    </div>