package kotlinFisrt

class Counter{

  fun map(mapper: (Counter) -> Counter) = mapper(this)

  companion object{
    fun create()  = Counter()
  }
}