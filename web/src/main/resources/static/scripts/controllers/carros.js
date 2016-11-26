angular.module('microservices')
	.controller('CarrosCtrl', function($scope, $http, $routeParams) {
		$http({
			method : 'GET',
			url : '/carros/concessionarias/' + $routeParams.id
		}).then(function(response) {
			$scope.carros = response.data;
		}, function(response) {
			console.error('Erro requisitando carros.')
		});
	});
