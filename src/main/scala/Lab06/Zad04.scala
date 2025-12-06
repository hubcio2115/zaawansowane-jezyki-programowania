package Lab06
import org.apache.pekko.actor.{ Actor, ActorLogging, ActorSystem, Props }

object Supervisor3 {
  case class StartGame(playerCount: Int)
}

class Supervisor3(val maxLoops: Int) extends Actor, ActorLogging {
  import Supervisor3.*
  import Player4.*

  private var counter = 0

  def receive: Receive = {
    case StartGame(playerCount) =>
      val players = 1 to playerCount map { i =>
        context.actorOf(Props[Player4](), s"Player$i")
      }

      log.info("Starting the game by sending Ping to Player1")
      players(0) ! Ping(1)

    case Pong(idx) =>
      log.info(s"Supervisor received Pong from Player$idx")
      val players = context.children.toList

      if (counter >= maxLoops * players.size) {
        log.info("Max loops reached, stopping the game.")
        context.system.terminate()
      } else {
        val next_idx = (idx % players.size) + 1
        counter += 1
        players(next_idx - 1) ! Ping(next_idx)
      }
  }
}

object Player4 {
  case class Ping(idx: Int)
  case class Pong(idx: Int)
}

class Player4 extends Actor, ActorLogging {
  import Player4.*

  def receive: Receive = { case Ping(idx) =>
    log.info(s"${self.path.name} received Ping from Player${idx - 1}")
    sender() ! Pong(idx)
  }
}

@main def runZad04(): Unit = {
  val system = ActorSystem("Game")
  val supervisor = system.actorOf(Props(classOf[Supervisor3], 5), "Supervisor")

  supervisor ! Supervisor3.StartGame(4)
}
