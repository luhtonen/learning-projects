import concurrent.ExecutionContext.Implicits.global
import  concurrent.Future

def cityTemp(name: String): Double = {
  val url = "http://api.openweathermap.org/data/2.5/weather"
  val cityUrl = s"$url?q=$name&units=metric"
  val json = io.Source.fromURL(cityUrl).mkString.trim
  val pattern = """.*"temp":([\d.]+).*""".r
  val pattern(temp) = json
  temp.toDouble
}


val cityTemps = Future sequence Seq(
  Future(cityTemp("Zurich")), Future(cityTemp("Stäfa"))
)

cityTemps onSuccess { 
  case Seq(x,y) if x > y => println(s"Zurich is warmer: $x C")
  case Seq(x,y) if y > x => println(s"Stäfa is warmer: $y C")
}
