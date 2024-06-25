<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/E3/css/common.css">
<link rel="stylesheet" href="/E3/css/login.css">

<title>ふぃたごっち</title>
</head>
<body>

  			<h1 id="logo">
    			<a href="login.html"><img src="/E3/img/ふぃたごっち.png" width="300" height="150" alt="ふぃたごっち"></a>

  			</h1>


<!--<h2>新規登録ｲ</h2>
        <h2 text-align:center></h2>-->
<div class="loginbox">
<form id="login_form" method="POST" action="/E3/LoginServlet">
        <p>ID<br></p>
        <input type="text" name="id" value=""placeholder="ID">

        <p>パスワード<br></p>
        <input type="password" name="password" value=""placeholder="パスワード">

      <p><input type= "submit" value="ログイン" class="login"><br></p>

      <span id="error_message"></span>
</form>
<form action="IdpwRegistServlet" method="get">
          <input class="button" type="submit" value="新規登録へ">
</form>
    <p>&copy;2024 MySTAR ALL Rights Reserved</p>
</div>

<script src="/E3/js/login.js"></script>
</body>
</html>

