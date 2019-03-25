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
			  
        $scope.dest={
                location:'',
                destination:'',
                distance:'',
                price:'',
                };
			 
			$scope.check='';
<<<<<<< HEAD
			$scope.chosencab={};
=======
			  $scope.chosencab={ c_id:'',
						  trn:'',
						  year:'',
						  model:'',
						  name:'',
						  available:'',
						  fare:'',
						  distance:''};
>>>>>>> branch 'detta-development10' of https://github.com/DeathAmongMen/Ascari
			 $scope.search='false';
<<<<<<< HEAD
			 $scope.customer={
                id: '',
=======
			 $scope.customer={id:'',
>>>>>>> branch 'detta-development10' of https://github.com/DeathAmongMen/Ascari
				location: '',
				destination : '',
				number : '',
				feedback : '',
				rating : '',
				confirm_pk : '',
                confirm_arr : ''};
                
			 $scope.cab={
					 c_id:'',
                    trn:'',
                    year:'',
                    model:'',
                    name:'',
                    available:'',
                    fare:'',
                    distance:''
                };

<<<<<<< HEAD
            $scope.cabManager={
                id: '',
                email: '',
                password: ''                                        
            };


			//  $scope.add = function() {
			// 	    $http.post('/api/customer/add', $scope.customer).then(function(response) {console.log(response);});
			//  }
=======
			 };
			 $scope.add = function() {
				    $http.post('/api/customer/add', $scope.customer).then(function(response) {});
			 }
>>>>>>> branch 'detta-development10' of https://github.com/DeathAmongMen/Ascari
			 
$scope.add = function (){$http({
	method:'POST',
    url:'/api/customer/add',
		data: $scope.customer
}).then(function(response)
		{
		console.log($scope.chosencab);
<<<<<<< HEAD
        })};
        
$scope.getreq= function(){
	$scope.request={

	id:	$scope.customer.id,
	c_number: $scope.customer.number,
	c_id: $scope.chosencab.c_id,
	location:$scope.customer.location,
	destination:$scope.customer.destination,
	fare : $scope.chosencab.fare ///probably make care come directly from system*/
=======
		})};
		$scope.getreq= function()
		{	 $scope.request={
			id:	$scope.customer.id,
			c_number: $scope.customer.number,
			c_id: $scope.chosencab.c_id,
			location:$scope.customer.location,
			destination:$scope.customer.destination,
			fare : $scope.chosencab.fare} ///probably make care come directly from system
			
			console.log($scope.request);
			/*.then(function (){$http({
				method:'POST',
		    url:'/api/system//add',
		    data:$scope.request
		    
				
			})})*/};
				  
>>>>>>> branch 'detta-development10' of https://github.com/DeathAmongMen/Ascari
	
		

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
			 $scope.pickup= function  (check)
				  {
					  $scope.customer.confirm_pk= 'true';
				  };

});