package kotlinFisrt

import kotlinx.coroutines.*

suspend fun doWork(id: Int, sleep: Long) = coroutineScope {

  try {
    println("$id: enter $sleep")
    delay(sleep)
    println("$id: finished nap $sleep")

    withContext(NonCancellable) {
      println("$id: do not disturb , please")
      delay(5000)
      println("$id: OK, you can talk to me now")
    }

    println("$id: outside the restricted context")
    println("$id; isAcitve: $isActive")

  } catch(ex: CancellationException) {
    println("$id: doWork($sleep) wa cancelled")

  }
}
runBlocking {
  val job = launch(Dispatchers.Default) {
    launch {doWork(1, 3000)}
    launch {doWork(2, 1000)}
  }

  Thread.sleep(2000)
  job.cancel()

  println("cancelling")
  job.join()

  println("done")

}