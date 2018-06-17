package app.stutz.spenden.model

import java.util.*

data class Spende(val id:UUID,
                  val personId: UUID,
                  val dienstleisterId:UUID,
                  val betrag:Double)