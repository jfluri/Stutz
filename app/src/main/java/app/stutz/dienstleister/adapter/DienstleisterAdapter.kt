package app.stutz.dienstleister.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.google.firebase.firestore.*

class DienstleisterAdapter : RecyclerView.Adapter<DienstleisterAdapter.ViewHolder>, EventListener<QuerySnapshot> {

    val query: Query
    val spendeSelectedListener : OnSpendeSelectedListener

    interface OnSpendeSelectedListener {

        fun onSpendeSelected(spende: DocumentSnapshot)

    }

    constructor(query: Query, spendeSelectedListener: OnSpendeSelectedListener) : super() {
        this.query = query
        this.spendeSelectedListener = spendeSelectedListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("not implemented")
    }

    override fun onEvent(querySnapshot: QuerySnapshot?, ex: FirebaseFirestoreException?) {
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