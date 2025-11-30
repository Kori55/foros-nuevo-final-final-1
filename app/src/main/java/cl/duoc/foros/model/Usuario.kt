package cl.duoc.foros.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import cl.duoc.foros.viewmodel.UsuarioErrores

@Entity(tableName = "usuarios")
data class Usuario(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nombre : String = "",
    val correo : String = "",
    val clave : String = "",
    val terminos : Boolean = false,
    val moderador : Boolean = false
)
