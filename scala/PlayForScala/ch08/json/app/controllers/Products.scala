package controllers

import models.Product
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}

/** Created by luhtonen on 16/07/15. */
class Products extends Controller {

  def list = Action {
    val productCodes = Product.findAll.map(_.ean)

    Ok(Json.toJson(productCodes))
  }
}
