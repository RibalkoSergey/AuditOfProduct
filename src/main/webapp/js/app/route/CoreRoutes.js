_AOP.core.config(function($stateProvider) {
    $stateProvider
        .state('home', {
            url: '/home',
            abstract: true,
            template: '<div ui-view></div>'
        })
        .state('customization', {
            url: '/customization',
            abstract: true,
            template: '<div ui-view></div>'
        });
});