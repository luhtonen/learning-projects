

/** Created by luhtonen on 09/02/16. */
object MyTimerAnonymous {

  def oncePerSecond(callback: () => Unit): Unit = {
    while (true) { callback(); Thread sleep 1000 }
  }

  def main(args: Array[String]) {
    oncePerSecond(() => {
      println("time flies like an arrow...")
    })
  }
}
