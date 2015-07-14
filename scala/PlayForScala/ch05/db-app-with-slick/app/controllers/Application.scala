package controllers

import javax.inject.Inject

import dao.ProductDAO
import play.api.mvc._

class Application @Inject()(productDAO: ProductDAO) extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

}
