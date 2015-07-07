// Types
// Type Aliases
object TypeFun {
  type Whole = Int
  val x: Whole = 5

  type UserInfo = Tuple2[Int, String]
  val u: UserInfo = new UserInfo(123, "George")

  type T3[A,B,C] = (A, B, C) // sames as Tuple3[A,B,C]
  val things = new T3(1, 'a', true)
}
val x = TypeFun.x
val u = TypeFun.u
val things = TypeFun.things

// Abstract Types
class User(val name: String)
trait Factory { type A; def create: A }
trait UserFactory extends Factory {
  type A = User
  def create = new User("")
}

trait Factory2[A] { def create: A }
trait UserFactory2 extends Factory2[User] {
  def create = new User("")
}

// Bounded Types
class BaseUser(val name: String)
class Admin(name: String, val level: String) extends BaseUser(name)
class Customer(name: String) extends BaseUser(name)
class PreferredCustomer(name: String) extends Customer(name)
def check[A <: BaseUser](u: A) {
  if (u.name.isEmpty) println("Fail!")
}
check(new Customer("Fred"))
check(new Admin("", "strict"))

def recruit[A >: Customer](u: Customer): A = u match {
  case p: PreferredCustomer => new PreferredCustomer(u.name)
  case c: Customer => new Customer(u.name)
}
val customer = recruit(new Customer("Fred"))
val preferredCustomer = recruit(new PreferredCustomer("George"))

abstract class Card {
  type UserType <: BaseUser
  def verify(u: UserType): Boolean
}
class SecurityCard extends Card {
  type UserType = Admin
  def verify(u: Admin) = true
}
val v1 = new SecurityCard().verify(new Admin("George", "high"))

class GiftCard extends Card {
  type UserType = Customer
  def verify(u: Customer) = true
}
val v2 = new GiftCard().verify(new Customer("Fred"))

// Type Variance
class Car { override def toString = "Car()" }
class Volvo extends Car { override def toString = "Volvo()" }
val c: Car = new Volvo()

case class Item[A](a: A) { def get: A = a }
// val c: Item[Car] = new Item[Volvo](new Volvo)
// this line causes following error
// <console>:14: error: type mismatch;
//  found   : Item[Volvo]
//  required: Item[Car]
// Note: Volvo <: Car, but class Item is invariant in type A.
// You may wish to define A as +A instead. (SLS 4.5)
//        val c: Item[Car] = new Item[Volvo](new Volvo)
//                           ^

case class Item2[+A](a: A) { def get: A = a }
val c1: Item2[Car] = new Item2[Volvo](new Volvo)
val auto = c1.get

//  class Check[+A] { def check(a: A) = {} }
// this causes following error
// <console>:10: error: covariant type A occurs in contravariant position in type A of value a
//        class Check[+A] { def check(a: A) = {} }
//                                    ^

class Check[-A] { def check(a: A) = {} }

class Car1; class Volvo1 extends Car1; class VolvoWagon1 extends Volvo1
class Item1[+A](a: A) { def get: A = a }
class Check1[-A] { def check(a: A) = {} }
def item(v: Item1[Volvo1]) { val c: Car1 = v.get }
def check(v: Check1[Volvo1]) { v.check(new VolvoWagon1()) }
// item(new Item1[Car1](new Car1()))
// <console>:15: error: type mismatch;
//  found   : Item1[Car1]
//  required: Item1[Volvo1]
//        item(new Item1[Car1](new Car1()))
//             ^
item(new Item1[Volvo1](new Volvo1()))
item(new Item1[VolvoWagon1](new VolvoWagon1()))
check(new Check1[Car1])
check(new Check1[Volvo1])
//check(new Check1[VolvoWagon1])
// <console>:16: error: type mismatch;
//  found   : Check1[VolvoWagon1]
//  required: Check1[Volvo1]
//        check(new Check1[VolvoWagon1])
//              ^
