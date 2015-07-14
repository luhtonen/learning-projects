package models

import org.squeryl.KeyedEntity
import org.squeryl.dsl.ManyToOne

/** Created by luhtonen on 13/07/15. */
case class StockItem(id: Long, product: Long, location: Long, quatity: Long) extends KeyedEntity[Long] {
  lazy val product: ManyToOne[Product] = Database.productToStockItems.right(this)
  lazy val warehouse: ManyToOne[Warehouse] = Database.warehouseToStockItems.rigth(this)
}
