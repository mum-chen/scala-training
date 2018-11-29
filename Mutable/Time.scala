class Time {
  private[this] var h = 12
  private[this] var m = 0
  def hour: Int = h
  def hour_= (x: Int) = {
    require(0 <= x && x < 24)
    h = x
  }
}

object TestTime {
  def main(args: Array[String]) = {
    var time = new Time()
    time.hour = 23
  }
}
