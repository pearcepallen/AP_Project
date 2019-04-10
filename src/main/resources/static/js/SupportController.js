
myApp.controller('SupportController',  function($scope,$http,$log) {
 

 $scope.support={id:'',     
                name: '',
                studentId : ''};



$scope.allSupport= function () {
                    $http({
                            method:'GET',
                            url:'/api/support/all'
                        })
                            .then(function(response)
                            {
                                    $scope.support= response.data;
                                    //$log.info(response);
                            })};


$scope.studentPick = 0;                            


$scope.addSupport= function (){$http({
        method:'POST',
        url:'/api/support/add',
        data: $scope.support
            }).then(function(response)
                    {})};




$scope.updateSupport=function (a) {$http({
                    method:'PUT',
                    url:'/api/student/' +  $scope.selectedSupport,
                    data: $scope.support
                    
                        }).then(function(response)
                    {})};




$scope.deleteSupport=function (a) {$http({
                    method:'DELETE',
                    url:'/api/student/' +  $scope.selectedSupport,
                    data: $scope.support
                    
                        }).then(function(response)
                    {})};


$scope.update = true;    
$scope.selectedSupport= 0;                
                 

$scope.IsUpdate = function()
{
    if ($scope.selectedSupport != 0 )
        {
            return $scope.update = false;
        } 
}

                    


$scope.delete = true;              
                 

$scope.IsDelete = function()
{
    if ($scope.selectedSupport != 0 )
        {
            return $scope.delete = false;
        } 
}

    

});

           