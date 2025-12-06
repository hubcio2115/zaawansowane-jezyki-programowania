package Lab06

import org.apache.pekko.actor.{ Actor, ActorLogging, ActorSystem, Props }

object Supervisor {
  case class StartGame()
}

class Supervisor extends Actor, ActorLogging {
  import Supervisor.*

  def receive: Receive = {
    case StartGame() =>
      val player = context.actorOf(Props[Player2](), "Player1")
      context.actorOf(Props[Player2](), "Player2")
      context.actorOf(Props[Player2](), "Player3")

      log.info("Starting the game by sending Ping to Player1")
      player ! Player2.Ping("Supervisor")

    case Player2.Pong("Player1") =>
      log.info("Supervisor received Pong from Player1")
      val player = context.actorSelection("/user/Supervisor/Player2")
      player ! Player2.Ping("Player2")

    case Player2.Pong("Player2") =>
      log.info("Supervisor received Pong from Player2")
      val player = context.actorSelection("/user/Supervisor/Player3")
      player ! Player2.Ping("Player3")

    case Player2.Pong("Player3") =>
      log.info("Supervisor received Pong from Player3")
      val player = context.actorSelection("/user/Supervisor/Player1")
      player ! Player2.Ping("Player1")
  }
}

object Player2 {
  case class Ping(name: String)
  case class Pong(name: String)
}

class Player2 extends Actor, ActorLogging {
  import Player2.*

  def receive: Receive = {
    case Ping("Player1") | Ping("Supervisor") =>
      log.info("{} received Ping from Player3", self.path.name)
      sender() ! Pong("Player1")

    case Ping("Player2") =>
      log.info("{} received Ping from Player1", self.path.name)
      sender() ! Pong("Player2")

    case Ping("Player3") =>
      log.info("{} received Ping from Player2", self.path.name)
      sender() ! Pong("Player3")
  }
}

@main def runZad02(): Unit = {
  val system = ActorSystem("Game")
  val supervisor = system.actorOf(Props[Supervisor](), "Supervisor")

  supervisor ! Supervisor.StartGame()
}
