package controllers

import akka.actor.{Actor, Props}
import akka.pattern.ask
import akka.util.Timeout
import play.api.Play.current
import play.api.libs.concurrent.Akka
import play.api.libs.iteratee.{Concurrent, Enumerator, Iteratee}
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller, WebSocket}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.language.postfixOps

/** Created by luhtonen on 21/07/15. */
class Chat extends Controller {

  implicit val timeout = Timeout(1 seconds)
  val room = Akka.system.actorOf(Props[ChatRoom])

  def showRoom(nick: String) = Action { implicit request =>
//    Ok(views.html.chat(s"Chat room for $nick", nick))
    Ok(views.html.chatroom(s"Chat room for $nick", nick))
  }

  def chatSocket(nick: String) = WebSocket.tryAccept { request =>
    val channelsFuture = room ? Join(nick)
    channelsFuture.mapTo[(Iteratee[String, _], Enumerator[String])].map(Right.apply)
  }
}

case class Join(nick: String)
case class Leave(nick: String)
case class Broadcast(message: String)

class ChatRoom extends Actor {
  var users = Set[String]()
  val (enumerator, channel) = Concurrent.broadcast[String]
  val systemUser = "system"

  def receive = {
    case Join(nick) =>
      if (!users.contains(nick)) {
        val iteratee = Iteratee.foreach[String]{ message =>
          self ! Broadcast(buildMessage(nick, message))
        }.map { _ =>
          self ! Leave(nick)
        }

        users += nick
        channel.push(buildMessage(systemUser, "User %s has joined the room, now %s users" format (nick, users.size)))
        sender ! (iteratee, enumerator)
      } else {
        val enumerator = Enumerator("Nickname %s is already in use." format nick)
        val iteratee = Iteratee.ignore
        sender ! (iteratee, enumerator)
      }
    case Leave(nick) =>
      users -= nick
      channel.push(buildMessage(systemUser, "User %s left the room, %s users left" format (nick, users.size)))
    case Broadcast(msg: String) => channel.push(msg)
  }

  def buildMessage(nick: String, message: String) = {
    Json.obj(
      "nick" -> nick,
      "message" -> message
    ).toString()
  }
}