<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
    <title>消費カロリー計算</title>
    <link rel="stylesheet" href="/E3/css/common.css">
<body>
    <header>
        <a href="/E3/MainServlet"><img src="images/TOP.png" width="65" height="70" alt="メイン画面ボタン"></a>
        <h1>おさんぽ</h1>
        <a href="/E3/WalkingServlet"><img src="images/refreshmark.png" width="50" height="70" alt="更新ボタン"></a><br>


    </header>

    <div id="map" style="height: 300px;"></div>
    <div class="texthani">
    <input onclick="calculateDistance()" type="submit" value="計算" style="width: 150px;">
    <input type="submit" id="register" name="submit" value="登録"style="width: 150px;"><br>
    <div class="causiontext">
    <p>※登録ボタンを押すとメイン画面に遷移します</p>
    </div>
    </div>
    <div class="osanpotext">
    <p>距離： <span id="distance"></span> km</p>
    <p>消費カロリー： <span id="calories"></span> kcal</p>
    <p>かかった時間： <span id="duration"></span> 分</p>
    </div>

    <!-- <div id="directionsPanel"></div> -->

    <script>
        var map;
        var directionsService;
        var directionsDisplay;
        var markers = [];

        function initMap() {
            map = new google.maps.Map(document.getElementById('map'), {
                center: {lat: 37.9120, lng: 139.0618},
                zoom: 14
            });

            directionsService = new google.maps.DirectionsService();
            directionsDisplay = new google.maps.DirectionsRenderer({
                map: map,
                panel: document.getElementById('directionsPanel')
            });

            // マップをクリックしたときのイベントを追加
            map.addListener('click', function(event) {
                placeMarker(event.latLng);
            });
        }

        function placeMarker(location) {
            if (markers.length < 2) {
                var marker = new google.maps.Marker({
                    position: location,
                    map: map
                });
                markers.push(marker);
            } else {
                markers[1].setPosition(location);
            }
        }

        function calculateDistance() {
            if (markers.length < 2) {
                alert('出発地と目的地を設定してください。');
                return;
            }

            var originLatLng = markers[0].getPosition();
            var destinationLatLng = markers[1].getPosition();

            var request = {
                origin: originLatLng,
                destination: destinationLatLng,
                travelMode: 'WALKING'
            };

            directionsService.route(request, function(response, status) {
                if (status === 'OK') {
                    var route = response.routes[0];
                    var distance = 0;
                    var duration = 0;

                    for (var i = 0; i < route.legs.length; i++) {
                        distance += route.legs[i].distance.value;
                        duration += route.legs[i].duration.value;
                    }

                    var distanceInKm = distance / 1000;
                    document.getElementById('distance').innerText = distanceInKm.toFixed(2);

                    var caloriesPerKm = 55; // 1kmあたりの消費カロリー
                    var calories = distanceInKm * caloriesPerKm;
                    document.getElementById('calories').innerText = calories.toFixed(2);

                    var durationInMinutes = duration / 60;
                    document.getElementById('duration').innerText = durationInMinutes.toFixed(2);

                    directionsDisplay.setDirections(response);
                }
            });
        }
    </script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCS9xq4Zz-x0CKigvuH2E4DuGld06H8YKE&callback=initMap" async defer></script>
</body>
</html>