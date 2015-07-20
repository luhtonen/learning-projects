package utils

import javax.inject.Inject

import play.api.Configuration
import play.api.libs.ws.{WSResponse, WSAuthScheme, WSClient}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/** Created by 805515 on 20.07.2015. */
class Twitter @Inject() (ws: WSClient, config: Configuration) {

  lazy val bearerToken: Future[String] = {
    require(config.getString("twitter.consumer.key").isDefined)
    require(config.getString("twitter.consumer.secret").isDefined)

    ws.url("https://api.twitter.com/oauth2/token")
      .withAuth(config.getString("twitter.consumer.key").get, config.getString("twitter.consumer.secret").get, WSAuthScheme.BASIC)
      .post(Map("grant_type" ->  Seq("client_credentials")))
      .withFilter(response => (response.json \ "token_type").asOpt[String].contains("bearer"))
      .map(response => (response.json \ "access_token").as[String])
  }

  def fetchTweets(bearerToken: String, query: String, count: Int = 15): Future[WSResponse] = {
    ws.url("https://api.twitter.com/1.1/search/tweets.json")
      .withQueryString("q" -> query, "count" -> count.toString)
      .withHeaders("Authorization" -> s"Bearer $bearerToken")
      .get()
  }
}
