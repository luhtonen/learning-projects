package models

import play.api.libs.json.Json

/** Created by luhtonen on 05/07/15. */
case class Person(name: String)

object Person {

  implicit val personFormat = Json.format[Person]
}
