(function () {
  'use strict';

  $.getJSON('/get-user-data', function (data) {
    var viewModel = ko.mapping.fromJS(data);
    viewModel.loadUserData = function () {
      $.getJSON('/get-user-data', function (data) {
        ko.mapping.fromJS(data, viewModel);
      });
    };
    viewModel.saveUserData = function () {
      var data_to_send = {userData: ko.toJSON(viewModel)};
      $.post('/save-user-data', data_to_send, function (data) {
        alert('Your data has been posted to the server!');
      });
    };
    ko.applyBindings(viewModel);
  });
}());
