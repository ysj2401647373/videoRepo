<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>视频添加-视频管理</title>
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
				<h2>编辑视频信息-视频管理</h2>
			</div>
			<form class="form-horizontal" action="${pageContext.request.contextPath}/video/addVideo.action" method="post">
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">视频标题</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputEmail3" placeholder="视频标题" name="videoTitle">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">主讲人</label>
					<div class="col-sm-10">
						<select class="form-control" id="inputPassword3" name="speakerId">
							<c:forEach var="speaker" items="${speaker}">
							<option value="${speaker.id}">${speaker.speakerName}</option>
						</c:forEach>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">所属课程</label>
					<div class="col-sm-10">
						<select class="form-control" id="inputPassword3" name="courseId">
						<c:forEach var="subject" items="${subject}">
							<option value="${subject.id}">${subject.subjectName}</option>
						</c:forEach>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">视频时长</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputEmail3" placeholder="视频时长(秒)" name="videoLength">
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">封面图片</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputEmail3" placeholder="视频封面图片地址,网络图片" name="videoImageUrl">
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">视频播放地址</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputEmail3" placeholder="视频播放地址,网络地址" name="videoUrl">
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">视频简介</label>
					<div class="col-sm-10">
						
						<textarea class="form-control" id="inputEmail3" placeholder="请输入视频简介" name="videoDescr" rows="3"></textarea>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<input type="submit" class="btn btn-primary">
						<a class="btn btn-default" href="javascript:history.go(-1)">返回列表</a>
					</div>
				</div>
			</form>
		</div>

	</body>

</html>