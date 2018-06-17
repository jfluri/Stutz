package app.stutz.spenden

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import app.stutz.R
import app.stutz.person.PersonRepo
import app.stutz.spenden.model.Spende

import kotlinx.android.synthetic.main.activity_select_spende.*
import kotlinx.android.synthetic.main.content_select_spende.*
import java.util.*

class SelectSpendeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_spende)
        setSupportActionBar(toolbar)

        val person = PersonRepo().get(UUID.fromString(this.intent.getStringExtra("app.stutz.EXTRA_PERSON_ID")))
        name.text = person.name
        location.text = person.region
        personImage.setImageResource(person.imageResId)

        sleeper.setOnClickListener {
            val spende = Spende(UUID.randomUUID(), person.id, UUID.fromString("567dae99-7763-4781-b3fa-c7443894e342"), 5.00)
            SpendeRepo.allSpenden.add(spende)
            startActivity(Intent("app.stutz.PAYMENT"))
        }

    }

}
