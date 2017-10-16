import com.atomicscala.AtomicTest._

// 1.
case class Person(first: String, last: String, email: String)
val p = Person("Jane", "Smile", "jane@smile.com")
p.first is "Jane"
p.last is "Smile"
p.email is "jane@smile.com"
// 2.
val people = Vector(
  Person("Jane", "Smile", "jane@smile.com"),
  Person("Ron", "House", "ron@house.com"),
  Person("Sally", "Dove", "sally@dove.com")
)

people(0) is "Person(Jane,Smile,jane@smile.com)"
people(1) is "Person(Ron,House,ron@house.com)"
people(2) is "Person(Sally,Dove,sally@dove.com)"
// 3.
case class Dog(name: String, blood: String)
val dogs = Vector(
  Dog("Fido", "Golden Lab"),
  Dog("Ruff", "Alaskan Malamute"),
  Dog("Fifi", "Miniature Podle")
)

dogs(0) is "Dog(Fido,Golden Lab)"
dogs(1) is "Dog(Ruff,Alaskan Malamute)"
dogs(2) is "Dog(Fifi,Miniature Podle)"
// 4.
case class Dimension(var height: Int, var width: Int)
val c = new Dimension(5, 7)
c.height is 5
c.height = 10
c.height is 10
c.width = 19
c.width is 19
// 5.
case class Dimension2(val height: Int, var width: Int)
val c2 = new Dimension2(5, 7)
//c2.height = 6 // reassignment to val
c2.width = 8
// 6.
// case类中可以使用缺省参数
case class SimpleTimeDefault(val hours: Int, val minutes: Int = 0) {
  def subtract(time: SimpleTimeDefault): SimpleTimeDefault = {
    if (time.hours > hours) {
      new SimpleTimeDefault(0, 0)
    } else {
      if (minutes >= time.minutes) {
        new SimpleTimeDefault(hours - time.hours, minutes - time.minutes)
      } else {
        new SimpleTimeDefault(hours - 1 - time.hours, 60 + minutes - time.minutes)
      }
    }
  }
}
val anotherT1 = new SimpleTimeDefault(10, 30)
val anotherT2 = new SimpleTimeDefault(9)
val anotherST = anotherT1.subtract(anotherT2)
anotherST.hours is 1
anotherST.minutes is 30
val anotherST2 = new SimpleTimeDefault(10).subtract(new SimpleTimeDefault(9, 45))
anotherST2.hours is 0
anotherST2.minutes is 15
