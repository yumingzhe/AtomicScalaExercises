import com.atomicscala.AtomicTest._

// 1.
case class Bicycle(riders: Int) {
  override def toString: String = s"Bicycle built for $riders"
}
val forTwo = Bicycle(2)
forTwo is "Bicycle built for 2"

// 2.
case class Cycle(riders: Int) {
  override def toString: String = {
    riders match {
      case 1 => "Unicycle"
      case 2 => "Bicycle"
      case 3 => "Tricycle"
      case 4 => "Quandricycle"
      case _ => s"Cycle with $riders wheels"
    }
  }
}
val c1 = Cycle(1)
c1 is "Unicycle"
val c2 = Cycle(2)
c2 is "Bicycle"
val cn = Cycle(5)
cn is "Cycle with 5 wheels"

// 3.
case class Cycle2(riders: Int) {
  override def toString: String = {
    if (riders < 0) {
      return "That's not a cycle!"
    }
    riders match {
      case 1 => "Unicycle"
      case 2 => "Bicycle"
      case 3 => "Tricycle"
      case 4 => "Quandricycle"
      case _ =>
        if (riders < 0) "That's not a cycle!"
        else s"Cycle with $riders wheels"
    }
  }
}
Cycle2(-2) is "That's not a cycle!"
