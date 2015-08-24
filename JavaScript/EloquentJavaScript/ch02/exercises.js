/**
 * Created by luhtonen on 24/08/15.
 */
function min(a, b) {
  if (a > b) {
    return b;
  } else {
    return a;
  }
}

function testMin(a, b) {
  console.log("min(a, b) = " + min(a, b));
}

function isEven(number) {
  if (number < 0) {
    return isEven(number * -1);
  } else
  if (number == 0) {
    return true;
  } else if (number == 1) {
    return false;
  } else {
    return isEven(number - 2);
  }
}

function testIsEven(number) {
  console.log(number + " is even = " + isEven(number));
}

function countBs(word) {
  var count = 0;
  for (var i = 0; i < word.length; i++) {
    if (word.charAt(i) === 'B') {
      count++;
    }
  }
  return count;
}

function testCountBs(word) {
  console.log("B count in word [" + word + "] = " + countBs(word));
}

function countChar(word, char) {
  var count = 0;
  for (var i = 0; i < word.length; i++) {
    if (word.charAt(i) === char) {
      count++;
    }
  }
  return count;
}

function testCountChar(word, char) {
  console.log(char + " count in word [" + word + "] = " + countChar(word, char));
}

function countBs2(word) {
  return countChar(word, 'B');
}

function testCountBs2(word) {
  console.log("B count in word [" + word + "] = " + countBs2(word));
}