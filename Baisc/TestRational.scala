object TestRational extends App {
  var one = new Rational(1)
  val oneHalf = new Rational(1, 2)
  val twoThirds = new Rational(2, 3)
  val foo = oneHalf + twoThirds
  println(foo, foo.numer, foo.denom)
  println(oneHalf * twoThirds)
  println(twoThirds lessThan oneHalf)
  println(oneHalf max twoThirds)
  println(new Rational(10, 5))
  println(one / 2)

  /*
   * error: XXX
   * should define implicit conversions.
   * but the implicit is a buggy way.
   */
  // println(2 / one)
  implicit def intToRational(x: Int) = new Rational(x)
  println(2 / one)
}
