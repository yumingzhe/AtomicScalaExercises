import com.atomicscala.AtomicTest._

// 1.
var m = Map(1 -> "one")
val m1 = m + (2 -> "two")
m.size is 1
m1.size is 2
m = Map(2 -> "two")
m(2) is "two"
val m2 = collection.mutable.Map(1 -> "one")
m2 += 2 -> "two"
m2.size is 2
m2(1) is "one"
m2(2) is "two"
// 2.
val s1 = Set(1)
s1 + 2
s1.size is 1
val s2 = collection.mutable.Set(1)
s2 += 2
s2.size is 2
s2 is "Set(1, 2)"
// 3.
var l1 = List(1)
l1.size is 1
val l2 = collection.mutable.MutableList(1)
l2 += 2
l2.size is 2
l2 is "MutableList(1, 2)"
// 4.
val v = Vector(1)
val v1 = v :+ 2
v1 is "Vector(1, 2)"

// 5.
class Animal(val name: String)

def test(a: Animal): Unit = {
  // reassign to val
  //  a = new Animal("Goat")
}

// 6.
class Bird(var name: String)

def test2(b: Bird) = {
  b.name = "twitter"
}
val bird = new Bird("swan")
test2(bird)
bird.name is "twitter"

// 7.
// 一个类既有val域又有var域，那么只能修改var域
class People(val name: String, var age: Int)

val p = new People("zhangsan", 23)
p.age = 24
// reassign to val
//p.name="aa"
