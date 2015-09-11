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
        console.log(data.firstName);
      });
    };
  };
});
