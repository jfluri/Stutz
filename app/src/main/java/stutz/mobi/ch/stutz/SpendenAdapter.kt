package stutz.mobi.ch.stutz

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.person_suche_resultat_layout.view.*
import kotlinx.android.synthetic.main.spende_suche_resultat_layout.view.*
import java.security.AccessControlContext

class SpendenAdapter: ArrayAdapter<Spende>  {

    constructor(context: Context, values:List<Spende>):super(context,R.layout.spende_suche_resultat_layout,values)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(this.context).inflate(R.layout.spende_suche_resultat_layout, parent,false)
        val dienstleisterId = this.getItem(position).dienstleisterId
        val dienstleister = DienstleisterRepo().get(dienstleisterId)
        view.gefundeneSpende.text = dienstleister.dienstleistung
        return view

    }
}
