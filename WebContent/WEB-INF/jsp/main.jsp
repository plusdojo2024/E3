<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.io.File" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>メイン画面</title>
    <link rel="stylesheet" href="/E3/css/main.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=DotGothic16&display=swap" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

    <div class="first_row">
        <div class="left">
            <img src="/E3/img/卵背景透過.png" width="90px" height="105px">
        </div>
        <div class="center">
            <b>キャットネス</b>
        </div>
        <div class="right" style="cursor: pointer;">
            <img src="/E3/img/Yuzar_Icon.png" width="95px" height="105px" id="myImg">
        </div>

    </div>

    <br>

    <div class="second_row">
        <div class="right">
            <img src="/E3/img/gurafu.png" width="95px" height="100px">
        </div>
    </div>

    <br>

    <div class="third_row">
        <div class="right">
            <img src="/E3/img/book_zukan_animal.png" width="85px" height="100px">
        </div>
    </div>

    <div class="growth_organism">
    <img src="/E3/img/卵背景透過.gif" width="200px" height="250px">
    </div>

    <!--吹き出し-->
    <div class="bubble" id="message">
        <p>運動しましょう!!</p>
        </div>

    <br>
    <br>
    <br>

<div class="under_btn_group">

    <a href="#" class="under_btn">カロリー登録</a>
    <a href="#" class="under_btn">おさんぽ</a>
</div>

<!-- ユーザー情報のモーダルウィンドウ -->
<div id="userModal" class="user_modal">
    <div class="modal-content">
      <span class="close">&times;</span>
      <br>
      <h2>アカウント情報</h2>
      <img src="/E3/img/Yuzar_Icon.png" width="65px" height="65px">
      <form id="myForm">
        <label for="user_name">ユーザーネーム:</label><br>
        <input type="text" id="user_name" name="user_name" value="たまこ" placeholder="必須入力"><br>
        <label for="height">身長:</label><br>
        <input type="text" id="height" name="height" value="200.0" placeholder="必須入力"><br>
        <label for="weight">体重:</label><br>
        <input type="text" id="weight" name="weight" value="200.0" placeholder="必須入力"><br>
        <label for="goal_weight">目標体重:</label><br>
        <input type="text" id="goal_weight" name="goal_weight" value="25.0" placeholder="必須入力"><br>
      </form>
	<p id="user_alert_message" style="color: red;"></p>
      ーーーーーーーーーーー
      <br>
      <br>

      <div class="user_modal_btn_group">
        <a href="#" class="user_modal_btn">ログアウト</a><br><br>
        <a href="#" class="user_modal_btn" style="color: red;">アカウント削除</a>
      </div>

    </div>
  </div>

   <!--  キャットネスの名前をつけるためのモーダルウインドウ -->
<div id="nameModal" class="name_modal">
    <div class="modal-content">
      <span class="close2">&times;</span>
      <br>
      <h2>キャットネスに名前をつけよう</h2>
      <form id="myForm2">
        <label for="cat_name">キャットネスの名前:</label><br>
        <input type="text" id="cat_name" name="cat_name" value="キューピー" placeholder="必須入力"><br>
      </form>
      <p id="cat_name_message" style="color: red;"></p>
    </div>
  </div>

  <script src="/E3/js/main3.js"></script>

</body>
</html>