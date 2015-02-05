var _AOP = _AOP || {};

_AOP.core.controller("HomeCtrl", function($scope, $http, $modal, $state) {
    $scope.items = [];
    $scope.init = function() {
        console.log(2323432424);
    };

    $scope.paging = {
        currentPage: 1,
        pageSize: 25
    };

});