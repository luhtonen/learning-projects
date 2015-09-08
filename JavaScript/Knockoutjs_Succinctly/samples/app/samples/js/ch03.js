define(['jquery', 'knockout'], function($, ko) {
  this.activeTab = ko.observable('ch03');
  this.firstName = ko.observable('John');
  this.lastName = ko.observable('Smith');
  this.fullName = ko.computed(function() {
    return this.firstName() + " " + this.lastName();
  }, this);
});
