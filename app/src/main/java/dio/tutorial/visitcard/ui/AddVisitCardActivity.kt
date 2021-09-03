package dio.tutorial.visitcard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dio.tutorial.visitcard.databinding.ActivityAddVisitCardBinding

class AddVisitCardActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityAddVisitCardBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initializeListeners()
    }

    private fun initializeListeners(){
        binding.btnClose.setOnClickListener { finish() }
        binding.btnSubmit.setOnClickListener {  }
    }
}