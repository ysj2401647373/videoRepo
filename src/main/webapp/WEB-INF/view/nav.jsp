<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
	<!--引入模版-->

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
		<title>后台管理系统</title>

		<!-- Bootstrap -->
		<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
	</head>
	<style>
		.container {
			border: 0px solid black;
		}
	</style>

	<body>
		<div class="container">
			<nav class="navbar navbar-inverse">
				<div class="container-fluid">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
						<a class="navbar-brand" href="#">视频管理系统</a>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li class="active">
								<a href="#">视频管理<span class="sr-only">(current)</span></a>
							</li>
							<li>
								<a href="#">主讲人管理</a>
							</li>
							<li>
								<a href="#">课程管理</a>
							</li>
							<li>
								<a href="#">统计分析</a>
							</li>

						</ul>
						<div class="nav navbar-nav navbar-right">
							
							<div class="navbar-brand">
								
								<a href="#">admin<a class="glyphicon glyphicon-share"></a></a>
							</div>
							
							
						</div>

					</div>
					
				</div>
				
			</nav>