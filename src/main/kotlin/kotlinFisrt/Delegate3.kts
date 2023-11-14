package kotlinFisrt

import kotlin.properties.Delegates


fun getTemperature(city: String): Double {
  println("fetch from webservice for $city")
  return 30.0
}


val showTemperature = false
val city = "Boulder"

// if(showTemperature && getTemperature(city) > 20)
//   println("Warm")
// else
//   println("Nothing to report")

// 使使用by lazy 关键字可以在真正使用到这个参数的时候才去执行对应的表达式求值
// attention
// val temperature by lazy {getTemperature(city)}
//
// if(showTemperature && temperature > 20)
//   println("Warm")
// else
//   println("Nothing to report")


// var count by Delegates.observable(0){
//   property, oldValue, newValue ->
//   println("Property: $property old: $oldValue: new: $newValue")
// }
//
// println("The value of count is :$count")
//
// count ++
//
// println("The value of count is :$count")
//
// count --
// println("The value of count is :$count")

var count by Delegates.vetoable(0){property, oldValue, newValue -> newValue > oldValue}

println("The value of count is: $count")

count ++


println("The value of count is: $count")

count --

println("The value of count is: $count")
