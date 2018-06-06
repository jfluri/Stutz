package stutz.mobi.ch.stutz

import java.util.*

class PersonRepo {

    val allPerson = listOf(Person( "Paul", "Bern", "file://paul.png", UUID.fromString("d56f7fdd-9dfa-4022-aa55-b14b480715ee")),
            Person("Peter", "Bern", "file://peter.png", UUID.fromString("83ed5bd9-5757-4b53-b5a6-c7a94eacac9c")),
            Person("Paula", "Ostermundigen", "file://paula.png", UUID.fromString("9432af4f-8c3d-42a5-8a16-dcb5359100fd")))

    fun search(name: String):List<Person> {
        return allPerson.filter { it.name.startsWith(name, true)}
    }

    fun get(id: UUID) : Person{
        return allPerson.find { it.id.equals(id) }!!
    }
}