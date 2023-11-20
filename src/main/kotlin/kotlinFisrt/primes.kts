package  kotlinFisrt


// fun primes(start: Int): Sequence<Int> = sequence {
//   println("Starting to look")
//   var index = start
//
//   while(true) {
//     if(index > 1 && (2 until index).none {i -> index % i == 0}) {
//       yield(index)
//       println("Generating next after $index")
//     }
//     index++
//   }
// }
//
// for(prime in primes(start = 17)) {
//   println("Received $prime")
//   if(prime > 30) break
//
// }


// operator fun ClosedRange<String>.iterator() =
//   object: Iterator<String> {
//     private val next = StringBuilder(start)
//     private val last = endInclusive
//
//     override fun hasNext(): Boolean {
//       return last >= next.toString() && last.length >= next.length
//     }
//
//     override fun next(): String {
//       val result = next.toString()
//
//       val lastCharacter = next.last()
//
//       if(lastCharacter < Char.MAX_VALUE) {
//         next.setCharAt(next.length - 1, lastCharacter + 1)
//
//       } else {
//         next.append(Char.MIN_VALUE)
//       }
//       return result
//
//     }
//   }
//

operator fun ClosedRange<String>.iterator(): Iterator<String> = iterator {
  val next = StringBuilder(start)
  val last = endInclusive

  while(last >= next.toString() && last.length >= next.length) {
    val result = next.toString()
    val lastCharacter = next.last()

    if(lastCharacter < Char.MAX_VALUE) {
      next.setCharAt(next.length - 1, lastCharacter + 1)
    } else {
      next.append(Char.MIN_VALUE)
    }

    yield(result)
  }
}


for(word in "hell".."help") {
  print("$word, ")
}