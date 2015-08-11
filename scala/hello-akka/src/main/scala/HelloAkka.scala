import akka.actor.{Props, ActorSystem, Actor}

/** Created by luhtonen on 11/08/15. */
class HelloActor extends Actor {
  def receive = {
    case "hello" => println("hello back at you")
    case _ => println("huh?")
  }
}

object HelloAkka extends App {
  val system = ActorSystem("AkkaHelloSystem")
  val helloActor = system.actorOf(Props[HelloActor], name = "helloActor")
  helloActor ! "hello"
  helloActor ! "buenos dias"

  system.shutdown()
}
