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

    function Product(name, price, tags, discount) {
      this.name = ko.observable(name);
      this.price = ko.observable(price);
      tags = typeof (tags) !== 'undefined' ? tags : [];
      this.tags = ko.observableArray(tags);
      discount = typeof (discount) !== 'undefined' ? discount : 0;
      this.discount = ko.observable(discount);
      this.formattedDiscount = ko.computed(function () {
        return (this.discount() * 100) + '%';
      }, this);
    }
    self.shoppingCart = ko.observableArray([
      new Product('Beer', 10.99, null, 0.2),
      new Product('Brats', 7.99),
      new Product('Buns', 1.49, ['Baked goods', 'Hot dogs'])
    ]);

    self.addProduct = function () {
      self.shoppingCart.push(new Product('More Beer', 10.99));
    };

    self.removeProduct = function (product) {
      self.shoppingCart.destroy(product);
    };

    self.featuredProduct = ko.observable(new Product('Acme BBQ Sauce', 3.99));
  };
});
