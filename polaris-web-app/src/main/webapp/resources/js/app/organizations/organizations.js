"use strict";

var organizations = angular.module('organizations', []);

organizations.config(function($stateProvider) {
    $stateProvider
        .state('organizations', {
            url: '/organizations',
            resolve: {
                organizations: function(organizationsService) {
                    return organizationsService.getOrganizations();
                }
            },
            views: {
                'polarisHeader': {
                    template: '<h1>Show organizations</h1>'
                },
                'polarisContent': {
                    templateUrl: 'resources/js/app/organizations/organizations.html',
                    controller: 'organizationsCtrl'
                }
            }

        });
});

organizations.controller('organizationsCtrl', function ($scope, organizations) {
    $scope.organizations = organizations;
});