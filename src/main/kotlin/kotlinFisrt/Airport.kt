package kotlinFisrt

import com.beust.klaxon.Json
import com.beust.klaxon.Klaxon
import kotlinx.coroutines.Job
import java.net.URL
import kotlin.system.measureTimeMillis

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


fun main() {
  val airportCodes = listOf("LAX", "SF-", "PD", "SEA")

  val jobs: List<Job> = air
}