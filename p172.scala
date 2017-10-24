import AtomicTest._

// 1.
// 方法带有()表明该方法会修改内部状态

// 2.
class GreatApe2(val weight: Double, val age: Int, val gender: String) {
  def myWords: Vector[String] = Vector("Roar")
}

class Bonobo2(weight: Double, age: Int, gender: String)
  extends GreatApe2(weight, age, gender) {
  override def myWords: Vector[String] = super.myWords ++ Vector("Hello")
}

val roaringApe = new GreatApe2(112, 9, "Male")
roaringApe.myWords is Vector("Roar")
val chattyBonobo = new Bonobo2(150, 14, "Female")
chattyBonobo.myWords is Vector("Roar", "Hello")

// 3.
case class Trip(val origination: String, val destination: String, val startDay: String, val endDay: String) {
  override def toString: String = s"From $origination to $destination: $startDay to $endDay"
}

class AirplaneTrip(from: String, to: String, startDay: String, endDay: String, val movie: String) extends Trip(from, to, startDay, endDay) {
  override def toString: String = s"${super.toString}, we watched $movie"
}

class CarTrip(cities: Vector[String], val startDate: String, endDay: String) extends Trip(cities.head, cities.last, startDate, endDay) {
  override def toString: String = s"${super.toString}, we visited $cities"
}

val t = new Trip("Detroit", "Houston", "5/1/2012", "6/1/2012")
val a = new AirplaneTrip("Detroit", "London", "9/1/1939", "10/31/1939", "Superman")
val cities = Vector("Boston",
  "Albany", "Buffalo", "Cleveland",
  "Columbus", "Indianapolis",
  "St. Louis", "Kansas City",
  "Denver", "Grand Junction",
  "Salt Lake City", "Las Vegas",
  "Bakersfield", "San Francisco")
val c = new CarTrip(cities, "6/1/2012", "7/1/2012")
c.origination is "Boston"
c.destination is "San Francisco"
c.startDate is "6/1/2012"
t is "From Detroit to Houston: 5/1/2012 to 6/1/2012"
a is "From Detroit to London: 9/1/1939 to 10/31/1939, we watched Superman"
c is "From Boston to San Francisco: 6/1/2012 to 7/1/2012, we visited Vector(Boston, Albany, Buffalo, Cleveland, Columbus," +
  " Indianapolis, St. Louis, Kansas City, Denver, Grand Junction, Salt Lake City, Las Vegas, Bakersfield, San Francisco)"