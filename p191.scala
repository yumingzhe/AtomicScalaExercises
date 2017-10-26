import com.atomicscala.AtomicTest._

// 2.
trait EnergySource

trait BatteryPower {
  def monitor(p: Int) = {
    if (p > 40) {
      "green"
    } else if (p >= 20 && p <= 39) {
      "yellow"
    } else {
      "red"
    }
  }
}

class Battery extends EnergySource with BatteryPower

object Battery extends App {
  val battery = new Battery
  battery.monitor(80) is "green"
  battery.monitor(30) is "yellow"
  battery.monitor(10) is "red"
}

// 3.
object Battery2 extends App {
  val battery = new Battery

  for (arg <- args) {
    battery.monitor(arg.toInt)
  }
}
