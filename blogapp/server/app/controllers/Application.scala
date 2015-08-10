package controllers

import javax.inject.Inject

import models.User
import models.database.Database
import play.api.data.Form
import play.api.data.Forms._
import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

class Application @Inject()(database: Database, val messagesApi: MessagesApi)
                           (implicit ec: ExecutionContext) extends Controller with I18nSupport {

  def index = Action {
    Ok("Your new application is ready.")
  }

  val signUpForm = Form {
    mapping(
      "email" -> email,
      "password" -> nonEmptyText
    )((email, password) => User(None, email, password))((user: User) => Some(user.email, user.password))
  }

  val loginForm = Form {
    mapping(
      "email" -> email,
      "password" -> nonEmptyText
    )(LoginForm.apply)(LoginForm.unapply)
  }

  def signup = Action.async { implicit request =>
    signUpForm.bindFromRequest.fold(
      errorForm => {
        Future.successful(BadRequest(errorForm.errorsAsJson))
      },
      user => {
        database.findUserByEmail(user.email).map { users =>
          println("### found users " + users)
          if (users.nonEmpty) {
            Ok(Json.toJson(Map("error" -> s"User with email $user.email already exists.")))
          }
        }
        database.insert(user).map {_ =>
          Ok(Json.toJson(Map("success" -> "User created successfully.")))
        }
      }
    )
  }

  def login = Action.async { implicit request =>
    loginForm.bindFromRequest.fold(
      errorForm => {
        Future.successful(BadRequest(errorForm.errorsAsJson))
      },
      user => {
        database.findUserByEmailAndPassword(user.email, user.password).map { users =>
          if (users.isEmpty) {
            Ok(Json.toJson(Map("error" -> "Incorrect email or password")))
          } else {
            val msg = Json.obj(
              "success" -> Json.obj("message" -> "Logged in successfully", "user" -> user.email)
            )
            Ok(msg).withSession("username" -> user.email)
          }
        }
      }
    )
  }

  def logout = Action.async { implicit request =>
    Future.successful(Ok(Json.toJson(Map("success" -> "Logged out successfully.")))
      .withSession(request.session - "username"))
  }

  def isAuthenticated = Action.async{ implicit request =>
    if(request.session.get("username") == null) {
      Future.successful(Unauthorized)
    } else {
      val msg = Json.obj("success" -> Json.obj(
        "message" -> "User is logged in already",
        "user" -> request.session.get("username")
      ))
      Future.successful(Ok(msg))
    }
  }

  trait UserForm {
    def email: String
  }
  case class SignUpForm(email: String, password: String) extends UserForm
  case class LoginForm(email: String, password: String) extends UserForm
}
