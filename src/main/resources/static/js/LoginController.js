
myApp.controller('LoginController',  function($scope,$http,$log) {
 
$scope.Pass = true;
$scope.Fail = false;
    // Login Usernames
var managerUsername= "topman";        

    // Login Passwords
 var managerPassword="topman";
 

$scope.login = function()
            {
             
                if ($scope.username  == managerUsername && $scope.password  == managerPassword )
                    {
                        return $scope.Pass = false;
                    }
                else
                    {
                        return $scope.Fail = true;
                    } 
            }

            




});