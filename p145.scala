import com.atomicscala.AtomicTest._

// 1.
class Exclaim(var s: String) {
  def parens(): String = s + "!"

  def noParens: String = s + "!"
}

val e = new Exclaim("yes")
e.noParens is "yes!"
e.parens() is "yes!"

// 2.
class Exclaim2(var s: String) {
  val noParens = s + "!"

  def parens(): String = s + "!"

}

val e2 = new Exclaim2("yes")
e2.noParens is "yes!"
e2.parens() is "yes!"

// 3.
class Exclaim3(var s: String) {
  def parens: String = s + "!"

  def noParens: String = s + "!"
}

// 4.
class Exclaim4(var s: String) {
  var count: Int = 0

  def parens: String = {
    count += 1
    s + "!"
  }

  def noParens: String = {
    count += 1
    s + "!"
  }
}

val e4 = new Exclaim4("counting")
e4.noParens
e4.parens
e4.count is 2
