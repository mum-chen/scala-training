
class SlowAppendQueue[T](elems: List[T]) {
  def head = elems.head
  def tail = new SlowAppendQueue(elems.tail)
  def enqueue(x: T) = new SlowAppendQueue(elems ::: List(x))
}

class SlowHeadQueue[T](smele: List[T]) {
  def head = smele.last
  def tail = new SlowAppendQueue(smele.init)
  def enqueue(x: T) = new SlowAppendQueue(x :: smele)
}

class Queue[T](
  private val leading: List[T],
  private val trailing: List[T]
) {
  private def mirror =
    if (leading.isEmpty)
      new Queue(trailing.reverse, Nil)
    else
      this

  def head = mirror.leading.head
  def tail = {
    val q = mirror
    new Queue(q.leading.tail, q.trailing)
  }

  def enqueue(x: T) =
    new Queue(leading, x :: trailing)
}

object Queue {
  def apply[T](xs: T*): Queue[T] = new Queue[T](xs.toList, Nil)
}
