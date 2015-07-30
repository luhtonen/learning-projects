package controllers

import javax.inject.Inject

import models.database.Database
import play.api.data.Form
import play.api.data.Forms._
import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

class Application @Inject()(val database: Database, val messagesApi: MessagesApi)
                           (implicit ec: ExecutionContext) extends Controller with I18nSupport {

  def index = Action {
    Ok("Your new application is ready.")
  }

  val signUpForm: Form[SignUpForm] = Form {
    mapping(
      "email" -> email,
      "password" -> nonEmptyText
    )(SignUpForm.apply)(SignUpForm.unapply)
  }

  def signup = Action.async { implicit request =>
    signUpForm.bindFromRequest.fold(
      errorForm => {
        Future.successful(BadRequest(errorForm.errorsAsJson))
      },
      user => {
        database.findUserByEmail(user.email).map { users =>
          if (users.nonEmpty) { Ok(Json.toJson(Map("error" -> s"User with email $user.email already exists."))) }
        }
        database.create(user.email, user.password).map {_ =>
          Ok(Json.toJson(Map("success" -> "User created successfully.")))
        }
      }
    )
  }

  trait UserForm {
    def email: String
  }
  case class SignUpForm(email: String, password: String) extends UserForm
}
