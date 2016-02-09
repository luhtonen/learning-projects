/** Created by luhtonen on 09/02/16. */
class MyDate(y: Int, m: Int, d: Int) extends Ord {
  def year = y
  def month = m
  def day = d

  override def toString: String = year + "-" + month + "-" + day

  override def equals(that: Any): Boolean = {
    that.isInstanceOf[MyDate] && {
      val o = that.asInstanceOf[MyDate]
      o.day == day && o.month == month && o.year == year
    }
  }

  def <(that: Any): Boolean = {
    if (!that.isInstanceOf[MyDate]) {
      sys.error("cannot compare " + that + " and a Date")
    }

    val o = that.asInstanceOf[MyDate]
    (year < o.year) ||
      (year == o.year && (month < o.month ||
        month == o.month && day < o.day))
  }
}
