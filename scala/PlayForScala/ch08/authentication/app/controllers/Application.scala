package controllers

import play.api.mvc._

class Application extends Controller {

  def index = AuthenticatedAction { request =>
    Ok("Authenticated response...")
  }

  def authenticate(request: Request[AnyContent]) = true

  def AuthenticatedAction(f: Request[AnyContent] => Result): Action[AnyContent] = {

    Action { request =>
      if (authenticate(request)) {
        f(request)
      } else {
        Unauthorized
      }
    }
  }
}
