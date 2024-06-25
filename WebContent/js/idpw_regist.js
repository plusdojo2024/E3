 /* HTML要素をオブジェクトとして取得する */
 'use strict'
  let formObj = document.getElementById('idpw_box');
  let errorMessageObj = document.getElementById('error_message');

  /* [ログイン]ボタンをクリックしたときの処理 */
  formObj.onsubmit = function() {
    if (!formObj.ID.value || !formObj.password.value) {
      errorMessageObj.textContent = '※IDとパスワードを入力してください！';
      return false;
    }
    errorMessageObj.textContent = null;
  };

