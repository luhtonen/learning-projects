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

function groupBy(array, group) {
  var groups = {};
  array.forEach(function(person) {
    var groupName = group(person);
    if (groupName in groups) {
      groups[groupName].push(person);
    } else {
      groups[groupName] = [person];
    }
  });
  return groups;
}

function calculateLifeExpectancy() {
  var centuries = groupBy(ancestry, function(person) {
    return Math.ceil(person.died / 100);
  });

  for (var century in centuries) {
    var ages = centuries[century].map(function(person) {
      return person.died - person.born;
    });
    console.log(century + ": " + average(ages).toFixed(1));
  }
}

function every(array, predicate) {
  for (var i = 0; i < array.length; i++) {
    if(!predicate(array[i])) {
      return false;
    }
  }
  return true;
}

function some(array, predicate) {
  for (var i = 0; i < array.length; i++) {
    if(predicate(array[i])) {
      return true;
    }
  }
  return false;
}
