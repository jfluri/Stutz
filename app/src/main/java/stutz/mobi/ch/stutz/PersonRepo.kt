package stutz.mobi.ch.stutz

class PersonRepo {

    val allPerson = listOf(Person("Paul", "Bern", "file://paul.png"),
            Person("Peter", "Bern", "file://peter.png"), Person("Paula", "Ostermundigen", "file://paula.png"))

    fun search(name: String):List<Person> {
        return allPerson.filter { it.name.startsWith(name, true)}
    }
}