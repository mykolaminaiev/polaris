"use strict";

var organizations = angular.module('organizations');

organizations.service('organizationsService', function($http) {
    return {
        getOrganizations: function () {
            return $http({
                method: 'GET',
                url: '/polaris/organizations'
            })
            .then(function (response) {
                if (response.status == 200) {
                    return response.data;
                }
            });
        }
    };
});