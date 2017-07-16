///////////////////////////////////////////////////////////////////////////////////////////////////////////
//
// Defines the javascript files that need to be loaded and their dependencies.
//
///////////////////////////////////////////////////////////////////////////////////////////////////////////

require.config({
    paths: {
        angular: '../../bower_components/angular/angular',
        angularMessages: '../../bower_components/angular-messages/angular-messages',
        loginApp: 'loginApp'
    },
    shim: {
        angular: {
            exports: "angular"
        },
        angularMessages: {
            deps: ['angular']
        },
        loginApp: {
            deps: ['angular', 'angularMessages']
        }
    }
});

require(['loginApp'], function () {

    angular.bootstrap(document.getElementById('loginApp'), ['loginApp']);

});