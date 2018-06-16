package app.stutz.person.suchen.model

import java.util.*

// mapping id from firestore too: https://stackoverflow.com/questions/46995080/how-do-i-get-the-document-id-for-a-firestore-document-using-kotlin-data-classes/46999773#46999773
data class Person( val name: String,
                   val region: String,
                   val imageLink: String,
                   val id:UUID,
                   val imageResId: Int)
