package controllers

import play.api.mvc._
import play.mvc.Http

class Application extends Controller {

  def index = AuthenticatedAction { request =>
    Ok("Authenticated response...")
  }

  def authenticate(request: Request[AnyContent]) = true

  def authenticate(user: String, password: String) = true

  def AuthenticatedAction(f: Request[AnyContent] => Result): Action[AnyContent] = {

    Action { request =>
      val maybeCredentials = readQueryString(request) orElse
        readBasicAuthentication(request.headers)

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

  def readBasicAuthentication(headers: Headers): Option[Either[Result, (String, String)]] = {
    headers.get(Http.HeaderNames.AUTHORIZATION).map { header =>
      val BasicHeader = "Basic (.*)".r
      header match {
        case BasicHeader(base64) => {
          try {
            import org.apache.commons.codec.binary.Base64
            val decodedBytes = Base64.decodeBase64(base64.getBytes)
            val credentials = new String(decodedBytes).split(":", 2)
            credentials match {
              case Array(username, password) => Right(username -> password)
              case _ => Left(BadRequest("Invalid basic authentication"))
            }
          }
        }
        case _ => Left(BadRequest("Bad Authorization header"))
      }
    }
  }
}
