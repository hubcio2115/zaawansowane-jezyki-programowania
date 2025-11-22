package Lab05

import scala.io.Source
import scala.util.Using

@main def runZad04(): Unit = {
  val bookText = Using(Source.fromURL(getClass.getResource("/ogniem-i-mieczem.txt"))) { source =>
    source.mkString
  }.getOrElse("File not found!")

  val histo = histogram(bookText, 100)
  println(histo)
}

def histogram(input: String, max: Int): String = {
  val histo = input.trim
    .filter(_.isLetter)
    .groupBy(char => char.toLower)
    .toSeq
    .sortBy(_._1)
    .foldLeft("")((acc, value) => acc + s"${value._1}: ${"*" * value._2.length.min(max)}\n")

  histo
}
