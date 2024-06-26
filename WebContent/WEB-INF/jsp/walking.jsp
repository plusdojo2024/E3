<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
    <title>消費カロリー計算</title>
    <link rel="stylesheet" href="/E3/css/walking.css">
    <script src="/E3/js/walking.js"></script>
<body>
    <header>
        <a href="/E3/MainServlet"style="padding-left:20px;"><img src="/E3/img/TOP.png" width="65" height="70" alt="メイン画面ボタン"></a>
        <h1>おさんぽ</h1>
        <a href="/E3/WalkServlet" style="padding-right:20px;"><img src="/E3/img/refreshmark.png" width="50" height="70" alt="更新ボタン"></a>


    </header>

    <div id="map" style="height: 300px;"></div>
    <div class="texthani">
    <table class="texthyou">
    <tr>
    <th>
    <button type="button" onclick="calculateDistance()">計算</button>
    </th>
    <th>
    <!-- フォームー追加 -->
    <form id="registerForm" action="/E3/WalkServlet" method="post" onsubmit="return setCalories()">
    <!-- 情報for send -->
    <input type="hidden" id="caloriesInput" name="calorie" value="">
    <input type="submit" id="register" name="submit" value="登録">
	</form>
    </th>
    </tr>
    </table>
    <!-- フォームー追加 おわり -->

    <div class="causiontext">
    <p>※登録ボタンを押すとメイン画面に遷移します</p>
    </div>
    </div>
    <div class="osanpotext">
    <p>距離： <span id="distance"></span> km</p>
    <p>消費カロリー： <span id="calorie"></span> kcal</p>
    <p>かかった時間： <span id="duration"></span> 分</p>
    </div>

    <!-- <div id="directionsPanel"></div> -->
      <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCS9xq4Zz-x0CKigvuH2E4DuGld06H8YKE&callback=initMap" async defer></script>

</body>
</html>