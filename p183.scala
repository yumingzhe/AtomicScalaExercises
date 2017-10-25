import com.atomicscala.AtomicTest._

// 1.
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

val battery = new Battery
battery.monitor(80) is "green"
battery.monitor(30) is "yellow"
battery.monitor(10) is "red"

// 2.
class Toy

class BatteryPoweredToy extends Toy with BatteryPower

val toy = new BatteryPoweredToy
toy.monitor(50) is "green"

// 3.
val toy2 = new Toy with BatteryPower
toy2.monitor(50) is "green"
