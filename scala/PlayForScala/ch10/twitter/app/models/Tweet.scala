package models

import play.api.libs.functional.syntax._
import play.api.libs.json.Reads._
import play.api.libs.json._

/** Created by eduard.luhtonen on 20.07.2015. */
case class Tweet(from: String, text: String)

object Tweet {
  implicit val tweetReads = (
    (JsPath \ "user" \ "name").read[String] and
      (JsPath \ "text").read[String]
    )(Tweet.apply _)
}