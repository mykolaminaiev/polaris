"use strict";

var home = angular.module('home');

home.service('userService', function($http) {
    return {
        logout: function () {
            $http({
                method: 'POST',
                url: '/polaris/logout'
            })
            .then(function (response) {
                if (response.status == 200) {
                    window.location.reload();
                } else {
                    console.log("Logout failed!");
                }
            });
        }
    };
});

home.service('refreshService', function($http, $rootScope) {
    return {
        refresh: function() {
            $rootScope.loading = true;
            $http({
                method: 'POST',
                url: '/polaris/refresh'
            })
            .then(function (response) {
                if (response.status == 200) {
                    console.log("Refresh successful!");
                } else {
                    console.log("Logout failed!");
                }
                $rootScope.loading = false;
            });
        }
    };
});