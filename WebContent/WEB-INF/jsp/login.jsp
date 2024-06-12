<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/E3/css/common.css">
<title>ふぃたごっち</title>
<!--
<style>
       
.wrapper {
  background-color: #FBF0B2;
  
}

.content {
  margin: 10px auto 10px auto;
  width: 720px;	
}
h2 {
font-size: 28px;
border-bottom-width: 2px;
border-bottom-style: dotted;
border-bottom-color: saddlebrown;
padding: 20px auto 20px;
}

#footer-bg{
 margin-top: 30px;
 background-image:url(nodoguro_footer.gif);
 background-repeat: repeat-x;
 height: 162px;
 width:100%;
}

#footer{
margin-top:30px;
margin: 10px auto 10px auto;

/*width: 720px;
  background-image: url(footer-bg.png);
  background-repeat: repeat-x;
}*/
</style>
-->
</head>
<body>

<div class="wrapper">
	<div class="content">
		<div style="padding-top:30px;">
  			<h1 id="logo">
    			<a href="login.html"><img src="卵背景透過➀.png" width="260" height="60" alt="ふぃたごっち"></a>
  			</h1>
  		</div>

<h2>ログイン</h2>

<form method="POST" action="/simpleBC/LoginServlet">
    <table>
      <tr>
        <td>
          <label>ID
          <input type="text" name="ID">
          </label>
        </td>
      </tr>
      <tr>
        <td>
          <label>パスワード
          <input type="password" name="PW">
          </label>
        </td>
      <tr>
      <tr>
        <label>新規登録
          
          </label>
        <td>
      </tr>
    </table>

</form>
<div id="footer-bg"></div>
<div id="footer">

    <p style="padding-top:0px;text-align:center;">&copy;2024 MySTAR ALL Rights Reserved</p>
</div>
</div><!--  content --> 


<!-- メイン（ここまで） -->
<!-- フッター（ここから） -->

</div><!--  wrapper --> 



</body>
</html>
</head>
<body>

</body>
</html>