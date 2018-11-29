trait HiddenQueue[T] {
  def head: T
  def tail: HiddenQueue[T]
  def enqueue(x: T): HiddenQueue[T]
}

object HiddenQueue {
  def apply[T](xs: T*): HiddenQueue[T] =
    new HiddenQueueImpl[T](xs.toList, Nil)

  private class HiddenQueueImpl[T](
    private val leading: List[T],
    private val trailing: List[T]
  ) extends HiddenQueue[T] {
    private def mirror =
      if (leading.isEmpty)
        new HiddenQueueImpl(trailing.reverse, Nil)
      else
        this

    def head = mirror.leading.head
    def tail = {
      val q = mirror
      new HiddenQueueImpl(q.leading.tail, q.trailing)
    }

    def enqueue(x: T) =
      new HiddenQueueImpl(leading, x :: trailing)
  }
}
