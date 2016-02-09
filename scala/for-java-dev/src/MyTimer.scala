/** Created by luhtonen on 09/02/16. */
object MyTimer {
  def oncePerSecond(callback: () => Unit): Unit = {
    while(true) { callback(); Thread sleep 1000 }
  }

  def timeFlies(): Unit = {
    println("time flies like an arrow...")
  }

  def main(args: Array[String]) {
    oncePerSecond(timeFlies)
  }
}
