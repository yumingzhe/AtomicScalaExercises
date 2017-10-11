// 1.
package com.atomicscala.pythagorean
class RightTriangle {
  def hypotenuse(a: Double, b: Double) = {
    Math.sqrt(a * a + b * b)
  }

  def area(a: Double, b: Double): Double = {
    a * b / 2
  }
}

// 2.
class EquilateralTriangle {
  def area(side: Double): Double = {
    Math.sqrt(3) * side * side / 4
  }
}

val t = new EquilateralTriangle
val area = t.area(4)
assert(area == Math.sqrt(3) * 4, "")
