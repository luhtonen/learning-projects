package controllers

import play.api.mvc._

class Application extends Controller {

  def index = Action {
    Ok(views.html.index("Hello world"))
  }

  def hello(name: String) = Action {
    Ok(views.html.index("Hello, " + name))
  }
}
