package dao

import javax.inject.Inject

import models.Product
import play.api.db.slick.{HasDatabaseConfigProvider, DatabaseConfigProvider}
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import slick.driver.JdbcProfile

import scala.concurrent.Future

/** Created by eduard.luhtonen on 14.07.2015. */
class ProductDAO @Inject()(protected val dbConfigProvider: DatabaseConfigProvider) extends HasDatabaseConfigProvider[JdbcProfile] {
  import driver.api._

  private val Products = TableQuery[ProductsTable]

  def all: Future[Seq[Product]] = db.run(Products.result)

  def insert(product: Product): Future[Unit] = db.run(Products += product).map {_ => ()}

  private class ProductsTable(tag: Tag) extends Table[Product](tag, "PRODUCTS") {
    def id = column[Long]("id", O.PrimaryKey)
    def ean = column[Long]("ean")
    def name = column[String]("name")
    def description = column[String]("description")
    def * = (id.?, ean, name, description.?) <> (Product.tupled, Product.unapply)
  }
}
