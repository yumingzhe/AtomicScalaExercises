import com.atomicscala.AtomicTest._

// 1.
def matchColor(color: String): String = {
  if (color.equals("red")) {
    "RED"
  } else if (color.equals("blue")) {
    "BLUE"
  } else if (color.equals("green")) {
    "GREEN"
  } else {
    "UNKNOWN COLOR: " + color
  }
}
matchColor("white") is "UNKNOWN COLOR: white"
matchColor("blue") is "BLUE"
// 2.
def oneOrTheOther(exp: Boolean) = {
  exp match {
    case true => "True!"
    case false => "It's false"
  }
}
val v = Vector(1)
val v2 = Vector(3, 4)
oneOrTheOther(v == v.reverse) is "True!"
oneOrTheOther(v2 == v2.reverse) is "It's false"
// 3.
def checkTruth(exp1: Boolean, exp2: Boolean): String = {
  exp1 match {
    case true => {
      if (exp2) {
        "Both are true"
      } else {
        "First: ture, second: false"
      }
    }
    case false => {
      if (exp2) {
        "First: false, second: ture"
      } else {
        "Both are false"
      }
    }
  }
}
checkTruth(true || false, true) is "Both are true"
checkTruth(1 > 0 && -1 < 0, 1 == 2) is "First: ture, second: false"
checkTruth(1 >= 2, 1 >= 1) is "First: false, second: ture"
checkTruth(true && false, false && true) is "Both are false"
// 4.
def forecast(value: Int): String = {
  value match {
    case 100 => "Sunny"
    case 80 => "Mostly Sunny"
    case 50 => "Partly Sunny"
    case 20 => "Mostly Cloudy"
    case 0 => "Cloudy"
    case _ => "Unknown"
  }
}
forecast(100) is "Sunny"
forecast(80) is "Mostly Sunny"
forecast(50) is "Partly Sunny"
forecast(20) is "Mostly Cloudy"
forecast(0) is "Cloudy"
forecast(15) is "Unknown"
// 5.
val sunnyData = Vector(100, 80, 50, 20, 0, 15)
for (i <- sunnyData) {
  println(forecast(i))
}
