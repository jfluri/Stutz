package app.stutz.dienstleister.model

import com.google.firebase.firestore.Exclude
import java.util.*

// https://stackoverflow.com/questions/46995080/how-do-i-get-the-document-id-for-a-firestore-document-using-kotlin-data-classes/46999773#46999773
data class Dienstleister(
        @get:Exclude var id: UUID,
        val name: String = "",
        val dienstleistung: String = "",
        val ort: String = "",
        val betrag: Double = 0.0,
        val email: String = ""
)
