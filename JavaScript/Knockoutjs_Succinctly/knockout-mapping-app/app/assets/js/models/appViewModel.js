'use strict';

/* global define:true*/
define(['jquery',
  'knockout'
], function ($, ko) {
  $.getJSON('/get-user-data', function (data) {
    var viewModel = ko.mapping.fromJS(data);

    viewModel.loadUserData = function () {
      $.getJSON('/get-user-data', function (data) {
        ko.mapping.fromJS(data, viewModel);
      });
    };
    viewModel.saveUserData = function () {
      var dataToSend = {userData: ko.toJSON(viewModel)};
      $.post('/save-user-data', dataToSend, function (data) {
        console.log('Your data has been posted to the server: ' + data);
      });
    };

    ko.applyBindings(viewModel);
  });
});
