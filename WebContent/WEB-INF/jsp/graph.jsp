<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/E3/css/common.css">
	<link rel="stylesheet" href="/E3/css/graph.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ふぃたごっち | 活動記録</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<style>

</style>

</head>
<body>
    <h1>消費カロリーグラフ</h1>
    <div>
      <button id="weekButton" onclick="showTab('week')" class="active-button">週</button>
      <button id="monthButton" onclick="showTab('month')">月</button>
      <button id="yearButton" onclick="showTab('year')">年</button>
  </div>
    <div id="week" class="tab active">
        <h2 id="weekLabel">1週目</h2>
        <canvas id="weekChart"></canvas>
        <div class="slider-controls">
            <button onclick="changeWeek(-1)">&#9664;</button>
            <button onclick="changeWeek(1)">&#9654;</button>
        </div>
    </div>
    <div id="month" class="tab">
        <h2 id="monthLabel">1月</h2>
        <canvas id="monthChart"></canvas>
        <div class="slider-controls">
            <button onclick="changeMonth(-1)">&#9664;</button>
            <button onclick="changeMonth(1)">&#9654;</button>
        </div>
    </div>
    <div id="year" class="tab">
        <h2 id="yearLabel">1年目</h2>
        <canvas id="yearChart"></canvas>
        <div class="slider-controls">
            <button onclick="changeYear(-1)">&#9664;</button>
            <button onclick="changeYear(1)">&#9654;</button>
        </div>
    </div>

    <script>
        const weekData = [
            [100, 200, 150, 250, 300, 200, 100],
            [120, 220, 180, 260, 320, 210, 130],
            [140, 240, 190, 270, 340, 230, 150],
            [160, 260, 200, 280, 360, 240, 170],
            [180, 280, 210, 290, 380, 250, 190]
        ];

        const monthData = [
            [100, 200, 150, 250, 300, 200, 100, 150, 200, 250, 300, 350, 400, 450, 500, 550, 600, 650, 700, 750, 800, 850, 900, 950, 1000, 1050, 1100, 1150, 1200, 1250, 1300],
            [110, 210, 160, 260, 310, 210, 110, 160, 210, 260, 310, 360, 410, 460, 510, 560, 610, 660, 710, 760, 810, 860, 910, 960, 1010, 1060, 1110, 1160, 1210, 1260, 1310],
            [120, 220, 170, 270, 320, 220, 120, 170, 220, 270, 320, 370, 420, 470, 520, 570, 620, 670, 720, 770, 820, 870, 920, 970, 1020, 1070, 1120, 1170, 1220, 1270, 1320],
            [130, 230, 180, 280, 330, 230, 130, 180, 230, 280, 330, 380, 430, 480, 530, 580, 630, 680, 730, 780, 830, 880, 930, 980, 930, 1080, 1130, 1180, 1230, 1280, 1330],
            [140, 240, 190, 290, 340, 240, 140, 190, 240, 290, 340, 390, 440, 490, 540, 590, 640, 690, 740, 790, 840, 890, 940, 990, 740, 590, 740, 1390, 740, 670, 1140]
        ];

        const yearData = [
            [1000, 2000, 1500, 2500, 3000, 2000, 1000, 1500, 2000, 2500, 3000, 3500],
            [1100, 2100, 1600, 2600, 3100, 2100, 1100, 1600, 2100, 2600, 3100, 3600],
            [1200, 2200, 1700, 2700, 3200, 2200, 1200, 1700, 2200, 2700, 3200, 3700],
            [1300, 2300, 1800, 2800, 3300, 2300, 1300, 1800, 2300, 2800, 3300, 3800],
            [1400, 2400, 1900, 2900, 3400, 2400, 1400, 1900, 2400, 2900, 3400, 3900]
        ];

        let weekChart, monthChart, yearChart;
        let currentWeek = 0;
        let currentMonth = 0;
        let currentYear = 0;

        function showTab(tabName) {
            document.querySelectorAll('.tab').forEach(tab => tab.classList.remove('active'));
            document.getElementById(tabName).classList.add('active');
        }

        function updateWeekChart() {
            document.getElementById('weekLabel').innerText = `${currentWeek + 1}週目`;
            weekChart.data.datasets[0].data = weekData[currentWeek];
            weekChart.update();
        }

        function changeWeek(step) {
            currentWeek = (currentWeek + step + weekData.length) % weekData.length;
            updateWeekChart();
        }

        function updateMonthChart() {
            document.getElementById('monthLabel').innerText = `${currentMonth + 1}月`;
            monthChart.data.datasets[0].data = monthData[currentMonth];
            monthChart.update();
        }

        function changeMonth(step) {
            currentMonth = (currentMonth + step + monthData.length) % monthData.length;
            updateMonthChart();
        }

        function updateYearChart() {
            document.getElementById('yearLabel').innerText = `${currentYear + 1}年目`;
            yearChart.data.datasets[0].data = yearData[currentYear];
            yearChart.update();
        }

        function changeYear(step) {
            currentYear = (currentYear + step + yearData.length) % yearData.length;
            updateYearChart();
        }

        window.onload = function() {
            const ctxWeek = document.getElementById('weekChart').getContext('2d');
            weekChart = new Chart(ctxWeek, {
                type: 'bar',
                data: {
                    labels: ['月', '火', '水', '木', '金', '土', '日'],
                    datasets: [{
                        label: '消費Kカロリー',
                        data: weekData[0],
                        backgroundColor: 'rgba(75, 192, 192, 0.2)',
                        borderColor: 'rgba(75, 192, 192, 1)',
                        borderWidth: 1
                    }]
                },
                options: {
                    scales: {
                        y: {
                            beginAtZero: true
                        }
                    }
                }
            });

            const ctxMonth = document.getElementById('monthChart').getContext('2d');
            monthChart = new Chart(ctxMonth, {
                type: 'bar',
                data: {
                    labels: Array.from({ length: 31 }, (_, i) => i + 1),
                    datasets: [{
                        label: '消費Kカロリー',
                        data: monthData[0],
                        backgroundColor: 'rgba(153, 102, 255, 0.2)',
                        borderColor: 'rgba(153, 102, 255, 1)',
                        borderWidth: 1
                    }]
                },
                options: {
                    scales: {
                        y: {
                            beginAtZero: true
                        }
                    }
                }
            });

            const ctxYear = document.getElementById('yearChart').getContext('2d');
            yearChart = new Chart(ctxYear, {
                type: 'bar',
                data: {
                    labels: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'],
                    datasets: [{
                        label: '消費Kカロリー',
                        data: yearData[0],
                        backgroundColor: 'rgba(255, 159, 64, 0.2)',
                        borderColor: 'rgba(255, 159, 64, 1)',
                        borderWidth: 1
                    }]
                },
                options: {
                    scales: {
                        y: {
                            beginAtZero: true
                        }
                    }
                }
            });
        };

    function showTab(tabName) {
      // すべてのタブを非表示にする
      document.querySelectorAll('.tab').forEach(tab => {
      tab.classList.remove('active');
      });

      // 選択されたタブを表示する
      document.getElementById(tabName).classList.add('active');

      // すべてのボタンから active-button クラスを削除する
      document.querySelectorAll('button').forEach(button => {
      button.classList.remove('active-button');
      });

      // 選択されたボタンに active-button クラスを追加する
      document.getElementById(tabName + 'Button').classList.add('active-button');
    }

    </script>
</body>
</html>