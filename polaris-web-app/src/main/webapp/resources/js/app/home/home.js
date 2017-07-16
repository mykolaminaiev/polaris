"use strict";

var home = angular.module('home', []);

home.config(function($stateProvider, $urlRouterProvider) {

    // For any unmatched url, redirect to /
    $urlRouterProvider.otherwise('/');

    $stateProvider
        .state('home', {
            url: '/',
            views: {
                'polarisHeader': {
                    template: '<h1>Polaris Security Analytics Tool</h1>'
                },
                'polarisContent': {
                    templateUrl: 'resources/js/app/home/home.html',
                    controller: 'homeCtrl'
                }
            }

        });
});

home.controller('homeCtrl', function ($scope, userService, refreshService) {
    $scope.logout = function() {
        userService.logout();
    };

    $scope.refresh = function() {
        refreshService.refresh();
    };
});


