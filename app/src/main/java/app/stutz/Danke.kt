package app.stutz

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_danke.*
import kotlinx.android.synthetic.main.content_danke.*

class Danke : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_danke)
        setSupportActionBar(toolbar)

        neue_spende.setOnClickListener( {
            startActivity(Intent("app.stutz.MAIN"))
        })
    }

    override fun onBackPressed() {
        startActivity(Intent("app.stutz.MAIN"))
    }

}
