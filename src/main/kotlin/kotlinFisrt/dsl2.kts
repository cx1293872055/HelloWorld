package kotlinFisrt

// "Release Planning" meeting{
//   start at 14.30
//   end by 15.20
// }
//
//
// infix fun String.meeting(block: () -> Unit) {
//   println("step 1 accomplished")
// }
//
// "Release Planning" meeting {}

open class MeetingTime(var time: String = "") {
  protected fun convertToString(time: Double) = String.format("%.02f", time)

}

class StartTime: MeetingTime() {
  infix fun at(theTime: Double) {
    time = convertToString(theTime)
  }
}

class EndTime: MeetingTime() {
  infix fun by(theTime: Double) {
    time = convertToString(theTime)
  }

}

class Meeting(val title: String) {
  val start = StartTime()
  val end = EndTime()

  override fun toString() = "$title Meeting starts ${start.time} end ${end.time}"

}

infix fun String.meeting(block: Meeting.() -> Unit) {
  val meeting = Meeting(this)

  meeting.block()

  println(meeting)
}

"Release Planning" meeting {
  start at 14.30
  end by 15.20
}