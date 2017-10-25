import com.atomicscala.AtomicTest._

// 1.
abstract class Animal {
  def templateMethod = s"The $animal goes $sound"

  def animal: String

  def sound: String

  def food: String
}

class Duck extends Animal {
  def animal = "Duck"

  override def sound = "Quack"

  override def food: String = "plants"
}

class Cow extends Animal {
  def animal = "Cow"

  def sound = "Moo"

  override def food: String = "grass"
}

val duck = new Duck
duck.food is "plants"
val cow = new Cow
cow.food is "grass"

// 2.
class Chicken extends Animal {
  override def animal: String = "Chicken"

  override def food: String = "insects"

  override def sound: String = ???
}

class Pig extends Animal {
  override def animal: String = "Pig"

  override def food: String = "anything"

  override def sound: String = ???
}

val chicken = new Chicken
chicken.food is "insects"
val pig = new Pig
pig.food is "anything"

// 3.
abstract class Adder(x: Int) {
  def add(y: Int): Int
}

class NumericAdder(val x: Int) extends Adder(x) {
  def add(y: Int): Int = x + y
}

val num = new NumericAdder(5)
num.add(10) is 15

// 4.
// case类也可以继承abstract类
abstract class AClass {
  val num: Int
}

case class CaseClass(p: Int) extends AClass {
  override val num: Int = 2
}

new CaseClass(1)

// 5.
class Bird extends Animal {
  override def animal: String = ???

  def animal(p: Int) = "test"

  override def food: String = ???

  override def sound: String = ???
}
