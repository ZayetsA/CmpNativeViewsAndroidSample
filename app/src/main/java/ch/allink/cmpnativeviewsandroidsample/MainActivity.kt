package ch.allink.cmpnativeviewsandroidsample

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ch.allink.sample_cmp_app.ComposeActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setClickListeners()
    }

    private fun setClickListeners() {
        val toComposeBtn: Button? = findViewById<Button>(R.id.toCompose)
        toComposeBtn?.setOnClickListener {
            navigateToComposeActivity()
        }
    }

    private fun navigateToComposeActivity() {
        val intent = Intent(this, ComposeActivity::class.java)
        startActivity(intent)
    }
}