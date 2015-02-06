var _AOP = _AOP || {};

_AOP.core.provider('$cronosModals', function() {
    var cronosModalProvider = {
        $get: ['$modal', function ($modal) {
            var message = "";

            var CronosModalDialogCtrl = function($scope, $modalInstance, data) {
                $scope.data = data;

                $scope.close = function() {
                    $modalInstance.close();
                };

                $scope.dismiss = function() {
                    $modalInstance.dismiss();
                };
            };

            var defaultOptions = {
                controller: CronosModalDialogCtrl,
                resolve: {
                    data: function() {
                        return { message: message };
                    }
                }
            };

            var errorModalOptions = {
                templateUrl: '/cm/view/utils/modalDialogs/error.dialog.tmpl.html',
                windowClass: 'cronos-modal cronos-error-modal'
            };

            var infoModalOptions = {
                templateUrl: '/cm/view/utils/modalDialogs/info.dialog.tmpl.html',
                windowClass: 'cronos-modal cronos-info-modal'
            };

            var warningModalOptions = {
                templateUrl: '/cm/view/utils/modalDialogs/warning.dialog.tmpl.html',
                windowClass: 'cronos-modal cronos-warning-modal'
            };

            var $cronosModals = {};

            $cronosModals.cronosErrorModal = function(options, msg) {
                var dialogOptions = angular.copy(errorModalOptions);
                message = msg ||message;
                angular.extend(dialogOptions, defaultOptions, options);
                return $modal.open(dialogOptions);
            };

            $cronosModals.cronosInfoModal = function(options, msg) {
                var dialogOptions = angular.copy(infoModalOptions);
                message = msg ||message;
                angular.extend(dialogOptions, defaultOptions, options);
                return $modal.open(dialogOptions);
            };

            $cronosModals.cronosWarningModal = function(options, msg) {
                var dialogOptions = angular.copy(warningModalOptions);
                message = msg ||message;
                angular.extend(dialogOptions, defaultOptions, options);
                return $modal.open(dialogOptions);
            };

            return $cronosModals;
        }]
    };

    return cronosModalProvider;
});