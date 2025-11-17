package cl.duoc.foros.model

data class Usuario(
    val nombre : String = "",
    val correo : String = "",
    val clave : String = "",
    val terminos : Boolean = false,
    val errores : UsuarioErrores = UsuarioErrores()
)
