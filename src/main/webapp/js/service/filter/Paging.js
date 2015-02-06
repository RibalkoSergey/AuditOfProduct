var _AOP = _AOP || {};

_AOP.core.filter("pagingFilter", function() {
    return function(input, currentPage, pageSize ) {
        return input ? input.slice(currentPage * pageSize, currentPage * ( pageSize + 1 )) : [];
    };
});