(function () {
  'use strict';

  function PersonViewModel () {
    var self = this;
    self.firstName = ko.observable('');
    self.lastName = ko.observable('');
    self.activities = ko.observable([]);
    self.favoriteHobby = ko.observable('');

    self.loadUserData = function () {
      $.getJSON('/get-user-data', function (data) {
        self.firstName(data.firstName);
        self.lastName(data.lastName);
        self.activities(data.activities);
        self.favoriteHobby(data.favoriteHobby);
      });
    };

    self.saveUserData = function () {
      var data_to_send = {userData: ko.toJSON(self)};
      $.post('/save-user-data', data_to_send, function (data) {
        alert('Your data has been posted to the server!');
      });
    };
  }
  ko.applyBindings(new PersonViewModel());
}());
