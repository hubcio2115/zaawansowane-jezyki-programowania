package Lab04

def threeNumbers(n: Int): Set[(Int, Int, Int)] = {
  val range = (1 to n).toList;

  (for {
    a <- range
    b <- range
    c <- range
  } yield
    if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) Some((a, b, c))
    else None).flatten.toSet
}
