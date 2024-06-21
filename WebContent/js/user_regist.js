  /* HTML要素をオブジェクトとして取得する */
  let formObj = document.getElementById('user_form');
  let errorMessageObj = document.getElementById('error_message');

  /* [ログイン]ボタンをクリックしたときの処理 */
  formObj.onsubmit = function() {
    if (!formObj.name.value || !formObj.height.value || !formObj.weight.value || !formObj.gender.value || !formObj.goal_weight.value) {
      errorMessageObj.textContent = '※全項目を入力してください！';
      return false;
    }
    errorMessageObj.textContent = null;
  };

