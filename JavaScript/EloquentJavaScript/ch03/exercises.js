/**
 * Created by luhtonen on 26/08/15.
 */
function sum(ints) {
  var result = 0;
  for (var i = 0; i < ints.length; i++) {
    result += ints[i];
  }
  return result;
}

function range(start, end, step) {
  var result = [];
  if (!step) {
    step = 1;
  }
  for (var i = start; (step > 0 && i <= end) || (step < 0 && i >= end); i += step) {
    result.push(i);
  }
  return result;
}

function reverseArray(array) {
  var result = [];
  for (var i = array.length - 1; i >= 0; i--) {
    result.push(array[i]);
  }
  return result;
}

function reverseArrayInPlace(array) {
  if (array.length < 2) {
    return array;
  }
  for (var i = 0; i < Math.floor(array.length / 2); i++) {
    var value = array[i];
    array[i] = array[array.length - 1 - i];
    array[array.length - 1 - i] = value;
  }
  return array;
}

function arrayToList(array) {
  var list = null;
  for (var i = array.length - 1; i >= 0; i--) {
    list = {value: array[i], rest: list};
  }
  return list;
}

function listToArray(list) {
  var array = [];
  for (var element = list; element; element = element.rest) {
    array.push(element.value);
  }
  return array;
}

function prepend(element, list) {
  return {value: element, rest: list};
}

function nth(list, number) {
  if (!list) {
    return undefined;
  } else if (number == 0) {
    return list.value;
  } else {
    return nth(list.rest, number - 1);
  }
}

function deepEqual(obj1, obj2) {
  if (obj1 === obj2) return true;

  if (!obj1 || typeof obj1 != "object" ||
    !obj2 || typeof obj2 != "object") {
    return false;
  }

  var propsA = 0, propsB = 0;

  for (var p in obj1) {
    propsA++;
  }
  for (var prop in obj2) {
    propsB++;
    if (!(prop in obj1) || !deepEqual(obj1[prop], obj2[prop])) {
      return false;
    }
  }
  return propsA == propsB;
}