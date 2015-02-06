var _AOP = _AOP || {};

_AOP.core.factory('HomeFactory', function($resource) {
    var resource = $resource('', {},
        {
            getData: {method: 'GET', url: '/aop/home/get/data', isArray: true},
            create: {method: 'GET', url: '/aop/home/create/product', isArray: true}
        });

    function _getData(callback) {
        resource.getData({},
            function(data) {
                if (angular.isFunction(callback))
                    callback(data)
            });
    };

    function _create(productCode, productName, productAmount, callback) {
        resource.create({productCode: productCode, productName: productName, productAmount: productAmount}, {},
            function(data) {
                if (angular.isFunction(callback))
                    callback(data)
            });
    }

    return {
        getData: _getData,
        createProduct: _create
    };
});
