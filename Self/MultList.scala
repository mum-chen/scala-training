object MultMain extends App {
  println(for (a <- 1 to 3; b <- 4 to 5; c <- 6 to 7) yield List(a, b, c))

  val xs1 = (1 to 3).toList
  val xs2 = (4 to 5).toList
  val xs3 = (6 to 7).toList

  val xss = List(xs1, xs2, xs3, List())
  val yss = xss.foldLeft(List[List[Int]]()) { (ass, bs: List[Int]) =>
    if (ass.isEmpty) bs map {List(_)}
    else if (bs.isEmpty) ass
    else {
      for (as <- ass; b <- bs) yield as :+ b
    }
  }
  println(yss)

  println("==========>>>>>>>")

  val zs1 = List((1 to 3).toList)
  val zs2 = zs1 ++ List((4 to 5).toList)
  val zs3 = zs2 ++ List((6 to 7).toList)

  println(for (z1 <- zs1; z2 <- zs2; z3 <- zs3) yield List(z1, z2, z3))

  val zss = List(zs1, zs2, zs3)
  val zss2 = zss.foldLeft(List[List[List[Int]]]()) { (ass, bs: List[List[Int]]) =>
    if (ass.isEmpty) bs map {List(_)}
    else if (bs.isEmpty) ass
    else {
      for (as <- ass; b <- bs) yield as :+ b
    }
  }
  println(zss2)

  println("==========>>>>>>>")
  def common[T <: Any](xss: List[List[T]]): List[List[T]] = {
    val yss = xss.foldLeft(List[List[T]]()) { (ass, bs: List[T]) =>
      if (ass.isEmpty) bs map {List(_)}
      else if (bs.isEmpty) ass
      else {
        for (as <- ass; b <- bs) yield as :+ b
      }
    }
    yss
  }
  println(common[Int](xss))
  println(common[List[Int]](zss))
}
