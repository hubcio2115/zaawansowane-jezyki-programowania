package Lab06

import org.apache.pekko.actor.{ Actor, ActorLogging, ActorSystem, Props }

class Player1 extends Actor, ActorLogging {
  def receive: Receive = { case msg =>
    log.info("Received message: {}", msg)
    sender() ! "pong"
  }
}

@main def runZad01(): Unit = {
  val system = ActorSystem("Game")
  val player1 = system.actorOf(Props[Player1](), "Player1")
  val player2 = system.actorOf(Props[Player1](), "Player2")

  player1.tell("pong", player2)
}
