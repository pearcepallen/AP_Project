if(app) //ensure app is defined
{
	app.factory('BasketService',[
		'Restangular',
		function(Restangular){
			var BasketService = {};
			var restB
			BasketService.add = function(ownerName){
				var restBase = Restangular.all('/api/baskets');
				var resultPromise = restBase.post({
					ownerName:ownerName
				});
				return resultPromise;
			};
			return BasketService;
		}]);
	app.component('basket',{
		templateUrl:'assets/components/basket/basket.component.html',
		controllerAs: '$ctrl',
		bindings:{
			ownerName:'<'
		},
		controller: [
			'$scope',
			'BasketService',
			function BasketController($scope,BasketService){
				$scope.operationType = '';
				var lastBasketId = 2;
				$scope.baskets = [
					{
						id:1,
						ownerName:"Hermione Granger"
					},
					{
						id:2,
						ownerName:"Tom Riddle"
					}
				];
				
				$scope.showAdd=function(){
					$scope.operationType='Add';
				}
				
				$scope.doAction=function(){
					switch($scope.operationType){
					case 'Add': addBasket();
                                addBasketToApi();
                    case 'Delete': deleteBasket
					}
				}
				
				function addBasketToApi(){
					BasketService.add($scope.$ctrl.ownerName)
					   .then(function success(response){
						   console.log(response);
						   window.alert("We successfully added basket to api");
					   },function error(){
						   window.alert("We were unable to add basket with api");
					   })
				}
				
				function addBasket(){
					var ownerName = $scope.$ctrl.ownerName;
					console.log("Adding ",ownerName);
					$scope.baskets.push({
						id : ++lastBasketId,
						ownerName : ownerName
					});
					$scope.operationType='';
					window.alert("Basket added successfully");					
					
				}
			}
		]
	});
}