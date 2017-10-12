import com.atomicscala.AtomicTest._

// 1.
//scala> val v = Vector(1,2,3)
//v: scala.collection.immutable.Vector[Int] = Vector(1, 2, 3)

//scala> val v2 = Vector(1.1,2.2)
//v2: scala.collection.immutable.Vector[Double] = Vector(1.1, 2.2)

//scala> val v3 = Ve
//Vector   VerifyError

//scala> val v3 = Vector(1,2.2)
//v3: scala.collection.immutable.Vector[Double] = Vector(1.0, 2.2)

//scala> val v4  =Vector(1,"ad",2.2)
//v4: scala.collection.immutable.Vector[Any] = Vector(1, ad, 2.2)

//scala> val v5 = Vector("a","b")
//v5: scala.collection.immutable.Vector[String] = Vector(a, b)

// 2.
val v = Vector(Vector(1, 2), Vector("a", "b"))
v(0)(0) is 1
v(0)(1) is 2
v(1)(0) is "a"
v(1)(1) is "b"

// 3.
val v2 = Vector("The", "dog", "visited", "the", "firehouse")
var str: String = ""
for (i <- v2) {
  println(i)
  str += i
  str += " "
}
str.toString is "The dog visited the firehouse "

// 4.
var str2: String = ""
for (i <- v2) {
  println(i)
  str += i
  str += " "
}
str.replace("firehouse ", "firehouse!")
str.toString is "The dog visited the firehouse!"

// 5.
for (i <- v2) {
  println(i.reverse)
}

// 6.
for (i <- v2.reverse) {
  println(i)
}

// 7.
val intV = Vector(1, 2, 3)
val doubleV = Vector(1.0, 2.0, 3.0)
println(intV.sum) // 6
println(intV.min) // 1
println(intV.max) // 3
println(doubleV.sum) // 6.0
println(doubleV.min) // 1.0
println(doubleV.max) // 3.0

// 8.
val strV = Vector("a", "b")
println(strV.min) // a
println(strV.max) // b
//println(strV.sum) // Error: could not find implicit value for parameter num: Numeric[String]}
// sum要求参数为数字类型

// 11.
val list = List("hello", "world", "scala")
val set = Set("hello", "world", "scala")
for (i <- list) {
  println(i)
}
for (j <- set) {
  println(j)
}
println(list.reverse) // List(scala, world, hello)
println(list.sorted) // List(hello, scala, world)

// 12.
val myVector1 = Vector(1, 2, 3, 4, 5, 6)
val myVector2 = Vector(1, 2, 3, 4, 5, 6)
myVector1 is myVector2 // true
