package kotlinFisrt

import java.net.URL
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


// data class Point(val x: Int, val y: Int)
// data class Circle(val cx: Int, val cy: Int, val radius: Int)

// operator infix fun Circle.contains(point: Point) =
//   (point.x - cx) * (point.x - cx) + (point.y - cy) * (point.y - cy) < radius * radius
//
// val circle = Circle(100, 100, 25)
// val point = Point(110, 110)
// val point2 = Point(10, 100)

// println(circle.contains(point))
// println(circle contains point)
// println(point in circle)
// println(point2 contains circle)

// val Circle.area: Double
//   get() = PI * radius * radius
//
// val circle = Circle(100, 100, 25)
// println("Area is ${circle.area}")

fun String.isPalindrome(): Boolean {
  return reversed() == this
}

fun String.shout() = toUpperCase()

val str = "dad"
// println(str.isPalindrome())
// println(str.shout())


operator fun ClosedRange<String>.iterator() =
  object: Iterator<String> {
    private val next = StringBuilder(start)
    private val last = endInclusive

    /**
     * Returns `true` if the iteration has more elements.
     */
    override fun hasNext(): Boolean {
      return last >= next.toString() && last.length >= next.length
    }

    /**
     * Returns the next element in the iteration.
     *
     * @throws NoSuchElementException if the iteration has no next element.
     */
    override fun next(): String {
      val result = next.toString()

      val lastCharacter = next.last()

      if(lastCharacter < Char.MAX_VALUE) {
        next.setCharAt(next.length - 1, lastCharacter + 1)

      } else {
        next.append(Char.MIN_VALUE)
      }
      return result
    }
  }

// println(("hell".."help").iterator().asSequence().joinToString(","))
// for(word in "hell".."help") {
//   print("$word, ")
// }

fun String.Companion.toURL(link: String) = URL(link)

val url = String.toURL("https://www.baidu.com")

// println(url)


class Point(x: Int, y: Int) {
  private val pair = Pair(x, y)

  private val firstsign = if(pair.first < 0) "" else "+"
  private val secondsign = if(pair.second < 0) "" else "+"

  override fun toString(): String {
    return pair.point2String()
  }

  fun Pair<Int, Int>.point2String() = "(${firstsign}${first}, ${this@Point.secondsign}${this.second})"
}

// println(Point(1, -3))
// println(Point(-3, 4))





fun <T, R, U> ((T)-> R).andThen(next: (R) -> U): (T) -> U =
  { input: T -> next(this(input))}

fun increment(number: Int): Double = number + 1.toDouble()
fun double(number: Double) = number * 2

val incrementAndDouble = ::increment.andThen(::double)
println(incrementAndDouble(5))

