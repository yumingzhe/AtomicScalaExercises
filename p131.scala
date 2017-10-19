import com.atomicscala.AtomicTest._

// 1.
//filterOddLT10

// 2.
def yielding2(l: List[Int]): List[Int] = {
  for {
    n <- l
    if n < 10
    isOdd = (n % 2 != 0)
    if (isOdd)
  } yield n
}
val theList = List(1, 2, 3, 5, 6, 7, 8, 10, 13, 14, 17)
yielding2(theList) is List(1, 3, 5, 7)

// 3.
def yielding3(v: Vector[Int]): Vector[Int] = {
  val result: Vector[Int] = for {
    n <- v
    if n < 10
    if n % 2 != 0
  } yield n * 10 + 2
  result
}
val v = Vector(1, 2, 3, 5, 6, 7, 8, 10, 13, 14, 17)
yielding3(v) is Vector(12, 32, 52, 72)

// 4.
// todo

// 5.
case class Activity(date: String, activity: String)

def getDates(activity: String, activities: Vector[Activity]) = {
  val result: Vector[String] = for {
    n <- activities
    if n.activity.equals(activity)
  } yield n.date
  result
}
val activities = Vector(
  Activity("01-01", "Run"),
  Activity("01-03", "Ski"),
  Activity("01-04", "Run"),
  Activity("01-10", "Ski"),
  Activity("01-03", "Run")
)
getDates("Ski", activities) is Vector("01-03", "01-10")
getDates("Run", activities) is Vector("01-01", "01-04", "01-03")
getDates("Bike", activities) is Vector()
// 6.
def getActivities(date: String, activities: Vector[Activity]) = {
  val result: Vector[String] = for {
    n <- activities
    if n.date.equals(date)
  } yield n.activity
  result
}
getActivities("01-01", activities) is Vector("Run")
getActivities("01-02", activities) is Vector()
getActivities("01-03", activities) is Vector("Ski", "Run")
getActivities("01-04", activities) is Vector("Run")
getActivities("01-10", activities) is Vector("Ski")
