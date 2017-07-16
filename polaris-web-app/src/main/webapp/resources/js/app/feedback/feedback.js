"use strict";

var feedback = angular.module('feedback', []);

feedback.config(function($stateProvider) {
    $stateProvider
        .state('feedback', {
            url: '/feedback',
            views: {
                'polarisHeader': {
                    template: '<h1>Your feedback</h1>'
                },
                'polarisContent': {
                    templateUrl: 'resources/js/app/feedback/feedback.html',
                    controller: 'feedbackCtrl'
                }
            }

        });
});

feedback.controller('feedbackCtrl', function ($scope, $state) {

});