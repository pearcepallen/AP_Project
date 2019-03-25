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
			$scope.check='';
			  $scope.chosencab={};
			 $scope.search='false';
			 $scope.customer={
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
			 $scope.add = function() {
				    $http.post('/api/customer/add', $scope.customer).then(function(response) {console.log(response);});
			 }
			 
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
		  url:'/api/customer/all'})
		  .then(function(response)
		  {
	$scope.cabs= response.data;
	//$log.info(response);
		  })};
		  $scope.show = function () {$http({
			  method:'GET',
				  url:'/api/cab/all'})
				  .then(function(response)
				  {
		  	$scope.cabs= response.data;
		  	//$log.info(response);
				  })};
			 $scope.pickup= function  (check)
				  {
					  customer.confirm_pk= 'true';
				  };

});