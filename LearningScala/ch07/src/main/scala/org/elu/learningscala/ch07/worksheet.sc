// Mutable Collections
val m = Map("AAPL" -> 597, "MSFT" -> 40)
val n = m - "AAPL" + ("GOOG" -> 521)
println(m)

// Creating New Mutable Collections
val nums = collection.mutable.Buffer(1)
for (i <- 2 to 10) nums += i
println(nums)
val l = nums.toList

// Creating Mutable Collections from Immutable Ones
val b = m.toBuffer
b trimStart 1
b += ("GOOG" -> 521)
val n1 = b.toMap

b += ("GOOG" -> 521)
val l1 = b.toList
val s = b.toSet

// Using Collection Builders
val b1 = Set.newBuilder[Char]
b1 += 'h'
b1 ++= List('e', 'l', 'l', 'o')
val helloSet = b1.result()

// Arrays
val colors = Array("red", "green", "blue")
colors(0) = "purple"
colors
println("very purple: " + colors)
val files = new java.io.File(".").listFiles()
val scala = files map (_.getName) filter (_ endsWith "scala")

// Seq and Sequences
val inks = Seq('C', 'M', 'Y', 'K')

val hi = "Hello, " ++ "worldly" take 12 replaceAll ("w", "W")

// Streams
def inc(i: Int): Stream[Int] = Stream.cons(i, inc(i+1))
val s1 = inc(1)
val l2 = s1.take(5).toList

def inc1(head: Int): Stream[Int] = head #:: inc1(head + 1)
inc1(10).take(10).toList

def to(head: Char, end: Char): Stream[Char] = head > end match {
  case true => Stream.empty
  case false => head #:: to((head + 1).toChar, end)
}
val hexChars = to('A', 'F').take(20).toList

// Option Collections
val x: String = "Indeed"
val a = Option(x)
val y:String = null
val b2 = Option(y)

println(s"a is defined? ${a.isDefined}")
println(s"b2 is not defined? ${b2.isEmpty}")

def divide(amt: Double, divisor: Double): Option[Double] = {
  if (divisor == 0) None
  else Option(amt / divisor)
}
val legit = divide(5, 2)
val illegal = divide(3, 0)

val odds = List(1, 3, 5)
val firstOdd = odds.headOption
val evens = odds filter (_ % 2 == 0)
val firstEvens = evens.headOption

val words = List("risible", "scavenger", "gist")
val uppercase = words find (w => w == w.toUpperCase)
val lowercase = words find (w => w == w.toLowerCase)

val filtered = lowercase filter (_ endsWith "ible") map (_.toUpperCase)
val exactSize = filtered filter (_.size > 15) map (_.size)

def nextOption = if (util.Random.nextInt > 0) Some(1) else None
val ab = nextOption
val ba = nextOption

// Try Collections
// throw new Exception("No DB connection, exiting...")
// previous line throws exception:
// java.lang.Exception: No DB connection, exiting...
//   at #worksheet#.#worksheet#(worksheet.sc0.tmp:88)

def loopAndFail(end: Int, failAt: Int): Int = {
  for (i <- 1 to end) {
    println(s"$i) ")
    if (i == failAt) throw new Exception("too many iterations")
  }
  end
}
// loopAndFail(10, 3)
// this method call prints out first 3 values and then throws excetion
// 1)
// 2)
// 3)
//java.lang.Exception: too many iterations
//  at org.elu.learningscala.ch07.A$A50$A$A50$$anonfun$loopAndFail$1.apply$mcVI$sp(worksheet.sc0.tmp:96)
//  at scala.collection.immutable.Range.foreach$mVc$sp(worksheet.sc0.tmp:162)
//  at org.elu.learningscala.ch07.A$A50$A$A50.loopAndFail(worksheet.sc0.tmp:94)
//  at #worksheet#.#worksheet#(worksheet.sc0.tmp:100)

val t1 = util.Try(loopAndFail(2, 3))
val t2 = util.Try{ loopAndFail(4, 2) }

def nextError = util.Try{ 1 / util.Random.nextInt(2) }
val xy = nextError
val yx = nextError
val xx = nextError
val yy = nextError

val input = " 123 "
val result = util.Try(input.toInt) orElse util.Try(input.trim.toInt)
result foreach{ r => println(s"Parsed '$input' to $r!") }
val xxx = result match {
  case util.Success(x1) => Some(x1)
  case util.Failure(ex) =>
    println(s"Couldn't parse input '$input'")
    None
}
