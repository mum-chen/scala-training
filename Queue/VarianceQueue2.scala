class VarianceQueue2[+T] private (
  /* The `this` is necessary.*/
  private[this] var leading: List[T],
  private[this] var trailing: List[T]
) {
  private def mirror() =
    if (leading.isEmpty) {
      while (!trailing.isEmpty) {
        leading = trailing.head :: leading
        trailing = trailing.tail
      }
    }
  def head: T = {
    mirror()
    leading.head
  }

  def tail: VarianceQueue2[T] = {
    mirror()
    new VarianceQueue2(leading.tail, trailing)
  }

  def enqueue[U >: T](x: U) =
    new VarianceQueue2[U](leading, x :: trailing)
}

object VarianceQueue2 {
  def apply[T](xs: T*): VarianceQueue2[T] = new VarianceQueue2[T](xs.toList, Nil)
}
