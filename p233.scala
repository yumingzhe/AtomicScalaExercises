import com.atomicscala.AtomicTest._

// 1.
val constants = Map(3.141 -> "Pi", 2.718 -> "e", 1.618 -> "phi")
Map((3.141, "Pi"), (2.718, "e"), (1.618, "phi")) is constants
Vector((3.141, "Pi"), (2.718, "e"), (1.618, "phi")).toMap is constants
constants(2.718) is "e"
constants.keys is "Set(3.141, 2.718, 1.618)"
(for (pair <- constants) yield pair.toString) is "List((3.141,Pi), (2.718,e), (1.618,phi))"
(for ((k, v) <- constants) yield k + ": " + v) is "List(3.141: Pi, 2.718: e, 1.618: phi)"

// 2.
case class Name(val firstName: String, val lastName: String)

val m = Map("sally@taylor.com" -> Name("Sally", "Taylor"))
m("sally@taylor.com") is Name("Sally", "Taylor")
// 3.
val m2 = Map("sally@taylor.com" -> Name("Sally", "Taylor"), "jiminy@cricket.com" -> Name("Jiminy", "Cricket"))
m2("jiminy@cricket.com") is Name("Jiminy", "Cricket")
m2("sally@taylor.com") is Name("Sally", "Taylor")
// 4.
val languages = Map(("English", 1), ("French", 2), ("Spanish", 3), ("German", 4), ("Chinese", 5))
val newLanguages = languages + ("Turkish" -> 6)
newLanguages("Turkish") is 6
newLanguages.size is 6
// 5.
val newLanguages2 = languages + ("English" -> 6)
newLanguages2.size is 5
newLanguages2("English") is 6
// 6.
languages.size is 5
val newLanguages3 = languages - "Spanish"
newLanguages3.size is 4
val m3 = m2 - "jiminy@cricket.com"
m3.size is 1

// 7.
case class Person(name: String)

val people = Map((Person("Janice"), "CFO"))
people(Person("Janice")) is "CFO"
