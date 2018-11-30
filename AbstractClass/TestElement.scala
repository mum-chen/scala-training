import Element.elem

object Test extends App {
  val column1 = elem("hello") above elem("***")
  val column2 = elem("***") above elem("world")

  println(column1 beside column2)
}
