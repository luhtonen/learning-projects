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
