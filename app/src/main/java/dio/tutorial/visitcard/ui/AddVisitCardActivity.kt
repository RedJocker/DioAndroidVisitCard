package dio.tutorial.visitcard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import dio.tutorial.visitcard.App
import dio.tutorial.visitcard.R
import dio.tutorial.visitcard.data.VisitCard
import dio.tutorial.visitcard.databinding.ActivityAddVisitCardBinding

class AddVisitCardActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityAddVisitCardBinding.inflate(layoutInflater)
    }

    private val mainViewModel : MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initializeListeners()
    }

    private fun initializeListeners(){
        binding.btnClose.setOnClickListener { finish() }
        binding.btnSubmit.setOnClickListener {
            val visitCard = VisitCard(
                    name = (binding.tilName.editText?.text).toString(),
                    phone = (binding.tilPhone.editText?.text).toString(),
                    mail = (binding.tilMail.editText?.text).toString(),
                    company = (binding.tilCompany.editText?.text).toString(),
                    color = (binding.tilColor.editText?.text).toString()
            )

            mainViewModel.insert(visitCard)
            Toast.makeText(this, getString(R.string.label_show_sucess), Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}