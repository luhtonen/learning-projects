package models

import org.squeryl.PrimitiveTypeMode._
import org.squeryl.Schema

/** Created by luhtonen on 13/07/15. */
object Database extends Schema {
  val productsTable = table[Product]("products")
  val stockItemsTable = table[StockItem]("stock_items")
  val warehousesTable = table[Warehouse]("warehouse")

  val productToStockItems = oneToManyRelation(productsTable, stockItemsTable)
    .via((p, s) => p.id === s.product)

  val warehouseToStockItems = oneToManyRelation(warehousesTable, stockItemsTable)
    .via((w, s) => w.id === s.location)

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
