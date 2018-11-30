import scala.language.implicitConversions

class PreferredPrompt(val preference: String)
class PreferredDrink(val preference: String)

object Greeter {
  def greet(name: String)(implicit prompt: PreferredPrompt) = {
    println("Welcome, " + name + ". The system is ready")
    println(prompt.preference)
  }

  def greetZeal(name: String)
      (implicit prompt: PreferredPrompt, drink: PreferredDrink) = {
    println("Welcome, " + name + ". The system is ready")
    print("But while you work, ")
    println("why not enjoy a cup of " + drink.preference + "?")
    println(prompt.preference)
  }
}

object JoesPrefs {
  implicit val prompt = new PreferredPrompt("Yes, master> ")
  implicit val drink = new PreferredDrink("tea")
}


object TestImplicit {
  case class Rectangle(width: Int, height: Int)

  /*
   * The implicit class couldn't be in package level.
   * The implicit class must has the constructor with one arg.
   */
  implicit class RectangleMaker(width: Int) {
    def x(height: Int) = Rectangle(width, height)
  }

  def main(args: Array[String]) {
    // val i: Int = 3.5 //error
    implicit def doubleToInt(x: Double) = x.toInt
    val i: Int = 3.5

    /*
     * Int don't have methond `x`, the compiler will find the method
     * RectangleMaker: Int => RectangleMaker, which generated by implicit class.
     */
    val myRectangle = 3 x 4
    println(myRectangle)

    val bobsPrompt = new PreferredPrompt("relax> ")
    Greeter.greet("Bob")(bobsPrompt)

    import JoesPrefs.prompt
    Greeter.greet("Joe")

    import JoesPrefs.drink
    Greeter.greetZeal("Joe")
  }
}

