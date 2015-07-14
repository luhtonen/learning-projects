package models

import org.squeryl.KeyedEntity
import org.squeryl.dsl.OneToMany

/** Created by luhtonen on 13/07/15. */
case class Warehouse(id: Long, name: String) extends KeyedEntity[Long] {
  lazy val stockItems: OneToMany[StockItem] = Database.warehouseToStockItems.left(this)
}
