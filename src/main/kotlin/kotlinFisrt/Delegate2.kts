package kotlinFisrt

import kotlin.reflect.KProperty

// var comment: String = "Some nice message"
// println(comment)
//
// comment = "This is stupid"
// println(comment)
//
// println("comment is of length: ${comment.length}")

// class PoliteString(var content: String){
//   operator fun getValue(thisRef: Any?, property: KProperty<*>) =
//     content.replace("stupid", "x****")
//
//   operator fun setValue(thisRef: Any, property: KProperty<*>, value: String){
//     content = value
//   }
// }
//
// fun beingpolite(content: String) = PoliteString(content)
//
// var comment: String by beingpolite("Some nice message")
// println(comment)
//
// comment = "This is stupid"
// println(comment)
//
// println("comment is of length: ${comment.length}")

class PoliteString(val dataSource: MutableMap<String, Any>){
  operator fun getValue(thisRef: Any?, property: KProperty<*>): String{
    println(property)
    return (dataSource[property.name] as? String)?.replace("stupid", "s****") ?: ""
  }
  operator fun setValue(thisRef: Any, property: KProperty<*>, value: String){
    println(property)
    dataSource[property.name] = value
  }
}


class PostComment(dataSource: MutableMap<String, Any>){
  val title: String by dataSource
  var likes: Int by dataSource
  val comment: String by PoliteString(dataSource)

  override fun toString() = "Title:: $title Likes: $likes Comment: $comment"
}


var data = listOf(
  mutableMapOf(
    "title" to "Using Delegation",
    "likes" to 2,
    "comment" to "Keep it simple, stupid"
  ),
  mutableMapOf(
    "title" to "Using Inheritance",
    "likes" to 1,
    "comment" to "Prefer Delegation where possible"
  )
)

val forPost1 = PostComment(data[0] as MutableMap<String, Any>)
val forPost2 = PostComment(data[1] as MutableMap<String, Any>)

forPost1.likes ++
println(forPost1.title)
println(forPost1.comment)

println(data[0])




// println(forPost1)
// println(forPost2)
