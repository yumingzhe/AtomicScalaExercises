class SailBoat {
  def raise(): String = {
    println("Sails raised")
    "Sails raised"
  }

  def lower(): String = {
    println("Sails lowered")
    "Sails lowered"
  }
}

class Motorboat {
  def on(): String = {
    "Motor on"
  }

  def off(): String = {
    "Motor off"
  }
}

val sailBoat = new SailBoat
val r1 = sailBoat.raise()
assert(r1 == "Sails raised", "Expected Sails raised, Got " + r1)
val r2 = sailBoat.lower()
assert(r2 == "Sails lowered", "Expected Sails lowered, Got " + r1)
val motorboat = new Motorboat
val s1 = motorboat.on()
assert(s1 == "Motor on", "Expected Motor on, Got " + s1)
val s2 = motorboat.off()
assert(s2 == "Motor off", "Expected Motor off, Got " + s2)
// 2.
class Flare {
  def light(): String = {
    "Flare used!"
  }
}

val flare = new Flare
val f1 = flare.light()
assert(f1 == "Flare used!", "Expected Flare used!, Got " + f1)
// 3.
class SailBoat2 {
  def signal(): String = {
    val flare = new Flare
    flare.light()
  }
}

class Motorboat2 {
  def signal(): String = {
    val flare = new Flare
    flare.light()
  }
}

val sailBoat2 = new SailBoat2
val signal = sailBoat2.signal()
assert(signal == "Flare used!", "Expected Flare used! Got " + signal)

val motorboat2 = new Motorboat2
val flare2 = motorboat2.signal()
assert(flare2 == "Flare used!", "Expected Flare used!, Got " + flare2)
