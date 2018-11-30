class Food
abstract class Animal {
  type SuitableFood <: Food
  def eat(food: SuitableFood)
}

class Grass extends Food
class Cow extends Animal {
  type SuitableFood = Grass
  override def eat(food: Grass) = {}
}

class Pasture {
  /* refinement type, structural subclass, similar with duck-typing */
  var animals: List[Animal { type SuitableFood = Grass }] = Nil
}

object Color extends Enumeration {
  val Red = Value
  val Green, Blue = Value
}

object Direction extends Enumeration {
  val North = Value("North")
  val East = Value("East")
  val South = Value("South")
  val West = Value("West")
}

object TestFood {
  def main(args: Array[String]) = {
    var cow = new Cow()
    var pasture = new Pasture()
    pasture.animals ::= cow
    println(pasture.animals)

    for (d <- Direction.values) print(d + " ")
    println()
  }
}
