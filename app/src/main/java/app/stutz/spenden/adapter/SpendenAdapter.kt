package app.stutz.spenden.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import app.stutz.R
import app.stutz.dienstleister.DienstleisterRepo
import app.stutz.person.PersonRepo
import app.stutz.spenden.model.Spende
import kotlinx.android.synthetic.main.cell_detail_layout.view.*

class SpendenAdapter : ArrayAdapter<Spende> {

    constructor(context: Context, values: List<Spende>) : super(context, -1, values)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(this.context).inflate(R.layout.cell_detail_layout, parent, false)
        val spende = this.getItem(position)
        val dienstleister = DienstleisterRepo().get(spende.dienstleisterId)
        val person = PersonRepo().get(spende.personId)

        view.title.text = dienstleister.dienstleistung
        view.subtitle.text = person.name
        view.image.setImageResource(person.imageResId)
        return view
    }
}
