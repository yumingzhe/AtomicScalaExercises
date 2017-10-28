import com.atomicscala.AtomicTest._
import scala.reflect.runtime.currentMirror

// 1.
trait Mobile {
  def move(): String
}

class Animal extends Mobile {
  override def move(): String = "animal move"
}

class Transport extends Mobile {
  override def move(): String = "transport move"
}

def test(mobile: Mobile) = mobile.move()
test(new Animal) is "animal move"
test(new Transport) is "transport move"

// 2.
object Name {
  def className(o: Any) =
    currentMirror.reflect(o).symbol.
      toString.replace('$', ' ').
      split(' ').last
}

trait Name {
  override def toString =
    Name.className(this)
}

class Element extends Name {
  def interact(other: Element) = s"$this interact $other"

  def draw = "Drawing the element"
}

class Inert extends Element {
  override def draw: String = "Inert drawing!"
}

class Wall extends Inert

trait Material {
  def resilience: String
}

trait Wood extends Material {
  def resilience = "Breakable"
}

trait Rock extends Material {
  def resilience = "Hard"
}

class RockWall extends Wall with Rock

class WoodWall extends Wall with Wood

trait Skill

trait Fighting extends Skill {
  def fight = "Fight!"
}

trait Digging extends Skill {
  def dig = "Dig!"
}

trait Magic extends Skill {
  def castSpell = "Spell!"
}

trait Flight extends Skill {
  def fly = "Fly!"
}

class Character(var player: String = "None")
  extends Element

class Fairy extends Character with Magic

class Viking extends Character
  with Fighting

class Dwarf extends Character with Digging
  with Fighting

class Wizard extends Character with Magic

class Dragon extends Character with Magic
  with Flight

val e = new Element
e.draw is "Drawing the element"
val in = new Inert
in.draw is "Inert drawing!"
val wall = new Wall
wall.draw is "Inert drawing!"

// 3.
class Wall2 extends Inert {
  override def draw: String = "Don't draw on the wall!"
}

val wall2 = new Wall2
wall2.draw is "Don't draw on the wall!"

// 4.
class Character2(var player: String = "None") extends Element

class Dragon2(player: String) extends Character2(player)

val d = new Dragon2("Puff")
d.player is "Puff"

// 5.
class Seed

class Tomato extends Seed {
  override def toString: String = "Tomato"
}

class Corn extends Seed {
  override def toString: String = "Corn"
}

class Zucchini extends Seed {
  override def toString: String = "Zucchini"
}

class Garden(s: Seed*) {
  var seeds: Vector[Seed] = s.toVector

  override def toString: String = seeds.mkString(", ")
}

val garden = new Garden(new Tomato, new Corn, new Zucchini)
garden is "Tomato, Corn, Zucchini"

// 6.
trait Shape {
  def draw: String
}

class Ellipse extends Shape {
  override def draw: String = "Ellipse"

  override def toString: String = "Ellipse"
}

class Rectangle extends Shape {
  override def draw: String = "Rectangle"
}

class Circle extends Ellipse {
  override def draw: String = "Circle"
}

class Square extends Rectangle {
  override def draw: String = "Square"
}

class Drawing(shapes: Shape*) {
  var internal: Vector[Shape] = Vector()
  for (s <- shapes) {
    internal = internal :+ s
  }

  def draw: Vector[String] = {
    for (s <- internal) yield s.draw
  }

  override def toString: String = {
    draw.mkString(", ")
  }
}

val drawing = new Drawing(new Rectangle, new Square, new Ellipse, new Circle)
drawing.draw is "Vector(Rectangle, Square, Ellipse, Circle)"
drawing is "Rectangle, Square, Ellipse, Circle"
