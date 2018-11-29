sealed abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOP(operator: String, arg: Expr) extends Expr
case class BinOP(operator: String, left: Expr, right: Expr) extends Expr

object TestPatternBase {
  def simplifyTop(expr: Expr): Expr = expr match {
    case UnOP("-", UnOP("-", e)) => e
    case BinOP("+", e, Number(0)) => e
    case BinOP("*", e, Number(1)) => e
    case _ => expr
  }

  def simplifAdd(e: Expr) = e match {
    case BinOP("+", x, y) if x == y => BinOP("*", x, Number(2))
    case _ => e
  }

  def simplifyAll(expr: Expr): Expr = expr match {
    case UnOP("-", UnOP("-", e)) =>
      simplifyAll(e)
    case BinOP("+", e, Number(0)) =>
      simplifyAll(e)
    case BinOP("*", e, Number(1)) =>
      simplifyAll(e)
    case UnOP(op, e) =>
      UnOP(op, simplifyAll(e))
    case BinOP(op, l, r) =>
      BinOP(op, simplifyAll(l), simplifyAll(r))
    case _ => expr
  }

  def describe(x: Any) = x match {
    case 5 => "five"
    case true => "truth"
    case "hello" => "hi!"
    case Nil => "the empty litst"
    case _ => "something else"
  }

  def checkZero(x: Int) = x match {
    case 0 => "zero"
    case somethingElse => "not zero: " + somethingElse
  }

  /* This function will got a warning */
  def isIntIntMap(x: Any) = x match {
    case m: Map[Int, Int] => true
    case _ => false
  }

  def isStringArray(x: Any) = x match {
    case a: Array[String] => "yes"
    case _ => "no"
  }

  def tupleDemo(expr: Any) =
    expr match {
      case (a, b, c) => println("matched " + a + b + c)
      case _ =>
    }

  def main(args: Array[String]) = {
    println("===== demo for expre")
    val v = Var("x")
    // val v = new Var("x")
    val op = BinOP("+", Number(1), v)
    val op2 = op.copy(operator = "-")
    println(op)
    println(op2)

    println("===== pattern everywhere ")
    val BinOP(o, left, right) = op2
    assert(o == "-")
    assert(left == Number(1))
    assert(right == Var("x"))


    val withDefault: Option[Int] => Int = {
      case Some(x) => x
      case None => 0
    }

    assert(withDefault(Some(10)) == 10)
    assert(withDefault(None) == 0)

    println("====== constructor mode")
    val op3 = BinOP("*", Number(0), Number(1))
    println(simplifyTop(op3))

    op3 match {
      case BinOP(_, _, _) => println(op3 + " is a binary operation")
      case _ => println("It's something else")
    }

    println(checkZero(1))

    println("===== sequence mode")
    val list = List(0, 1, 2)
    assert((list match {
      case List(0, _ , _) => "found it"
      case _ => ""
    }) == "found it")

    assert((list match {
      case List(0, _*) => "found it"
      case _ => ""
    }) == "found it")

    println("===== sequence mode with variable")
    assert((list match {
      case List(0, x @ _, y @ _) => x + y
      case _ => 0
    }) == 3)

    assert((list match {
      case List(0, xs @ _*) => xs
      case _ => Nil
    }) == List(1, 2))

    println("===== tuple mode")
    tupleDemo(("a", 3, "-tuple"))

    println("===== type mode")
    assert(isIntIntMap(Map(1 -> 1)) == true)
    assert(isIntIntMap(Map("abc" -> "abc")) == true)

    assert(isStringArray(Array("abc")) == "yes")
    assert(isStringArray(Array(1)) == "no")

    println("===== guard mode")
    assert(simplifAdd(BinOP("+", Number(1), Number(1))) == BinOP("*", Number(1), Number(2)))

    println("===== partial function")
    val secondBad: List[Int] => Int = {
      case x :: y :: _ => y
    }

    assert(secondBad(List(0, 1, 2)) == 1)
    assert(secondBad(List(0, 1)) == 1)
    // secondBad(List()) cause runtime error

    val second: PartialFunction[List[Int], Int] = {
      case x :: y :: _ => y
    }

    assert(second.isDefinedAt(List()) == false)
    assert(second.isDefinedAt(List(1)) == false)
    assert(second.isDefinedAt(List(1, 2)) == true)

    println("===== pattern in for")
    val map = Map(1 -> 2, 2 -> 4, 4-> 8)
    for ((x, y) <- map) assert(2 * x == y)

    val results = List(Some("apple"), None, Some("orange"))
    for (Some(fruit) <- results) assert(fruit != None)
  }
}
