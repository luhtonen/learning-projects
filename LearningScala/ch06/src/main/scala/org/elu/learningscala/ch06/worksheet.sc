// List, Sets, and Maps
// Lists
val numbers = List(32, 95, 24, 21, 17)
val colors = List("red", "green", "blue")
println(s"I have ${colors.size} colors: $colors")

colors.head
colors.tail
colors(1)
colors(2)

var total = 0; for (i <- numbers) { total += i }
for (c <- colors) { println(c) }

colors.foreach( (c: String) => println(c) )
val sizes = colors.map((c: String) => c.length)
val total1 = numbers.reduce((a: Int, b: Int) => a + b)
// do the same as previous code
val total2 = numbers.sum

// Sets
val unique = Set(10, 20, 30, 20, 20, 10)
val sum = unique.reduce((a: Int, b: Int) => a + b)

// Maps
val colorMap = Map("red" -> 0xFF0000, "green" -> 0xFF00, "blue" -> 0xFF)
val redRGB = colorMap("red")
val cyanRGB = colorMap("green") | colorMap("blue")
val hasWhite = colorMap.contains("white")

for (pairs <- colorMap) { println(pairs) }

// What’s in a List?
val oddsAndEvens = List(List(1, 3, 5), List(2, 4, 6))
val keyValues = List(('A', 65), ('B', 66), ('C', 67))

val primes = List(2, 3, 5, 7, 11, 13)
val first = primes(0)
val fourth = primes(3)

val first1 = primes.head
val remaining = primes.tail

var i = primes
while(i.nonEmpty) {
  print(i.head + ", ")
  i = i.tail
}

def visit(i: List[Int]): Unit = {
  if (i.size > 0) {
    print(i.head + ", ")
    visit(i.tail)
  }
}
visit(primes)

i = primes
while(i != Nil) {
  print(i.head + ", ")
  i = i.tail
}

val l: List[Int] = List()
l == Nil
val m: List[String] = List("a")
m.head
m.tail == Nil

// The Cons Operator
val numbers1 = 1 :: 2 :: 3 :: Nil
val first2 = Nil.::(1)
first2.tail == Nil
val second = 2 :: first2
second.tail == first2

// List Arithmetic
val f = List(23, 8, 14, 21) filter(_ > 18)
val p = List(1, 2, 3, 4, 5) partition (_ < 3)
val s = List("apple", "to") sortBy (_.length)

val appended = List(1, 2, 3, 4) :+ 5
val suffix = appended takeRight 3
val middle = suffix dropRight 2

// Mapping Lists
List(0, 1, 0) collect {case 1 => "ok"}
List("milk,tea") flatMap(_.split(','))
List("milk", "tea") map(_.toUpperCase)

// Reducing Lists
val validations = List(true, true, false, true, true, true)
val valid1 = !(validations contains false)
val valid2 = validations forall (_ == true)
val valid3 = validations.exists(_ == false) == false

def contains(x: Int, l: List[Int]): Boolean = {
  var a: Boolean = false
  for (i <- l) {
    if (!a) {
      a = i == x
    }
  }
  a
}
val included = contains(19, List(46, 19, 92))

def boolReduce(l: List[Int], start: Boolean)(f: (Boolean, Int) => Boolean): Boolean = {
  var a = start
  for (i <- l) a = f(a, i)
  a
}
val included1 = boolReduce(List(46, 19, 92), false) { (a, i) =>
  if (a) a else i == 19
}

def reduceOp[A,B](l: List[A], start: B)(f: (B, A) => B): B = {
  var a = start
  for (i <- l) a = f(a, i)
  a
}
val included2 = reduceOp(List(46, 19, 92), false) { (a, i) =>
  if (a) a else i == 19
}
val answer = reduceOp(List(11.3, 23.5, 7.2), 0.0)(_ + _)

val included3 = List(46, 19, 92).foldLeft(false) { (a, i) =>
  if (a) a else i == 19
}
val answer1 = List(11.3, 23.5, 7.2).reduceLeft(_ + _)

// Pattern Matching with Collections
val statuses = List(500, 404)
val msg = statuses.head match {
  case x if x < 500 => "okay"
  case _ => "whoah, an error"
}
val msg1 = statuses match {
  case x if x contains 500 => "has error"
  case _ => "okay"
}
val msg2 = statuses match {
  case List(404, 500) => "not found & error"
  case List(500, 404) => "error & not found"
  case List(200, 200) => "okay"
  case _ => "not sure what happened"
}
val msg3 = statuses match {
  case List(500, x) => s"Error followed by $x"
  case List(e, x) => s"$e was followed by $x"
}
val head = List('r', 'g', 'b') match {
  case x :: xs => x
  case Nil => ' '
}
val code = ('h', 204, true) match {
  case (_, _, false) => 501
  case ('c', _, true) => 302
  case ('h', x, true) => x
  case (c, x, true) =>
    println(s"Did not expected code $c")
    x
}
