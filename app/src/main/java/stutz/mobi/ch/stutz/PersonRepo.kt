package stutz.mobi.ch.stutz

import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*


class PersonRepo {

    val allPerson = mutableListOf<Person>(
//            Person( "Paul", "Bern", "file://paul.png", UUID.fromString("d56f7fdd-9dfa-4022-aa55-b14b480715ee"), R.drawable.profilfoto1),
//            Person("Peter", "Bern", "file://peter.png", UUID.fromString("83ed5bd9-5757-4b53-b5a6-c7a94eacac9c"), R.drawable.profilfoto2),
//            Person("Paula", "Ostermundigen", "file://paula.png", UUID.fromString("9432af4f-8c3d-42a5-8a16-dcb5359100fd"), R.drawable.profilfoto3)
    )

    constructor() {
        val store = FirebaseFirestore.getInstance()
        val docRef = store.collection("Person").document("d56f7fdd-9dfa-4022-aa55-b14b480715ee")

        docRef.collection("Person")


        val person = store.collection("Person").document("d56f7fdd-9dfa-4022-aa55-b14b480715ee")
        person.get().addOnCompleteListener(OnCompleteListener<DocumentSnapshot> { task ->
            if (task.isSuccessful) {
                val doc = task.result
                val fields = StringBuilder("")
                fields.append("Name: ").append(doc.get("Name"))
                fields.append("\nEmail: ").append(doc.get("Email"))
                fields.append("\nPhone: ").append(doc.get("Phone"))
//                textDisplay.setText(fields.toString())
            }
        })
                .addOnFailureListener(OnFailureListener { })


        /*
        val reference = FirebaseDatabase.getInstance().reference

        val personListener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                snapshot.children.mapNotNullTo(allPerson) {
                    it.getValue<Person>(Person::class.java)
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }
        }

//        val singleReadListener = object :
//        reference.addListenerForSingleValueEvent(singleReadListener);

//        reference.addValueEventListener(personListener)
        reference.addListenerForSingleValueEvent(personListener)

        val dbRef = reference.child("Person")
        val p2 = dbRef.child("d56f7fdd-9dfa-4022-aa55-b14b480715ee")
        */
        println("")
    }


    fun search(name: String):List<Person> {
        return allPerson.filter { it.name.startsWith(name, true)}
    }

    fun get(id: UUID) : Person{
        return allPerson.find { it.id.equals(id) }!!
    }



}