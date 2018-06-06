package stutz.mobi.ch.stutz

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_select_spende.*
import java.util.*

class SelectSpende : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_spende)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        val person = PersonRepo().get(UUID.fromString(this.intent.getStringExtra("stutz.mobi.ch.stutz.EXTRA_PERSON_ID")))

    }


}
