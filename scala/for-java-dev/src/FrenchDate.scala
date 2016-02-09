import java.text.DateFormat._
import java.util.{Locale, Date}

/** Created by luhtonen on 09/02/16. */
object FrenchDate {
  def main(args: Array[String]): Unit = {
    val now = new Date()
    val df = getDateInstance(LONG, Locale.FRANCE)
    println(df format now)
  }
}
