import akka.actor.{Props, ActorSystem, ActorLogging, Actor}

/** Created by luhtonen on 10/08/15. */
case object Pint

class Person extends Actor with ActorLogging {
  def receive = {
    case Pint => log.info("Thanks for the pint")
  }
}

object HowdyAkka extends App {
  val system = ActorSystem("howdy-akka")

  val alice = system.actorOf(Props(new Person()), "alice")

  alice ! Pint

  system.shutdown()
}
