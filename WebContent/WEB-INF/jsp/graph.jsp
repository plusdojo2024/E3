<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ふぃたごっち | 活動記録</title>
<link rel="stylesheet" href="/E3/css/common.css">
<link rel="stylesheet" href="/E3/css/graph.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://cdn.jsdelivr.net/npm/chart.js@3.9.1/dist/chart.min.js"></script>
</head>
<body>
	<header>
		<a href="/E3/GrowthServlet"><img src="/E3/img/TOP.png" width="10%"></a>
		<h3 class="username">  
		<input type="text" name="user_name" value="${user_name}" readonly="readonly">さんの<br>
		活動記録
		</h3>
	</header>
	<body>
		<c:choose>
			<c:when test="${before}">
				<p>応援メッセージ</p>
			</c:when>
		</c:choose>
		<c:choose>
    		<c:when test="${sum_calories < 500}">
        		<img src="/E3/img/TOP.png" width="10%">
    		</c:when>
    		
		</c:choose>
		
	<!-- 切り替えタブ -->
		<div class="tabs">
			<input id="week" type="radio" name="tab_item" checked>
			<label class="tab_item" for="week">週</label>
			<input id="month" type="radio" name="tab_item">
 			<label class="tab_item" for="month">月</label>
			 <input id="year" type="radio" name="tab_item">
 			<label class="tab_item" for="year">年</label>

			<div class="tab_content" id="week_content">
				<div class="tab_content_description">
					<canvas id="weekchart"></canvas>
					<script>
	
						let barCtx = document.getElementById('weekchart').getContext("2d");
						//グラフの設定
						barCtx.canvas.height = "50px";
						let barConfig = {
							type: 'bar',
							data: {
								labels: ["日","月","火","水","木","金","土"],
								datasets : [ {
									data : [34, 10, 24, 24, 40, 12, 34],
									label : 'kcal',
								backgroundColor: [
										'red','yellow','yellow','yellow','yellow','yellow','red',
									],
									borderwidth : 1,
								} ] , 
							} ,
						} ;
						let barChart = new Chart(barCtx, barConfig);
					</script>
				</div>
			</div>
			<div class="tab_content" id="month_content">
				<div class="tab_content_description">
					<canvas id="month"></canvas>
				</div>
			</div>
			<div class="tab_content" id="year_content">
				<div class="tab_content_description">
					<canvas id="year"></canvas>
				</div>
			</div>
		</div>
	</body>
	<footer>
	</footer>
	
</body>
</body>
</html>