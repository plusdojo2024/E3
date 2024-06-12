<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
 <meta charset="UTF-8">
    <link rel="stylesheet" href="/E3/css/style.css">
 <title>カロリー登録</title>
</head>
<body>
<div class="header">
    <img src="egg_icon.png" alt="Icon">
    <div class="title">カロリー登録</div>
</div>
<div class="form-container">
    <div>
       <label for="activity">運動項目</label>
        <select id="activity">
          <option value="walking">ウォーキング</option>
          <option value="running">ランニング</option>
          <option value="cycling">サイクリング</option>

        </select>
    </div>
    <div>
        <label for="time">運動時間</label>
        <input type="number" id="time" min="1"> 分
    </div>
    <div class="buttons">
        <button>計算</button>
        <button>リセット</button>
    </div>
    <div>
        <label for="calories">消費カロリー</label>
        <input type="text" id="calories" readonly> kcal
    </div>
        <button>登録</button>
    </div>
</body>
</html>
