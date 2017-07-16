"use strict";

var polarisApp = angular.module('polarisApp', [
    'ui.router',
    'datatables',
    'datatables.light-columnfilter',
    'datatables.buttons',
    'home',
    'feedback',
    'latestLogs',
    'settings',
    'organizations'
]);

polarisApp.config(function($locationProvider) {
    $locationProvider.html5Mode(true);
});
