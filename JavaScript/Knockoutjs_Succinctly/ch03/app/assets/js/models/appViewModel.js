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
    self.fullName = ko.computed(function () {
      return self.firstName() + ' ' + self.lastName();
    }, self);

    function Product(name, price) {
      this.name = ko.observable(name);
      this.price = ko.observable(price);
    }
    self.shoppingCart = ko.observableArray([
      new Product('Beer', 10.99),
      new Product('Brats', 7.99),
      new Product('Buns', 1.49)
    ]);

    self.addProduct = function () {
      self.shoppingCart.push(new Product('More Beer', 10.99));
    };

    self.removeProduct = function (product) {
      self.shoppingCart.remove(product);
    };
  };
});
