package Lab06
import org.apache.pekko.actor.{ Actor, ActorLogging, ActorRef, ActorSystem, Props, Terminated }

object Supervisor4 {
  case class StartGame(playerCount: Int)
}

class Supervisor4 extends Actor, ActorLogging {
  import Supervisor4.*
  import Player5.*

  var players: List[Option[ActorRef]] = List()

  def receive: Receive = {
    case StartGame(playerCount) =>
      val players = 1 to playerCount map { i =>
        Some(
          context.actorOf(
            Props(classOf[Player5], Math.floor(Math.random() * 5).toInt + 1),
            s"Player$i"
          )
        )
      }

      this.players = players.toList

      log.info("Starting the game by sending Ping to Player1")
      players(0).get ! Ping(1)

    case Pong(idx, shouldDie) =>
      players = players.zipWithIndex
        .map {
          case (Some(p), p_idx) if p_idx == idx && shouldDie => None
          case other                                         => other._1
        }
        .filter(p => p.isDefined)

      if (players.size == 1) {
        log.info(s"Player${players.head.get.path.name} is the last player standing! Game over.")
        context.system.terminate()
      } else {
        log.info(s"Supervisor received Pong from ${sender().path.name}")
        val next_idx = (idx + 1) % players.size
        players(next_idx).get ! Ping(next_idx)
      }

  }
}

object Player5 {
  case class Ping(idx: Int)
  case class Pong(idx: Int, shouldDie: Boolean)
}

class Player5(var maxHits: Int) extends Actor, ActorLogging {
  import Player5.*

  private var counter = 0

  def receive: Receive = { case Ping(idx) =>
    log.info(s"${self.path.name} received Ping from Player${sender().path.name}")

    counter += 1
    if (counter >= maxHits) {
      log.info(s"${self.path.name} reached max hits ($maxHits) and will stop.")
      context.stop(self)

      sender() ! Pong(idx, true)
    } else {
      sender() ! Pong(idx, false)
    }

  }
}

@main def runZad05(): Unit = {
  val system = ActorSystem("Game")
  val supervisor = system.actorOf(Props[Supervisor4](), "Supervisor")

  supervisor ! Supervisor4.StartGame(4)
}
