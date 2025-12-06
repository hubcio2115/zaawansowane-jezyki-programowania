package Lab06
import org.apache.pekko.actor.{ Actor, ActorLogging, ActorSystem, Props }

object Supervisor2 {
  case class StartGame(playerCount: Int)
}

class Supervisor2 extends Actor, ActorLogging {
  import Supervisor2.*
  import Player3.*

  def receive: Receive = {
    case StartGame(playerCount) =>
      val players = 1 to playerCount map { i =>
        context.actorOf(Props[Player3](), s"Player$i")
      }

      log.info("Starting the game by sending Ping to Player1")
      players(0) ! Ping(1)

    case Pong(idx) =>
      log.info(s"Supervisor received Pong from Player$idx")
      val players = context.children.toList

      val next_idx = (idx % players.size) + 1
      players(next_idx - 1) ! Ping(next_idx)
  }
}

object Player3 {
  case class Ping(idx: Int)
  case class Pong(idx: Int)
}

class Player3 extends Actor, ActorLogging {
  import Player3.*

  def receive: Receive = { case Ping(idx) =>
    log.info(s"${self.path.name} received Ping from Player${idx - 1}")
    sender() ! Pong(idx)
  }
}

@main def runZad03(): Unit = {
  val system = ActorSystem("Game")
  val supervisor = system.actorOf(Props[Supervisor2](), "Supervisor")

  supervisor ! Supervisor2.StartGame(4)
}
