/** Created by luhtonen on 09/02/16. */
object ComplexNumber {

  def main(args: Array[String]) {
    val c = new MyComplex(1.2, 3.4)
    println("imaginary part: " + c.im)
    println("result: " + c)
  }
}
