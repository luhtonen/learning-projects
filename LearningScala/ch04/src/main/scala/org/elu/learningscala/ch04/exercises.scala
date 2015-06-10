// Exercises
// ---------
// 1. Write a function that computes the area of a circle given its radius.
def computeCircleArea(radius: Double): Double = Math.PI * (radius * radius)
computeCircleArea(2.0)

// 2. Provide an alternate form of the function in exercise 1 that takes the radius as a String.
// What happens if your function is invoked with an empty String ?
def computeCircleArea(radius: String): Double = {
  val r = if(radius == "") 0 else radius.toDouble
  Math.PI * (r * r)
}
computeCircleArea("2.0")
computeCircleArea("")

// 3. Write a recursive function that prints the values from 5 to 50 by fives, without using for
// or while loops. Can you make it tail-recursive?
def printFives(start: Int = 5, end: Int = 50): Unit = {
  println(start)
  if(start < end) printFives(start + 5, end)
}
printFives()

// 4. Write a function that takes a milliseconds value and returns a string describing the value
// in days, hours, minutes, and seconds. What’s the optimal type for the input value?
def millisecondsToDays(millis: Long): String = {
  val seconds = millis / 1000
  val minutes = seconds / 60
  val hours = minutes / 60
  val days = hours / 24
  s"$days days, $hours hours, $minutes minutes, $seconds seconds"
}
millisecondsToDays(1000000000000L)

// 5. Write a function that calculates the first value raised to the exponent of the second value.
// Try writing this first using math.pow, then with your own calculation. Did you implement it with
// variables? Is there a solution available that only uses immutable data? Did you choose a
// numeric type that is large enough for your uses?
def raiseToExponent(value: Double, exponent: Double): Double = Math.pow(value, exponent)

def toExponent(value: Double, exponent: Int): Double = {
  if (value == 0) return 0
  var result = 1.0
  for (x <- 1 to Math.abs(exponent)) {
    result = result * value
  }
  if (exponent < 0) {
    result = 1 / result
  }
  return result
}
"raiseToExponent(2.0, 2.5) = " + raiseToExponent(2.0, 2.5)
"raiseToExponent(0, 3) = " + raiseToExponent(0.0, 3)
"raiseToExponent(3, 2) = " + raiseToExponent(3, 2)
"raiseToExponent(2, 3) = " + raiseToExponent(2, 3)
"raiseToExponent(9, -2) = " + raiseToExponent(9, -2)
"raiseToExponent(2, 0) = " + raiseToExponent(2, 0)
"raiseToExponent(-3, 2) = " + raiseToExponent(-3, 2)
"raiseToExponent(-2, 3) = " + raiseToExponent(-2, 3)

"toExponent(0, 3) = " + toExponent(0.0, 3)
"toExponent(3, 2) = " + toExponent(3, 2)
"toExponent(2, 3) = " + toExponent(2, 3)
"toExponent(9, -2) = " + toExponent(9, -2)
"toExponent(2, 0) = " + toExponent(2, 0)
"toExponent(-3, 2) = " + toExponent(-3, 2)
"toExponent(-2, 3) = " + toExponent(-2, 3)

// 6. Write a function that calculates the difference between a pair of 2D points (x and y) and
// returns the result as a point. Hint: this would be a good use for tuples (see “Tuples”
// on page 25).
def compare(x1: Double, y1: Double)(x2: Double, y2: Double): (Double, Double) = {
  return (x1 - x2, y1 - y2)
}
compare(1.0, 3.0)(2.0, 2.0)

// 7. Write a function that takes a 2-sized tuple and returns it with the Int value (if included)
// in the first position. Hint: this would be a good use for type parameters and the isInstanceOf
// type operation.
def getInt[T](tuple: (T, Any)): (T, Any) = {
  if(tuple._1.isInstanceOf[Int]) {
    return (tuple._1, tuple._2)
  } else {
    return tuple
  }
}
getInt(1, "abc")
getInt("bcd", 2)
getInt("abc", "def")

// 8. Write a function that takes a 3-sized tuple and returns a 6-sized tuple, with each original
// parameter followed by its String representation. For example, invoking the function with (true,
// 22.25, "yes") should return (true, "true", 22.5, "22.5", "yes", "yes"). Can you ensure that
// tuples of all possible types are compatible with your function? When you invoke this function,
// can you do so with explicit types not only in the function result but in the value that you use
// to store the result?
def checkTuple[A,B,C](tuple: (A, B, C)): (A, String, B, String, C, String) = {
  (tuple._1, s"${tuple._1}", tuple._2, s"${tuple._2}", tuple._3, s"${tuple._3}")
}
checkTuple(true, 22.5, "yes")
