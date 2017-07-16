"use strict";

var settings = angular.module('settings', []);

settings.config(function($stateProvider) {
    $stateProvider
        .state('settings', {
            url: '/settings',
            resolve: {
                settings: function(settingsService) {
                    return settingsService.getSettings();
                }
            },
            views: {
                'polarisHeader': {
                    template: '<h1>Show settings</h1>'
                },
                'polarisContent': {
                    templateUrl: 'resources/js/app/settings/settings.html',
                    controller: 'settingsCtrl'
                }
            }

        });
});

settings.controller('settingsCtrl', function ($scope, settings) {
    $scope.settings = settings;
});