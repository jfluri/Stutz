package app.stutz.dienstleister.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot

class DienstleisterAdapter : RecyclerView.Adapter<DienstleisterAdapter.ViewHolder>(), EventListener<QuerySnapshot> {

    override fun onEvent(p0: QuerySnapshot?, p1: FirebaseFirestoreException?) {
        TODO("not implemented")
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("not implemented")
    }

    override fun getItemCount(): Int {
        TODO("not implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("not implemented")
    }


    class ViewHolder : RecyclerView.ViewHolder {
        constructor(itemView: View): super(itemView)
    }

}