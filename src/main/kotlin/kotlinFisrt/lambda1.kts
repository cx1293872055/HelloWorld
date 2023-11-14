package kotlinFisrt

// val doubleOfEven = mutableListOf<Int>()
//
// for(i in 1..10) {
//   if(i % 2 == 0) {
//     doubleOfEven.add(i * 2)
//   }
// }
//
// println(doubleOfEven)


// val doubleOfEven = (1..10)
//   .filter {e -> e % 2 == 0}
//   .map {e -> e * 2}
// println(doubleOfEven)

// fun isprime(n: Int) = n > 1 && (2 until n).none {n % it == 0}
//
// fun walk1To(n: Int, action: (Int) -> Unit) = (1..n).forEach(action)
//
// walk1To(5, System.out::println)

// val names = listOf("Pam", "Pat", "Paul", "Paule")
// fun predicateOfLength(length: Int) = {input: String -> input.length == length}
//
// println(names.find(predicateOfLength(5)))
// println(names.find(predicateOfLength(4)))


// val checkLength5 = fun(name: String): Boolean { return name.length == 5}

// names.find (checkLength5)


// var factor = 2
// val doubled = listOf(1, 2).map {it * factor}
// val doubledAlse = sequenceOf(1, 2).map {it * factor}
//
// factor = 0
// doubled.forEach {println(it)}
// doubledAlse.forEach {println(it)}
//


inline fun invokeTwo(
  n: Int,
  action1: (Int) -> Unit,
  noinline action2: (Int) -> Unit,
): (Int) -> Unit {
  println("enter invokeTwo $n")
  action1(n)
  action2(n)

  println("exit invokeTwo $n")
  return {_: Int -> println("lambda returned from invokeTwo")}
}

fun report(n: Int) {
  println("")
  print("called with $n")

  val stackTrace = RuntimeException().stackTrace

  println("Stack depth: ${stackTrace.size}")
  println("Partial listing of stack:")
  stackTrace.take(5).forEach(::println)
}

fun callInvokeTwo() {
  invokeTwo(1, {i -> report(i)},{ i -> report(i)} )
}


callInvokeTwo()