package app.stutz.dienstleister.model

import java.util.*

data class Dienstleister(val id: UUID,
                         val name:String,
                         val dienstleistung:String,
                         val ort:String,
                         val betrag:Double,
                         val email: String )


