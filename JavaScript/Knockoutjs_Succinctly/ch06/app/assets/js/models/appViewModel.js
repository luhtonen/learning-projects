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

    self.details = ko.observable('');
    self.showDetails = function (target, event, details) {
      self.details(details);
    };
    self.hideDetails = function (target, event) {
      self.details('');
    };

    self.primaryPhone = ko.observable('');
    self.secondaryPhone = ko.observable('');

    self.annoyMe = ko.observable(true);
    self.annoyTimes = ko.observableArray(['morning', 'evening']);
    self.annoyTime = ko.observable('morning');

    self.annoyOptTimes = ko.observableArray([
      'In the morning',
      'In the afternoon',
      'In the evening'
    ]);
    self.selectedTime = ko.observable('In the afternoon');

    self.products = ko.observableArray([
      {name: 'Beer', price: 10.99},
      {name: 'Brats', price: 7.99},
      {name: 'Buns', price: 2.99}
    ]);
    self.favoriteProduct = ko.observable({});
  };
});
