package models

import org.squeryl.KeyedEntity

/** Created by luhtonen on 13/07/15. */
case class Warehouse(id: Long, name: String) extends KeyedEntity[Long]
