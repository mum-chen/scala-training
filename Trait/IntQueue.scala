import scala.collection.mutable.ArrayBuffer

abstract class IntQueue {
  def get(): Int
  def put(x: Int)
}

trait Doubling extends IntQueue {
  /* the keyword is abstract override */
  abstract override def put(x: Int) = { super.put(2 * x) }
}

trait Incrementing extends IntQueue {
  abstract override def put(x: Int) = { super.put(x + 1) }
}

trait Filtering extends IntQueue {
  abstract override def put(x: Int) = {
    if (x >= 0) super.put(x)
  }
}

class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]
  def get() = buf.remove(0)
  def put(x: Int) = { buf += x }
}

class MyQueue extends BasicIntQueue with Doubling

class MyQueue2 extends BasicIntQueue with Filtering with Incrementing
class MyQueue3 extends BasicIntQueue with Incrementing with Filtering
class MyQueue4 extends BasicIntQueue with Incrementing with Filtering {
  override def put(x: Int) = { super.put(x * 3) }
}

object TestQueue extends App {
  val queue = new MyQueue
  queue.put(10)
  assert(queue.get() == 20)

  val queue2 = new MyQueue2
  queue2.put(-1)
  queue2.put(0)
  queue2.put(1)

  assert(queue2.get() == 0)
  assert(queue2.get() == 1)
  assert(queue2.get() == 2)

  val queue3 = new MyQueue3
  queue3.put(-1)
  queue3.put(0)
  queue3.put(1)

  assert(queue3.get() == 0 + 1)
  assert(queue3.get() == 1 + 1)

  val queue4 = new MyQueue4
  queue4.put(-1)
  queue4.put(0)
  queue4.put(1)

  assert(queue4.get() == 0 * 3 + 1)
  assert(queue4.get() == 1 * 3 + 1)
}
