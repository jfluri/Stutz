package stutz.mobi.ch.stutz

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.person_suche_resultat_layout.view.*
import java.security.AccessControlContext

class PersonAdapter: ArrayAdapter<Person>  {

    constructor(context: Context, values:List<Person>):super(context,R.layout.person_suche_resultat_layout,values)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(this.context).inflate(R.layout.person_suche_resultat_layout, parent,false)
        view.gefundenePerson.text = this.getItem(position).name
        return view

    }
}
