'use strict';

/* global define:true*/
define(['jquery',
    'knockout'
    ], function ($, ko) {
  return function () {
    var self = this;

    self.firstName = ko.observable('John');
    self.lastName = ko.observable('Smith');

    self.saveUserData = function (model, event) {
      console.log(model.firstName() + ' is trying to checkout!');
      if (event.altKey) {
        console.log('He was holding down the Alt key for some reason.');
      }
    };

    self.displayName = function () {
      console.log(self.firstName());
    };
    self.setName = function () {
      self.firstName('Bob');
    };

    self.details = ko.observable(false);
    self.showDetails = function (target, event) {
      self.details(true);
    };
    self.hideDetails = function (target, event) {
      self.details(false);
    };
  };
});
