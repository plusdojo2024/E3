<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/E3/css/common.css">
<link rel="stylesheet" href="/E3/css/idpw_regist.css">

<meta charset="UTF-8">
<title>ふぃたごっち</title>
</head>
<body>

		<div class="idpwbox">
  			<h1 id="logo">
    			<a href="/E3/LoginServlet"><img src="/E3/img/ふぃたごっち.png" width="300" height="150" alt="ふぃたごっち"></a>
          </h1>
    </div>

<div class="idpwinfo">
<h2>新規登録</h2>

<form id="idpw_box" method="POST" action="/E3/IdpwRegistServlet">
    <p>ID<br></p>
          <input type="text" name="ID" value=""placeholder="ID" maxlength=20 minlength=5>

    <p>パスワード<br></p>
          <input type="password" name="password" value="" placeholder="パスワード" maxlength=20 minlength=5><br>



            <span id="error_message"></span>

      <p><button type="submit">新規登録</button><br></p>


</form>

<form action="LoginServlet" method="get">
          <input class="button" type="submit" value="ログインへ">
</form>
     <!--  <p><input type= "submit" value="ログインへ" class="touroku"><br></p> -->
</div>
<div id="footer">

    <p>&copy;2024 MySTAR ALL Rights Reserved</p>
    </div>
<script src="/E3/js/idpw_regist.js"></script>
</body>
</html>
