package app.stutz

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter

import kotlinx.android.synthetic.main.activity_spenden_anzeigen_und_suchen.*

class SpendenAnzeigenUndSuchenActivity : AppCompatActivity() {

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = getMenuInflater()
        inflater.inflate(R.menu.menudienstleiter, menu)
        return true
    }

    fun logoutclicked(menuItem: MenuItem) {
        LoginStore.dienstleister = null
        val intent = Intent("app.stutz.MAIN")
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spenden_anzeigen_und_suchen)
        setSupportActionBar(toolbarSpendeSuche)


        listSpenden.adapter = SpendenAdapter(
                this,
                SpendeRepo.search(sucheSpendenNachName.text.toString(), LoginStore.dienstleister))
        sucheSpendenNachName.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val adapter = listSpenden.adapter as ArrayAdapter<Spende>
                adapter.clear()
                adapter.addAll(SpendeRepo.search(s.toString(), LoginStore.dienstleister))
            }
        })


        listSpenden.setOnItemClickListener  { parent:Any, view: View, position:Int, id:Long ->
            val spende = listSpenden.getItemAtPosition(position) as Spende
            SpendeRepo.remove(spende)
            startActivity(Intent("app.stutz.DANKE_DIENSTLEISTER"))
        }

    }

}
