<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="bobo" uri="http://zhiyou100.com/common/"%>
<!DOCTYPE html>

<html>

	<head>
		<meta charset="UTF-8">
		<title>课程列表-课程管理</title>
		<link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
		<script src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"></script>
		<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
		<style>
			.container {
				border: 0px solid black;
				
			}
		</style>
	</head>

	<body>
		<div class="container">

			<div class="jumbotron">
				<h2>课程列表-课程管理</h2>
			</div>
			<div>
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-form navbar-left">

					<a href="${pageContext.request.contextPath}/course/addCourse.action" class="btn btn-primary">添加课程</a>
				</div>

			</div>
			<!-- /.container-fluid -->
			<div style="margin-top: 10px;">
				<table class="table">
					<tr>
						<th width="2%">序号</th>
						<th width="5%">标题</th>
						<th width="5%">学科</th>
						<th width="80%">简介</th>
						<th width="4%">编辑</th>
						<th width="4%">删除</th>
					</tr>
					<c:forEach var="course"  items="${page.rows}" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td>${course.courseName}</td>
						<td>${course.sName}</td>
						<td>${course.courseDescr}</td>
						<td>
							<a class="glyphicon glyphicon-edit" role="button" href="${pageContext.request.contextPath}/course/updateCourse.action?id=${course.id}"></a>
						</td>
						<td>
							<a class="glyphicon glyphicon-trash" role="button" href="${pageContext.request.contextPath}/course/deleteCourse.action?id=${course.id}"></a>
						</td>
					</tr>
					</c:forEach>
				</table>
			</div>

			<div class="navbar-form navbar-right">
				<!-- <nav aria-label="...">
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
				</nav> -->
				
				<bobo:page
					url="${pageContext.request.contextPath }/course/courseList.action"></bobo:page>
				
				
			</div>

		</div>

	</body>

</html>