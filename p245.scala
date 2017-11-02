import com.atomicscala.AtomicTest._

// 1.
def exceptionMethod() = {
  try {
    throw new Exception("this is a exception msg")
  } catch {
    case e: Exception => e.getMessage is "this is a exception msg"
  }
}
exceptionMethod()

// 2.
class Test {
  def f() = {}
}

var t: Test = null
try {
  t.f()
} catch {
  case e: Exception => e.getMessage
}
// 3.
val v = Vector("a", "b")
try {
  v(2)
} catch {
  case e: Exception => e.getMessage
}

// 4.
case class MyException(s: String) extends Exception(s)

try {
  throw MyException("test own exception")
} catch {
  case e: MyException => e.getMessage is "test own exception"
}

// 5.
case class Exception1(s: String) extends Exception(s)

case class Exception2(s: String) extends Exception(s)

case class Exception3(s: String) extends Exception(s)

def test(n: Int) = {
  n match {
    case 1 => throw new Exception1("exception 1")
    case 2 => throw new Exception2("exception 2")
    case _ => throw new Exception3("exception 3")
  }
}
var n = 1
try {
  test(n)
} catch {
  case e: Exception => e.getMessage is s"exception $n"
}

// 6.
class MyClass {
  def g = throw new Exception1("exception 1")

  def f = {
    try {
      g
    } catch {
      case e: Exception1 => throw new Exception2("exception 2")
    }
  }
}

val m = new MyClass
try {
  m.f
} catch {
  case e: Exception2 => e.getMessage is "exception 2"
}

// 7.
class BaseClass {
  //  throw new Exception("exception coming from Base class")
}

class DerivedClass extends BaseClass {
  try {
  } catch {
    case x: Exception => x.getMessage
  }
}

// 8.
class FailingConstructor(n: Int) {
  if (n <= 0) throw new Exception
  println("construct object...")
}

def test2(n: Int) = {
  if (n > 0)
    new FailingConstructor(n)
  else
    "can not construct object!"
}
test2(2)
test2(0) is "can not construct object!"

// 9.
class Exception4 extends Exception

class Exception5 extends Exception4

class Exception6 extends Exception5

class A {
  def f = throw new Exception4
}

class B extends A {
  override def f = throw new Exception5
}

class C extends B {
  override def f = throw new Exception6
}

val a: A = new C
//a.f

// 10.
try {
  throw new Exception("test exception")
} catch {
  case e: Exception => println("catch exception")
} finally {
  println("finally executed!")
}
