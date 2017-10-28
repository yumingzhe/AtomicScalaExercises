import com.atomicscala.AtomicTest._

// 1.
trait WIFI {
  val address: String

  def reportStatus = "working"
}
class Camera {
  def showImage = "Showing video"
}
class WIFICamera(val address: String = "192.168.0.200") extends Camera with WIFI
val webcam = new WIFICamera
webcam.showImage is "Showing video"
webcam.address is "192.168.0.200"
webcam.reportStatus is "working"
// 2.
trait Connections {
  val maxConnections = 5
  var connected: Int = 0

  def connect(status: Boolean) = {
    status match {
      case true if connected < maxConnections =>
        connected += 1
        true
      case true if connected >= maxConnections => false
      case false if connected > 0 =>
        connected -= 1
        true
      case false if connected <= 0 => false
    }
  }
}
val c = new Object with Connections
c.maxConnections is 5
c.connect(true) is true
c.connected is 1
for (i <- 0 to 3)
  c.connect(true) is true
c.connect(true) is false
c.connect(false) is true
c.connected is 4
for (i <- 0 to 3)
  c.connect(false) is true
c.connected is 0
c.connect(false) is false
// 3.
val c2 = new WIFICamera with Connections
c2.maxConnections is 5
c2.connect(true) is true
c2.connected is 1
c2.connect(false) is true
c2.connected is 0
c2.connect(false) is false
// 4.
trait ArtPeriod {
  def period(year: Int) =
    year match {
      case x if x < 1300 => "Pre-Renaissance"
      case x if x >= 1300 && x <= 1599 => "Renaissance"
      case x if x >= 1600 && x <= 1699 => "Baroque"
      case x if x >= 1700 && x <= 1789 => "Late Baroque"
      case x if x >= 1790 && x <= 1880 => "Romanticism"
      case x if x >= 1881 && x <= 1970 => "Modern"
      case x if x >= 1971 => "Contemporary"
    }
}
val art = new Object with ArtPeriod
art.period(1400) is "Renaissance"
art.period(1650) is "Baroque"
art.period(1279) is "Pre-Renaissance"

// 5.
class Painting(name: String, year: Int) extends ArtPeriod {
  def period = super.period(year)
}

val painting = new Painting("The Starry Night", 1889)
painting.period is "Modern"
