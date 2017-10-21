import com.atomicscala.AtomicTest._

// 1.
class SimpleTime2(val hours: Int, val minutes: Int) {
  def -(time: SimpleTime2): SimpleTime2 = {
    if (time.hours > hours) {
      new SimpleTime2(0, 0)
    } else {
      if (minutes >= time.minutes) {
        new SimpleTime2(hours - time.hours, minutes - time.minutes)
      } else {
        new SimpleTime2(hours - 1 - time.hours, 60 + minutes - time.minutes)
      }
    }
  }
}
val someT1 = new SimpleTime2(10, 30)
val someT2 = new SimpleTime2(9, 30)
val someST = someT1 - someT2
someST.hours is 1
someST.minutes is 0
val someST2 = new SimpleTime2(10, 30) - new SimpleTime2(9, 45)
someST2.hours is 0
someST2.minutes is 45
// 2.
class FancyNumber1(var base: Int) {
  def power(n: Int) = Math.pow(base.toDouble, n.toDouble).toInt
}

val a1 = new FancyNumber1(2)
a1.power(3) is 8
val b1 = new FancyNumber1(10)
b1.power(2) is 100
// 3.
class FancyNumber2(var base: Int) {
  def power(n: Int) = Math.pow(base.toDouble, n.toDouble).toInt

  def ^(n: Int) = Math.pow(base.toDouble, n.toDouble).toInt
}

val a2 = new FancyNumber2(2)
a2.^(3) is 8
val b2 = new FancyNumber2(10)
b2 ^ 2 is 100
// 4.
class FancyNumber3(var base: Double) {
  def power(n: Int) = Math.pow(base.toDouble, n.toDouble).toInt

  def ^(n: Int) = power(n)

  def **(n: Int) = power(n)
}

val a3 = new FancyNumber3(2.0)
a3.**(3) is 8
val b3 = new FancyNumber3(10.0)
b3 ** 2 is 100
