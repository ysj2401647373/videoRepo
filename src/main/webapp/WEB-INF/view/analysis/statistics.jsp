<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>"> 
<title>统计 - 统计分析</title>
<link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"></script>
<script src="${pageContext.request.contextPath }//js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath }/js/echarts.js"></script>
<script src="${pageContext.request.contextPath }/js/echarts-all.js"></script>

<script type="text/javascript">
	$(function(){
		 var theData = "${data}".split(",");
		var theTimes = "${times}".split(",");
		 // 基于准备好的dom，初始化echarts图表
        var myChart = echarts.init(document.getElementById('main'));
        // 指定图表的配置项和数据
        var option = {
        		
        		title: {
                    text: '课程平均播放次数',
                    subtext: '数据来源:zhiyou100.com',
                    sublink:'http://www.zhiyou100.com',
                    x: 'center'
        		
        		},
       
                tooltip: {
                	  show: true
                	  
                },
                legend: {
                	  y: 'bottom',
                    data:['课程平均播放次数']
                },
                xAxis : [
                    {
                        type : 'category',
                        data : theData
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series : [
                    {
                        "name":"课程平均播放次数",
                        "type":"bar",
                        "data":theTimes
                    }
                ]
            };
    
            // 为echarts对象加载数据 
            myChart.setOption(option); 
        }
    );
	</script>
</head>
<body>
	
	<!-- 引入公用的导航信息 -->
	<%-- <jsp:include page="WEB-INF/view/admin.jsp">
		<jsp:param value="statistics" name="fromJsp"/>
	</jsp:include> --%>
	
	<div class="container">
		<div class="jumbotron">
  			<h2>统计 - 统计分析</h2>
		</div>
		<div class="row">
			<div id="main" style="min-width:400px;height:400px"></div>
		</div>
	</div>
	<input type="button" value="加载ajax图表">
	<div>
	
	
	</div>
 <a href="video/videoList.action"></a>

	

</body>
</html>