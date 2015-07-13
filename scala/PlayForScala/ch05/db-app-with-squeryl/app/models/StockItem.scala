package models

import org.squeryl.KeyedEntity

/** Created by luhtonen on 13/07/15. */
case class StockItem(id: Long, product: Long, location: Long, quatity: Long) extends KeyedEntity[Long]
