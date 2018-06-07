package stutz.mobi.ch.stutz


import java.util.*

object SpendeRepo {

    var allSpenden = mutableListOf(
            Spende(UUID.fromString("ed67b912-8161-477a-a081-558f12cdfa74"), UUID.fromString("d56f7fdd-9dfa-4022-aa55-b14b480715ee"), UUID.fromString("567dae99-7763-4781-b3fa-c7443894e342"), 5.00, Date()),
            Spende(UUID.fromString("77aab1a1-5e6a-4b5e-a6ab-0925e21e0c09"), UUID.fromString("83ed5bd9-5757-4b53-b5a6-c7a94eacac9c"), UUID.fromString("b6231856-850b-47a3-bb4a-522cd514443c"), 3.50, Date()),
            Spende(UUID.fromString("86c96ea7-0a6a-46d4-938f-c6fdf48aa936"), UUID.fromString("9432af4f-8c3d-42a5-8a16-dcb5359100fd"), UUID.fromString("593dfa65-b917-4e95-ad04-b8d6122eebaf"), 5.00, Date()),
            Spende(UUID.fromString("77aab1a1-5e6a-4b5e-a6ab-0925e21e0c09"), UUID.fromString("83ed5bd9-5757-4b53-b5a6-c7a94eacac9c"), UUID.fromString("567dae99-7763-4781-b3fa-c7443894e342"), 5.00, Date()),
            Spende(UUID.fromString("86c96ea7-0a6a-46d4-938f-c6fdf48aa936"), UUID.fromString("9432af4f-8c3d-42a5-8a16-dcb5359100fd"), UUID.fromString("567dae99-7763-4781-b3fa-c7443894e342"), 5.00, Date())
    )

    fun search(name: String, dienstleister: Dienstleister?):List<Spende> {
        return allSpenden.filter { it ->
            val person = PersonRepo().get(it.personId)
             person.name.startsWith(name, true) && dienstleister != null && dienstleister.id.equals(it.dienstleisterId)
        }
    }

    fun get(id: UUID) : Spende{
        return allSpenden.find { it.id.equals(id) }!!
    }

    fun remvoe() {

    }

    fun remove(spende: Spende) {
        allSpenden.remove(spende)
    }

}