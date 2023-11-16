package kotlinFisrt


// val format = "%-10s%-10s%-10s%-10s"
// val str = "context"
// val result = "RESULT"
//
// fun toString() = "lexical"
//
// println(String.format("%-10s%-10s%-10s%-10s%-10s", "Method", "Arugument", "Receiver", "Return", "Result"))
//
// println("====================================")
//
// val result1 = str.let {arg ->
//   print(String.format(format, "let", arg, this, result))
//   result
// }
//
//
// println(String.format("%-10s", result1))
//
// val result2 = str.also {arg ->
//   print(String.format(format, "also", arg, this, result))
//   result
// }
//
// println(String.format("%-10s", result2))
//
// val result3 = str.run {
//   print(String.format(format, "run", "N/A", this, result))
//   result
// }
// println(String.format("%-10s", result3))
//
// val result4 = str.apply {
//   print(String.format(format, "apply", "N/A", this, result))
//   result
// }
//
// println(String.format("%-10s", result4))




class Mailer{
  val details = StringBuilder()

  fun from(addr: String) = details.append("from $addr...\n")
  fun to(addr: String) = details.append("to $addr...\n")
  fun subject(line: String) = details.append("subject $line...\n")
  fun body(message: String) = details.append("body $message...\n")
  fun send() = "...sending...\n$details"
}


// val mailer = Mailer()
// mailer.from("builder@agiledeveloper.com")
// mailer.to("venkats@agiledeveloper.com")
// mailer.subject("Your code sucks")
// mailer.body("...details...")
//
// val result = mailer.send()
// println(result)

// val result = Mailer().run {
//   from("builder@agiledeveloper.com")
//   to("venkats@agiledeveloper.com")
//   subject("Your code sucks")
//   body("...details...")
//   send()
// }
// println(result)



fun createMailer() = Mailer()

fun perpareAndSend(mailer: Mailer) = mailer.run {
  from("builder@agiledeveloper.com")
  to("venkats@agiledeveloper.com")
  subject("Your code sucks")
  body("...details...")
  send()
}

// val mailer = createMailer()
// val result = perpareAndSend(mailer)

val result = createMailer().let(::perpareAndSend)
println(result)
