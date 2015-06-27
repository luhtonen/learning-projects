// More Field and Method Types
// Overloaded Methods
class Printer(msg: String) {
  def print(s: String): Unit = println(s"$msg: $s")
  def print(l: Seq[String]): Unit = print(l.mkString(", "))
}
new Printer("Today's Report").print("Foggy" :: "Rainy" :: "Hot" :: Nil)

// Apply Methods
class Multiplier(factor: Int) {
  def apply(input: Int) = input * factor
}
val tripleMe = new Multiplier(3)
val tripled = tripleMe.apply(10)
val tripled2 = tripleMe(10)

val l = List('a', 'b', 'c')
val character = l(1)
val character2 = l.apply(2)

// Lazy Values
class RandomPoint {
  val x = { println("creating x"); util.Random.nextInt() }
  lazy val y = { println("now y"); util.Random.nextInt() }
}
val p = new RandomPoint
println(s"Location is ${p.x}, ${p.y}")
println(s"Location is ${p.x}, ${p.y}")
