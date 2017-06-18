var app = angular.module('zuurekaDashboardApp', []);

app.controller('zuurekaDashboardAppController', function($scope,$location,$http,$anchorScroll) {
	
	$http.get('http://rest-service.guides.spring.io/greeting').
    then(function(response) {
        $scope.servicesList = response.data;
    });

});