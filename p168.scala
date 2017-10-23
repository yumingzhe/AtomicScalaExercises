import com.atomicscala.AtomicTest._

// 1.
class GreatApe(val weight: Double, val age: Int, val gender: String)

class Bonobo(weight: Double, age: Int, gender: String) extends GreatApe(weight, age, gender)

class Chimpanzee(weight: Double, age: Int, gender: String) extends GreatApe(weight, age, gender)

class BonoboB(weight: Double, age: Int, gender: String) extends Bonobo(weight, age, gender)

def display(ape: GreatApe) = s"weight: ${ape.weight} age: ${ape.age} gender: ${ape.gender}"
display(new GreatApe(100, 12, "Male")) is "weight: 100.0 age: 12 gender: Male"
display(new Bonobo(100, 12, "Male")) is "weight: 100.0 age: 12 gender: Male"
display(new Chimpanzee(100, 12, "Female")) is "weight: 100.0 age: 12 gender: Female"
display(new BonoboB(100, 12, "Female")) is "weight: 100.0 age: 12 gender: Female"

// 2.
class GreatApe2(val weight: Double, val age: Int) {
  def say = "ape"
}

class Bonobo2(w: Double, a: Int) extends GreatApe2(w, a) {
  println(say)
}

new Bonobo2(1, 2)

// 3.
class House(val address: String, val state: String, val zip: String) {
  def this(state: String, zip: String) = this("address?", state, zip)

  def this(zip: String) = this("address?", "state?", zip)
}

class Home(address: String, state: String, zip: String, val heart: Boolean = true) extends House(address, state, zip) {
  override def toString: String = "Where the heart is"
}

val h = new Home("aa", "bb", "cc")
h.toString is "Where the heart is"
h.heart is true

// 4.
class VacationHouse(state: String, zip: String, val startMonth: Int, val endMonth: Int) extends House(state, zip) {
  def month(m: Int) = {
    m match {
      case 1 => "January"
      case 2 => "February"
      case 3 => "March"
      case 4 => "April"
      case 5 => "May"
      case 6 => "June"
      case 7 => "July"
      case 8 => "August"
      case 9 => "September"
      case 10 => "October"
      case 11 => "November"
      case 12 => "December"
    }
  }

  override def toString: String = s"Rented house in $state for months of ${month(startMonth)} through ${month(endMonth)}."
}

val v = new VacationHouse("MI", "49431", 6, 8)
v is "Rented house in MI for months of June through August."

// 5.
case class Trip(val origination: String, val destination: String, val startDay: String, val endDay: String) {
  override def toString: String = s"From $origination to $destination: $startDay to $endDay"
}

class AirplaneTrip(from: String, to: String, startDay: String, endDay: String, val movie: String) extends Trip(from, to, startDay, endDay) {
  override def toString: String = s"On a flight from $origination to $destination, we watched $movie"
}

class CarTrip(cities: Vector[String], val startDate: String, endDay: String) extends Trip(cities.head, cities.last, startDate, endDay)

val t = new Trip("Detroit", "Houston", "5/1/2012", "6/1/2012")
val a = new AirplaneTrip("Detroit", "London", "9/1/1939", "10/31/1939", "Superman")
val cities = Vector("Boston", "Albany", "Buffalo", "Cleveland", "Columbus", "Indianapolis",
  "St. Louis", "Kansas City", "Denver", "Grand Junction", "Salt Lake City", "Las Vegas", "Bakersfield", "San Francisco")
val c = new CarTrip(cities, "6/1/2012", "7/1/2012")
c.origination is "Boston"
c.destination is "San Francisco"
c.startDate is "6/1/2012"
t is "From Detroit to Houston: 5/1/2012 to 6/1/2012"
a is "On a flight from Detroit to London, we watched Superman"
c is "From Boston to San Francisco: 6/1/2012 to 7/1/2012"

// 8.
//case类的子类不能再是case类
