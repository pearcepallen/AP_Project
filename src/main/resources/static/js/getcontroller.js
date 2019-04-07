var myApp = angular.module('myApp',[]);

myApp.controller('DoubleController',  function($scope,$http,$log,$interval) {
 //$scope.cabs=[{}];
// to show all option
	$scope.id=0;
  $scope.show = function () {$http({
		  method:'GET',
			  url:'/api/cab/all'})
			  .then(function(response)
			  {
			  	$scope.cabs= response.data;
			  	//$log.info(response);
			  })};
			  
			  $scope.dest={
					  location:'',
					  destination:'',
						  distance:'',
						  price:'',
			  			};
			 $scope.cabbie;
			$scope.check='';
			 
			  
			 $scope.search='false';
			 $scope.customer={id:'',
				location: '',
				destination : '',
				number : '',
				feedback : '',
				rating : '',
				confirm_pk : '',
				confirm_arr : ''};
		/*	 $scope.cab={
					 c_id:'',
						  trn:'',
						  year:'',
						  model:'',
						  name:'',
						  available:'',
						  fare:'',
						  distance:''

			 };*/
 $scope.add = function() {
				 $http.post('/api/customer/add', $scope.customer).then(function(response) {});
			 }
			 
$scope.add = function (){$http({
	method:'POST',
    url:'/api/customer/add',
    
		data: $scope.customer
	
			}).then(function(response)
					{
						console.log($scope.cabbie);
						})};

$scope.getreq= function()
		{	$scope.id++;
			$scope.customer.location = $scope.route.location;
			$scope.customer.destination =  $scope.route.destination;
			$scope.cabbie.fare = $scope.route.price;
			console.log($scope.route);
			$scope.request={
			id:	$scope.customer.id,
			c_number: $scope.customer.number,
			c_id: $scope.cabbie.c_id,
			location:$scope.customer.location,
			destination:$scope.customer.destination,
			fare : $scope.cabbie.fare} ///probably make care come directly from system
			
						/*.then(function (){$http({
				method:'POST',
		    url:'/api/system//add',
		    data:$scope.request
		    
				
			})})*/
				 $http.post('/api/request/add', $scope.request).then(function(response) {});
				 console.log($scope.request);
				 console.log($scope.id);

			};
				  
	
		

$scope.system= function () {$http({
			  method:'GET',
				  url:'/api/system/get'})
				  .then(function(response)
				  {
			 $scope.sysdests= response.data;
			//$log.info(response);
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

				  
$scope.pickup= function  ()
				  {		var time = $scope.route.distance *5;
					  $scope.customer.confirm_pk= 'true';
					  $scope.cabbie.available = 'false'
					  setInterval(function()
						{
						  $scope.cabbie.available = 'true';
						},time	  
						///Add an update here to the availability
					  )
				   };

	/*			   
$scope.UpdateInfo = function () {$http({
	  method:'PUT',
	  url:'/api/customer/'})
	  .then(function(response)
	  {
		  	$scope.cabs= response.data;
		  	//$log.info(response);
	   })};*/

});