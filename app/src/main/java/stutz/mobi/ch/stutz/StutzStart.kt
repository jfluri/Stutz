package stutz.mobi.ch.stutz

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter

import kotlinx.android.synthetic.main.activity_stutz_start.*

class StutzStart : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stutz_start)

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
    }

}
