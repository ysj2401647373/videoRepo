<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>

	<head>
		<meta charset="UTF-8">
		<title>主讲人列表-主讲人管理</title>
		<link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
		<script src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"></script>
		<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
		<style>
			.container {
				border: 0px solid black;
				;
			}
		</style>
	</head>

	<body>
		<div class="container">

			<div class="jumbotron">
				<h2>主讲人列表-主讲人管理</h2>
			</div>
			<div>
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-form navbar-left">

					<a href="${pageContext.request.contextPath}/speaker/addSpeaker.action" class="btn btn-primary">添加主讲人</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

					<form class="navbar-form navbar-right" action="${pageContext.request.contextPath}/speaker/speakerList.action" method="post">

						<b>名称</b>
						<input type="text" name="speakerName" placeholder="主讲人名称" class="form-control" />
						<b>职位</b>
						<input type="text" name="speakerJob" placeholder="主讲人职位" class="form-control" />

						<button type="submit" class="btn btn-primary">查询</button>

					</form>

				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
			<div style="margin-top: 10px;">
				<table class="table">
					<tr>
						<th width="2%">序号</th>
						<th width="5%">名称</th>
						<th width="5%">职位</th>
						<th width="80%">简介</th>
						<th width="4%">编辑</th>
						<th width="4%">删除</th>
					</tr>
					<c:forEach var="speaker"  items="${speaker}" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td>${speaker.speakerName}</td>
						<td>${speaker.speakerJob}</td>
						<td>${speaker.speakerDescr}</td>
						<td>
							<a class="glyphicon glyphicon-edit" role="button" href="${pageContext.request.contextPath}/speaker/updateSpeaker.action?id=${speaker.id}"></a>
						</td>
						<td>
							<a class="glyphicon glyphicon-trash" role="button" href="${pageContext.request.contextPath}/speaker/deleteSpeaker.action?id=${speaker.id}"></a>
						</td>
					</tr>
					
					</c:forEach>
				</table>
			</div>

			<div class="navbar-form navbar-right">
				<nav aria-label="...">
					<ul class="pagination">
						<li class="disabled">
							<a href="#" aria-label="Previous"><span aria-hidden="true">上一页</span></a>
						</li>
						<li class="active">
							<a href="#">1 <span class="sr-only">(current)</span></a>
						</li>
						<li>
							<a href="#">2</a>
						</li>
						<li class="disabled">
							<a href="#" aria-label="Previous"><span aria-hidden="true">下一页</span></a>
						</li>
					</ul>
				</nav>
			</div>

		</div>

	</body>

</html>