angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8190/app';



    $scope.loadProducts = function () {
        $http.get(contextPath + '/getallproducts')
            .then(function (response) {
                $scope.loadProducts = response.data;

            });
    };
    // исполнили метод
    $scope.loadProducts();

  /* $scope.changeScore = function (clientId, delta){
        $http({
            url: contextPath + '/client/change_score',
            method: 'GET',
            params: {
                clientId: clientId,
                delta: delta
            }
        }).then(function (response){
            $scope.loadProducts;
        });
    }; */

 //  $scope.loadProducts;

});