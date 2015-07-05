package models

import sorm._

/** Created by luhtonen on 05/07/15. */
object DB extends Instance(entities = Seq(Entity[Person]()), url = "jdbc:h2:mem:test")
