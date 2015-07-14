package controllers

import models.Database._
import models.{Product, StockItem}
import org.squeryl.PrimitiveTypeMode.transaction
import play.api.mvc.Controller

/** Created by luhtonen on 14/07/15. */
class Products extends Controller {

  def addNewProductGood(product: Product, stockItem: StockItem): Unit = {
    transaction {
      productsTable.insert(product)
      stockItemsTable.insert(stockItem)
    }
  }

  def addNewProductBad(product: Product, stockItem: StockItem): Unit = {
    productsTable.insert(product)
    stockItemsTable.insert(stockItem)
  }
}
