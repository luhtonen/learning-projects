/**
 * Created by luhtonen on 03/09/15.
 */
var personViewModel = {
  firstName: ko.observable('John'),
  lastName: ko.observable('Smith')
};
ko.applyBindings(personViewModel);
personViewModel.firstName('Ryan');