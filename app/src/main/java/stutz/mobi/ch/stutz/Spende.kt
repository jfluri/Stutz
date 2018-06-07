package stutz.mobi.ch.stutz

import java.time.LocalDateTime
import java.util.*

data class Spende(val id:UUID, val personId: UUID,  val dienstleisterId:UUID, val betrag:Double, val datum: Date)