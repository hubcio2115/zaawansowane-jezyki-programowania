package Lab01.Zad02

class Complex(val re: Double, val im: Double) extends Ordered[Complex] {
  def this(re: Double) = this(re, 0)

  override def toString: String =
    (re, im) match {
      case (_, 0)          => s"$re"
      case (0, _)          => s"${im}i"
      case (x, i) if i < 0 => s"$x - ${-i}i"
      case _               => s"$re + ${im}i"
    }

  def +(that: Complex): Complex =
    new Complex(re + that.re, im + that.im)

  def -(that: Complex): Complex =
    new Complex(re - that.re, im - that.im)

  def *(that: Complex): Complex =
    new Complex(
      re * that.re - im * that.im,
      re * that.im + im * that.re
    )

  def /(that: Complex): Complex = {
    val divisor = Math.pow(that.im, 2) + Math.pow(that.re, 2)

    if (divisor == 0) throw new IllegalArgumentException("")

    val dividend = new Complex(
      (re * that.re + im * that.im) + (im * that.re - re * that.im)
    )

    dividend / divisor
  }

  def compare(that: Complex): Int = {
    if (re < that.re) return -1
    if (re == that.re && im < that.im) return -1

    if (re > that.re) return 1
    if (re == that.re && im > that.im) return 1

    0
  }

  def /(that: Double): Complex =
    this / new Complex(that)

  extension (d: Double)
    def +(other: Complex): Complex =
      Complex(d) + other

    def -(other: Complex): Complex =
      Complex(d) - other

    def *(other: Complex): Complex =
      Complex(d) * other

    def /(other: Complex): Complex =
      Complex(d) / other

}
