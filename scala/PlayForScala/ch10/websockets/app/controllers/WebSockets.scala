package controllers

import java.lang.management.ManagementFactory

import scala.concurrent.duration._

import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.libs.concurrent.Promise
import play.api.libs.iteratee.{Enumerator, Iteratee}
import play.api.mvc.{WebSocket, Action, Controller}

import scala.language.postfixOps

/** Created by 805515 on 21.07.2015. */
class WebSockets extends Controller {

  def statusPage = Action { request =>
    Ok(views.html.websockets.status(request))
  }

  def statusFeed = WebSocket.using[String] { implicit request =>
    def getLoadAverage = {
      "%1.2f" format ManagementFactory.getOperatingSystemMXBean.getSystemLoadAverage
    }
    val in = Iteratee.ignore[String]
    val out = Enumerator.repeatM {
      Promise.timeout(getLoadAverage, 3 seconds)
    }
    (in, out)
  }
}
