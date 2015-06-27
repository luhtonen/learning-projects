// Packages continues
// Import Alias
import collection.mutable.{Map=>MutMap}
val m1 = Map(1 -> 2)
val m2 = MutMap(2 -> 3)
m2.remove(2)
println(m2)

// Privacy Controls
class User {
  protected val passwd = util.Random.nextString(10)
}
class ValidUser extends User {
  def isValid = !passwd.isEmpty
}
val isValid = new ValidUser().isValid

class User1(private var password: String) {
  def update(p: String): Unit = {
    println("Modifying the password")
    password = p
  }
  def validate(p: String) = p == password
}
val u = new User1("1234")
val isValid1 = u.validate("4567")
u.update("4567")
val isValid2 = u.validate("4567")
