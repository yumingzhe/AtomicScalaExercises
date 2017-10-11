import com.atomicscala.AtomicTest._

// setup
class Cup2 {
  var percentFull = 0
  val max = 100

  def add(increase: Int): Int = {
    percentFull += increase
    if (percentFull > max) {
      percentFull = max
    }
    percentFull
  }
}

// 1.
// 不需要额外代码来满足下面的测试
val cup2 = new Cup2
cup2.add(45) is 45
cup2.add(-15) is 30
cup2.add(-50) is -20

// 2.
class Cup3 {
  var percentFull = 0
  val max = 100
  val min = 0

  def add(increase: Int): Int = {
    percentFull += increase
    if (percentFull > max) {
      percentFull = max
    }
    if (percentFull < min) {
      percentFull = min
    }
    percentFull
  }
}

val cup3 = new Cup3
cup3.add(45) is 45
cup3.add(-55) is 0
cup3.add(10) is 10
cup3.add(-9) is 1
cup3.add(-2) is 0

// 3.
// 可以
cup3.percentFull = 56
cup3.percentFull is 56

// 4.
class Cup4 {
  var percentFull = 0
  val max = 100
  val min = 0

  def add(increase: Int): Int = {
    percentFull += increase
    if (percentFull > max) {
      percentFull = max
    }
    if (percentFull < min) {
      percentFull = min
    }
    percentFull
  }

  def set(value: Int): Unit = {
    percentFull = value
  }

  def get(): Int = {
    percentFull
  }
}

val cup4 = new Cup4
cup4.set(56)
cup4.get() is 56
