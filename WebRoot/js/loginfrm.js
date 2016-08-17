$(function(){
		
			var $loginFrm=$("#myloginfrm");
			$loginFrm.hide();
			$("#msg").hide();
			
			//为登录链接增加点击事件
			$(".bbsline .right a").eq(1).click(function(){
				$loginFrm.show();
			});
			
			//关闭登录窗口
			$("input[value='取消']").click(function(){
				$loginFrm.hide();
			});
			
			//登录
			var $userName=$("input[name='username']");
			var $userPwd=$("input[name='userpwd']");
			$("input[value='登录']").click(function(){
				var flag=true;
				if($userName.val()==""){
					$("#myloginfrm td").eq(2).html("<font color='red'>* 必填项</font>");
					flag=false;
				}
				if($userPwd.val()==""){
					$("#myloginfrm td").eq(5).html("<font color='red'>* 必填项</font>");
					flag=false;
				}
				//必填项全填
				if(flag){
					$.ajax({
						url:"/bbs/user/login",
						type:"post",
						data:{username:$userName.val(),userpwd:$userPwd.val()},
						cache:false,
						timeout:1000,
						beforeSend:function(){
							$("#msg").show();
						},
						success:function(d){
							if(d==""){
								$("#msg").html("登录失败!");
							}else{
								$loginFrm.hide();
								$(".bbsline").eq(0).html("<%=Utils.getHello()%>，"+d);
							}
						},
						error:function(){
							alert("error");
						}
					});
				}
			});
			
			$userName.blur(function(){
				if($userName.val()==""){
					$("#myloginfrm td").eq(2).html("<font color='red'>* 必填项</font>");
				}else{
					$("#myloginfrm td").eq(2).html("");
				}
			});
			$userPwd.blur(function(){
				if($userPwd.val()==""){
					$("#myloginfrm td").eq(5).html("<font color='red'>* 必填项</font>");
				}else{
					$("#myloginfrm td").eq(5).html("");
				}
			});
		});