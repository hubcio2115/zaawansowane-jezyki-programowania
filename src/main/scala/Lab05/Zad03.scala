package Lab05

def score(code: Seq[Int])(move: Seq[Int]): (Int, Int) = {
  val blacks = code.zip(move).count { case (c, m) => c == m }

  val codeCounts = code.groupBy(identity).view.mapValues(_.size)
  val moveCounts = move.groupBy(identity).view.mapValues(_.size)

  val totalColorHits = codeCounts.foldLeft(0) { case (sum, (color, count)) =>
    sum + math.min(count, moveCounts.getOrElse(color, 0))
  }

  val whites = totalColorHits - blacks

  (blacks, whites)
}
