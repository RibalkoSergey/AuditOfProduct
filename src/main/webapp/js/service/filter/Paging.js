var _CM = _CM || {};

_CM.CmCoreApp.filter("pagingFilter", function() {
    return function(input, currentPage, pageSize ) {
        return input ? input.slice(currentPage * pageSize, currentPage * ( pageSize + 1 )) : [];
    };
});