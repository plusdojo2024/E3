<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/E3/css/calorie_regist.css">
    <script src="/E3/js/calorie_regist.js"></script>

<!--
 <link href="https://fonts.googleapis.com/css?family=Press+Start+2P" rel="stylesheet">
    <link href="https://unpkg.com/nes.css/css/nes.css" rel="stylesheet" />
-->

    <title>カロリー登録</title>
</head>
<body>
<div class="header">
    <a href="/E3/MainServlet"> <img src="/E3/img/TOP.png" alt="TOP"></a>
    <div class="title">カロリー登録</div>
</div>
<div class="form-container">
    <form action="CalorieRegistServlet" method="post">
    <div>
       <label for="ex_ID">運動項目</label>
       <select name="ex_ID" id="ex_ID">
         <option value="2.3">ストレッチング</option>
         <option value="3.5">自重筋力トレーニング</option>
         <option value="4">ラジオ体操</option>
         <option value="5.5">階段の上り下り</option>
         <option value="6">ウェイトトレーニング</option>
         <option value="8">サイクリング</option>
         <option value="10">ランニング</option>
         <option value="3.5">さんぽ</option>
     </select>
    </div>
   <div>
      <label for="time">運動時間</label>
      <input type="text" name="time" id="time"> 分
     </div>
     <div class="buttons">
         <button type="button" onclick="calculateCalories()">計算</button>
         <button type="reset">リセット</button>
     </div>
     <div>
         <label for="calorie">消費カロリー</label>
         <input type="text" name="calorie" id="calorie" readonly> kcal
     </div>
     <div class="buttons">
     <button type="submit" >登録</button>
     </div>
     <p>※登録ボタンを押すとメイン画面に遷移します</p>
 </form>
</div>

</body>
</html>
