package dio.tutorial.visitcard.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dio.tutorial.visitcard.data.VisitCard
import dio.tutorial.visitcard.data.VisitCardRepository

class MainViewModel(private val visitCardRepository: VisitCardRepository): ViewModel() {

    fun insert(visitCard: VisitCard){
        visitCardRepository.insert(visitCard)
    }
    fun getAll(): LiveData<List<VisitCard>> {
        return visitCardRepository.getAll()
    }
}

class MainViewModelFactory(private val repository: VisitCardRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }

        throw  IllegalArgumentException("Unknown ViewModel class")
    }

}