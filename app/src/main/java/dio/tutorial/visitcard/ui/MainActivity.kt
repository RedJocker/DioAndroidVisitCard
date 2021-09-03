package dio.tutorial.visitcard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dio.tutorial.visitcard.R
import dio.tutorial.visitcard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}