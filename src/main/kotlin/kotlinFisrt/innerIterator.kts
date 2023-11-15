package kotlinFisrt


data class Person(val firstName: String, val age: Int)

val people = listOf(
  Person("Sara", 12),
  Person("Jill", 51),
  Person("Paula", 23),
  Person("Paul", 25),
  Person("Mani", 12),
  Person("Jack", 70),
  Person("Sue", 10)
)

val result = people.filter {it.age > 20}
  .map {it.firstName}
  .map {it.toUpperCase()}
  .joinToString (",")

// println(result)


val totalAge2 = people.map {it.age}
  .sum()
// println(totalAge2)

val families = listOf(
  listOf(Person("Jack", 40), Person("Jill", 40)),
  listOf(Person("Eve", 18), Person("Adam", 18))
)
// println(families.size)
// println(families.flatten().size)


val namesAndReversed2 = people.map {it.firstName}
  .map(String::lowercase)
  .flatMap {listOf(it, it.reversed())}

// println(namesAndReversed2.size)


val namesSortedByAge = people.filter {it.age > 17}
  .sortedByDescending {it.age}
  .map {it.firstName}
// println(namesSortedByAge)

val groupBy1stLetter = people.groupBy ({it.firstName.first()}){
  it.firstName
}
// println(groupBy1stLetter)


fun isAudit(person: Person): Boolean {
  println("isAudit called for ${person.firstName}")
  return person.age > 17
}

fun fetchFirstName(person: Person): String{
  println("fetchFirstName called for ${person.firstName}")
  return person.firstName
}

// val nameOfFirstAudit = people.asSequence()
//   .filter(::isAudit)
//   .map(::fetchFirstName)
//   .toList()
// // println(nameOfFirstAudit)


fun isPrime(n: Long) = n > 1 && (2 until n).none{i -> n % i == 0L}

tailrec fun nextPrime(n: Long): Long =
  if(isPrime(n + 1)) n + 1 else nextPrime(n + 1)

val primes = generateSequence(5, ::nextPrime)

// println(primes.take(6).toList())


val primes2 = sequence {
  var i : Long = 0
  while(true) {
     i++

    if(isPrime(i)) {
      yield(i)
    }
  }
}
println(primes2.drop(2).take(6).toList())
println(primes2.drop(2).take(6).toList())
println(primes2.drop(2).take(6).toList())
