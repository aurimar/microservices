angular.module('microservices')
	.controller('MainCtrl', function($scope, $http) {
		$http({
			method : 'GET',
			url : '/concessionarias'
		}).then(function(response) {
			$scope.concessionarias = response.data;
		}, function(response) {
			console.error('Erro requisitando concessionarias');
		});
	});
