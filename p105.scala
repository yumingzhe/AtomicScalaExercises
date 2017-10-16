import com.atomicscala.AtomicTest._

// 1.
class Coffee(val shots: Int, val decaf: Int) {
  val caf = shots - decaf
}

val doubleHalfCaf = new Coffee(shots = 2, decaf = 1)
val tripleHalfCaf = new Coffee(shots = 3, decaf = 2)
doubleHalfCaf.decaf is 1
doubleHalfCaf.caf is 1
doubleHalfCaf.shots is 2
tripleHalfCaf.decaf is 2
tripleHalfCaf.caf is 1
tripleHalfCaf.shots is 3

// 2.
class Tea(name: String = "Earl Grey", decaf: Boolean = false, milk: Boolean = false, sugar: Boolean = false) {
  def describe(): String = {
    var s: String = name
    if (decaf) {
      s += " decaf"
    }
    if (milk) {
      s += " + milk"
    }
    if (sugar) {
      s += " + sugar"
    }
    s
  }

  def calories(): Int = {
    var c: Int = 0
    if (milk) {
      c += 100
    }
    if (sugar) {
      c += 16
    }
    c
  }
}

val tea = new Tea
tea.describe is "Earl Grey"
tea.calories is 0
val lemonZinger = new Tea(decaf = true, name = "Lemon Zinger")
lemonZinger.describe() is "Lemon Zinger decaf"
lemonZinger.calories() is 0
val sweetGreen = new Tea(name = "Jasmine Green", sugar = true)
sweetGreen.describe() is "Jasmine Green + sugar"
sweetGreen.calories() is 16
val teaLatte = new Tea(sugar = true, milk = true)
teaLatte.describe() is "Earl Grey + milk + sugar"
teaLatte.calories() is 116

// 3.
class Tea2(val name: String = "Earl Grey", val decaf: Boolean = false, val milk: Boolean = false, val sugar: Boolean = false) {
  var describe: String = name
  if (decaf) {
    describe += " decaf"
  }
  if (milk) {
    describe += " + milk"
  }
  if (sugar) {
    describe += " + sugar"
  }

  var calories = 0
  if (milk) {
    calories += 100
  }
  if (sugar) {
    calories += 16
  }
}

val tea2 = new Tea2
tea2.describe is "Earl Grey"
tea2.calories is 0
tea2.name is "Earl Grey"

val lemonZinger2 = new Tea2(decaf = true, name = "Lemon Zinger")
lemonZinger2.describe is "Lemon Zinger decaf"
lemonZinger2.calories is 0
lemonZinger2.decaf is true

val sweetGreen2 = new Tea2(name = "Jasmine Green", sugar = true)
sweetGreen2.describe is "Jasmine Green + sugar"
sweetGreen2.calories is 16
sweetGreen2.sugar is true

val teaLatte2 = new Tea2(sugar = true, milk = true)
teaLatte2.describe is "Earl Grey + milk + sugar"
teaLatte2.calories is 116
teaLatte2.milk is true
