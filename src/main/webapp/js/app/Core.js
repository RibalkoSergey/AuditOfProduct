var _AOP = _AOP || {};
_AOP.core = angular.module('core', ['ui.bootstrap', 'ui.router', 'ui.sortable', 'toggle-switch', 'truncate', 'ngResource', 'scrollable-table']);

_AOP.core.config(function($modalProvider) {
    $modalProvider.options.backdrop = 'static';
    $modalProvider.options.keyboard = false;
});

_AOP.core.run(function($rootScope, $state, $modalStack) {
    $rootScope.$on('$stateChangeStart', function() {
      var top = $modalStack.getTop();
      if (top) {
        $modalStack.dismiss(top.key);
      }
    });

    $rootScope.$on('$stateChangeStart');
});


_AOP.core.config(function($httpProvider) {
    $httpProvider.defaults.headers.common['Cache-Control'] = 'no-cache';
    $httpProvider.defaults.cache = false;
    if (!$httpProvider.defaults.headers.get) {
        $httpProvider.defaults.headers.get = {};
    }
    $httpProvider.defaults.headers.get['If-Modified-Since'] = '0';
    // -----------------------------
});
