<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<div id="all_content">

    <div class="first_row">
        <div class="left">
            <a href="/E3/MainServlet"><img src="/E3/img/TOP.png" width="90px" height="105px"></a>
        </div>
        <div class="center">
            <b><%= request.getAttribute("Cat_Name") %></b>
        </div>
        <div class="right" style="cursor: pointer;">
            <img src="/E3/img/Yuzar_Icon.png" width="90px" height="105px" id="myImg">
        </div>

    </div>

    <br>

    <div class="second_row">
        <div class="right">
            <a href="/E3/GraphServlet"><img src="/E3/img/graph.png" width="85px" height="100px"></a>
        </div>
    </div>

    <br>

    <div class="third_row">
        <div class="right">
            <a href="/E3/GrowthServlet"><img src="/E3/img/index.png" width="85px" height="100px"></a>
        </div>
    </div>

    <div class="growth_organism">
    <img id="myImage" src="/E3/img/tamago.gif" width="210px" height="250px">
    </div>

    <!--吹き出し-->
    <div class="bubble" id="message">
        <p>運動しましょう!!</p>
        </div>

	<br>
        <b>現在の総消費カロリー：<%= request.getAttribute("Sum_Calorie") %>kcal</b><br>
        <b>(Current total calories burned：<%= request.getAttribute("Sum_Calorie") %>kcal)</b><br>
        <input type="text" id="Sum_Calorie" name="Sum_Calorie" value="<%= request.getAttribute("Sum_Calorie") %>" style="display: none;">

    <br>
    <br>

<div class="under_btn_group">

    <a href="/E3/CalorieRegistServlet" class="under_btn" id="btn_text1">カロリー登録</a>
    <a href="/E3/WalkServlet" class="under_btn" id="btn_text2">おさんぽ</a>
</div>

<!-- ユーザー情報のモーダルウィンドウ -->
<div id="userModal" class="user_modal">
    <div class="modal-content">
      <span class="close">&times;</span>
      <br>
      <h2 id="user_text1">アカウント情報</h2>
      <img id="profileImage" src="" alt="プロフィール画像" width="75px" height="75px" onclick="selectImage()">
      <br>
      <input type="file" id="fileInput" accept="image/*" onchange="previewImage(event)">
      <form id="myForm">
        <label for="user_name" id="user_text2">ユーザーネーム:</label><br>
        <input type="text" id="user_name" name="user_name" value="<%= request.getAttribute("User_Name") %>" placeholder="必須入力"><br>
        <label for="height" id="user_text3">身長:</label><br>
        <input type="text" id="height" name="height" value="<%= request.getAttribute("Height") %>" placeholder="必須入力"><br>
        <label for="weight" id="user_text4">体重:</label><br>
        <input type="text" id="weight" name="weight" value="<%= request.getAttribute("Weight") %>" placeholder="必須入力"><br>
        <label for="goal_weight" id="user_text5">目標体重:</label><br>
        <input type="text" id="goal_weight" name="goal_weight" value="<%= request.getAttribute("Goal_Weight") %>" placeholder="必須入力"><br>
      </form>
	<p id="user_alert_message" style="color: red;"></p>
      ーーーーーーーーーーー
      <br>
		<div id="user_text6">言語切り替え(一部のみ):</div><br>
      <label>
        <input type="radio" id="ja" name="languages" value="ja" onclick="translateText()" checked>
        日本語
      </label>
      <label>
        <input type="radio" id="en" name="languages" value="en" onclick="translateText()">
        English
      </label>

        <br>
        <br>

      <div class="user_modal_btn_group">
        <a href="/E3/LogoutServlet" class="user_modal_btn" id="user_text7">ログアウト</a><br><br>
        <a href="/E3/DeleteServlet" class="user_modal_btn" id="user_text8" style="color: red;">アカウント削除</a>
      </div>

    </div>
  </div>

   <!--  キャットネスの名前をつけるためのモーダルウインドウ -->
<div id="nameModal" class="name_modal">
    <div class="modal-content">
      <span class="close2">&times;</span>
      <br>
      <h3>卵が孵化しました!名前をつけてあげよう!<br>(The eggs have hatched! Let's give them names!)</h3>
      <form id="myForm2">
        <label for="cat_name">キャットネスの名前(Catness'name):</label><br>
        <input type="text" id="cat_name" name="cat_name" value="<%= request.getAttribute("Cat_Name") %>" placeholder="必須入力"><br>
      </form>
      <p id="cat_name_message" style="color: red;"></p>
    </div>
  </div>

  </div>

  <script src="/E3/js/main.js"></script>
  <script>
        // 初期表示時にローカルストレージから画像を読み込む
        window.onload = function() {
            const savedImage = localStorage.getItem('profileImage');
            if (savedImage) {
                const imgElement = document.getElementById('profileImage');
                imgElement.src = savedImage;
                const ImgElement = document.getElementById('myImg');
                ImgElement.src = savedImage;
            }
        };

        // プロフィール画像をクリックしたらファイル選択ダイアログを表示する関数
        function selectImage() {
            document.getElementById('fileInput').click();
        }

        // プロフィール画像を表示するための関数
        function previewImage(event) {
            const file = event.target.files[0]; // 選択されたファイルを取得
            const reader = new FileReader(); // FileReaderオブジェクトを作成

            // 読み込みが完了した際の処理
            reader.onload = function() {
                const imgElement = document.getElementById('profileImage'); // img要素を取得
                imgElement.src = reader.result; // 画像のURLをimg要素のsrc属性に設定
                const ImgElement = document.getElementById('myImg');
                ImgElement.src = reader.result;

                // ローカルストレージに画像のDataURLを保存
                localStorage.setItem('profileImage', reader.result);
            }

            reader.readAsDataURL(file); // ファイルの読み込みを実行
        }

    </script>

     <!--  翻訳用のスクリプトの残骸
     <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script> -->

</body>
</html>