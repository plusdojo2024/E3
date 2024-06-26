'use strict'
		event.preventDefault();
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

                    var caloriePerKm = 55; // 1kmあたりの消費カロリー
                    var calorie = distanceInKm * caloriePerKm;
                    document.getElementById('calorie').innerText = calorie.toFixed(2);

                    var durationInMinutes = duration / 60;
                    document.getElementById('duration').innerText = durationInMinutes.toFixed(2);

                    directionsDisplay.setDirections(response);
                }
            });
        }
