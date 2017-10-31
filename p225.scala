import com.atomicscala.AtomicTest._

// 1.
def max(list: List[Int], maxNum: Int = 0): Int = {
  if (list.isEmpty) {
    maxNum
  } else {
    var temp = list.head
    if (temp < maxNum)
      temp = maxNum
    max(list.tail, temp)
  }
}
val aList = List(10, 20, 45, 15, 30)
max(aList) is 45

// 2.
def sumIt(toSum: List[Int], sum: Int = 0): Int =
  if (toSum.isEmpty)
    sum
  else {
    println(toSum.tail + " " + (sum + toSum.head))
    sumIt(toSum.tail, sum + toSum.head)
  }
sumIt(List(10, 20, 30, 40, 50)) is 150
// 3.
def sumIt(list: List[Int]): Int = {
  list.sum
}
sumIt(List(1, 2, 3)) is 6
sumIt(List(45, 45, 45, 60)) is 195

// 4.
def calcFreq(list: List[String], target: String, count: Int = 0): Int = {
  if (list.isEmpty)
    count
  else {
    if (target.equals(list.head)) {
      calcFreq(list.tail, target, count + 1)
    } else
      calcFreq(list.tail, target, count)
  }
}

val animalList = List("cat", "dog", "cat", "bird", "cat", "cat", "kitten", "mouse")
calcFreq(animalList, "cat") is 4
calcFreq(animalList, "dog") is 1
calcFreq(animalList, "bird") is 1
calcFreq(animalList, "kitten") is 1
calcFreq(animalList, "mouse") is 1
