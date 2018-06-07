package stutz.mobi.ch.stutz

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        try {
            // Simulate network access.
            Thread.sleep(500)
        } catch (e: InterruptedException) {
        }
        startActivity(Intent(this, StutzStart::class.java))
        finish()
    }

}
