import com.atomicscala.AtomicTest._
class GreatApe {
  val weight = 100.0
  val age = 12

  def vocalize = "Grrr!"
}
class Bonobo extends GreatApe
class Chimpanzee extends GreatApe
class BonoboB extends Bonobo
val ape1 = new GreatApe
ape1.vocalize is "Grrr!"
val ape2 = new Bonobo
ape2.vocalize is "Grrr!"
val ape3 = new Chimpanzee
ape3.vocalize is "Grrr!"
// 2.
def says(ape: GreatApe) = "says " + ape.vocalize
says(new GreatApe) is "says Grrr!"
says(new Bonobo) is "says Grrr!"
says(new Chimpanzee) is "says Grrr!"
says(new BonoboB) is "says Grrr!"
// 3.
class Cycle {
  val wheels = 2

  def ride = "Riding"
}

class Bicycle extends Cycle

val c = new Cycle
c.ride is "Riding"
val b = new Bicycle
b.ride is "Riding"
b.wheels is 2
