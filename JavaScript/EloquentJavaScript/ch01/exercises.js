/**
 * Created by luhtonen on 20/08/15.
 */
function createTriangle() {
  var sign = '#';
  for (var i = 0; i < 8; i++) {
    console.log(sign);
    sign +='#'
  }
}

function fizzBuzz() {
  for (var i = 1; i < 101; i++) {
    if (i % 3 == 0) {
      console.log("Fizz");
    } else if (i % 5 == 0) {
      console.log("Buzz");
    } else {
      console.log(i);
    }
  }
}

function fizzBuzzExt() {
  var word = '';
  for (var i = 1; i < 101; i++) {
    if (i % 3 == 0) {
      word += "Fizz";
    }
    if (i % 5 == 0) {
      word += "Buzz";
    }
    if (word.length == 0) {
      word = i
    }
    console.log(word);
    word = '';
  }
}

function chessBoard(boardSize) {
  var board = '';
  for (var x = 0; x < boardSize; x++) {
    for (var y = 0; y < boardSize; y++) {
      if ((x + y) % 2 == 0) {
        board += ' ';
      } else {
        board += '#';
      }
    }
    board += "\n";
  }
  console.log(board);
}