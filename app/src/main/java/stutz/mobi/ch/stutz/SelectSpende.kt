package stutz.mobi.ch.stutz

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_select_spende.*
import kotlinx.android.synthetic.main.content_select_spende.*
import kotlinx.android.synthetic.main.content_select_spende.view.*
import java.util.*

class SelectSpende : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_spende)
        setSupportActionBar(toolbar)

        val person = PersonRepo().get(UUID.fromString(this.intent.getStringExtra("stutz.mobi.ch.stutz.EXTRA_PERSON_ID")))
        name.text = person.name
        location.text = person.region
        personImage.setImageResource(person.imageResId)

        sleeper.setOnClickListener({
            val spende = Spende(UUID.randomUUID(), person.id, UUID.fromString("567dae99-7763-4781-b3fa-c7443894e342"), 5.00, Date())
            SpendeRepo.allSpenden.add(spende)
            startActivity(Intent("stutz.mobi.ch.stutz.PAYMENT"))
        })

    }

}
