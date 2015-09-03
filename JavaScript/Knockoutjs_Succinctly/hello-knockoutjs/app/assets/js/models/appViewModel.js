'use strict';

/* global define:true*/
define(['jquery',
    'knockout'
    ], function ($, ko) {
  return function () {
    var self = this;

    self.firstName = ko.observable('John');
    self.lastName = ko.observable('Smith');
    self.modalTitle = ko.observable('');
    self.modalText = ko.observable('');
    self.checkout = function () {
      self.modalTitle('Checkout');
      self.modalText('Trying to checkout');
    };
  };
});
