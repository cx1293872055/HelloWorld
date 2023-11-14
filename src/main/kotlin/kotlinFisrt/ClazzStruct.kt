package kotlinFisrt

/**
 * @author chenxin
 * @date 2023/11/13 星期一 13:53
 */

interface Remote {
  fun up()
  fun down()

  fun doubleUp() {
    up()
    up()
  }

  companion object {
    fun combine(first: Remote, second: Remote): Remote = object: Remote {
      override fun up() {
        first.up()
        second.up()
      }

      override fun down() {
        first.down()
        second.down()
      }
    }
  }
}

class TV {
  var volume = 0

  // 匿名内部类
  // 直接在方法中实现，不能使用inner 关键字
  val remote: Remote
    get() = object: Remote {
      override fun up() {
        volume++
      }

      override fun down() {
        volume--
      }
    }

  // 嵌套内部类
  // inner class TVRemote: Remote{
  //   override fun up() {
  //     volume ++
  //   }
  //
  //   override fun down() {
  //     volume --
  //   }
  //
  //   override fun toString()= "Remote: ${this@TV.toString()}"
  // }


}

// class TVRemote(val tv: TV): Remote {
//   override fun up() {
//     tv.volume++
//   }
//
//   override fun down() {
//     tv.volume--
//   }
// }

// fun main() {
//   val tv = TV()
//   val remote = TVRemote(tv)
//   val anotherTV = TV()
//
//   val combine = Remote.combine(remote, TVRemote(anotherTV))
//   combine.up()
//   println(tv.volume)
//   println(anotherTV.volume)
// }

abstract class Musician(val name: String, val activeFrom: Int) {
  abstract fun instrumentType(): String
}

class Cellist(name: String, activeFrom: Int): Musician(name, activeFrom) {
  override fun instrumentType() = "String"
}

// fun main() {
//   val ma = Cellist("Yo-Yo ma", 1961)
//
// }


open class Vehicle(val year: Int, open var color: String) {
  open val km = 0

  override fun toString() = "year: $year, Color: $color , KM: $km"

  fun repaint(newColor: String) {
    color = newColor
  }
}

open class Car11(year: Int, color: String): Vehicle(year, color) {
  override var km: Int = 0
    set(value) {
      if(value < 1) {
        throw RuntimeException("can't set negative value")
      }

      field = value
    }

  fun drive(distance: Int) {
    km += distance
  }
}


class FamilyCar(year: Int, color: String): Car11(year, color) {
  override var color: String
    get() = super.color
    set(value) {
      if(value.isEmpty()) {
        throw RuntimeException("Color required")
      }

      super.color = value
    }
}


// fun main() {
//   val car = Car11(2019, "Orange")
//   println(car.year)
//   println(car.color)
//   car.drive(10)
//
//   println(car)
//   try {
//     car.drive(-30)
//
//   } catch(ex: RuntimeException) {
//     println(ex.message)
//
//   }
//
// }


// fun main() {
//   val familyCar = FamilyCar(2019, "Green")
//   println(familyCar.color)
//   try {
//     familyCar.repaint("")
//   } catch(ex: RuntimeException) {
//     println(ex.message)
//   }
//
// }

enum class Suit(val symbol: Char) {
  CLUBS('\u2663'),
  DIAMONDS('\u2666'),
  HEARTS('\u2665') {
    override fun display() = "${super.display()} $symbol"
  },
  SPADES('\u2660');

  open fun display() = "$symbol $name"
}

sealed class Card(val suit: Suit)

class Ace(suit: Suit): Card(suit)

class King(suit: Suit): Card(suit) {
  override fun toString() = "Kong of $suit"
}


class Queen(suit: Suit): Card(suit) {
  override fun toString() = "Queen of $suit"
}

class Jack(suit: Suit): Card(suit) {
  override fun toString() = "jJack of $suit"
}

class Pip(suit: Suit, val number: Int): Card(suit) {
  init {
    if(number < 2 || number > 10) {
      throw RuntimeException("Pip has to be between 2 and 10")
    }
  }
}

fun process(card: Card) = when(card) {
  is Ace -> "${card.javaClass.name} of ${card.suit}"
  is King, is Queen, is Jack -> "$card"
  is Pip -> "${card.number} of ${card.suit}"
}


fun main() {
  // println(process(Ace(Suit.DIAMONDS)))
  // println(process(Queen(Suit.CLUBS)))
  // println(process(Pip(Suit.SPADES, 2)))
  // println(process(Pip(Suit.HEARTS, 6)))

  // val valueOf = Suit.valueOf("DIAMONDS")
  // println(valueOf)

  for(suit in Suit.values()) {
    println(suit.display())
  }
}



