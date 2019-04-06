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
var ave='available';
$scope.myFilter = function() {
 if ($scope.cabs.available == false)    
   {
   	return cabs;
   	console.log(Scope.cabs);
   }
 
};

		
  
});