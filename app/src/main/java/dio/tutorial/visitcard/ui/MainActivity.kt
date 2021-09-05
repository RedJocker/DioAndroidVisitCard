package dio.tutorial.visitcard.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import dio.tutorial.visitcard.App
import dio.tutorial.visitcard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val mainViewModel : MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }
    private val adapter by lazy {
        VisitCardAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rvCards.adapter = adapter
        getAllVisitCard()
        initializeListeners()
    }

    private fun initializeListeners(){
        binding.fab.setOnClickListener {
            val addVisitCardIntent = Intent(this@MainActivity,  AddVisitCardActivity::class.java)
            startActivity(addVisitCardIntent)
        }
    }

    private fun getAllVisitCard(){
        mainViewModel.getAll().observe(this) { visitCardsList  ->
            adapter.submitList(visitCardsList)
        }
    }
}