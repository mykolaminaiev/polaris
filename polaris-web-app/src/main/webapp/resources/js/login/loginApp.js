"use strict";

var login = angular.module('loginApp', ['ngMessages']);

login.config(function ($locationProvider) {
    $locationProvider.html5Mode(true);
});

login.controller('loginCtrl', function ($scope, loginService, $http) {

    $scope.onLogin = function() {
        var loginData = loginService.prepareLoginData($scope.username, $scope.password, $scope.email);
        loginService.login(loginData);
    };

});

login.factory('loginService', function ($http) {
    var loginService = {
        authenticated: false,
        loginPath: '/polaris/login',
        logoutPath: '/logout',
        homePath: '/polaris/resources/index.html',

        prepareLoginData: function (username, password, email) {
            var username = username != undefined ? username : '';
            var password = password != undefined ? password : '';
            var email = email != undefined ? email : '';

            return 'username=' + username + '&password=' + password + '&email=' + email;
        },

        login: function (loginData) {
            $http({
                method: 'POST',
                url: loginService.loginPath,
                data: loginData,
                headers: {
                    "Content-Type": "application/x-www-form-urlencoded",
                    "X-Login-Ajax-call": 'true'
                }
            }).then(function (response) {
                if (response.data == 'ok') {
                    window.location.replace(loginService.homePath);
                } else {
                     $scope.vm.errorMessages = [];
                     $scope.vm.errorMessages.push({description: 'Access denied'});
                }
            });
        }
    };
    return loginService;
});

