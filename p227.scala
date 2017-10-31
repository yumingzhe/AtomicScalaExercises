import com.atomicscala.AtomicTest._
// 1.
val people = Vector("Sally Smith",
  "Dan Jones", "Tom Brown", "Betsy Blanc",
  "Stormy Morgan", "Hal Goodsen")
val group1 = people.take(people.size/2)
val group2 = people.takeRight(people.size/2)
val pairs = group1.zip(group2)
pairs is Vector(
  ("Sally Smith", "Betsy Blanc"),
  ("Dan Jones", "Stormy Morgan"),
  ("Tom Brown", "Hal Goodsen"))
// 2.
// 当zip配对的两个序列个数不一样时，只会产生最小个数的配对
val v1 = Vector("a", "b", "c")
val v2 = Vector(1, 2)
v1.zip(v2) is "Vector((a,1), (b,2))"

// 3.
// 使用List来实现时不必修改代码
val people2 = List("Sally Smith",
  "Dan Jones", "Tom Brown", "Betsy Blanc",
  "Stormy Morgan", "Hal Goodsen")
val group3 = people.take(people2.size/2)
val group4 = people.takeRight(people2.size/2)
val pairs2 = group3.zip(group4)
pairs2 is Vector(
  ("Sally Smith", "Betsy Blanc"),
  ("Dan Jones", "Stormy Morgan"),
  ("Tom Brown", "Hal Goodsen"))

// 4.
def number(s: String) =
  s.zipWithIndex.map {
    case (c, i) => (i, c)
  }

number("Howdy") is Vector((0, 'H'), (1, 'o'), (2, 'w'), (3, 'd'), (4, 'y'))
