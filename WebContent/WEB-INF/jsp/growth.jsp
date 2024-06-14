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
		<a href="/E3/GraphServlet"><img src="/E3/img/TOP.png" width="10%"></a>
		<h2>成長記録</h2>
	</header>
	<body>
		<div class="tabs">
			<input id="one" type="radio" name="tab_item" checked>
			<label class="tab_item" for="one">個別</label>
			<input id="all" type="radio" name="tab_item">
 			<label class="tab_item" for="all">一覧</label>

			<div class="tab_content" id="one_content">
				<div class="tab_content_description">
					<button class="downarrow"><img src="/E3/img/upArrow.png" width="20%"></button><br>
					
					<button class="downarrow"><img src="/E3/img/downArrow.png" width="20%"></button>
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