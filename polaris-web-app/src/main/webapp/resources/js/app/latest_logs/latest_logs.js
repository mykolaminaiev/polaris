"use strict";

var latestLogs = angular.module('latestLogs', []);

latestLogs.config(function($stateProvider) {
    $stateProvider
        .state('latestLogs', {
            url: '/latestLogs',
            resolve: {
                logs: function(logsService) {
                    return logsService.getLatestLogs();
                }
            },
            views: {
                'polarisHeader': {
                    template: '<h1>Show latest events from AWS</h1>'
                },
                'polarisContent': {
                    templateUrl: 'resources/js/app/latest_logs/latest_logs.html',
                    controller: 'latestLogsCtrl'
                }
            }

        });
});

latestLogs.controller('latestLogsCtrl', function ($scope, logs, DTOptionsBuilder, DTColumnBuilder) {
    $scope.logs = logs;
    $scope.dtOptions = DTOptionsBuilder.newOptions()
       .withPaginationType('full_numbers')
       .withOption('responsive', true)
        .withOption('order', [[1, 'desc']])
       .withButtons([
           'colvis',
           'copy',
           'print',
           'excel',
           'pdf'
       ])
       .withLightColumnFilter({
           '0' : {
               type : 'text'
           },
           '1' : {
               type : 'text'
           },
           '2' : {
               type : 'text'
           },
           '3' : {
               type : 'text'
           },
           '4' : {
               type : 'text'
           },
           '5' : {
               type : 'text'
           }
       });
});
