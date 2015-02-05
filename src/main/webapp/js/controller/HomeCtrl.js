var _AOP = _AOP || {};

_AOP.core.controller("HomeCtrl", function($scope, $http, $modal, $state) {
    $scope.items = [];
    $scope.init = function() {

    };

    $scope.paging = {
        currentPage: 1,
        pageSize: 25
    };

});