package app.stutz

import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.storage.FirebaseStorage
import java.util.*


class PersonRepo() {


    fun search(name: String):List<Person> {
        return getPerson().filter { it.name.startsWith(name, true)}
    }

    fun get(id: UUID) : Person {
        return getPerson().find { it.id.equals(id) }!!
    }

    fun getPerson(): MutableList<Person> {
        return PersonRepoStore.allPerson
    }

    companion object {
        init {
            if(!PersonRepoStore.initialized) {
                val storage = FirebaseStorage.getInstance()
                val store = FirebaseFirestore.getInstance()
                val settings = FirebaseFirestoreSettings.Builder()
                        .setTimestampsInSnapshotsEnabled(true)
                        .build()
                store.firestoreSettings = settings

                val docRef = store.collection("Person").document("d56f7fdd-9dfa-4022-aa55-b14b480715ee")

                docRef.collection("Person")

                val persList = mutableListOf<Person>()
                val firePersons = store.collection("Personen").get()
                firePersons.addOnCompleteListener(OnCompleteListener<QuerySnapshot> { task ->
                    if (task.isSuccessful) {
                        for(person in task.result) {
                            val personId = person.id
                            val name = person.get("name") as String
                            val region = person.get("region") as String
                            val documentRef = person.get("imageLink") as DocumentReference
                            val path = documentRef.path

                            var imageResId = 0
                            when {
                                path.endsWith("profilfoto3.png") -> imageResId = R.drawable.profilfoto3
                                path.endsWith("profilfoto2.png") -> imageResId = R.drawable.profilfoto2
                                path.endsWith("profilfoto1.png") -> imageResId = R.drawable.profilfoto1
                            }
                            val imageLink = path

                            // storage.reference.downloadUrl

                            val firePers = Person(name, region, imageLink, UUID.fromString(personId), imageResId)
                            persList.add(firePers)
                        }

                        println("Loaded Persons from Firestore: " + persList.size)

                        PersonRepoStore.initialized =  true
                        PersonRepoStore.hasChanged()
                        PersonRepoStore.updatePersonsAndNotify(persList)
                    }
                })
                        .addOnFailureListener(OnFailureListener { ex ->
                            println("Firestore Failure: " + ex.message)
                        })
            }
        }
    }

}