angular.module('microservices', ['ngRoute'])
	.config(function($routeProvider) {
		$routeProvider.when('/concessionarias', {
			templateUrl : 'views/main.html',
			controller : 'MainCtrl'
		}).when('/concessionarias/:id/carros', {
			templateUrl : 'views/carros.html',
			controller : 'CarrosCtrl'
		}).otherwise({
			redirectTo : '/concessionarias'
		});
	});
