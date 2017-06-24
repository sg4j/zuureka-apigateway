var app = angular.module('zuurekaDashboardApp', []);

app.controller('zuurekaDashboardAppController', function ($scope, $location,
	$http, $anchorScroll) {

	initializeWebSocket();

	$scope.zuurekaGatewayPath = '';
	$scope.homePageVisibility = true;
	$scope.serviceDetailsVisibility = false;

	$scope.currentService = '';
	$scope.currentServiceInstance = '';
	$scope.currentServiceDetailTab = 'Overview';

	$scope.currentServiceInstanceEndPoints = '';

	$scope.registeredServicesDetails = {};

	$scope.messageFromWS = function (data) {
		$scope.updateService(data.application);
	}

	$http.get('/eureka/apps/').then(
		function (response) {
			var eurekaRegisteredServiceList = response.data.applications.application;
			if (eurekaRegisteredServiceList && eurekaRegisteredServiceList.length > 0) {
				for (var serviceListIndex = 0; serviceListIndex < eurekaRegisteredServiceList.length; serviceListIndex++) {
					$scope.updateService(eurekaRegisteredServiceList[serviceListIndex].name);
				}
			}
		});

	$scope.$watch('serviceDetailsVisibility',
		function () {
			if (!$scope.serviceDetailsVisibility) {
				return;
			}
		});

	$scope.showPage = function (pageNumber) {
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

	$scope.updateService = function (serviceName) {
		$http.get('/eureka/apps/' + serviceName).then(
			function (response) {
				var instances = response.data.application.instance;
				if (instances && instances.length > 0) {
					$scope.registeredServicesDetails[serviceName] = instances;
				}
			},function(data) {
		       delete $scope.registeredServicesDetails[serviceName];
		    });
	}

	$scope.listActuatorTabs = function () {
		var actuatorUrl = $scope.currentServiceInstance.homePageUrl + 'actuator';
		$http.get(actuatorUrl).then(
			function actuatorCallSuccess(response) {
				$scope.currentServiceInstanceEndPoints = response.data;
			});
	}

	$scope.showServiceDetails = function (serviceSelected, instanceSelected) {
		$scope.currentService = serviceSelected;
		$scope.currentServiceInstance = instanceSelected;
		$scope.listActuatorTabs();
		$scope.showPage(1);
	}

	$scope.isServiceDetailsTabSelected = function (currentServiceDetailsTabSelected) {
		if ($scope.currentServiceDetailTab == currentServiceDetailsTabSelected) {
			return true;
		} else {
			return false;
		}
	}

	$scope.showServiceDetailsTab = function (currentServiceDetailsTabSelected) {
		$scope.currentServiceDetailTab = currentServiceDetailsTabSelected;
	}

});