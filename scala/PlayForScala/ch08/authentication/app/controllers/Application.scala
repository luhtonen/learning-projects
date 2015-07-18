package controllers

import play.api.mvc._

class Application extends Controller {

  def index = AuthenticatedAction { request =>
    Ok("Authenticated response...")
  }

  def authenticate(request: Request[AnyContent]) = true

  def authenticate(user: String, password: String) = true

  def AuthenticatedAction(f: Request[AnyContent] => Result): Action[AnyContent] = {

    Action { request =>
      val maybeCredentials = readQueryString(request)

      maybeCredentials.map {
        case Left(errorResult) => errorResult
        case Right(credentials) =>
          val (user, password) = credentials
          if (authenticate(user, password)) {
            f(request)
          } else {
            Unauthorized("Invalid user name or password")
          }
      }.getOrElse{
        Unauthorized("No user name and password provided")
      }
    }
  }

  def readQueryString(request: Request[_]): Option[Either[Result, (String, String)]] = {
    request.queryString.get("user").map { user =>
      request.queryString.get("password").map { password =>
        Right((user.head, password.head))
      }.getOrElse {
        Left(BadRequest("Password not specified"))
      }
    }
  }
}
