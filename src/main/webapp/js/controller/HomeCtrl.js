var _AOP = _AOP || {};

_AOP.core.controller("HomeCtrl", function($scope, $timeout, $interval, $cronosModals, HomeFactory) {
    $scope.products = [];
    $scope.init = function() {
        HomeFactory.getData(function(data) {
            $scope.products = data;
        })
    };

    $scope.create = function() {
        $cronosModals.cronosInfoModal({
            templateUrl: '/aop/jsp/create.html',
            windowClass: 'cronos-modal cronos-default-modal customize-project-dialog',
            controller: CreateProductCtrl,
            resolve: {
                data: function() {
                    return {};
                }
            }
        }, "").result.then(function(data) {
                $scope.products = data;
        });
    };

    $scope.paging = {
        currentPage: 1,
        pageSize: 15
    };

    $interval(function() {
        HomeFactory.getData(function(data) {
        $scope.products = data;
    })}, 3000);

    var CreateProductCtrl = function($scope, $modalInstance, HomeFactory) {
        $scope.cancel = function() {
            $modalInstance.dismiss();
        };

        $scope.dismiss = function() {
            $modalInstance.dismiss();
        };

        $scope.createProduct = function(productCode, productName, productAmount) {
            HomeFactory.createProduct(productCode, productName, productAmount, function(data) {
                $modalInstance.close(data);
            });
        };
    };

});