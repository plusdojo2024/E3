'use strict'
function calculateCalories() {
    const ex_ID = document.getElementById('ex_ID').value;
    const time = document.getElementById('time').value;
    const taiju = 10;
    const factor = 1.05;
    if (time === '' || isNaN(time) || time <= 0) {
        alert('運動時間を正しく入力してください。');
        return;
    }
    const calorie = ex_ID*taiju*(time/60)*factor;
    document.getElementById('calorie').value=calorie.toFixed(1);
}
