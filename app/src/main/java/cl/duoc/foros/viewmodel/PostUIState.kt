package cl.duoc.foros.viewmodel

data class PostUIState(
    val usuarioID : Int = 0,
    val titulo : String = "",
    val contenido : String = "",
    val valoracion : Int = 0,
    val errores : PostErrores = PostErrores()
)