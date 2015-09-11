'use strict';

/* global define:true*/
define(['jquery',
    'knockout'
    ], function ($, ko) {
  return function () {
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
      var dataToSend = {userData: ko.toJSON(self)};
      $.post('/save-user-data', dataToSend, function (data) {
        console.log('Your data has been posted to the server: ' + data);
      });
    };
  };
});
