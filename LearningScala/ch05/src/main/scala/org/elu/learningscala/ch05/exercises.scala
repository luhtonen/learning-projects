/** Created by luhtonen on 14/06/15. */
// 1. Write a function literal that takes two integers and returns the higher number. Then write a
// higher-order function that takes a 3-sized tuple of integers plus this function literal, and
// uses it to return the maximum value in the tuple.
val max = (x: Int, y: Int) => if (x > y) x else y
def maxFromTuple(a: Int, b: Int, c: Int)(f: (Int, Int) => Int) = {
  f(f(a, b), c)
}
maxFromTuple(1, 2, 3)(max)
maxFromTuple(21, 12, 3)(max)

// 2. The library function util.Random.nextInt returns a random integer. Use it to invoke the “max”
// function with two random integers plus a function that returns the larger of two given integers.
// Do the same with a function that returns the smaller of two given integers, and then a function
// that returns the second integer every time.
max(util.Random.nextInt, util.Random.nextInt)
val min = (x: Int, y: Int) => if(x < y) x else y
val second = (x: Int, y: Int) => y
min(util.Random.nextInt, util.Random.nextInt)
second(util.Random.nextInt, util.Random.nextInt)

// 3. Write a higher-order function that takes an integer and returns a function. The returned
// function should take a single integer argument (say, “x”) and return the product of x and the
// integer passed to the higher-order function.

// 4. Let’s say that you happened to run across this function while reviewing another developer’s
// code:
//    def fzero[A](x: A)(f: A => Unit): A = { f(x); x }
// What does this function accomplish? Can you give an example of how you might invoke it?

// 5. There’s a function named “square” that you would like to store in a function value. Is this
// the right way to do it? How else can you store a function in a value?
//    def square(m: Double) = m * m
//    val sq = square

// 6. Write a function called “conditional” that takes a value x and two functions, p and f, and
// returns a value of the same type as x. The p function is a predicate, taking the value x and
// returning a Boolean b. The f function also takes the value x and returns a new value of the same
// type. Your “conditional” function should only invoke the function f(x) if p(x) is true, and
// otherwise return x. How many type parameters will the “conditional” function require?

// 7. Do you recall the “typesafe” challenge from the exercises in Chapter 3? There is a popular
// coding interview question I’ll call “typesafe,” in which the numbers 1-100 must be printed one
// per line. The catch is that multiples of 3 must replace the number with the word “type,” while
// multiples of 5 must replace the number with the word “safe.” Of course, multiples of 15 must
// print “typesafe.”
// Use the “conditional” function from exercise 6 to implement this challenge.
// Would your solution be shorter if the return type of “conditional” did not match the type of the
// parameter x? Experiment with an altered version of the “conditional” function that works better
// with this challenge.
