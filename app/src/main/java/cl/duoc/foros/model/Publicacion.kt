package cl.duoc.foros.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts")
data class Publicacion(
    @PrimaryKey(autoGenerate = true) val postID : Int = 0,
    val usuarioID : Int = 0,
    val contenido : String = "",
    val valoracion : Int = 0,
)
