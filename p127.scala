import com.atomicscala.AtomicTest._

// 1.
val v = Vector(1, 2, 3, 4)
v.map(i => i * 11 + 10) is Vector(21, 32, 43, 54)

// 2.
// 可以使用for来替换map，不过需要用var来暂存中间结果

// 3.
var v1 = Vector[Int]()
for (i <- v) {
  v1 = v1.:+(i * 11 + 10)
}
v1 is Vector(21, 32, 43, 54)

// 4.
var v2 = Vector[Int]()
for (i <- v) {
  v2 = v2.:+(i + 1)
}
v2 is Vector(2, 3, 4, 5)

// 5.
val v3 = Vector(1, 10, 100, 1000)
var sum: Int = 0
for (i <- v3) {
  sum += i
}
sum is 1111

// 6.
def sumIt(args: Int*) = {
  args.reduce((sum, i) => i + sum)
}
sumIt(1, 2, 3) is 6
sumIt(45, 45, 45, 60) is 195
