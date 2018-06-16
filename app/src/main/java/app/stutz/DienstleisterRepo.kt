package app.stutz

import java.util.*

class DienstleisterRepo {

    val allDienstleister = listOf(
            Dienstleister(UUID.fromString("567dae99-7763-4781-b3fa-c7443894e342"),
                    "Sleeper",
                    "Übernachtung in Notschlafstelle",
                    "Bern",
                    5.00, "info@sleeper.be"),
            Dienstleister(UUID.fromString("b6231856-850b-47a3-bb4a-522cd514443c"),
                    "Löscher",
                    "Kaffee",
                    "Bern",
                    3.50, "info@loescher.be"),
            Dienstleister(UUID.fromString("593dfa65-b917-4e95-ad04-b8d6122eebaf"),
                    "Gassenküche",
                    "Abendessen",
                    "Bern",
                    5.00, "info@gassenkueche.be")
    )

    fun get(id: UUID): Dienstleister {
        return allDienstleister.find { it.id.equals(id) }!!
    }

    fun getByUsername(username: String): Dienstleister {
        return allDienstleister.find { it.email.equals(username) }!!
    }

}