var myApp = angular.module('myApp',[]);

myApp.controller('DoubleController',  function($scope,$http,$log) {
 //$scope.cabs=[{}];
  $scope.show = function () {$http({
		  method:'GET',
			  url:'/api/cab/all'})
			  .then(function(response)
			  {
	  	$scope.cabs= response.data;
	  	//$log.info(response);
			  })};
			
				  
			 $scope.search='false';
			 $scope.cutomer={id: '',
				location: '',
				destination : '',
				number : '',
				feedback : '',
				rating : '',
				confirm_pk : '',
				confirm_arr : ''};
/*
$scope.add= function (customer){$http({
	method:'POST',
    url:'/api/cab/add',
    
		data: customer
	
}).then(function(response)
		{
		console.log(response);
		})};

		*/
  
});