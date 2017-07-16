"use strict";

var latestLogs = angular.module('latestLogs');

latestLogs.service('logsService', function($http) {
    return {
        getLatestLogs: function () {
            return $http({
                method: 'GET',
                url: '/polaris/logs'
            })
            .then(function (response) {
                if (response.status == 200) {
                    return response.data;
                }
            });
        }
    };
});