import java.math.BigInteger

import scala.annotation.tailrec

/** Created by eduard.luhtonen on 12.08.2015. */
object PrimeSearch extends App {
  def search(limit: BigInteger) = {
    println(s"searching for prime number between 1 and $limit")
  }

  def sum2(ints: List[Int]): Int = {
    @tailrec
    def sumAccumulator(ints: List[Int], accum: Int): Int = {
      ints match {
        case Nil => accum
        case x :: tail => sumAccumulator(tail, accum + x)
      }
    }
    sumAccumulator(ints, 0)
  }

  def sum(xs: List[Int]): Int = {
    if(xs.isEmpty) 0
    else xs.head + sum(xs.tail)
  }

  println("sum of number between 1 and 100  = " + sum(List.range(1, 100)))
  println("sum of number between 1 and 15   = " + sum(List.range(1, 15)))
  println("sum of number between 1 and 1500 = " + sum(List.range(1, 1500)))

  println("sum with List.sum = " + List.range(1, 100).sum)
}
