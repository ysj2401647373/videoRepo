<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

<script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>


<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/messages_zh.min.js"></script>
<script type="text/javascript">
$(function(){
	$(".form-horizontal").validate({
		rules:{
			loginName:{
				required:true
			},
	        loginPwd:{
	        	required:true
	        }
		},
		messages:{
			loginName:{
				required:"请输入用户名"
			},
	        loginPwd:{
	        	required:"请输入登录密码"
	        }
			
		}
		
		
		
		
		
	})
	
	
})


</script>
<style>
.container {
	margin: 200px auto;
}
</style>
</head>

<body>
	<!--两边有空白-->
	<div class="container">
		
		<form class="form-horizontal"
			action="${pageContext.request.contextPath}/video/login.action"
			method="post">
			<div class="form-group">
				
			<div class="col-sm-6">
			<img src="${pageContext.request.contextPath}/img/logo.png" />
		</div>
			</div>
			<div class="form-group">
				<div class="col-sm-6">
					<input type="text" class="form-control" id="inputEmail3"
						placeholder="用户名" name="loginName" value="admin">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-6">
					<input type="password" class="form-control" id="inputPassword3"
						placeholder="登录密码" name="loginPwd" value="admin">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-6">
					<button type="submit" class="btn btn-lg btn-primary btn-block">登录</button>
				</div>
			</div>
		</form>

	</div>

</body>

</html>