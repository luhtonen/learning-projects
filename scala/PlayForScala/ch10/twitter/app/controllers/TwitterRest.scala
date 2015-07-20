package controllers

import javax.inject.Inject

import models.Tweet
import play.api.libs.ws.WSClient
import play.api.mvc._
import play.api.libs.json.Json
import utils.Twitter

import scala.concurrent.Await
import scala.concurrent.duration._

/** Created by 805515 on 20.07.2015. */
class TwitterRest @Inject() (ws: WSClient, twitter: Twitter) extends Controller {

  def blocking = Action { implicit request =>
    val count = 3
    val query = """paperclip OR "paper clip""""
    val bearerToken = Await.result(twitter.bearerToken, 10 seconds)

    val responseFuture = ws.url("https://api.twitter.com/1.1/search/tweets.json")
      .withQueryString("q" -> query, "count" -> count.toString)
      .withHeaders("Authorization" -> s"Bearer $bearerToken")
      .get()
    val response = Await.result(responseFuture, 10 seconds)
    val tweets = (Json.parse(response.body) \ "statuses").as[Seq[Tweet]]
    Ok(views.html.twitterrest.tweetlist(tweets))
  }
}
