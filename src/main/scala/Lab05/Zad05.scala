package Lab05

import scala.io.Source
import scala.util.Using

@main def runZad05(): Unit = {
  val scores = Using(Source.fromURL(getClass.getResource("/wyniki.csv"))) { source =>
    source.mkString
  }.getOrElse("File not found!")

  val voivodeships = List(
    Voivodeship("dolnośląskie", 20_000),
    Voivodeship("kujawsko-pomorskie", 40_000),
    Voivodeship("lubelskie", 60_000),
    Voivodeship("lubuskie", 80_000),
    Voivodeship("łódzkie", 100_000),
    Voivodeship("małopolskie", 120_000),
    Voivodeship("mazowieckie", 140_000),
    Voivodeship("opolskie", 160_000),
    Voivodeship("podkarpackie", 180_000),
    Voivodeship("podlaskie", 200_000),
    Voivodeship("pomorskie", 220_000),
    Voivodeship("śląskie", 240_000),
    Voivodeship("świętokrzyskie", 260_000),
    Voivodeship("warmińsko-mazurskie", 280_000),
    Voivodeship("wielkopolskie", 300_000),
    Voivodeship("zachodniopomorskie", 320_000)
  )

  val results = io.Source
    .fromResource("wyniki.csv")
    .getLines
    .toList
    .map { l =>
      l.split(",").toList.map(_.toInt) match {
        case List(a, b, c, d, e, f, g, h, i, j, k) => Result(a, b, c, d, e, f, g, h, i, j, k)
        case _                                     => throw new IllegalArgumentException
      }
    }

  val results_per_voivodeship = results.groupBy { voivodeship =>
    if (voivodeship.ID > 320_000) "zachodniopomorskie"
    else if (voivodeship.ID > 300_000) "wielkopolskie"
    else if (voivodeship.ID > 280_000) "warmińsko-mazurskie"
    else if (voivodeship.ID > 260_000) "świętokrzyskie"
    else if (voivodeship.ID > 240_000) "śląskie"
    else if (voivodeship.ID > 220_000) "pomorskie"
    else if (voivodeship.ID > 200_000) "podlaskie"
    else if (voivodeship.ID > 180_000) "podkarpackie"
    else if (voivodeship.ID > 160_000) "opolskie"
    else if (voivodeship.ID > 140_000) "mazowieckie"
    else if (voivodeship.ID > 120_000) "małopolskie"
    else if (voivodeship.ID > 100_000) "łódzkie"
    else if (voivodeship.ID > 80_000) "lubuskie"
    else if (voivodeship.ID > 60_000) "lubelskie"
    else if (voivodeship.ID > 40_000) "kujawsko-pomorskie"
    else "dolnośląskie"
  }.toSeq

  val results_sum = results_per_voivodeship.map { case (name, results) =>
    (
      name,
      results.foldLeft((0, 0, 0)) { (acc, result) =>
        val total =
          result.KOALICJA_OBYWATELSKA + result.PIS + result.LEWICA_RAZEM + result.POLEXIT +
            result.JEDNOŚĆ_NARODU + result.EUROPA_CHRISTI + result.WIOSNA + result.KONFEDERACJA +
            result.KUKIZ15 + result.POLSKA_FAIR_PLAY

        (acc._1 + result.KOALICJA_OBYWATELSKA, acc._2 + result.PIS, acc._3 + total)
      }
    )
  }

  val percentage_values = results_sum
    .map { case (name, (ko, pis, total)) =>
      val ko_percentage = (ko.toDouble / total.toDouble) * 100
      val pis_percentage = (pis.toDouble / total.toDouble) * 100
      (name, ko_percentage, pis_percentage, (ko_percentage - pis_percentage).abs)
    }
    .sortBy { case (_, _, _, diff) => diff }

  percentage_values.foreach { (name, ko_percentage, pis_percentage, diff) =>
    println(
      f"$name%s -\nKOALICJA_OBYWATELSKA: $ko_percentage%1.2f%%, PIS: $pis_percentage%1.2f%%, diff: $diff%1.2fpp.\n"
    )
  }
}

case class Voivodeship(name: String, min: Int)

case class Result(
  ID: Int,
  KOALICJA_OBYWATELSKA: Int,
  LEWICA_RAZEM: Int,
  POLEXIT: Int,
  JEDNOŚĆ_NARODU: Int,
  PIS: Int,
  EUROPA_CHRISTI: Int,
  WIOSNA: Int,
  KONFEDERACJA: Int,
  KUKIZ15: Int,
  POLSKA_FAIR_PLAY: Int
)
