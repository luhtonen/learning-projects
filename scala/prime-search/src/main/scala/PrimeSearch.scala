import scala.annotation.tailrec

/** Created by eduard.luhtonen on 12.08.2015. */
object PrimeSearch extends App {
  def search(limit: BigInt) = {
    println(s"searching for prime number between 1 and $limit")
  }

  MathExperiments.main()
}

object MathExperiments {
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

  def product2(ints: List[BigInt]): BigInt = {
    @tailrec
    def productAccumulator(ints: List[BigInt], accum: BigInt): BigInt = {
      ints match {
        case Nil => accum
        case x :: tail => productAccumulator(tail, accum * x)
      }
    }
    productAccumulator(ints, 1)
  }

  def product(xs: List[BigInt]): BigInt = {
    if (xs.isEmpty) 1
    else xs.head * product(xs.tail)
  }

  def max(ints: List[Int]): Int = {
    @tailrec
    def maxAccum(ints: List[Int], theMax: Int): Int = {
      ints match {
        case Nil => theMax
        case x :: tail =>
          val newMax = if (x > theMax) x else theMax
          maxAccum(tail, newMax)
      }
    }
    maxAccum(ints, 0)
  }

  def max2(ints: List[Int]): Int = {
    @tailrec
    def maxAccum2(ints: List[Int], theMax: Int): Int = {
      if (ints.isEmpty) {
        theMax
      } else {
        val newMax = if (ints.head > theMax) ints.head else theMax
        maxAccum2(ints.tail, newMax)
      }
    }
    maxAccum2(ints, 0)
  }

  def fibonacci(x: Int): BigInt = {
    @tailrec
    def fibHelper(x: Int, prev: BigInt = 0, next: BigInt = 1): BigInt = x match {
      case 0 => prev
      case 1 => next
      case _ => fibHelper(x - 1, next, next + prev)
    }
    fibHelper(x)
  }

  def factorial(n: Long): BigInt = {
    @tailrec
    def factorialAccum(acc: BigInt, n: Long): BigInt = {
      if (n == 0) acc
      else factorialAccum(n * acc, n - 1)
    }
    factorialAccum(1, n)
  }

  def main() = {
    println("sum of numbers between 1 and 100    = " + sum(List.range(1, 100)))
    println("sum of numbers between 1 and 15     = " + sum(List.range(1, 15)))
    println("sum of numbers between 1 and 1500   = " + sum(List.range(1, 1500)))
    println("sum2 of numbers between 1 and 1500  = " + sum2(List.range(1, 1500)))

    println("sum with List.sum = " + List.range(1, 100).sum)

    println("product2 of numbers between 1 and 10 = " + product2(List.range(1, 10)))
    println("product2 of numbers between 1 and 15 = " + product2(List.range(1, 15)))
    println("product of numbers between 1 and 15  = " + product(List.range(1, 15)))

    val maxList = List.range(1, 100000)
    println("max of numbers between 1 and 1000000  = " + max(maxList))
    println("max2 of numbers between 1 and 1000000 = " + max2(maxList))

    println("fibonacci number for base 9   = " + fibonacci(9))
    println("fibonacci number for base 19  = " + fibonacci(19))
    println("fibonacci number for base 90 = " + fibonacci(90))

    println("factorial for base 5 = " + factorial(5))
    println("factorial for base 15 = " + factorial(15))
  }
}
