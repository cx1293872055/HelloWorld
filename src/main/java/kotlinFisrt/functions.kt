package kotlinFisrt

/**
 * @author chenxin
 * @date 2023/11/10 星期五 11:44
 */

fun main() {

  val original = mapOf(
    1 to 2,
    2 to 3,
    3 to 4
  )

  val map = original + (5 to 5)

  for((key, value) in map) {
    println("$key ------- $value")
  }

}
