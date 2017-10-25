import com.atomicscala.AtomicTest._

// 1.
abstract class Base {
  def f1: Int

  def f2: Int

  val d1: Int
  val d2: Int
  var d3: Int
  var n = 1
}

class Derived extends Base {
  def f1 = 1

  val f2 = 1
  val d1 = 1
  val d2 = 1

  def d3 = n

  def d3_=(newVal: Int) = n = newVal
}

val d = new Derived
d.d3 is 1
d.d3 = 42
d.d3 is 42

// 2.
// 当基类为具体类时，用 val 代替 def 时必须使用 override
class Base2 {
  def f1: Int = 1

  var n = 1
}

class Derived2 extends Base2 {
  override val f1 = 1

  def d3 = n

  def d3_=(newVal: Int) = n = newVal
}

val d2 = new Derived2
d2.n is 1
d2.d3 = 2
d2.d3 is 2

// 3.
class Klass {
  var internal: Int = 0

  def x = internal

  def x_=(n: Int) = internal = n
}

val c = new Klass
c.internal is 0
c.x = 2
c.x is 2
c.internal is 2
