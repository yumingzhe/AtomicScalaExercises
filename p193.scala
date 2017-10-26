import com.atomicscala.AtomicTest._
import scala.reflect.runtime.currentMirror

// 1.
object Name {
  def className(o: Any) =
    currentMirror.reflect(o).symbol.
      toString.replace('$', ' ').split(' ').last
}
trait Name {
  override def toString = Name.className(this)
}
case class Test(n: Int)
val t = new Test(1)
t is "Test(1)"
case class TestName(n: Int) extends Name
val t2 = new TestName(1)
t2 is "TestName"
// 2.
class Test2(n: Int)

val t3 = new Test2(1)
//t3 is "A$A19$A$A19$Test2@7fb88a6a"

class Test2Name(n: Int) extends Name

val t4 = new Test2Name(1)
t4 is "Test2Name"
// 3.
object Name2 {
  def className(o: Any) =
    currentMirror.reflect(o).symbol.toString
}
trait Name2 {
  override def toString = Name2.className(this)
}
case class TestName2(n: Int) extends Name2
println(new TestName2(1))
// 4.
trait AllAbstract {
  def f(n:Int):Int
  val d:Double
}

trait PartialAbstract {
  def f(n:Int):Int
  val d:Double
  def g(s:String) = s"($s)"
  val j = 42
}

trait Concrete {
  def f(n:Int) = n * 11
  val d = 1.61803
}

val x = new AllAbstract with PartialAbstract with Concrete with Name2
x is "$anon"
