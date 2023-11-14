package kotlinFisrt

/**
 * @author chenxin
 * @date 2023/11/10 星期五 17:37
 */

class Car

class Car1(val yearOfMake: Int)

public class Car2 public constructor(public val yearOfMake: Int)

inline class SSN(val id: String)

fun receiveSSN(ssn: SSN) {
  println("Reveice $ssn")
}

// fun main() {
//   receiveSSN(SSN("chenxin"))
// }

class MachineOperator private constructor(val name: String) {
  fun checkin() = checkedIn++
  fun checout() = checkedIn--


  // 伴生对象
  // 在同一个类下 只允许存在一个伴生对象
  // 类似与Java中的静态成员集中管理
  // 但是却可以扩展，可以继承、实现父类 父接口
  // 通过类名直接访问，对于可变成员会有线程安全问题
  companion object Name {
    var checkedIn = 0
    fun minimumBreak() = "15 minutes every 2 hours"

    fun create(name: String): MachineOperator {
      val instance = MachineOperator(name)
      instance.checkin()
      return instance
    }
  }

}

// fun main() {
//   // 直接通过类名调用伴生类的方法
//   println(MachineOperator.minimumBreak())
//
//   // 通过限定的伴生类名调用方法
//   println(MachineOperator.Name.minimumBreak())
//
//   // 通过原来的构造方法创建对象，会报错，因为构造器已经私有化
//   // val machineOperator = MachineOperator()
//
//   // 通过伴生对象创建所属的对象
//   println(MachineOperator.create("chenxin"))
//
//   // 对于解构来说，
//   // 可以做到兼容Java代码，
//   // 只需要具有componentN方法即可在Kt中使用解构相关语法
//
//   // val (s, s1, s2) = Companion()
//   //
//   // println(s)
//   // println(s1)
//   // println(s2)
// }


// 对于数据类来说
// 本身就具有解构的能力
// 并且按照主构造方法的参数顺序进行解构
// 数据类的解构是不能跟随参数表变化而变化的
data class Task(
  val id: Int,
  val name: String,
  val completed: Boolean,
  val assigned: Boolean
)

fun main() {
  val task = Task(1, "chenxin", true, true)
  val (id, _, _, assigned) = task

}