<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/E3/css/common.css">
	<link rel="stylesheet" href="/E3/css/graph.css">
    <title>ふぃたごっち | 活動記録</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    
</head>
<body>
<header>
		<div class="header">
			<a href="/E3/MainServlet"><img src="/E3/img/TOPcopy.png"></a>
			<div class="title">
				<input type="text" name="user_name" value="蓋河内歩" readonly="readonly">さんの<br>
				活動記録
			</div>
		</div>
	</header>
	<main>
		<div class="balloon5">
	        <div class ="faceicon">
	            <c:choose>
		    		<c:when test="${totalCalories < 500}">
		        		<img src="/E3/img/tamago.gif" width="100px">
		        	</c:when>
		    		<c:when test="${totalCalories < 1500}">
		        		<img src="/E3/img/子猫背景透過.gif" width="100px">
		        	</c:when>
		        	<c:when test="${totalCalories < 3500}">
		        		<img src="/E3/img/大人猫背景透過.gif" width="100px">
		        	</c:when>
		        	<c:when test="${totalCalories < 7500}">
		        		<img src="/E3/img/コス猫背景透過.gif" width="100px">
		        	</c:when>
		        	<c:when test="${totalCalories >= 7500}">
		        		<img src="/E3/img/羽猫背景透過.gif" width="100px">
		        	</c:when>
				</c:choose>
	        </div>
	        <div class="chatting">
	            <div class="says">
	            <p><span id="ouen_message"></span></p>
	        	</div>
	        </div>
	    </div>
		
<div class="graph_back"><!-- graph -->
	<div class="exchange_buttons">
		<button id="weekButton" onclick="showTab('week')" class="active-button exchange_button">週</button>
		<button id="monthButton" onclick="showTab('month')"class="exchange_button" >月</button>
		<button id="yearButton" onclick="showTab('year')"class="exchange_button" >年</button>
	</div>
	<div id="week" class="tab active">
		<h2 class="hogeLabel" id="weekLabel">1週目</h2>
		<canvas id="weekChart" height="180px"></canvas>
		<div class="slider-controls">
			<button onclick="changeWeek(-1)"><img src="/E3/img/toLeft.png" width="30px"></button>
			<button onclick="changeWeek(1)"><img src="/E3/img/toRight.png" width="30px"></button>
	</div>
	</div>
	<div id="month" class="tab">
		<h2 class="hogeLabel" id="monthLabel">1月</h2>
		<canvas id="monthChart" height="180px"></canvas>
		<div class="slider-controls">
			<button onclick="changeMonth(-1)"><img src="/E3/img/toLeft.png" width="30px"></button>
			<button onclick="changeMonth(1)"><img src="/E3/img/toRight.png" width="30px"></button>
		</div>
	</div>
	<div id="year" class="tab">
		<h2 class="hogeLabel" id="yearLabel">1年目</h2>
		<canvas id="yearChart"height="180px"></canvas>
		<div class="slider-controls">
			<button onclick="changeYear(-1)"><img src="/E3/img/toLeft.png" width="30px"></button>
			<button onclick="changeYear(1)"><img src="/E3/img/toRight.png" width="30px"></button>
		</div>
	</div>
</div><!-- graph -->

</main>
<footer>
</footer>
<script src="/E3/js/graph.js"></script>
</body>
</html>