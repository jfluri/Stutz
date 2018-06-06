package stutz.mobi.ch.stutz

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.View
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_stutz_start.*

class StutzStart : AppCompatActivity() {

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = getMenuInflater()
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stutz_start)
        setSupportActionBar(toolbar2)

        person_suche_resultat.adapter = PersonAdapter(
                this,
                PersonRepo().search(nameSuchePerson.text.toString()))
        nameSuchePerson.addTextChangedListener(object:TextWatcher{
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val adapter = person_suche_resultat.adapter as ArrayAdapter<Person>
                adapter.clear()
                adapter.addAll(PersonRepo().search(s.toString()))
            }
        })

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        person_suche_resultat.setOnItemClickListener  {parent:Any,  view: View, position:Int, id:Long ->
            val person:Person = person_suche_resultat.adapter.getItem(position) as Person

            val i = Intent("stutz.mobi.ch.stutz.select_spende")
            i.putExtra("stutz.mobi.ch.stutz.EXTRA_PERSON_ID", person.id.toString())
            startActivity(i)
        }
    }

}
