package kotlinFisrt

import kotlinx.coroutines.*

suspend fun task1() {
  println("start task1 in Thread ${Thread.currentThread()}")
  yield()
  println("end task1 in Thread ${Thread.currentThread()}")
}

suspend fun task2() {
  println("start task2 in Thread ${Thread.currentThread()}")
  yield()
  println("end task2 in Thread ${Thread.currentThread()}")
}

// println("start")
//
// runBlocking {
//
//   launch(Dispatchers.Default) {task1()}
//   launch {task2()}
//
//   println("called task1 and task2 from ${Thread.currentThread()}")
// }
//
// println("done")


// Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())
//   .asCoroutineDispatcher().use {context ->
//
//     println("Start")
//
//     runBlocking {
//       launch(context, start = CoroutineStart.UNDISPATCHED) {task1()}
//       launch {task2()}
//
//       println("called task1 and task2 from ${Thread.currentThread()}")
//     }
//   }
//
// println("done")


// runBlocking {
//   println("starting in Thread ${Thread.currentThread()}")
//
//   withContext(Dispatchers.Default) {task1()} //   launch {task2()}
//   println("ending in Thread ${Thread.currentThread()}")
// }


// runBlocking(CoroutineName("top")) {
//   println("running in Thread ${Thread.currentThread()}")
//   withContext(Dispatchers.Default) {task1()}
//
//   launch(Dispatchers.Default + CoroutineName("task runner")) {task2()}
//
//   println("running in Thread ${Thread.currentThread()}")
// }


runBlocking {
  val count: Deferred<Int> = async(Dispatchers.Default) {
    println("fetching in ${Thread.currentThread()}")
    Runtime.getRuntime().availableProcessors()
  }

  println("called the function in ${Thread.currentThread()}")
  println("Number of cores is ${count.await()}")
}




