/**
 * Created by luhtonen on 27/08/15.
 */
function flattening() {
  var arrays = [[1, 2, 3], [4, 5], [6]];
  console.log(arrays.reduce(function(arr1, arr2) { return arr1.concat(arr2) }));
}

function motherChild() {
  var byName = {};
  ancestry.forEach(function(person) {
    byName[person.name] = person;
  });

  var diffs = ancestry.filter(function(person) {
    return byName[person.mother] != null
  }).map(function(person) {
    return person.born - byName[person.mother].born;
  });
  console.log(average(diffs));
}