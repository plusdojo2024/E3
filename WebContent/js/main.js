/**
 *
 */
//ここからキャットネスウインドウについて
    let random = 1
    console.log( random );

	var Sum_Calorie = document.getElementById('Sum_Calorie').value;
	console.log(Sum_Calorie);
	let SC = parseFloat(Sum_Calorie);
	console.log(SC);

 //ここからキャットネスの名前をつけるモーダルウインドウについて
// モーダルど画像を変更について
	if(SC >= 500){
		 let newImageSrc = "/E3/img/子猫背景透過.gif";
		 let imageElement = document.getElementById('myImage');
    		imageElement.src = newImageSrc;
		 document.getElementById("nameModal").style.display = "block";
    }
	if(SC >= 1500){
		 let newImageSrc = "/E3/img/大人猫背景透過.gif";
		 let imageElement = document.getElementById('myImage');
    		imageElement.src = newImageSrc;
    }
	if(SC >= 3500){
		 let newImageSrc = "/E3/img/コス猫背景透過.gif";
		 let imageElement = document.getElementById('myImage');
    		imageElement.src = newImageSrc;
    }
	if(SC >= 7500){
		 let newImageSrc = "/E3/img/羽猫背景透過.gif";
		 let imageElement = document.getElementById('myImage');
    		imageElement.src = newImageSrc;
    }

   //モーダルを閉じるための関数
  document.getElementsByClassName("close2")[0].addEventListener("click", function() {
	const cat_name = document.getElementById('cat_name').value;
	console.log('キャットネスの名前:', cat_name);
	if(!cat_name){
	  document.getElementById("cat_name_message").textContent = "名前は必ず必要です。かわいそうでしょうが!!";
		}else{
			document.getElementById("nameModal").style.display = "none";
      		// データを送信する処理をここに追加する
      		 sendData();
			}
    });

  //キャットネスの名前については、ここまで



//ランダムメッセージについて
const messages = [
    "今日も頑張れー!",
    "寝ちゃおうよー。",
    "今日は晴れだよ!多分!",
    "今日は平日かな。それとも休日かな。",
	"猫なのかって？、自分でも分かんない。"
];
const num = Math.floor(Math.random() * messages.length);
document.getElementById("message").textContent = messages[num];
//ここまで



//ここからアカウント情報のモーダルウインドウについて
// 画像をクリックしたときにモーダルを表示する関数
document.getElementById("myImg").addEventListener("click", function() {
  document.getElementById("userModal").style.display = "block";
});

// モーダルを閉じるための関数
document.getElementsByClassName("close")[0].addEventListener("click", function() {
	var user_name = document.getElementById('user_name').value;
	var height = document.getElementById('height').value;
	var weight = document.getElementById('weight').value;
	var goal_weight = document.getElementById('goal_weight').value;
	if(!user_name || !height || !weight || !goal_weight){
	  document.getElementById("user_alert_message").textContent = "全て必須入力です。All fields are required.";
		}else{
			document.getElementById("userModal").style.display = "none";
      		// データを送信する処理をここに追加する
      		 sendData();
			}
    // データを送信する処理をここに追加する
	//sendData();
	//document.getElementById("userModal").style.display = "none";
  });
//ここまでが、アカウント情報のモーダルウインドウについて


// データを送信する関数
function sendData() {
	var user_name = document.getElementById('user_name').value;
	var height = document.getElementById('height').value;
	var weight = document.getElementById('weight').value;
	var goal_weight = document.getElementById('goal_weight').value;
	var cat_name = document.getElementById('cat_name').value;
	console.log('名前:', user_name);
	console.log('身長:', height);
	console.log('体重:', weight);
	console.log('目標体重:', goal_weight);
	console.log('生物の名前:', cat_name);
    // ここにデータを送信するためのコードを追加する
    // 例えば、Ajaxを使用してサーバーにデータを送信するなど
    var xhr = new XMLHttpRequest();
  xhr.open("POST", "/E3/UpdateDataServlet", true);
  xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8');
   xhr.onreadystatechange = function() {
    if (xhr.readyState === XMLHttpRequest.DONE) {
      if (xhr.status === 200) {
        alert("更新されました。");
      } else {
        alert("エラーが発生しました");
      }
    }
  };
 //xhr.send("user_name=" + encodeURIComponent(user_name));
 //xhr.send("height=" + encodeURIComponent(height));
 //xhr.send("weight=" + encodeURIComponent(weight));
 //xhr.send("goal_weight=" + encodeURIComponent(goal_weight));
 let join_data = "user_name=" + user_name +"&"+"height=" +  height +"&"+"weight=" + weight +"&"+"goal_weight=" + goal_weight +"&"+"cat_name=" + cat_name;
 console.log(join_data);
xhr.send(join_data);
  }
//送信関数はここまで


	//言語切り替えについて
    function translateText() {

         // チェックされているラジオボタンの値を取得
         var selectedOption = document.querySelector('input[name="languages"]:checked');


    if(selectedOption === en){
    console.log("Option 2 is selected");

	//アカウントのモーダルウインドウの文字について
	document.getElementById("user_text1").textContent = "Account Information:";
	document.getElementById("user_text2").textContent = "User Name:";
	document.getElementById("user_text3").textContent = "Height:";
	document.getElementById("user_text4").textContent = "Weight:";
	document.getElementById("user_text5").textContent = "Goal Weight:";
	document.getElementById("user_text6").textContent = "Change language(With some exceptions):";
	document.getElementById("user_text7").textContent = "LogOut";
	document.getElementById("user_text8").textContent = "Account Delete";

	document.getElementById("btn_text1").textContent = "Calorie Regist";
	document.getElementById("btn_text2").textContent = "Walking";

}else if(selectedOption === ja){
    console.log("Option 1 is selected");

	//アカウントのモーダルウインドウの文字について
	document.getElementById("user_text1").textContent = "アカウント情報:";
	document.getElementById("user_text2").textContent = "ユーザーネーム:";
	document.getElementById("user_text3").textContent = "身長:";
	document.getElementById("user_text4").textContent = "体重:";
	document.getElementById("user_text5").textContent = "目標体重:";
	document.getElementById("user_text6").textContent = "言語切り替え(一部を除く):";
	document.getElementById("user_text7").textContent = "ログアウト";
	document.getElementById("user_text8").textContent = "アカウント削除";

	document.getElementById("btn_text1").textContent = "カロリー登録";
	document.getElementById("btn_text2").textContent = "お散歩";

}
}
