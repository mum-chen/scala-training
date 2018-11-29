class VarianceQueue[+T](
  private val leading: List[T],
  private val trailing: List[T]
) {
  private def mirror =
    if (leading.isEmpty)
      new VarianceQueue(trailing.reverse, Nil)
    else
      this

  def head = mirror.leading.head
  def tail = {
    val q = mirror
    new VarianceQueue(q.leading.tail, q.trailing)
  }

  def enqueue[U >: T](x: U) =
    new VarianceQueue[U](leading, x :: trailing)
}

object VarianceQueue {
  def apply[T](xs: T*): VarianceQueue[T] = new VarianceQueue[T](xs.toList, Nil)
}
