// Classes
class User
val u = new User
val isAnyRef = u.isInstanceOf[AnyRef]

class User1 {
  val name: String = "Yubaba"
  def greet: String = s"Hello from $name"
  override def toString = s"User($name)"
}
val u1 = new User1
println(u1.greet)

class User2(n: String) {
  val name: String = n
  def greet: String = s"Hello from $name"
  override def toString = s"User($name)"
}
val u2 = new User2("Zeniba")
println(u2.greet)

class User3(val name: String) {
  def greet: String = s"Hello from $name"
  override def toString = s"User($name)"
}
val users = List(new User3("Shoto"), new User3("Art3mis"), new User3("Aesch"))
val sizes = users map (_.name.length)
val sorted = users sortBy (_.name)
val third = users find (_.name contains "3")
val greet = third map (_.greet) getOrElse "hi"

class A {
  def hi = "Hello from A"
  override def toString = getClass.getSimpleName
}
class B extends A
class C extends B {
  override def hi = "hi C -> " + super.hi
}
val hiA = new A().hi
val hiB = new B().hi
val hiC = new C().hi

val aa: A = new A
val ab: A = new B
//val ba: B = new A
// previous line causes following error
//<console>:9: error: type mismatch;
//  found   : A
//  required: B
//        val ba: B = new A
//                    ^
val bb: B = new B

val misc = List(new C, new A, new B)
val messages = misc.map(_.hi).distinct.sorted

// Defining Classes
// Defining a Class with Input Parameters
class Car(val make: String, var reserved: Boolean) {
  def reserve(r: Boolean): Unit = { reserved = r }
}
val t = new Car("Volvo", false)
t.reserve(true)
println(s"My ${t.make} is now reserved? ${t.reserved}")

val t2 = new Car(reserved = false, make = "Tesla")
println(t2.make)

class Lotus(val color: String, reserved: Boolean) extends Car("Lotus", reserved)
val l = new Lotus("Silver", false)
println(s"Requested a ${l.color} ${l.make}")

// Defining a Class with Input Parameters and Default Values
class Car1(val make: String, var reserved: Boolean = true,
            val year: Int = 2015) {
  override def toString = s"$year $make, reserved = $reserved"
}
val a1 = new Car1("Acura")
val l1 = new Car1("Lexus", year = 2010)
val p1 = new Car1(reserved = false, make = "Porsche")

// Defining a Class with Type Parameters
class Singular[A](element: A) extends Traversable[A] {
  def foreach[B](f: A => B) = f(element)
}
val p = new Singular("Planes")
p foreach println
val name: String = p.head
