var app = angular.module('zuurekaDashboardApp', []);

app.controller('zuurekaDashboardAppController', function($scope, $location,
		$http, $anchorScroll) {

	$scope.zuurekaGatewayPath = 'http://localhost:8761';
	$scope.homePageVisibility = true;
	$scope.serviceDetailsVisibility = false;
	$scope.currentService = '';
	$scope.currentServiceInstance = '';
	$scope.currentServiceDetailTab = 'Overview';
	$scope.currentServiceInstanceEndPoints = '';

	if ($location.port() == '8761') {
		$scope.zuurekaGatewayPath = '';
	}

	$http.get($scope.zuurekaGatewayPath + '/zuureka/services/').then(
			function(response) {
				$scope.servicesList = response.data;
			});

	$scope.$watch('serviceDetailsVisibility',
			function() {
				if (!$scope.serviceDetailsVisibility) {
					return;
				}
			});
	
	$scope.showPage = function(pageNumber) {
		$scope.homePageVisibility = false;
		$scope.serviceDetailsVisibility = false;

		if (pageNumber == 0) {
			$scope.homePageVisibility = true;
		} else if (pageNumber == 1) {
			$scope.serviceDetailsVisibility = true;
		} else {
			$scope.homePageVisibility = true;
		}
	}

	$scope.showServiceDetails = function(serviceSelected, instanceSelected) {
		$scope.currentService = serviceSelected;
		$scope.currentServiceInstance = instanceSelected;

		window.alert($scope.currentServiceInstance.homePageUrl);
		$http({method: 'GET', url: $scope.currentServiceInstance.homePageUrl + 'info', headers: { 'Accept': 'application/json' }}).then(
			function actuatorCallSuccess(response) {
				window.alert("Came here");
				$scope.currentServiceInstanceEndPoints = response.data;
				window.alert("home page URL is"+$scope.currentServiceInstanceEndPoints);
			});
		
		$scope.showPage(1);
	}
	
	$scope.isServiceDetailsTabSelected = function(currentServiceDetailsTabSelected){
		if($scope.currentServiceDetailTab == currentServiceDetailsTabSelected) {
			return true;
		} else {
			return false;
		}
	}
	
	$scope.showServiceDetailsTab = function(currentServiceDetailsTabSelected)
	{
		$scope.currentServiceDetailTab = currentServiceDetailsTabSelected;
	}

});