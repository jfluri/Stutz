package app.stutz

import java.util.*

data class Spende(val id:UUID,
                  val personId: UUID,
                  val dienstleisterId:UUID,
                  val betrag:Double)