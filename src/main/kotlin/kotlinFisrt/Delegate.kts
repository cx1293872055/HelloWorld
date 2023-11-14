package kotlinFisrt

/**
 * @author chenxin
 * @date 2023/11/14 星期二 14:40
 */


interface Worker {
  fun work()
  fun takeVacation()
  fun fileTimeSheet() = println("Why? Really?")
}

interface Assistant {
  fun doChores()
  fun fileTimeSheet() = println("No escape from that")
}

class DepartmentAssistant: Assistant {
  override fun doChores() {
    println("routine stuff ")
  }
}

open class JavaProgrammer: Worker {
  override fun work() = println("... write Java")
  override fun takeVacation() = println(" ...code at the ranch")
}


class CSharpProgrammer: Worker {
  override fun work() = println("...write C# ...")
  override fun takeVacation() = println("... branch at the ranch")
}

// class Manager(val worker: Worker){
//   fun work() = worker.work()
//   fun takeVacation() = worker.work()
// }

class Manager(val staff: Worker, val assistant: Assistant):
  Worker by staff,
  Assistant by assistant {

  override fun takeVacation() {
    println("of course")
  }

  override fun fileTimeSheet() {
    println("manually forwarding this...")
    assistant.fileTimeSheet()
  }
}

// class Manager(): Worker by JavaProgrammer()


// fun main() {
//   val manager = Manager()
//   manager.work()
// }

var manager = Manager(CSharpProgrammer(), DepartmentAssistant())
val manager1 = Manager(JavaProgrammer(), DepartmentAssistant())

manager.work()
manager.takeVacation()
manager.doChores()
manager.fileTimeSheet()
// manager.meeting()

manager1.work()
// manager1.meeting()



