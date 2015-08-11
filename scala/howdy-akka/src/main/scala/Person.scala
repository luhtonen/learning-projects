import akka.actor.{ActorLogging, Actor}

/** Created by luhtonen on 11/08/15. */
class Person extends Actor with ActorLogging {
  def receive = {
    case FullPint(number) =>
      log.info("I'll make short work of this")

      Thread.sleep(1000)

      log.info(s"Done, here is empty glass for pint $number")

      sender ! EmptyPint(number)
  }
}
