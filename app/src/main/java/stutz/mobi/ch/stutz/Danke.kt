package stutz.mobi.ch.stutz

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_danke.*
import kotlinx.android.synthetic.main.content_danke.*

class Danke : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_danke)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        neue_spende.setOnClickListener( {
            startActivity(Intent("stutz.mobi.ch.stutz.MAIN"))
        })
    }

    override fun onBackPressed() {
        startActivity(Intent("stutz.mobi.ch.stutz.MAIN"))
    }

}
