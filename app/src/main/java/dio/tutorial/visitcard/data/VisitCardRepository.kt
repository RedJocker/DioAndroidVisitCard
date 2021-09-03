package dio.tutorial.visitcard.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.launch

class VisitCardRepository(private val dao: VisitCardDao) {

    fun insert(visitCard: VisitCard) = runBlocking {
        launch(Dispatchers.IO) {
            dao.insert(visitCard)
        }
    }

    fun getAll() = dao.getAll()
}