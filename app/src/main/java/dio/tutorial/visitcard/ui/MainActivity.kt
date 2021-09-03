package dio.tutorial.visitcard.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dio.tutorial.visitcard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initializeListeners()
    }

    private fun initializeListeners(){
        binding.fab.setOnClickListener {
            val addVisitCardIntent = Intent(this@MainActivity,  AddVisitCardActivity::class.java)
            startActivity(addVisitCardIntent)
        }
    }
}