package controllers

import play.api.mvc._

/** Created by luhtonen on 06/08/15. */
trait Secured {

  def username(request: RequestHeader) = request.session.get(Security.username)

  def onUnauthorized(request: RequestHeader) = Results.Redirect(routes.Application.index)

  def withAuth(f: => String => Request[AnyContent] => Result) = {
    Security.Authenticated(username, onUnauthorized) { user =>
      Action(request => f(user)(request))
    }
  }
}
