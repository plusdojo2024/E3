<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ふぃたごっち | 成長記録</title>
<link rel="stylesheet" href="/E3/css/common.css">
<link rel="stylesheet" href="/E3/css/growth.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<header>
		<div class="header">
			<a href="/E3/MainServlet"><img src="/E3/img/TOPcopy.png"></a>
			<div class="title">
				<p>成長記録</p>
			</div>
		</div>
	</header>
	<body>
		<div class="tabs">
			<input id="one" type="radio" name="tab_item" checked>
			<label class="tab_item" for="one">　　</label>
			<input id="all" type="radio" name="tab_item">
 			<label class="tab_item" for="all">　　</label>

			<div class="tab_content" id="one_content">
				<div class="tab_content_description">
				
					<!-- カルーセル開始 -->
					<div class="c-carousel">
						<!-- ラジオボタン設定 -->
						<input class="c-carousel__activator-main" type="radio" checked id="carousel-main-1" name="carousel-main">
						<input class="c-carousel__activator-main" type="radio" id="carousel-main-2" name="carousel-main">
						<input class="c-carousel__activator-main" type="radio" id="carousel-main-3" name="carousel-main">
						<input class="c-carousel__activator-main" type="radio" id="carousel-main-4" name="carousel-main">
						<input class="c-carousel__activator-main" type="radio" id="carousel-main-5" name="carousel-main">
						<div class="c-carousel__main">
						<!-- 切り替えボタン -->
							<div class="c-carousel__main-control">
							   
								<div class="c-carousel__main-control-item">
									<label class="c-carousel__btn-next-main" for="carousel-main-2">
										<img class="c-image-arrow" src="/E3/img/toRight.png" width="30px" alt=""/>
									</label>
								</div>
								<div class="c-carousel__main-control-item">
									<label class="c-carousel__btn-prev-main" for="carousel-main-1">
										<img class="c-image-arrow" src="/E3/img/toLeft.png" width="30px" alt=""/>
									</label>
									<c:if test="${totalCalories >= 500}">
										<label class="c-carousel__btn-next-main" for="carousel-main-3">
											<img class="c-image-arrow" src="/E3/img/toRight.png" width="30px" alt=""/>
										</label>
										</c:if>	
								</div>
								<div class="c-carousel__main-control-item">
									<label class="c-carousel__btn-prev-main" for="carousel-main-2">
										<img class="c-image-arrow" src="/E3/img/toLeft.png" width="30px" alt=""/>
									</label>
									<c:if test="${totalCalories >= 1500}">
											<label class="c-carousel__btn-next-main" for="carousel-main-4">
											<img class="c-image-arrow" src="/E3/img/toRight.png" width="30px" alt=""/>
										</label>
									</c:if>
								</div>
								<div class="c-carousel__main-control-item">
									<label class="c-carousel__btn-prev-main" for="carousel-main-3">
										<img class="c-image-arrow" src="/E3/img/toLeft.png" width="30px" alt=""/>
									</label>
									<c:if test="${totalCalories >= 3500}">
										<label class="c-carousel__btn-next-main" for="carousel-main-5">
											<img class="c-image-arrow" src="/E3/img/toRight.png" width="30px" alt=""/>
										</label>
									</c:if>	
								</div>
								<div class="c-carousel__main-control-item">
									<label class="c-carousel__btn-prev-main" for="carousel-main-4">
										<img class="c-image-arrow" src="/E3/img/toLeft.png" width="30px" alt=""/>
									</label>
								</div>
							</div>
							<!-- カルーセル中身 -->
							<div class="c-carousel__main-track">
								<div class="c-carousel__main-item">
									<img class="c-carousel__main-image1" src="/E3/img/tamago.gif">
									<p class="evolevel">第1段階</p>
								</div>
								<div class="c-carousel__main-item">
									<c:choose>
										<c:when test="${totalCalories >= 500}">
											<img class="c-carousel__main-image2" src="/E3/img/子猫背景透過.gif">
										</c:when>
										<c:otherwise>
											<img class="c-carousel__main-image_secret" src="/E3/img/はてな.png" alt="secret" height="300px">
										</c:otherwise>
									</c:choose>
									<p class="evolevel">第2段階</p>
								</div>
								<div class="c-carousel__main-item">
									<c:choose>
										<c:when test="${totalCalories >= 1500}">
											<img class="c-carousel__main-image3" src="/E3/img/大人猫背景透過.gif">
										</c:when>
										<c:otherwise>
											<img class="c-carousel__main-image_secret" src="/E3/img/はてな.png" alt="secret" height="300px">
										</c:otherwise>
									</c:choose>
									<p class="evolevel">第3段階</p>
								</div>
								<div class="c-carousel__main-item">
									<c:choose>
										<c:when test="${totalCalories >= 3500}">
											<img class="c-carousel__main-image4" src="/E3/img/コス猫背景透過.gif">
										</c:when>
										<c:otherwise>
											<img class="c-carousel__main-image_secret" src="/E3/img/はてな.png" alt="secret" height="300px">
										</c:otherwise>
									</c:choose>
									<p class="evolevel">第4段階</p>
								</div>
								<div class="c-carousel__main-item">
									<c:choose>
										<c:when test="${totalCalories >= 7500}">
											<img class="c-carousel__main-image5" src="/E3/img/羽猫背景透過.gif">
										</c:when>
										<c:otherwise>
											<img class="c-carousel__main-image_secret" src="/E3/img/はてな.png" alt="secret" height="300px">
										</c:otherwise>
									</c:choose>
									<p class="evolevel">第5段階</p>
								</div>
							</div>
						</div>
					</div>
					<!-- カルーセル終了 -->
				</div>
			</div>
			<div class="tab_content" id="all_content">
				<div class="tab_content_description">
					 
				</div>
			</div>

		</div>
	</body>
	<footer>
	</footer>
</body>
</html>