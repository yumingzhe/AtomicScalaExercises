// 1.
val r = Range(0, 5)
println(r.step)

// 2.
val str = "This is an experiment"
str.split(" ") // Array(This, is, an, experiment)

// 3.
var s1 = "Sally"
var s2 = "Sally"
if (s1.equals(s2)) { // true
  println("s1 and s2 are equal") // print
} else{
  println("s1 and s2 are not equal")
}

// 4.
s2 = "Sam"
if (s1.equals(s2)) { // false
  println("s1 and s2 are equal")
} else{
  println("s1 and s2 are not equal") // print
}
println(s1 == "Sally") // true

// 5.
var s3 = s1.toUpperCase()
if (s1.contentEquals(s3)) {// flase
  println("s1 and s3 are equal")
}else{
  println("s1 and s3 are not equal") // print
}
