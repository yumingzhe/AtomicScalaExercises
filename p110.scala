import com.atomicscala.AtomicTest._

// 1.
class Dimension(var height: Int, var width: Int)
val c = new Dimension(5, 7)
c.height is 5
c.height = 10
c.height is 10
c.width = 19
c.width is 19
// 2.
class Info(val name: String, var description: String)
val info = new Info("stuff", "Something")
info.name is "stuff"
info.description is "Something"
info.description = "Something else"
info.description is "Something else"
// 3.
class Info2(var name: String, var description: String)
val info2 = new Info2("stuff", "something")
info2.name = "This is the new name"
info2.name is "This is the new name"
// 4.
class SimpleTime(val hours: Int, val minutes: Int) {
  def subtract(time: SimpleTime): SimpleTime = {
    if (time.hours > hours) {
      new SimpleTime(0, 0)
    } else {
      if (minutes >= time.minutes) {
        new SimpleTime(hours - time.hours, minutes - time.minutes)
      } else {
        new SimpleTime(hours - 1 - time.hours, 60 + minutes - time.minutes)
      }
    }
  }
}
val t1 = new SimpleTime(10, 30)
val t2 = new SimpleTime(9, 30)
val st = t1.subtract(t2)
st.hours is 1
st.minutes is 0
val st2 = new SimpleTime(10, 30).subtract(new SimpleTime(9, 45))
st2.hours is 0
st2.minutes is 45
val st3 = new SimpleTime(9, 30).subtract(new SimpleTime(10, 0))
st3.hours is 0
st3.minutes is 0
// 5.
class SimpleTimeDefault(val hours: Int, val minutes: Int = 0) {
  def subtract(time: SimpleTimeDefault): SimpleTimeDefault = {
    if (time.hours > hours) {
      new SimpleTimeDefault(0, 0)
    } else {
      if (minutes >= time.minutes) {
        new SimpleTimeDefault(hours - time.hours, minutes - time.minutes)
      } else {
        new SimpleTimeDefault(hours - 1 - time.hours, 60 + minutes - time.minutes)
      }
    }
  }
}

val anotherT1 = new SimpleTimeDefault(10, 30)
val anotherT2 = new SimpleTimeDefault(9)
val anotherST = anotherT1.subtract(anotherT2)
anotherST.hours is 1
anotherST.minutes is 30
val anotherST2 = new SimpleTimeDefault(10).subtract(new SimpleTimeDefault(9, 45))
anotherST2.hours is 0
anotherST2.minutes is 15
// 6.
class SimpleTimeAux(val hours: Int, val minutes: Int = 0) {
  def this(hours: Int) = {
    this(hours, 0)
  }

  def subtract(time: SimpleTimeAux): SimpleTimeAux = {
    if (time.hours > hours) {
      new SimpleTimeAux(0, 0)
    } else {
      if (minutes >= time.minutes) {
        new SimpleTimeAux(hours - time.hours, minutes - time.minutes)
      } else {
        new SimpleTimeAux(hours - 1 - time.hours, 60 + minutes - time.minutes)
      }
    }
  }
}

val auxT1 = new SimpleTimeAux(10, 5)
val auxT2 = new SimpleTimeAux(6)
val auxST = auxT1.subtract(auxT2)
auxST.hours is 4
auxST.minutes is 5
val auxST2 = new SimpleTimeAux(12).subtract(new SimpleTimeAux(9, 45))
auxST2.hours is 2
auxST2.minutes is 15
