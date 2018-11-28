def plainOldSum(x: Int, y: Int) = x + y
assert(plainOldSum(1, 2) == 3)

def first(x: Int) = (y: Int) => x + y
val second = first(1)
assert(second(2) == 3)

def curriedSum(x: Int)(y: Int) = x + y
assert(curriedSum(1)(2) == 3)

/*
 * Note println_ is a valid identifier but the curriedSum(1)_ is not
 * So you can use curriedSum(1)_ instead of curriedSum(1) _
 */
val onePlus = curriedSum(1) _
assert(onePlus(2) == 3)

def twice(op: Double => Double, x: Double) = op(op(x))
assert(twice(_ + 1, 5) == 7)


def opSomeNumber(op: Int => Int)(x: => Int) = op(x)

val addSomeNumber = opSomeNumber { x => x + 1 } _

assert(addSomeNumber(2) == 3)

val n = 10
assert(opSomeNumber { x =>
  println("call op after", n, x)
  x * n
} {
  println("cal value first")
  n - 1
} == 90)


var assertionEnable = false

def byNameAssert(predicate: => Boolean) =
  if (assertionEnable && !predicate)
    throw new AssertionError

def byNameAssertVal(predicate: Boolean) =
  if (assertionEnable && !predicate)
    throw new AssertionError

byNameAssert(10 / 0 == 0)
println{
  try {
    byNameAssertVal(10 / 0 == 0)
  } catch {
    case ex: java.lang.ArithmeticException => ex

  }
}

/* demo for loan pattern */
/*
def withPrintWriter(file: File, op: PrintWriter => Unit) = {
  val writer = new PrintWriter(file)
  try {
    op(writer)
  } finally {
    writer.close()
  }
}
*/
