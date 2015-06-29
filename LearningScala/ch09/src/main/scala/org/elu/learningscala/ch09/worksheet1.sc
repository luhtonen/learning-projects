// Objects
object Hello {
  println("ih Hello")
  def hi = "hi"
}
println(Hello.hi)
println(Hello.hi)

object HtmlUtils {
  def removeMarkup(input: String) = {
    input
    .replaceAll("""</?\w[^>]*>""", "")
    .replaceAll("<.*>", "")
  }
}
val html = "<html><body><h1>Introduction</h1></body></html>"
val text = HtmlUtils.removeMarkup(html)

// Apply Methods and Companion Objects
class Multiplier(val x: Int) {
  def product(y: Int) = x * y
}
object Multiplier {
  def apply(x: Int) = new Multiplier(x)
}
val tripler = Multiplier(3)
val result = tripler.product(13)

object DBConnection {
  private val db_url = "jdbc:localhost"
  private val db_user = "franken"
  private val db_pass = "berry"

  def apply() = new DBConnection()
}
class DBConnection {
  private val props = Map(
    "url" -> DBConnection.db_url,
    "user" -> DBConnection.db_user,
    "pass" -> DBConnection.db_pass
  )
  println("Created new connection for " + props("url"))
}
val conn = DBConnection()
