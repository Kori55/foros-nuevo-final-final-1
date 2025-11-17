package cl.duoc.foros.model

data class Moderador(
    val nombre : String = "",
    val correo : String = "",
    val clave : String = "",
    val terminos : Boolean = false,
    // object funcionesModeracion : FuncionesModeracion()
)
