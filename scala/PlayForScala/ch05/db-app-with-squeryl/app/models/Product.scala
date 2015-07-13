package models

import org.squeryl.PrimitiveTypeMode._
import org.squeryl.{Query, KeyedEntity}

/** Created by luhtonen on 13/07/15. */
case class Product(id: Long, ean: Long, name: String, description: String) extends KeyedEntity[Long]

object Product {
  import Database.{productsTable, stockItemsTable}

  def allQ: Query[Product] = from(productsTable) {
    product => select(product) orderBy(product.name desc)
  }

  def findAll: Iterable[Product] = inTransaction {
    allQ.toList
  }

  def productsInWarehouse(warehouse: Warehouse) = {
    join(productsTable, stockItemsTable)((product, stockItem) =>
      where(stockItem.location === warehouse.id)
        .select(product)
        .on(stockItem.product === product.id)
    )
  }

  def productsInWarehouseByName(name: String, warehouse: Warehouse): Query[Product] = {
    from(productsInWarehouse(warehouse)) { product =>
      where(product.name like name).select(product)
    }
  }

  def insert(product: Product): Product = inTransaction {
    val defensiveCopy = product.copy()
    productsTable.insert(defensiveCopy)
  }

  def update(product: Product) {
    inTransaction { productsTable.update(product) }
  }
}