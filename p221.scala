import com.atomicscala.AtomicTest._

// 1.
case class Person(first: String, last: String, email: String) {
  val fullName = first + " " + last
}

val p = Person("John", "Smith", "john@smith.com")
p.fullName is "John Smith"
p.first is "John"
p.email is "john@smith.com"

// 2.
val people = Vector(
  Person("Zach", "Smith", "zach@smith.com"),
  Person("Mary", "Add", "mary@add.com"),
  Person("Sally", "Taylor", "sally@taylor.com")
)
people.size is 3

// 3.
val sorted = people.sortBy(p => p.last)
sorted is "Vector(" +
  "Person(Mary,Add,mary@add.com), " +
  "Person(Zach,Smith,zach@smith.com), " +
  "Person(Sally,Taylor,sally@taylor.com))"

// 4.
trait Contact {
  val email: String
}

case class Person2(first: String, last: String) {
  val fullName = first + " " + last
}

class Friend(first: String, last: String, val email: String) extends Person2(first, last) with Contact

val friends = Vector(
  new Friend("Zach", "Smith", "zach@smith.com"),
  new Friend("Mary", "Add", "mary@add.com"),
  new Friend("Sally", "Taylor", "sally@taylor.com")
)
val sorted2 = friends.sortBy(f => f.email).map(f => f.fullName)
sorted2 is "Vector(Mary Add, Sally Taylor, Zach Smith)"

// 5.
val friends2 = Vector(
  new Friend("Zach", "Smith", "zach@smith.com"),
  new Friend("Mary", "Add", "mary@add.com"),
  new Friend("Sally", "Taylor", "sally@taylor.com"),
  new Friend("Mary", "Smith", "mary@smith.com")
)
val s1 = friends2.sortBy(f => f.first)
val s2 = s1.sortBy(f => f.last).map(f => f.fullName)
s2 is "Vector(Mary Add, Mary Smith, Zach Smith, Sally Taylor)"

// 6.
val friends3 = Vector(
  new Friend("Zach", "Smith", "zach@smith.com"),
  new Friend("Mary", "Add", "mary@add.com"),
  new Friend("Sally", "Taylor", "sally@taylor.com"),
  new Friend("Mary", "Smith", "mary@smith.com")
)

val s3 = friends3.sortBy(f => f.last)
val s4 = s3.sortBy(f => f.first).map(f => f.fullName)
s4 is "Vector(Mary Add, Mary Smith, Sally Taylor, Zach Smith)"
