import com.atomicscala.AtomicTest._

// 1.
def explicitDouble(d1: Double, d2: Double, d3: Double): Vector[Double] = {
  Vector(d1, d2, d3)
}
explicitDouble(1.0, 2.0, 3.0) is Vector(1.0, 2.0, 3.0)

// 2.
def explicitList(v: Vector[Double]): List[Double] = {
  var l = List[Double]()
  for (d <- v.reverse) {
    l = l.::(d)
  }
  l
}
explicitList(Vector(10.0, 20.0)) is List(10.0, 20.0)
explicitList(Vector(1, 2, 3)) is List(1.0, 2.0, 3.0)
// 3.
def explicitSet(v: Vector[Double]): Set[Double] = {
  var s = Set[Double]()
  for (d <- v) {
    s = s.+(d)
  }
  s
}
explicitSet(Vector(10.0, 20.0, 10.0)) is Set(10.0, 20.0)
explicitSet(Vector(1, 2, 3, 2, 3, 4)) is Set(1.0, 2.0, 3.0, 4.0)
// 4.
def historicalData(v: Vector[Int]): String = {
  var sunny: Int = 0
  var mostlySunny: Int = 0
  var partlySunny: Int = 0
  var cloudy: Int = 0
  var mostlyCloudy: Int = 0
  for (i <- v) {
    i match {
      case 100 => sunny += 1
      case 80 => mostlySunny += 1
      case 50 => partlySunny += 1
      case 20 => mostlyCloudy += 1
      case 0 => cloudy += 1
    }
  }
  var s: String = ""
  if (sunny != 0) {
    s += s"Sunny=$sunny, "
  }
  if (mostlySunny != 0) {
    s += s"Mostly Sunny=$mostlySunny, "
  }
  if (partlySunny != 0) {
    s += s"Partly Sunny=$partlySunny, "
  }
  if (mostlyCloudy != 0) {
    s += s"Mostly Cloudy=$mostlyCloudy, "
  }
  if (cloudy != 0) {
    s += s"Cloudy=$cloudy, "
  }
  s.substring(0, s.length - 2)
}
val weather = Vector(100, 80, 20, 100, 20)
historicalData(weather) is "Sunny=2, Mostly Sunny=1, Mostly Cloudy=2"
