import bobsdelights.Fruits
import bobsdelights._
import bobsdelights.Fruits._
// same as
// import bobsdelights.Fruits.{_}

import Fruits.{Apple, Orange}
import Fruits.{Apple => BigApple}
import Fruits.{Pear => _, _}

object TestFruits extends App {
  def showFruit(fruit: Fruit) = {
    import fruit._
    println(name + "s are " + color)
  }

  showFruit(BigApple)
}
