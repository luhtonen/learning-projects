'use strict';

/* global define:true*/
define(['jquery',
    'knockout'
    ], function ($, ko) {
  return function () {
    var self = this;

    self.menus = ko.observableArray([
      {option: 'ch03', url: '/samples/ch03.html', title: 'Chapter 03'}
    ]);
  };
});
