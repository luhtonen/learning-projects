package models

import org.squeryl.PrimitiveTypeMode._
import org.squeryl.Schema

/** Created by luhtonen on 13/07/15. */
object Database extends Schema {
  val productsTable = table[Product]("products")
  val stockItemsTable = table[StockItem]("stock_items")
  val warehousesTable = table[Warehouse]("warehouse")

  on(productsTable) { p => declare {
    p.id is autoIncremented
  }}

  on(stockItemsTable) { s => declare {
    s.id is autoIncremented
  }}

  on(warehousesTable) { w => declare {
    w.id is autoIncremented
  }}
}
