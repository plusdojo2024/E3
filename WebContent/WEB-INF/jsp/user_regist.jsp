<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/E3/css/common.css">
<link rel="stylesheet" href="/E3/css/user_regist.css">
<script src="/E3/js/user_regist.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
        <div class="userbox">
  			<h1 id="logo">
    			<a href="login.html"><img src="ふぃたごっち.png" width="250" height="100" alt="ふぃたごっち"></a>
            </h1>
        </div>

<div class="userinfo">
<h2>新規登録</h2>

<form id="user_form" method="POST" action="/E3/UserRegistServlet">

          <p>名前<br></p>
          <input type="text" ID=name name="name" value=""placeholder="名前" maxlength=100>

        <p>身長<br></p>
          <input type="text" name="height" value="" placeholder="身長" maxlength=5>

        <p>体重</p>
          <input type="text" name="weight" value="" placeholder="体重" maxlength=5>

        <p>性別</p>
          <select name="gender" class="g_button">
            <option hidden>選択してください</option>
            <option value="men">男性</option>
            <option value="ladies">女性</option>
            <option value="other">その他</option>
          </select>

        <p>目標体重</p>
          <input type="text" name="goal_weight" value="" placeholder="目標体重" maxlength=5>

          <p><span id="error_message"></span><br></p>

      <p><input type= "submit" value="登録" class="touroku"><br></p>
</form>

<div id="footer">

    <p>&copy;2024 MySTAR ALL Rights Reserved</p>
</div>
</div>
</body>
</html>