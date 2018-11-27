println("""Welcome to Ultamix 3000.
           Type "Help" for help.""")

println("\n===== pretty version ====")
println("""|Welcome to Ultamix 3000.
           |Type "Help" for help.""".stripMargin)


println("\n===== symbol literal ====")
def updateRecordByName(r: Symbol, value: Any) = { }
updateRecordByName('foo, "I have a good name")


println("\n===== string OP ====")
val name = "reader"
println(s"Hello, $name!")
println(s"The answer is ${6 * 7}!")


val a = 10
val b = 20
println(s"The answer is ${a * b}!")
println(raw"No\\\\\\escape!")
println(f"0x${a * b}%x")

println("\n===== basic operation ====")
val s = "Hello, world"
println(s indexOf 'o')

var foo = -2.0
var bar = (2.0).unary_-
println(foo, bar)


println(List(1, 2, 3) != null)
println(1 == 1.0)
println(List(1, 2, 3) == List(1, 2, 3))
println(("he" + "llo") == "hello")
