import com.atomicscala.AtomicTest._

// 1.
val r1 = Range(0, 10)
r1 is Range(0, 10)

// 2.
val r2 = Range(0, 10).inclusive
//r2 is Range(0,10) // error, expected: Range(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

// 3.
// total必须使用var,因为total会不断的被修改
var total = 0
for (i <- 0 to 10) {
  total += i
}

total is 55

// 4.
var totalEvens = 0
for (i <- 0 to 10) {
  if (i % 2 == 0) {
    totalEvens += i
  }
}
totalEvens is 30

// 5.
var evens = 0
var odds = 0
for (i <- 0 to 10) {
  if (i % 2 == 0) {
    evens += i
  } else {
    odds += i
  }
}
evens is 30
odds is 25
(evens + odds) is 55

// 6.
evens = 0
odds = 0
for (i <- Range(0, 10).inclusive) {
  if (i % 2 == 0) {
    evens += i
  } else {
    odds += i
  }
}
evens is 30
odds is 25
(evens + odds) is 55
