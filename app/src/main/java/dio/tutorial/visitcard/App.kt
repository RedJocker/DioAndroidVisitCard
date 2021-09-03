package dio.tutorial.visitcard

import android.app.Application
import dio.tutorial.visitcard.data.AppDatabase
import dio.tutorial.visitcard.data.VisitCardRepository

class App : Application() {
    val database by lazy {
        AppDatabase.getDatabase(this)
    }
    val repository by lazy {
        VisitCardRepository(database.visitDao())
    }
}