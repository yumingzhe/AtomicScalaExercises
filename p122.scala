import com.atomicscala.AtomicTest._

// 1.
var str = ""
val v = Vector(1, 2, 3, 4)
v.foreach(i => str += i)
str is "1234"

// 2.
str = ""
v.foreach(i => str += (i + ","))
str is "1,2,3,4,"
// 3.
val dogYears = (i: Int) => i * 7
dogYears(10) is 70
// 4.
var s = ""
val v2 = Vector(1, 5, 7, 8)
v2.foreach(v => s += dogYears(v) + " ")
s is "7 35 49 56 "
// 5.
s = ""
v2.foreach(v => s += v * 7 + " ")
s is "7 35 49 56 "
// 6.
val between = (temperature: Int, low: Int, high: Int) => low <= temperature && temperature <= high
between(70, 80, 90) is false
between(70, 60, 90) is true
// 7.
var s2 = ""
val numbers = Vector(1, 2, 5, 3, 7)
numbers.foreach(i => s2 += i * i + " ")
s2 is "1 4 25 9 49 "
// 8.
val pluralize = (str: String) => str + "s"
pluralize("cat") is "cats"
pluralize("dog") is "dogs"
pluralize("silly") is "sillys"
// 9.
var s3 = ""
val words = Vector("word", "cat", "animal")
words.foreach(s => s3 += pluralize(s) + " ")
s3 is "words cats animals "
