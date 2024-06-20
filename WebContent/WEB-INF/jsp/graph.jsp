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
		<div class="header">
			<a href="/E3/GrowthServlet"><img src="/E3/img/TOPcopy.png"></a>
			<div class="title">
				<input type="text" name="user_name" value="週" readonly="readonly">さんの<br>
				活動記録
			</div>
		</div>
	</header>
	<main>
		<div class="balloon5">
	        <div class ="faceicon">
	            <img src="/E3/img/卵背景透過.gif" width="70" height="75" alt="卵">
	        </div>
	        <div class="chatting">
	            <div class="says">
	            <p><span id="ouen_message"></span></p>
	        	</div>
	        </div>
	    </div>
		<!-- 応援メッセージ表示 <div class="cheer">
			
			
		
			<c:choose>
				<c:when test="${before}">
					<p>応援メッセージ</p>
				</c:when>
			</c:choose>
			
			
			<img src="/E3/img/卵背景透過.png" width="25%">
			
			<c:choose>
	    		<c:when test="${sum_calories < 500}">
	        		<img src="/E3/img/		.png" width="10%">
	        	</c:when>
	    		<c:when test="${sum_calories < 1500}">
	        		<img src="/E3/img/		.png" width="10%">
	        	</c:when>
	        	<c:when test="${sum_calories < 3500}">
	        		<img src="/E3/img/		.png" width="10%">
	        	</c:when>
	        	<c:when test="${sum_calories < 7500}">
	        		<img src="/E3/img/		.png" width="10%">
	        	</c:when>
	        	<c:when test="${sum_calories >= 7500}">
	        		<img src="/E3/img/		.png" width="10%">
	        	</c:when>
			</c:choose>
			
		</div>-->
		
		<div class="tabs"><!-- タブ全体ここから -->
			<input id="week" type="radio" name="tab_item" checked>
			<label class="tab_item" for="week">週</label>
			<input id="month" type="radio" name="tab_item">
 			<label class="tab_item" for="month">月</label>
			<input id="year" type="radio" name="tab_item">
 			<label class="tab_item" for="year">年</label>
 			
            <div class="tab_content" id="week_content"><!--week tab -->
				<div class="tab_content_description">
					<div class="c-carousel"><!-- 週カルーセル開始 -->
						<!-- ラジオボタン設定 -->
						<input class="c-carousel__activator-main" type="radio" id="wcarousel-main-3" name="wcarousel-main">
						<input class="c-carousel__activator-main" type="radio" id="wcarousel-main-2" name="wcarousel-main">
						<input class="c-carousel__activator-main" type="radio" id="wcarousel-main-1" name="wcarousel-main"checked>
						<div class="c-carousel__main">
						
                            <div class="c-carousel__main-control"><!-- 切り替えボタン -->
                                <div class="c-carousel__main-control-item">
                                    <label class="c-carousel__btn-next-main" for="wcarousel-main-2">
                                        <img class="c-image-arrow" src="/E3/img/toRight.png" width="30px">
                                    </label>
                                </div>
                                <div class="c-carousel__main-control-item">
                                    <label class="c-carousel__btn-prev-main" for="wcarousel-main-3">
                                        <img class="c-image-arrow" src="/E3/img/toLeft.png" width="30px">
                                    </label>
                                    <label class="c-carousel__btn-next-main" for="wcarousel-main-1">
                                        <img class="c-image-arrow" src="/E3/img/toRight.png" width="30px">
                                    </label>
                                </div>
                                <div class="c-carousel__main-control-item">
                                    <label class="c-carousel__btn-prev-main" for="wcarousel-main-2">
                                        <img class="c-image-arrow" src="/E3/img/toLeft.png" width="30px">
                                    </label>
                                </div>
                            </div>                                  <!-- 切り替えボタン -->
							
							<div class="c-carousel__main-track"><!-- カルーセル中身 -->
								<div class="c-carousel__main-item">
									<canvas class="c-carousel__main-graph" id="weekpp_chart" height="100%"></canvas>
									<p>先々週</p>
								</div>
								<div class="c-carousel__main-item">
									<canvas class="c-carousel__main-graph" id="weekp_chart" height="100%"></canvas>
									<p>先週</p>
								</div>
								<div class="c-carousel__main-item">
									<canvas class="c-carousel__main-graph" id="weekn_chart" height="100%"></canvas>
									<p>今週</p>
								</div>
							</div>								<!-- カルーセル中身 -->
						</div>
					</div><!-- 週カルーセル終了 -->
					
					<div class="wchart_script"><!-- week chart scr -->
                        <script>
                            let weekppCtx = document.getElementById('weekpp_chart').getContext("2d");
                            //グラフの設定
                            weekppCtx.canvas.height = "300px";
                            let weekppConfig = {
                                type: 'bar',
                                data: {
                                    labels: ["日","月","火","水","木","金","土"],
                                    datasets : [ {
                                        data : [34, 49, 40, 4, 40, 12, 34],
                                        label : 'kcal',
                                        backgroundColor: ["#F2CFEE"],
                                    } ] , 
                                } ,
                            } ;
                            let weekppChart = new Chart(weekppCtx, weekppConfig);
                        </script>
                        <script>
                            let weekpCtx = document.getElementById('weekp_chart').getContext("2d");
                            //グラフの設定
                            weekpCtx.canvas.height = "300px";
                            let weekpConfig = {
                                type: 'bar',
                                data: {
                                    labels: ["日","月","火","水","木","金","土"],
                                    datasets : [ {
                                        data : [34, 8, 8, 8, 8, 8, 34],
                                        label : 'kcal',
                                        backgroundColor: ["#F2CFEE"],
                                    } ] , 
                                } ,
                            } ;
                            let weekpChart = new Chart(weekpCtx, weekpConfig);
                        </script>
                        <script>
                            let weeknCtx = document.getElementById('weekn_chart').getContext("2d");
                            //グラフの設定
                            weeknCtx.canvas.height = "300px";
                            let weeknConfig = {
                                type: 'bar',
                                data: {
                                    labels: ["日","月","火","水","木","金","土"],
                                    datasets : [ {
                                        data : [34, 10, 24, 24, 40, 12, 34],
                                        label : 'kcal',
                                        backgroundColor: ["#F2CFEE"],
                                    } ] , 
                                } ,
                            } ;
                            let weeknChart = new Chart(weeknCtx, weeknConfig);
                        </script>
					</div><!-- week chart scr -->
				</div>
			</div><!--week tab -->
			
			<div class="tab_content" id="month_content"><!-- month tab -->
				<div class="tab_content_description">
					<div class="c-carousel"><!-- 月カルーセル開始 -->
						<!-- ラジオボタン設定 -->
						<input class="c-carousel__activator-main" type="radio" id="mcarousel-main-3" name="mcarousel-main">
						<input class="c-carousel__activator-main" type="radio" id="mcarousel-main-2" name="mcarousel-main">
						<input class="c-carousel__activator-main" type="radio" id="mcarousel-main-1" name="mcarousel-main">
					<div class="c-carousel__main">
						
                            <div class="c-carousel__main-control"><!-- 切り替えボタン -->
                                <div class="c-carousel__main-control-item">
                                    <label class="c-carousel__btn-next-main" for="mcarousel-main-2">
                                        <img class="c-image-arrow" src="/E3/img/toRight.png" width="30px">
                                    </label>
                                </div>
                                <div class="c-carousel__main-control-item">
                                    <label class="c-carousel__btn-prev-main" for="mcarousel-main-3">
                                        <img class="c-image-arrow" src="/E3/img/toLeft.png" width="30px">
                                    </label>
                                    <label class="c-carousel__btn-next-main" for="mcarousel-main-1">
                                        <img class="c-image-arrow" src="/E3/img/toRight.png" width="30px"/>
                                    </label>
                                </div>
                                <div class="c-carousel__main-control-item">
                                    <label class="c-carousel__btn-prev-main" for="mcarousel-main-2">
                                        <img class="c-image-arrow" src="/E3/img/toLeft.png" width="30px">
                                    </label>
                                </div>
                            </div>                                  <!-- 切り替えボタン -->
							
							<div class="c-carousel__main-track"><!-- カルーセル中身 -->
								<div class="c-carousel__main-item">
									<canvas class="c-carousel__main-graph" id="monthpp_chart" height="100%"></canvas>
									<p>先々月</p>
								</div>
								<div class="c-carousel__main-item">
									<canvas class="c-carousel__main-graph" id="monthp_chart" height="100%"></canvas>
									<p>先月</p>
								</div>
								<div class="c-carousel__main-item">
									<canvas class="c-carousel__main-graph" id="monthn_chart" height="100%"></canvas>
									<p>今月</p>
								</div>
							</div>								<!-- カルーセル中身 -->
						</div>	
					</div><!-- 月カルーセル終了 -->
					
					<div class="mchart_script"><!-- month chart scr -->
                        <script>
                            let monthppCtx = document.getElementById('monthpp_chart').getContext("2d");
                            //グラフの設定
                            monthppCtx.canvas.height = "50px";
                            let monthppConfig = {
                                type: 'bar',
                                data: {
                                    labels: ["1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"],
                                    datasets : [ {
                                        data : [34, 10, 24, 24, 40, 12, 34, 65, 79, 23,46, 114, 98, 0, 0,34, 10, 24, 24, 40, 12, 34, 65, 79, 23,46, 114, 98, 0, 0],
                                        label : 'kcal',
                                        backgroundColor: ["#F2CFEE"],
                                    } ] , 
                                } ,
                            } ;
                            let monthppChart = new Chart(monthppCtx, monthppConfig);
                        </script>
                        <script>
                            let monthpCtx = document.getElementById('monthp_chart').getContext("2d");
                            //グラフの設定
                            monthpCtx.canvas.height = "50px";
                            let monthpConfig = {
                                type: 'bar',
                                data: {
                                    labels: ["1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"],
                                    datasets : [ {
                                        data : [34, 10, 24, 24, 40, 12, 34, 65, 79, 23,46, 114, 98, 0, 0,34, 10],
                                        label : 'kcal',
                                        backgroundColor: ["#F2CFEE"],
                                    } ] , 
                                } ,
                            } ;
                            let monthpChart = new Chart(monthpCtx, monthpConfig);
                        </script>
                        <script>
                            let monthnCtx = document.getElementById('monthn_chart').getContext("2d");
                            //グラフの設定
                            monthnCtx.canvas.height = "50px";
                            let monthnConfig = {
                                type: 'bar',
                                data: {
                                    labels: ["1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"],
                                    datasets : [ {
                                        data : [34, 10, 24, 24, 40],
                                        label : 'kcal',
                                        backgroundColor: ["#F2CFEE"],
                                    } ] , 
                                } ,
                            } ;
                            let monthnChart = new Chart(monthnCtx, monthnConfig);
                        </script>
                    </div><!-- month chart scr -->
				</div>
			</div><!-- month tab -->
			
            <div class="tab_content" id="year_content"><!--year tab -->
				<div class="tab_content_description">
					<div class="c-carousel"><!-- 年カルーセル開始 -->
						<!-- ラジオボタン設定 -->
						<input class="c-carousel__activator-main" type="radio" id="ycarousel-main-3" name="ycarousel-main">
						<input class="c-carousel__activator-main" type="radio" id="ycarousel-main-2" name="ycarousel-main">
						<input class="c-carousel__activator-main" type="radio" id="ycarousel-main-1" name="ycarousel-main" checked>
						<div class="c-carousel__main">
						
                            <div class="c-carousel__main-control"><!-- 切り替えボタン -->
                                <div class="c-carousel__main-control-item">
                                    <label class="c-carousel__btn-next-main" for="ycarousel-main-2">
                                        <img class="c-image-arrow" src="/E3/img/toRight.png" width="30px">
                                    </label>
                                </div>
                                <div class="c-carousel__main-control-item">
                                    <label class="c-carousel__btn-prev-main" for="ycarousel-main-3">
                                        <img class="c-image-arrow" src="/E3/img/toLeft.png" width="30px">
                                    </label>
                                    <label class="c-carousel__btn-next-main" for="ycarousel-main-1">
                                        <img class="c-image-arrow" src="/E3/img/toRight.png" width="30px">
                                    </label>
                                </div>
                                <div class="c-carousel__main-control-item">
                                    <label class="c-carousel__btn-prev-main" for="ycarousel-main-2">
                                        <img class="c-image-arrow" src="/E3/img/toLeft.png" width="30px">
                                    </label>
                                </div>
                            </div>                                  <!-- 切り替えボタン -->
							
							<div class="c-carousel__main-track"><!-- カルーセル中身 -->
								<div class="c-carousel__main-item">
									<canvas class="c-carousel__main-graph" id="yearpp_chart" height="100%"></canvas>
									<p>一昨年</p>
								</div>
								<div class="c-carousel__main-item">
									<canvas class="c-carousel__main-graph" id="yearp_chart" height="100%"></canvas>
									<p>去年</p>
								</div>
								<div class="c-carousel__main-item">
									<canvas class="c-carousel__main-graph" id="yearn_chart" height="100%"></canvas>
									<p>今年</p>
								</div>
							</div>								<!-- カルーセル中身 -->
						</div>
					</div><!-- 年カルーセル終了 -->
					
					<div class="ychart_script"><!-- year chart scr -->
                        <script>
						let yearppCtx = document.getElementById('yearpp_chart').getContext("2d");
						//グラフの設定
						yearppCtx.canvas.height = "50px";
						let yearppConfig = {
							type: 'bar',
							data: {
								labels: ["1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"],
								datasets : [ {
									data : [6897,8888,13459,4523,6598,7412,7444,3216,8469,9848,9020,5214],
									label : 'kcal',
									backgroundColor: ["#F2CFEE"],
									borderwidth : 1,
								} ] , 
							} ,
						} ;
						let yearppChart = new Chart(yearppCtx, yearppConfig);
						</script>
						<script>
						let yearpCtx = document.getElementById('yearp_chart').getContext("2d");
						//グラフの設定
						yearpCtx.canvas.height = "50px";
						let yearpConfig = {
							type: 'bar',
							data: {
								labels: ["1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"],
								datasets : [ {
									data : [1513,6549,321,9874,6461,3216,98,3546,9856,7412,5463,65],
									label : 'kcal',
									backgroundColor: ["#F2CFEE"],
									borderwidth : 1,
								} ] , 
							} ,
						} ;
						let yearpChart = new Chart(yearpCtx, yearpConfig);
						</script>
						<script>
						let yearnCtx = document.getElementById('yearn_chart').getContext("2d");
						//グラフの設定
						yearnCtx.canvas.height = "50px";
						let yearnConfig = {
							type: 'bar',
							data: {
								labels: ["1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"],
								datasets : [ {
									data : [7653, 7355,7983,7101,7854,6958,5412,8124,7452,6574,6985,5748],
									label : 'kcal',
									backgroundColor: ["#F2CFEE"],
									borderwidth : 1,
								} ] , 
							} ,
						} ;
						let yearnChart = new Chart(yearnCtx, yearnConfig);
						</script>
					</div><!-- year chart scr -->
				</div>
			</div><!--year tab -->			
			
			
					
				
			
		</div><!-- タブ全体ここまで -->
		
	</main>
	<footer>
	<script src="/E3/js/graph.js"></script>
	</footer>	

</body>
</html>