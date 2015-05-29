package controllers

import play.api.mvc._

/** Created by luhtonen on 29/05/15. */
object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

}
