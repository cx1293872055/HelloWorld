package kotlinFisrt

import com.beust.klaxon.Json
import com.beust.klaxon.Klaxon
import kotlinx.coroutines.*
import java.net.URL

/**
 * @author chenxin
 * @date 2023/11/20 星期一 18:57
 */


class Weather(@Json(name = "Temp") val temperature: Array<String>)

class Airport(
  @Json(name = "IATA") val code: String,
  @Json(name = "Name") val name: String,
  @Json(name = "Delay") val delay: Boolean,
  @Json(name = "Weather") val weather: Weather
){

  companion object{
    fun getAirportData(code: String): Airport?{
      val url = "https://soa.smext.faa.gov/asws/api/airport/status/$code"
      return Klaxon().parse<Airport>(URL(url).readText())
    }
  }
}


// fun main() {
//   val format = "%-10s%-20s%-10s"
//   println(String.format(format, "Code", "Temperature", "Delay"))
//
//   val time = measureTimeMillis {
//     val airportCodes = listOf("LAX", "SFO", "PDX", "SEA")
//
//     val airportData: List<Airport> =
//       airportCodes.mapNotNull {anAirportCode->
//         Airport.getAirportData(anAirportCode)
//       }
//
//     airportData.forEach {anAirport->
//       println(
//         String.format(
//           format, anAirport.code,
//           anAirport.weather.temperature.get(0), anAirport.delay
//         )
//       )
//     }
//   }
//   println("Time taken $time ms")
//
// }


// fun main() {
//   runBlocking {
//     val exceptionHandler = CoroutineExceptionHandler {context, ex ->
//       println("Caught: ${context[CoroutineName]} ${ex.message?.substring(0..28)}")
//     }
//     try {
//
//       val airportCodes = listOf("LAX", "SF-", "PD", "SEA")
//
//       val jobs: List<Job> = airportCodes.map {anAirportCode ->
//         launch(Dispatchers.IO + exceptionHandler +SupervisorJob()) {
//           val airport = Airport.getAirportData(anAirportCode)
//           println("${airport?.code} deplay: ${airport?.delay}")
//         }
//       }
//
//       jobs.forEach {it.join()}
//       jobs.forEach {println("Cancelled: ${it.isCancelled}")}
//
//     } catch(ex: Exception) {
//       println("ERROR:${ex.message}")
//
//     }
//   }
// }
//
//
fun main() {
  runBlocking {
    val airportCodes = listOf("LAX", "SF-", "PD", "SEA")

    val airportData = airportCodes.map {
      anAirportCode ->
      async(Dispatchers.IO + SupervisorJob()) {
        Airport.getAirportData(anAirportCode)
      }
    }

    for(airportData in airportData) {
      try {
        val airport = airportData.await()

        println("${airport?.code} ${airport?.delay}")
      } catch(ex: Exception) {
        println("Error : ${ex.message?.substring(0..28)}")
      }
    }
  }
}