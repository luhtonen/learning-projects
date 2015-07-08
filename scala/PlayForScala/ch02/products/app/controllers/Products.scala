package controllers

import javax.inject.Inject

import models.Product
import play.api.mvc.{Controller, Action}
import play.api.i18n.{MessagesApi, I18nSupport}

/** Created by eduard.luhtonen on 08.07.2015. */
class Products @Inject() (val messagesApi: MessagesApi) extends Controller with I18nSupport {
  def list = Action {implicit request =>
    val products = Product.findAll
    Ok(views.html.products.list(products))
  }
}
