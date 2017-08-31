<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="bobo" uri="http://zhiyou100.com/common/"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<title>视频列表-视频管理</title>
<link href="${pageContext.request.contextPath }/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/jquery-confirm.css"
	rel="stylesheet">
<script
	src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery-confirm.js"></script>
<style>
.container {
	border: 0px solid black;
	;
}
</style>
<script type="text/javascript">
	/* var count=0;
	function deleteVideo(){
	var x=confirm("你确定删除吗?");
	   alert(x);
	 }
	function countDelete(the) {
	if(the.checked==true){
		count++;
	}else{
		count--;
	}
	document.getElementsByTagName("span")[0].innerHTML=count;	
	}
	function deleteAll(a){
		var a=confirm("是否删除所选内容?");
		if(a==true){
			document.getElementsByTagName("form")[1].submit();		
	}	
	} */
	var count = 0;
	$(function() {
		$(".plAll").click(function() {
			$(".del").prop("checked", this.checked);
			if (this.checked) {
				count = $(".del").length;
			} else {
				count = 0;
			}
			$(".badge").text(count);
		})

		$(".del").click(function() {
			//alert("111");
			if (this.checked == true) {
				count++;
			} else {
				count--;
			}
			$(".badge").text(count);
			if (count == $(".del").length) {
				$(".plAll").prop("checked", true);
			} else {

				$(".plAll").prop("checked", false);
			}
		});

		/* $(".glyphicon-trash").click(function() {
			var x = confirm("你确定删除吗?");
			alert(x);
		})  */
		/* $(".glyphicon-trash").click(function(id) { */
			
		/* $("#pld").click(function(){
			var a=confirm("是否删除所选内容?");
			if(a==true){
			$(".pl").submit();	
			}
			
		});
		 */

		 
		 
		 
		 
		 
		 
	/*  $("#pld").click(function() {
			if (count == 0) {
				$.alert({
					title : '警告',
					content : '没有选中删除的序号',
				});
				return;
			}
			;
			$.confirm({
				title : '警告',
				content : '你确定要全部删除么',
				buttons : {
					confirm : {
						text : '确定',
						action : function() {
							$(".pl").submit();

						}
					},
					取消 : function() {
						$.alert('取消');
					}
				}
			});
		})  */
        $("#pld").click(function() {
			if (count == 0) {
				$.alert({
					title : '警告',
					content : '没有选中删除的序号',
				});
				return;
			}
			;
			$.confirm({
				title : '警告',
				content : '你确定要全部删除么',
				buttons : {
					confirm : {
						text : '确定',
						action : function() {
						     $.ajax({
								url:"${pageContext.request.contextPath}/video/deleteInVideo.action",
						    	 data:$(".pl").serialize(),
								success:function(msg){
							           if(msg=="success"){
							        	   location.reload();
							           }
								},
									
						})
		
						}
					},
					取消 : function() {
						$.alert('取消');
					}
				}
			});
		})


			
			
			
	/* 	}) */
		
		
		
		
		
	});
	
	
	
	function deleteIn(id){
		 $.confirm({
			    title: '警告',
			    content: '确认删除么?',
			 
			    buttons: {   
			        confirm: {
			            text: "确认",				          
			            action: function(){
			              $.ajax({
			            	  dataType:"text",
			            	  data:{"id":id},
			            	  url:"${pageContext.request.contextPath }/video/deleteVideo.action",
			            	  success:function(msg){
			            		  if(msg=="success"){
			            			  location.reload();
			            		  }
			            	  }
			            	  
			            	  
			              });
			            	/*location.href = "${pageContext.request.contextPath }/video/deleteVideo.action?id="+id; */
			            }
			        },
			        取消: function(){
			                
			        }
			    }
			});

	}

</script>
</head>
<body>
	<div class="container">


		<div class="jumbotron">
			<h2>视频列表-视频管理</h2>
		</div>
		<div>
			<div class="navbar-form navbar-left">

				<a href="${pageContext.request.contextPath}/video/addVideo.action"
					class="btn btn-primary">添加视频</a> <a class="btn btn-primary"
					role="button" id="pld">批量删除<span class="badge">0</span></a>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">

				<form class="navbar-form navbar-right"
					action="${pageContext.request.contextPath }/video/videoList.action"
					method="post">

					<input type="text" name="videoTitle" placeholder="视频标题"
						class="form-control" value="${videoTitle}" /> <select
						class="form-control" name="speakerId">
						<option value="0">请选择主讲人</option>
						<c:forEach var="speaker" items="${speaker}">
							<option value="${speaker.id}"
								${speaker.id == speakerId?"selected":""}>${speaker.speakerName}</option>
						</c:forEach>
					</select> <select class="form-control" name="courseId">
						<option value="0">请选择课程</option>
						<c:forEach var="course" items="${course}">
							<option value="${course.id}"
								${course.id ==courseId?"selected":""}>${course.courseName}</option>
						</c:forEach>
					</select>
					<button type="submit" class="btn btn-primary">查询</button>
				</form>

			</div>

		</div>

		<div style="margin-top: 10px;">

			<form
				action="${pageContext.request.contextPath}/video/deleteInVideo.action" id=""
				class="pl" >

				<table class="table table-hover">
					<tr>
						<th class="col-md-0"><input type="checkbox" name="idxf"
							class="plAll"></th>
						<th class="col-md-0">序号</th>
						<th class="col-md-1">名称</th>
						<th class="col-md-8">介绍</th>
						<th class="col-md-0">讲师</th>
						<th class="col-md-1">课程</th>
						<th class="col-md-1">时长(秒)</th>
						<th class="col-md-1">播放次数</th>
						<th class="col-md-0">编辑</th>
						<th class="col-md-0">删除</th>
					</tr>
					<c:forEach items="${page.rows}" var="video" varStatus="status">
						<tr>
							<td><input type="checkbox" name="ids" value="${video.id}"
								class="del"></td>
							<td>${status.count}</td>
							<td>${video.videoTitle}</td>
							<td>${video.videoDescr}</td>
							<td>${video.speakerName}</td>
							<td>${video.courseName}</td>
							<td>${video.videoLength}</td>
							<td>${video.videoPlayTimes}</td>
							<td><a class="glyphicon glyphicon-edit" role="button"
								href="${pageContext.request.contextPath }/video/updateVideo.action?id=${video.id}"></a></td>
							<td><a class="glyphicon glyphicon-trash" role="button"
								href="#" id="${video.id}" onclick="deleteIn(${video.id})"></a></td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</div>
		<div>
			<div style="float: right; margin-right: 50px; margin-top: -10px;">

				<bobo:page
					url="${pageContext.request.contextPath }/video/videoList.action"></bobo:page>
			</div>
			<%--   <div style="float:right; margin-right:-30px; margin-top: 5px;">共有${page.total }条</div> --%>
		</div>
	</div>
</body>

</html>