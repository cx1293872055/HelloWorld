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



// 使用inline关键字 可以使传递的lambda表达式内联到调用的方法中
// 这会增加字节码的体积
// 内联：我的理解是，会在编译阶段把lambda的实现直接应用到接收到lambda方法中
// noinline/crossinline
// 用来
// - 标记不会内联
// - 对于标注的参数来说，在调用该lambda的任何地方都会被内联
// 都不能使用非局部return
// 非局部return: 想要在使用该lambda时直接返回当前方法的return
// 局部return: 仅仅是返回当前lambda到调用方
inline fun invokeTwo(
  n: Int,
  action1: (Int) -> Unit,
  noinline action2: (Int) -> Unit,
): (Int) -> Unit {
  println("enter invokeTwo $n")
  action1(n)
  action2(n)

  println("exit invokeTwo $n")
  return {input: Int ->action2.invoke(input)}
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
  invokeTwo(1,
            {i ->
              if(i ==1) return
              report(i)
            },
            {i ->
              // if(i == 2) return
              report(i)
            })
}


callInvokeTwo()