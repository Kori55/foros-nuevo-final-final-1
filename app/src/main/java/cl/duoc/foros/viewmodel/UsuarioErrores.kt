package cl.duoc.foros.viewmodel

data class UsuarioErrores(
    val nombre : String ? = null,
    val correo : String? = null,
    val clave : String? = null,
    val moderador : Boolean? = null
)