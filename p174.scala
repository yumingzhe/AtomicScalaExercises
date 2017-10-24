import com.atomicscala.AtomicTest._

// 1.
object MonthName extends Enumeration {
  type MonthName = Value
  val January, February, March, April, May, June, July, August, September, October, November, December = Value
}

MonthName.February is "February"
MonthName.February.id is 1

// 2.
object MonthName2 extends Enumeration {
  type MonthName2 = Value
  val January = Value(1)
  val February, March, April, May, June, July, August, September, October, November, December = Value
}

MonthName2.February is "February"
MonthName2.February.id is 2
MonthName2.December.id is 12
MonthName2.July.id is 7
// 3.
import MonthName2._

def monthNumber(m: MonthName2) = m.id

July is "July"
monthNumber(July) is 7

// 4.

def season(m: MonthName2) =
  m match {
    case x if x == December || x == January || x == February => "Winter"
    case x if x == March | x == April | x == May => "Spring"
    case x if x == June || x == July || x == August => "Summer"
    case x if x == September || x == October || x == November => "Autumn"
  }

season(January) is "Winter"
season(April) is "Spring"
season(August) is "Summer"
season(November) is "Autumn"

// 5.
object Move extends Enumeration {
  type Move = Value
  val Unset, X, O = Value
}

import Move._

class Cell {
  var entry = Unset

  def set(e: Move) = {
    if (entry == Unset && (e == X || e == O)) {
      entry = e
      "successful move"
    } else
      "invalid move"
  }
}

class Grid {
  val cells = Vector(
    Vector(new Cell, new Cell, new Cell),
    Vector(new Cell, new Cell, new Cell),
    Vector(new Cell, new Cell, new Cell)
  )

  def play(e: Move, x: Int, y: Int) = {
    val status = {
      if (x < 0 || x > 2 || y < 0 || y > 2)
        "invalid move"
      else
        cells(x)(y).set(e)
    }
    showBoard()
    status
  }

  def showBoard() = {
    for (row <- cells) {
      for (cell <- row) {
        print(cell.entry + " ")
      }
      println
    }
  }
}

val grid = new Grid
grid.play(Move.X, 1, 1) is "successful move"
grid.play(Move.X, 1, 1) is "invalid move"
grid.play(Move.O, 1, 3) is "invalid move"
grid.play(Move.O, 0, 0) is "successful move"
grid.play(Move.X, 2, 2) is "successful move"

// 6.
object Level extends Enumeration {
  type Level = Value
  val Overflow, High, Medium, Low, Empty, Draining, Pooling, Dry = Value
}

import Level._

def checkLevel(level: Level) = level match {
  case Low => "Level Low OK"
  case Empty => "Alert"
  case Draining => "Level Draining OK"
  case Pooling => "Warning!"
  case Dry => "Alert"
}
Level.Draining is "Draining"
Level.Draining.id is 5
checkLevel(Low) is "Level Low OK"
checkLevel(Empty) is "Alert"
checkLevel(Draining) is "Level Draining OK"
checkLevel(Pooling) is "Warning!"
checkLevel(Dry) is "Alert"
