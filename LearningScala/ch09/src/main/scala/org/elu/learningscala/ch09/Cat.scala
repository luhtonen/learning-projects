package org.elu.learningscala.ch09

/** Created by luhtonen on 29/06/15. */
object Cat {
  def main(args: Array[String]): Unit = {
    for (arg <- args) {
      println(io.Source.fromFile(arg).mkString)
    }
  }
}
