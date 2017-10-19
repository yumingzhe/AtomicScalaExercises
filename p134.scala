import com.atomicscala.AtomicTest._

// 1.
case class Person(name: String)

def plus1(v: Any): Any = {
  v match {
    case s: String => s + "s"
    case i: Int => i + 1
    case p: Person => p + " + guest"
    case _ => "some error"
  }
}
plus1("car") is "cars"
plus1(67) is 68
plus1(Person("Joanna")) is "Person(Joanna) + guest"
// 2.
def convertToSize(v: Any): Any = {
  v match {
    case s: String => s.length
    case i: Int => i
    case d: Double => d
    case f: Float => f
    case p: Person => 1
    case _ => 0
  }
}
convertToSize(45) is 45
convertToSize("car") is 3
convertToSize("truck") is 5
convertToSize(Person("Joanna")) is 1
convertToSize(45.6F) is 45.6F
convertToSize(Vector(1, 2, 3)) is 0
// 3.
def convertToSize2(v: Any): Any = {
  v match {
    case s: String => s.length
    case i: Int => i
    case d: Double => Math.round(d)
    case f: Float => Math.round(f)
    case p: Person => 1
    case _ => 0
  }
}
convertToSize2(45) is 45
convertToSize2("car") is 3
convertToSize2("truck") is 5
convertToSize2(Person("Joanna")) is 1
convertToSize2(45.6F) is 46
convertToSize2(Vector(1, 2, 3)) is 0
// 4.
def quantify(v: Any): String = {
  v match {
    case i: Int if i < 100 => "small"
    case i: Int if i >= 100 && i <= 1000 => "medium"
    case i: Int if i > 1000 => "large"
    case d: Double if d < 100 => "small"
    case d: Double if d >= 100 && d <= 1000 => "medium"
    case d: Double if d > 1000 => "large"
  }
}
quantify(100) is "medium"
quantify(20.56) is "small"
quantify(100000) is "large"
quantify(-15999) is "small"

// 5.
def forecase(i: Int): String = {
  i match {
    case v: Int if v <= 100 && v > 80 => "Sunny"
    case v: Int if v <= 80 && v > 50 => "Mostly Sunny"
    case v: Int if v <= 50 && v > 20 => "Partly Sunny"
    case v: Int if v <= 20 && v > 0 => "Mostly Cloudy"
    case v: Int if v == 0 => "Cloudy"
    case _ => "Unknown"
  }
}
forecase(100) is "Sunny"
forecase(81) is "Sunny"
forecase(80) is "Mostly Sunny"
forecase(51) is "Mostly Sunny"
forecase(50) is "Partly Sunny"
forecase(21) is "Partly Sunny"
forecase(20) is "Mostly Cloudy"
forecase(1) is "Mostly Cloudy"
forecase(0) is "Cloudy"
forecase(-1) is "Unknown"
