/** Created by luhtonen on 09/02/16. */
class MyComplex(real: Double, imaginary: Double) {

  def re = real
  def im = imaginary
  override def toString = {
    "" + re + (if (im < 0) "" else "+") + im + "i"
  }
}
