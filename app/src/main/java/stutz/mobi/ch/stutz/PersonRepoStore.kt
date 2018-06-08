package stutz.mobi.ch.stutz

import java.util.*


object PersonRepoStore : Observable() {

    var allPerson = mutableListOf<Person>(
//            Person( "Paul", "Bern", "file://paul.png", UUID.fromString("d56f7fdd-9dfa-4022-aa55-b14b480715ee"), R.drawable.profilfoto1),
//            Person("Peter", "Bern", "file://peter.png", UUID.fromString("83ed5bd9-5757-4b53-b5a6-c7a94eacac9c"), R.drawable.profilfoto2),
//            Person("Paula", "Ostermundigen", "file://paula.png", UUID.fromString("9432af4f-8c3d-42a5-8a16-dcb5359100fd"), R.drawable.profilfoto3)
    )

    var initialized = false;

    fun updatePersonsAndNotify(persons : List<Person>) {
        allPerson.clear()
        allPerson.addAll(persons)
        setChanged()
        notifyObservers(persons)
        println("notify observers...")
    }

}