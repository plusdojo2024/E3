/**
 *
 */
 /*   //キャットネスについて
    var random = Math.floor(Math.random() * 3);
    console.log( random );
 //ここからキャットネスの名前をつけるモーダルウインドウについて
// モーダルを表示する関数
    if(random == 1){
        document.getElementById("nameModal").style.display = "block";
    }

  // モーダルを閉じるための関数
  document.getElementsByClassName("close2")[0].addEventListener("click", function() {
      document.getElementById("nameModal").style.display = "none";
      // データを送信する処理をここに追加する
      //sendData();
    });

  //一応、ここまで */


//提案メッセージについて
const messages = [
    "もっと運動しろや",
    "その調子やで",
    "運動しすぎや",
    "おまえ死ぬぞ!!"
];
const num = Math.floor(Math.random() * messages.length);
document.getElementById("message").textContent = messages[num];
//ここまでだお



//ここからアカウント情報のモーダルウインドウについて
// 画像をクリックしたときにモーダルを表示する関数
document.getElementById("myImg").addEventListener("click", function() {
  document.getElementById("userModal").style.display = "block";
});

// モーダルを閉じるための関数
document.getElementsByClassName("close")[0].addEventListener("click", function() {
    document.getElementById("userModal").style.display = "none";
    // データを送信する処理をここに追加する
    sendData();
  });

// データを送信する関数
function sendData() {
    var formData = new FormData(document.getElementById("myForm"));
    // ここにデータを送信するためのコードを追加する
    // 例えば、Ajaxを使用してサーバーにデータを送信するなど
	console.log("FormData:", formData); // デバッグ用のログ出力
    var xhr = new XMLHttpRequest();
  xhr.open("POST", "/E3/UpdateDataServlet", true);
   xhr.onreadystatechange = function() {
    if (xhr.readyState === XMLHttpRequest.DONE) {
      if (xhr.status === 200) {
        alert("更新されました。");
      } else {
        alert("エラーが発生しました");
      }
    }
  };
  xhr.send(formData);
  }
//ここまで

