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
			 $scope.customer={c_id: '',
				location: '',
				destination : '',
				number : '',
				feedback : '',
				rating : '',
				confirm_pk : '',
				confirm_arr : ''};
			 $scope.cab={
					 pc_id:'',
						  trn:'',
						  year:'',
						  model:'',
						  name:'',
						  available:'',
						  fare:'',
						  distance:''

			 };

$scope.add = function (){$http({
	method:'POST',
    url:'/api/customer/add',
    
		data: $scope.customer
	
}).then(function(response)
		{
		console.log(response);
		})};

		
  

$scope.showcab = function () {$http({
	  method:'GET',
		  url:'/api/customer/get'})
		  .then(function(response)
		  {
	$scope.cabs= response.data;
	//$log.info(response);
		  })};
		  
});