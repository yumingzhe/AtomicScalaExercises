import com.atomicscala.AtomicTest._

// 1.
class Family(names: String*) {
  def familySize(): Int = {
    names.size
  }
}
val f1 = new Family("Mom", "Dad", "Sally", "Dick")
f1.familySize() is 4
val f2 = new Family("Mom", "Dad", "Harry")
f2.familySize() is 3

// 2.
class FlexibleFamily(dad: String, mom: String, children: String*) {
  def familySize(): Int = {
    children.size + 2
  }
}
val f3 = new FlexibleFamily("Mom", "Dad", "Sally", "Dick")
f3.familySize() is 4
val f4 = new Family("Mom", "Dad", "Harry")
f4.familySize() is 3
// 3.
// 不用修改原来的代码，可变参数缺失也能正常工作
val familyNoKids = new FlexibleFamily("Mom", "Dad")
familyNoKids.familySize() is 2

// 4.
//不能，可变参数只能使用一次且必须在参数列表最后

// 5.
// 不能，可变参数必须在参数列表最后

// 6.
class Cup2(var percentFull: Int) {
  val max = 100

  def add(increase: Int) = {
    percentFull += increase
    if (percentFull > max) {
      percentFull = max
    }
    percentFull
  }
}
val c = new Cup2(60)
c.add(50) is 100
val c2 = new Cup2(60)
c2.add(20) is 80

// 7.
// 可以在外部设置和访问字段的值
val c3 = new Cup2(60)
c3.percentFull is 60
c3.percentFull = 50
c3.percentFull is 50

// 8.
class Cup5(var percentFull: Int) {
  val max = 100

  def add(increase: Int*) = {
    for (i <- increase) {
      percentFull += i
      if (percentFull > max) {
        percentFull = max
      }
    }
    percentFull
  }
}
val cup5 = new Cup5(0)
cup5.add(20,30,50,20,10,-10,-40,10,50) is 100
cup5.add(10,10,-10,10,90,70,-70) is 30

// 9.
def squareThem(num: Int*) = {
  var sum = 0
  for (i <- num) {
    sum += (i * i)
  }
  sum
}
squareThem(2) is 4
squareThem(2, 4) is 20
squareThem(1, 2, 4) is 21
