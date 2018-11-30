trait Abstract {
  type T
  def transform(x: T): T
  val initial: T
  var current: T
}

class Concrete extends Abstract {
  type T = String
  def transform(x: String) = x + x
  val initial = "hi"
  var current = initial
}

abstract class Fruit {
  val v: String
  def m: String
  var n: String
}

abstract class Apple extends Fruit {
  val v: String
  val m: String
  val n: String
}

abstract class BadApple extends Fruit {
  // def v: String // cause error, def <-> var, def -> val
  def n: String
  var m: String
}

trait AbstractTime {
  var hour: Int
  var minute: Int
  require(hour >= 0)
}

class ImplTime(var hour: Int, var minute: Int) extends AbstractTime

class Demo {
  val x = { println("initializing x"); "done" }
}

class LazyDemo {
  lazy val x = { println("initializing x"); "done" }
}

object TestAbstract extends App {
  def assertError(block: => Unit) = {
    try {
      block
      assert(false, "must cause error")
    } catch {
      case e: IllegalArgumentException => println("catch error")
    }
  }

  def asserNotError(block: => Unit) = {
    block
    println("could't catch error")
  }

  val time1 = new AbstractTime {
    var hour = 1
    var minute = 20
  }

  val time2 = new AbstractTime {
    var hour = 1
    var minute = 20
  }

  println(time1, time2) /* from different classes */

  val time3 = new ImplTime(hour = 1, minute = 20)
  val time4 = new ImplTime(hour = 1, minute = 20)
  println(time3, time4) /* from same classes */

  assertError {
    val time5 = new ImplTime(hour = -1, minute = 20)
  }

  asserNotError {
    val time6 = new AbstractTime {
      var hour = -1
      var minute = 20
    }
  }

  assertError {
    println("pre-initialized field")
    val time7 = new {
      var hour = -1
      var minute = 20
    } with AbstractTime
  }

  val demo = new Demo()
  println("initial class done")
  val lazyDemo = new LazyDemo()
  println("initial class done")
  lazyDemo.x
  println("initial lazy done")
}
