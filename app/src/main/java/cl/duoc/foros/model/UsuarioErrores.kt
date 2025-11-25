package cl.duoc.foros.model

data class UsuarioErrores(
    val nombre : String ? = null,
    val correo : String? = null,
    val clave : String? = null,
    val moderador : Boolean? = null
)
