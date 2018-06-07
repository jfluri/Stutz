package stutz.mobi.ch.stutz

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.ArrayAdapter

import kotlinx.android.synthetic.main.activity_spenden_anzeigen_und_suchen.*
import kotlinx.android.synthetic.main.activity_stutz_start.*

class SpendenAnzeigenUndSuchenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spenden_anzeigen_und_suchen)
        setSupportActionBar(toolbar)


        listSpenden.adapter = SpendenAdapter(
                this,
                SpendeRepo().search(sucheSpendenNachName.text.toString()))
        sucheSpendenNachName.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val adapter = listSpenden.adapter as ArrayAdapter<Spende>
                adapter.clear()
                adapter.addAll(SpendeRepo().search(s.toString()))
            }
        })


        listSpenden.setOnItemClickListener  { parent:Any, view: View, position:Int, id:Long ->
            val spende:Spende = listSpenden.adapter.getItem(position) as Spende

         //   val i = Intent("stutz.mobi.ch.stutz.select_spende")
         //   i.putExtra("stutz.mobi.ch.stutz.EXTRA_SPENDE_ID", spende.id.toString())
         //   startActivity(i)
        }

    }

}
