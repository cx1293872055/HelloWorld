package kotlinFisrt

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author chenxin
 * @date 2023/11/20 星期一 17:10
 */

class Compute{
  fun compute1(n: Long): Long = n * 2

  // suspend，协程
  // 目前的理解：在使用异步线程时，可类似于selector 、响应式
  // 在阻塞后，可能不是相同执行当前任务


  suspend fun compute2(n: Long): Long{
    val factor = 2
    println("$n received : Thread: ${Thread.currentThread()}")

    delay(n * 1000)
    val result = n * factor

    println("$n, returning $result: Thread: ${Thread.currentThread()}")
    return result

  }
}


fun main() {
  runBlocking {
    val compute = Compute()

    launch(Dispatchers.Default) {
      compute.compute2(2)
    }

    launch(Dispatchers.Default) {
      compute.compute2(1)
    }

    println("end ----------------")
  }
}




