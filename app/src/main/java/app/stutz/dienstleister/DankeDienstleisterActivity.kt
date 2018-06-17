package app.stutz.dienstleister

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import app.stutz.R

import kotlinx.android.synthetic.main.activity_danke.*
import kotlinx.android.synthetic.main.content_danke_dienstleister.*

class DankeDienstleisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_danke_dienstleister)
        setSupportActionBar(toolbar)

        zurueck.setOnClickListener {
            startActivity(Intent("app.stutz.SPENDEN_ANZEIGEN"))
        }
    }

    override fun onBackPressed() {
        startActivity(Intent("app.stutz.SPENDEN_ANZEIGEN"))
    }

}
