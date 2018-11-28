assert(List(10, 20, -4, -9).filter(_ > 10) == List(20))

// cause error
// val f = _ + _

val f = (_: Int) + (_: Int)
assert(f(10, 4) == 14)

(1 to 2).toList.foreach(println _)
/* if the parameter requires function, the underline can be emitted */
(-1 to 0).toList.foreach(println)

def sum(a: Int, b: Int, c: Int) = a + b + c
assert(sum(1, 2, 3) == 6)

val foo = sum _
assert(foo(1, 2, 3) == 6)
assert(foo.apply(1, 2, 3) == 6)

val bar = sum(1, _: Int, 3)
assert(bar(2) == 6)
assert(bar.apply(2) == 6)

println("==== demo for closure")
val someNumbers = (-5 to 6).toList
var sumNumbers = 0
someNumbers.foreach(sumNumbers += _)
assert(sumNumbers == 6)

println("==== demo for args")
def echo(args: String*) =
  for (arg <- args) println(arg)

echo("one")
echo("Hello", "wrold!")

val arr = Array("What's", "up", "doc?")
// echo(arr) // error
echo(arr: _*)

def speed(distance: Float, time: Float = 1) = distance / time
assert(speed(time = 10, distance = 100) == 10)
assert(speed(distance = 100) == 100)

println("==== demo for tail recursion")

def boom(x: Int): Int =
  if (x == 0) throw new Exception("boom!")
  else boom(x - 1) + 1

def bang(x: Int): Int =
  if (x == 0) throw new Exception("bang!")
  else bang(x - 1)

/* observe below two cases */
// boom(5)
// bang(5)


val funValue = nestedFun _
def nestedFun(x: Int): Unit = {
  if (x != 0) { println(x); funValue(x - 1) }
}
