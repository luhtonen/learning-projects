'use strict';

/**
 * @ngdoc function
 * @name clientApp.controller:AlertsCtrl
 * @description
 * # AlertsCtrl
 * Controller of the clientApp
 */
angular.module('clientApp')
  .controller('AlertsCtrl', ["$scope", "alertService", function ($scope, alertService) {
    $scope.alerts = alertService.get();
  }]);
