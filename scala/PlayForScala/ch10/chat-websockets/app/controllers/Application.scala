package controllers

import play.api.mvc._
import play.api.routing.JavaScriptReverseRouter

class Application extends Controller {

  def index = Action {
    Ok(views.html.index("Chat"))
  }

  def jsRoutes = Action { implicit request =>
    Ok(
      JavaScriptReverseRouter("jsRoutes")(
        routes.javascript.Chat.showRoom
      )
    ).as("text/javascript")
  }
}
