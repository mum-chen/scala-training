object TestQueue {
  def main(args: Array[String]) = {
    val q: Queue[String] = Queue()
    val q2 = HiddenQueue[String]()
    val q3 = VarianceQueue[String]()
    val q4 = VarianceQueue2[String]()
  }
}
