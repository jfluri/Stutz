package app.stutz

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.cell_detail_layout.view.*
import java.util.*

class PersonAdapter: ArrayAdapter<Person>  , Observer {

    override fun update(o: Observable?, arg: Any?) {
        val persons = arg as List<Person>
        this.clear()
        this.addAll(persons)
        this.notifyDataSetChanged()
        println("received update from Oberservable... " + persons.size)
    }

    constructor(context: Context, values: List<Person>) : super(context, R.layout.cell_detail_layout, values)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(this.context).inflate(R.layout.cell_detail_layout, parent, false)
        val person = this.getItem(position)

        view.title.text = person.name
        view.subtitle.text = person.region
        view.image.setImageResource(person.imageResId)
        return view
    }
}
