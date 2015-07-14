package controllers

import javax.inject.Inject

import dao.ProductDAO
import models.Product
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc._
import scala.concurrent.ExecutionContext.Implicits.global

class Application @Inject()(productDAO: ProductDAO) extends Controller {

  def index = Action.async { implicit request =>
    productDAO.all.map {
      case products => Ok(views.html.index(products))
    }
  }

  val productForm = Form(
    mapping(
      "id" -> optional(longNumber),
      "ean" -> longNumber,
      "name" -> nonEmptyText,
      "description" -> optional(text)
    )(Product.apply)(Product.unapply)
  )

  def insert = Action.async { implicit request =>
    val product = productForm.bindFromRequest.get
    productDAO.insert(product).map(_ => Redirect(routes.Application.index))
  }

  def reset = Action { implicit request =>
    Redirect(routes.Application.index)
  }
}
