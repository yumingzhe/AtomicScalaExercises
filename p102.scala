import com.atomicscala.AtomicTest._

// 2.
def f(): Int = {
  0
}
def f(n: Int): Int = {
  n
}
def f(n1: Int, n2: Int): Int = {
  n2 + n1
}
def f(n1: Int, n2: Int, n3: Int): Int = {
  n3 + n1 + n2
}
def f(n1: Int, n2: Int, n3: Int, n4: Int): Int = {
  n4 + n1 + n2 + n3
}
f() is 0
f(1) is 1
f(1, 2) is 3
f(1, 2, 3) is 6
f(1, 2, 3, 4) is 10

// 3.
class Overloading {
  def f(): Int = {
    0
  }

  def f(n: Int): Int = {
    n + f()
  }

  def f(n1: Int, n2: Int): Int = {
    n2 + f(n1)
  }

  def f(n1: Int, n2: Int, n3: Int): Int = {
    n3 + f(n1, n2)
  }

  def f(n1: Int, n2: Int, n3: Int, n4: Int): Int = {
    n4 + f(n1, n2, n3)
  }
}

val o = new Overloading
o.f is 0
o.f(1) is 1
o.f(1, 2) is 3
o.f(1, 2, 3) is 6
o.f(1, 2, 3, 4) is 10

// 4.
//具有相同名字和参数但返回类型不同则无法正常工作
//f(Int) is already defined in scope
class Overloading2 {

  def f(n: Int): Int = {
    n
  }

//  def f(n: Int): String = {
  //    ""
  //  }

}
