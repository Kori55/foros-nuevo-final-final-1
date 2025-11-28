package cl.duoc.foros.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import cl.duoc.foros.viewmodel.PostErrores

@Entity(tableName = "posts")
data class Publicacion(
    @PrimaryKey(autoGenerate = true)
    val postID : Int = 0,
    val usuarioID : Int = 0,
    val titulo : String = "",
    val contenido : String = "",
    val valoracion : Int = 0
)
