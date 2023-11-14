package kotlinFisrt

import kotlin.math.sqrt

/**
 * @author chenxin
 * @date 2023/11/10 星期五 15:16
 */

fun main() {

  // 范型>>>
  // 类型可变性
  // 对于可变集合来说，确实需要显式表明当前集合中的类型范围
  // 对于kotlin来说，不同类型的可变集合已经区分了，类型的可变性
  // 所以kotlin是把原先在Java中需要手动表明的含义默认化了。


  // 在可变集合中使用类型协变
  // 如果使用了out关键字
  // 那么该集合便不能像其中添加元素

  // val fruits = Array<Fruit>(3) {_ -> Fruit()}
  // val bananas = Array<Banana>(3) {_ -> Banana()}
  // copy(fruits, bananas)


  var array1: Array<Banana> = Array(3) {_ -> Banana()}
  var array2: Array<Any> = Array(3) {_ -> 1}

  copy(array1, array2)

  println(array1.contentToString())
}

fun compute(n: Double): Double {
  if(n >= 0) {
    return sqrt(n)
  } else {
    throw RuntimeException("No negative please")
  }
}


fun safe1() {
  val str = "chenxin"
  println(str !in listOf("1,2,3,"))
}


open class Fruit
open class Banana: Fruit()
class Ccc: Banana()
class Apple: Fruit()

fun copy(from: Array<out Banana>, to: Array<in Fruit>) {
  for(i in from.indices) {
    to[i] = from[i]
  }
}


// where 关键字的使用
// 可以限制多个范型类型
// 传入的参数必须同时是多个类型的子类/实现类
fun <T> close(input: T)
        where T: Number,
              T: CharSequence {
  input.toInt()
  input.chars()

}

// * 号可以防止任何情况下的写操作
// 只允许从中获取元素
fun star(list: List<*>) {
  println(list)
}