package stutz.mobi.ch.stutz

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.person_suche_resultat_layout.view.*

class PersonAdapter: ArrayAdapter<Person>  {

    constructor(context: Context, values:List<Person>):super(context,R.layout.person_suche_resultat_layout,values)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(this.context).inflate(R.layout.person_suche_resultat_layout, parent,false)
        val person = this.getItem(position)
        view.name.text = person.name
        view.region.text = person.region

        view.imagePerson.setImageResource(person.imageResId)

        return view

    }
}
