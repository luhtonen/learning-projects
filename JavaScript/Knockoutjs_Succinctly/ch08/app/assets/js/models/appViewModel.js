'use strict';

/* global define:true*/
define(['jquery',
    'knockout'
    ], function ($, ko) {
  return function () {
    var self = this;

    function Product(name, price /*, tags, discount, details */) {
      this.name = name;
      this.price = price;
    }

    self.instructions = ko.observable('');
    self.hasInstructions = ko.observable(false);

    self.items = ko.observableArray([
      new Product('Beer', 10.99),
      new Product('Brats', 7.99),
      new Product('Buns', 1.49)
    ]);

    self.addProduct = function () {
      self.items.push(new Product('More Beer', 10.99));
    };

    self.removeProduct = function (product) {
      self.items.destroy(product);
    };

    self.showProduct = function (element) {
      if (element.nodeType === 1) {
        $(element).hide().fadeIn();
      }
    };

    self.hideProduct = function (element) {
      if (element.nodeType === 1) {
        $(element).fadeOut(function () {
          $(element).remove();
        });
      }
    };

    ko.bindingHandlers.visibleFade = {
      init: function (element, valueAccessor) {
        var value = valueAccessor();
        $(element).toggle(value());
      },
      update: function (element, valueAccessor) {
        var value = valueAccessor();
        value() ? $(element).fadeIn() : $(element).fadeOut();
      }
    };
  };
});
