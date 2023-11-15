package kotlinFisrt

import kotlin.math.PI
import kotlin.math.abs


data class Complex(val real: Int, val imaginary: Int) {
  operator fun times(other: Complex) =
    Complex(
      real * other.real - imaginary * other.imaginary,
      real * other.imaginary + imaginary * other.real
    )

  private fun sign() = if(imaginary < 0) "-" else "+"

  override fun toString() = "$real ${sign()} ${abs(imaginary)}"
}

// println(Complex(4, 2) * Complex(-3, 4))


class Counter(val value: Int) {
  operator fun inc() = Counter(value + 1)
  operator fun dec() = Counter(value - 1)

  override fun toString() = "$value"
}

var counter = Counter(2)
// println(counter)
// println(++counter)
// println(counter)
// println(counter++)
// println(counter)


data class Point(val x: Int, val y: Int)
data class Circle(val cx: Int, val cy: Int, val radius: Int)

operator fun Circle.contains(point: Point) =
  (point.x - cx) * (point.x - cx) + (point.y - cy) * (point.y - cy) < radius * radius

// val circle = Circle(100, 100, 25)
// val point = Point(110, 110)
// val point2 = Point(10, 100)

// println(circle.contains(point))
// println(point in circle)
// println(point2 in circle)

val Circle.area:Double
  get() = PI * radius * radius

val circle = Circle(100, 100, 25)
println("Area is ${circle.area}")