"use strict";

var home = angular.module('home');

home.directive('loading', function () {
    return {
        restrict: 'E',
        replace: true,
        template: '<div class="loading"><img src="resources/images/loading.gif" width="300" height="300" /></div>',
        link: function (scope, element, attr) {
            scope.$watch('loading', function (val) {
                if (val)
                    $(element).show();
                else
                    $(element).hide();
            });
        }
    }
});