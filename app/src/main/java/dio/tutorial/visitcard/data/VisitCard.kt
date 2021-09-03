package dio.tutorial.visitcard.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class VisitCard(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val name: String,
    val phone: String,
    val mail: String,
    val company: String,
    val color: String
)
