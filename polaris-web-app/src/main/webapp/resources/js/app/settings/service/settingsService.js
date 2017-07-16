"use strict";

var settings = angular.module('settings');

settings.service('settingsService', function($http) {
    return {
        getSettings: function () {
            return $http({
                method: 'GET',
                url: '/polaris/settings'
            })
            .then(function (response) {
                if (response.status == 200) {
                    return response.data;
                }
            });
        }
    };
});