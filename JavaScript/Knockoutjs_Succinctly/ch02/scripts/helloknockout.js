/**
 * Created by luhtonen on 03/09/15.
 */
function PersonViewModel() {
  this.firstName = ko.observable('John');
  this.lastName = ko.observable('Smith');
  this.checkout = function() {
    alert("Trying to check out");
  };
}
ko.applyBindings(new PersonViewModel());
