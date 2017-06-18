var app = angular.module('zuurekaDashboardApp', []);

app.controller('zuurekaDashboardAppController', function($scope, $location,$http, $anchorScroll) {

	$scope.zuurekaGatewayPath = 'http://localhost:8761';

	if ($location.port() == '8761') 
	{
		$scope.zuurekaGatewayPath = '';
	}

	$http.get($scope.zuurekaGatewayPath + '/zuureka/services/').then(
			function(response) {
				$scope.servicesList = response.data;
			});

});