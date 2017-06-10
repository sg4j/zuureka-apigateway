/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
'use strict';

var angular = require('angular');

var module = angular.module('sba-applications-swagger', [ 'sba-applications']);
global.sbaModules.push(module.name);

require('./css/module.css');

//module.component('swaggerComp', require('./components/swaggerComp.js'));
//module.service('swaggerService', require('./services/swaggerService.js'));
module.controller('swaggerCtrl', require('./controllers/swaggerCtrl.js'));

module.config(function($stateProvider) {
	$stateProvider.state('applications.swagger', {
		url : '/swagger-ui',
		templateUrl : 'applications-swagger/swagger-static/index.html',
		controller : 'swaggerCtrl'
	});
});

module.run(function(ApplicationViews, $sce, $http) {
	ApplicationViews.register({
		order : 250,
		title : $sce
				.trustAsHtml('<i class="fa fa-file-text-o fa-fw"></i>Swagger'),
		state : 'applications.swagger',
		show : function(application) {
			return true;
		}
	});
});
