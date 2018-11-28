val x = "abcd".substring(2)
val y = "abcd".substring(2)

/* inherit == from any same as equals */
assert(x == y)
assert(x equals y)

/* inherit ne/eq from AnyRef, same as Java's == */
assert(x ne y)
assert(!(x eq y))
