package controllers

import javax.inject.Inject

import models.Product
import play.api.data.Form
import play.api.data.Forms.{mapping, longNumber, nonEmptyText}
import play.api.mvc.{Flash, Controller, Action}
import play.api.i18n.{MessagesApi, I18nSupport}

/** Created by eduard.luhtonen on 08.07.2015. */
class Products @Inject() (val messagesApi: MessagesApi) extends Controller with I18nSupport {

  private val productForm: Form[Product] = Form(
    mapping(
      "ean" -> longNumber.verifying(
        "validation.ean.duplicate", Product.findByEan(_).isEmpty
      ),
      "name" -> nonEmptyText,
      "description" -> nonEmptyText
    )(Product.apply)(Product.unapply)
  )

  def list = Action { implicit request =>
    val products = Product.findAll
    Ok(views.html.products.list(products))
  }

  def show(ean: Long) = Action { implicit request =>
    Product.findByEan(ean).map { product =>
      Ok(views.html.products.details(product))
    }.getOrElse(NotFound)
  }

  def save = Action { implicit request =>
    val newProductForm = productForm.bindFromRequest()

    newProductForm.fold(
      hasErrors = { form =>
        Redirect(routes.Products.newProduct())
          .flashing(Flash(form.data) + ("error" -> messagesApi("validation.errors")))
      },
      success = { newProduct =>
        Product.add(newProduct)
        val message = messagesApi("products.new.success", newProduct.name)
        Redirect(routes.Products.show(newProduct.ean)).flashing("success" -> message)
      }
    )
  }

  def newProduct = Action { implicit request =>
    val form = if (request2flash.get("error").isDefined)
      productForm.bind(request2flash.data)
    else
      productForm

    Ok(views.html.products.editProduct(form))
  }
}
