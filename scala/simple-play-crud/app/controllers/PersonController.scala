package controllers

import javax.inject._

import dal._
import play.api.data.Form
import play.api.data.Forms._
import play.api.data.validation.Constraints._
import play.api.i18n._
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

class PersonController @Inject() (repo: PersonRepository, val messagesApi: MessagesApi)
                                 (implicit ec: ExecutionContext) extends Controller with I18nSupport{

  /**
   * The mapping for the person form.
   */
  val personForm: Form[CreatePersonForm] = Form {
    mapping(
      "name" -> nonEmptyText,
      "age" -> number.verifying(min(0), max(140))
    )(CreatePersonForm.apply)(CreatePersonForm.unapply)
  }

  /**
   * The index action.
   */
  def index = Action {
    Ok(views.html.index(personForm))
  }

  /**
   * The add person action.
   *
   * This is asynchronous, since we're invoking the asynchronous methods on PersonRepository.
   */
  def addPerson = Action.async { implicit request =>
    // Bind the form first, then fold the result, passing a function to handle errors, and a function to handle succes.
    personForm.bindFromRequest.fold(
      // The error function. We return the index page with the error form, which will render the errors.
      // We also wrap the result in a successful future, since this action is synchronous, but we're required to return
      // a future because the person creation function returns a future.
      errorForm => {
        Future.successful(Ok(views.html.index(errorForm)))
      },
      // There were no errors in the from, so create the person.
      person => {
        repo.create(person.name, person.age).map { _ =>
          // If successful, we simply redirect to the index page.
          Redirect(routes.PersonController.index)
        }
      }
    )
  }

  /**
   * A REST endpoint that gets all the people as JSON.
   */
  def getPersons = Action.async {
  	repo.list().map { people =>
      Ok(Json.toJson(people))
    }
  }

  val ageFilterForm: Form[AgeFilterForm] = Form {
    mapping(
      "age" -> number.verifying(min(0), max(140))
    )(AgeFilterForm.apply)(AgeFilterForm.unapply)
  }

  def filter = Action {
    Ok(views.html.filter(ageFilterForm))
  }

  def setFilterAge = Action.async { implicit request =>
    ageFilterForm.bindFromRequest().fold(
      errorForm => {
        Future.successful(Ok(views.html.filter(errorForm)))
      },
      person => {
//        repo.findByAge(person.age).map { _ =>
//          Redirect(routes.PersonController.filter)
        repo.findByAge(person.age).map { people =>
          Ok(Json.toJson(people))
        }
      }
    )
  }

  def getPersonsByAge(age: Int) = Action.async {
    repo.findByAge(age).map { people =>
      Ok(Json.toJson(people))
    }
  }

  val personFilterForm: Form[PersonFilterForm] = Form {
    mapping(
      "id" -> longNumber()
    )(PersonFilterForm.apply)(PersonFilterForm.unapply)
  }

  def personFilter = Action {
    Ok(views.html.personfilter(personFilterForm))
  }

  def filterById = Action.async { implicit request =>
    personFilterForm.bindFromRequest().fold(
      errorForm => {
        Future.successful(Ok(views.html.personfilter(errorForm)))
      },
      person => {
        repo.findById(person.id).map { person =>
          Ok(Json.toJson(person))
        }
      }
    )
  }
}

/**
 * The create person form.
 *
 * Generally for forms, you should define separate objects to your models, since forms very often need to present data
 * in a different way to your models.  In this case, it doesn't make sense to have an id parameter in the form, since
 * that is generated once it's created.
 */
case class CreatePersonForm(name: String, age: Int)

case class AgeFilterForm(age: Int)

case class PersonFilterForm(id: Long)
