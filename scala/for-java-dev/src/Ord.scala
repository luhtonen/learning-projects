/** Created by luhtonen on 09/02/16. */
trait Ord {
  def < (that: Any) : Boolean
  def <= (that: Any): Boolean = (this < that) || (this == that)
  def > (that: Any) : Boolean = !(this <= that)
  def >= (that: Any): Boolean = !(this < that)
}
