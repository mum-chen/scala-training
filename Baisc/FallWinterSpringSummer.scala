import ChecksumAccumulator.calculate

object FallWinterSpringSummer extends App {
  for (season <- List("fall", "winter", "spring", "summer"))
    println(season + ": " + calculate(season))
}
