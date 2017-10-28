import com.atomicscala.AtomicTest._

// 1.
trait Mobility {
  def mobility: String
}
trait Vision {
  def vision: String
}
trait Manipulator {
  def manipulator: String
}
class Robot(mob: String, vi: String, manipu: String) extends Mobility with Vision with Manipulator {
  override def mobility: String = mob

  override def vision: String = vi

  override def manipulator: String = manipu
  override def toString: String = s"$mobility, $vision, $manipulator"
}
val walker = new Robot("Legs", "Visible Spectrum", "Magnet")
walker is "Legs, Visible Spectrum, Magnet"
val crawler = new Robot("Treads", "Infrared", "Claw")
crawler is "Treads, Infrared, Claw"
val arial = new Robot("Propeller", "UV", "None")
arial is "Propeller, UV, None"

// 2.
case class Mobility2(p: String) {
  def mobility = p
}

case class Vision2(p: String) {
  def vision = p
}

case class Manipulator2(p: String) {
  def manipulator = p
}

class Robot2(mob: Mobility2, vi: Vision2, manipu: Manipulator2) {
  def mobility = mob.mobility

  def vision = vi.vision
  def manipulator = manipu.manipulator
  override def toString: String = s"$mob, $vi, $manipu"
}
val walker2 = new Robot2(Mobility2("Legs"), Vision2("Visible Spectrum"), Manipulator2("Magnet"))
walker2 is "Mobility2(Legs), Vision2(Visible Spectrum), Manipulator2(Magnet)"
val crawler2 = new Robot2(Mobility2("Treads"), Vision2("Infrared"), Manipulator2("Claw"))
crawler2 is "Mobility2(Treads), Vision2(Infrared), Manipulator2(Claw)"
val arial2 = new Robot2(Mobility2("Propeller"), Vision2("UV"), Manipulator2("None"))
arial2 is "Mobility2(Propeller), Vision2(UV), Manipulator2(None)"

// 3.
class Robot3(mob: Vector[Mobility2], vi: Vector[Vision2], manipu: Vector[Manipulator2]) {
  def mobility = mob.mkString(", ")

  def vision = vi.mkString(", ")

  def manipulator = manipu.mkString(", ")
  override def toString: String = s"$mobility | $vision | $manipulator"
}
val bot = new Robot3(Vector(Mobility2("Propeller"), Mobility2("Legs")),
  Vector(Vision2("UV"), Vision2("Visible Spectrum")),
  Vector(Manipulator2("Magnet"), Manipulator2("Claw")))
bot is "Mobility2(Propeller), Mobility2(Legs) | Vision2(UV), Vision2(Visible Spectrum) | Manipulator2(Magnet), Manipulator2(Claw)"

// 4.
trait Ability

case class Mobility3(p: String) extends Ability {
  def mobility = p
}

case class Vision3(p: String) extends Ability {
  def vision = p
}

case class Manipulator3(p: String) extends Ability {
  def manipulator = p
}

class Robot4(abilities: Vector[Ability]) {
  override def toString: String = abilities.mkString(", ")
}

val bot4 = new Robot4(
  Vector(Mobility3("Propeller"),
    Mobility3("Legs"),
    Vision3("UV"),
    Vision3("Visible Spectrum"),
    Manipulator3("Magnet"),
    Manipulator3("Claw"))
)

bot4 is "Mobility3(Propeller), Mobility3(Legs), Vision3(UV), Vision3(Visible Spectrum), Manipulator3(Magnet), Manipulator3(Claw)"

// 5.
class Robot5() {
  var mobilities: Vector[Mobility3] = Vector()
  var visions: Vector[Vision3] = Vector()
  var manipulators: Vector[Manipulator3] = Vector()

  def addMobility(m: Mobility3) = {
    mobilities = mobilities :+ m
  }

  def addVision(v: Vision3) = {
    visions = visions :+ v
  }
  def addManipulator(m: Manipulator3) = {
    manipulators = manipulators :+ m
  }
  override def toString: String = s"${mobilities.mkString(", ")} | ${visions.mkString(", ")} | ${manipulators.mkString(", ")}"
}

val bot5 = new Robot5
bot5.addMobility(Mobility3("Propeller"))
bot5.addMobility(Mobility3("Legs"))
bot5.addVision(Vision3("UV"))
bot5.addVision(Vision3("Visible Spectrum"))
bot5.addManipulator(Manipulator3("Magnet"))
bot5.addManipulator(Manipulator3("Claw"))
bot5 is "Mobility3(Propeller), Mobility3(Legs) | Vision3(UV), Vision3(Visible Spectrum) | Manipulator3(Magnet), Manipulator3(Claw)"

// 6.
class Robot6() {
  var mobilities: Vector[Mobility3] = Vector()
  var visions: Vector[Vision3] = Vector()
  var manipulators: Vector[Manipulator3] = Vector()

  def +(m: Mobility3) = {
    mobilities = mobilities :+ m
    this
  }

  def +(v: Vision3) = {
    visions = visions :+ v
    this
  }

  def +(m: Manipulator3) = {
    manipulators = manipulators :+ m
    this
  }

  override def toString: String = s"${mobilities.mkString(", ")} | ${visions.mkString(", ")} | ${manipulators.mkString(", ")}"
}

val bot6 = new Robot6 +
  Mobility3("Propeller") +
  Mobility3("Legs") +
  Vision3("UV") +
  Vision3("Visible Spectrum") +
  Manipulator3("Magnet") +
  Manipulator3("Claw")

bot6 is "Mobility3(Propeller), Mobility3(Legs) | Vision3(UV), Vision3(Visible Spectrum) | Manipulator3(Magnet), Manipulator3(Claw)"
