package Lab05

@main def runZad06(): Unit = {
  val scores = List(
    Score("Jan", "Kowalski", 8, 7),
    Score("Anna", "Nowak", 9, 6),
    Score("Jan", "Kowalski", 7, 8),
    Score("Maria", "Wiśniewska", 10, 9),
    Score("Anna", "Nowak", 8, 7)
  )

  val results = calculateResults(scores)

  results.foreach { case LeaderboardScore(place, name, final_score) =>
    println(s"$place. $name : $final_score")
  }
}

case class Score(name: String, surname: String, grace_score: Int, wit_score: Int)

case class LeaderboardScore(place: Int, name: String, final_score: Double)

def calculateResults(scores: List[Score]): List[LeaderboardScore] =
  scores
    .groupBy(score => s"${score.name} ${score.surname}")
    .map { case (name, scores) =>
      val final_scores = scores.foldLeft((0, 0))((acc, value) =>
        (acc._1 + value.grace_score, acc._2 + value.wit_score)
      )

      val final_grace_score = final_scores._1.toDouble / scores.length
      val final_wit_score = final_scores._2.toDouble / scores.length

      (name, (final_grace_score, final_wit_score))
    }
    .toList
    .sortWith { (a, b) =>
      val final_score_a = a._2._1 + a._2._2
      val final_score_b = b._2._1 + b._2._2

      if (final_score_a == final_score_b) {
        a._1 < b._1
      } else {
        final_score_a > final_score_b
      }
    }
    .zipWithIndex
    .map { case (value, index) =>
      LeaderboardScore(index + 1, value._1, value._2._1 + value._2._2)
    }
