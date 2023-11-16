package  kotlinFisrt

import java.math.BigInteger
import kotlin.reflect.KProperty
import kotlin.system.measureTimeMillis

fun sort(numbers: List<Int>): List<Int> =
  if(numbers.isEmpty()) {
    numbers
  } else {
    val pivot = numbers.first()
    val tail = numbers.drop(1)

    val lessOrEqual = tail.filter {it < pivot}
    val larger = tail.filter {it > pivot}
    sort(lessOrEqual) + pivot + sort(larger)
  }

// println(sort(listOf(12,5,16,12,8,19)))


tailrec fun factorialRec(
  n: Int,
  result: BigInteger
): BigInteger =
  if(n <= 0) 1.toBigInteger() else factorialRec(n - 1, result * n.toBigInteger())

// println(factorialRec(5))
//
// object Factorial {
//   fun factorialRec(n: Int): BigInteger =
//     if(n <= 0) 1.toBigInteger() else n.toBigInteger() * factorialRec(n - 1)
//
//   tailrec fun factorial(
//     n: Int,
//     result: BigInteger = 1.toBigInteger()
//   ): BigInteger =
//     if(n <= 0) result else factorial(n - 1, result * n.toBigInteger())
//
// }
//
// fun <T, R> ((T) -> R).memoize(): ((T) -> R) {
//   val original = this
//   val cache = mutableMapOf<T, R>()
//   return {n: T -> cache.getOrPut(n) {original(n)}}
// }
//
//
// lateinit var fib: (Int) -> Long
//
// fib = {n: Int ->
//   when(n) {
//     0, 1 -> 1L
//     else -> fib(n - 1) + fib(n - 2)
//   }
// }.memoize()
//
//
// println(measureTimeMillis {fib(40)})
// println(measureTimeMillis {fib(45)})
// println(measureTimeMillis {fib(500)})
//

class Memoize<T, R> (val func: (T) -> R){
  val cache = mutableMapOf<T, R>()

  operator fun getValue(thisRef: Any?, property: KProperty<*>) = {
    n: T ->
    cache.getOrPut(n){ func(n)}
  }
}

val fib: (Int) -> Long by Memoize {n : Int ->
  when(n) {
    0, 1 -> 1L
    else -> fib(n - 1) + fib(n - 2)

  }
}


println(measureTimeMillis {fib(40)})
println(measureTimeMillis {fib(45)})
println(measureTimeMillis {fib(500)})


