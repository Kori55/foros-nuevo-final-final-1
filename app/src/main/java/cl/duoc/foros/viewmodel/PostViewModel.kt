package cl.duoc.foros.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.duoc.foros.model.Publicacion
import cl.duoc.foros.model.Usuario
import cl.duoc.foros.repository.PostRepository
import cl.duoc.foros.repository.UsuarioRepository
// import cl.duoc.foros.repository.PostRepository
// import cl.duoc.foros.repository.UsuarioRepository
import cl.duoc.foros.view.Post
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PostViewModel(private val repository : PostRepository) : ViewModel() {

    private val _estado = MutableStateFlow(PostUIState())

    val estado : StateFlow<PostUIState> = _estado

    fun onTituloCHange(valor : String) {
        _estado.update { it.copy(titulo = valor, errores = it.errores.copy(titulo = null))}
    }

    fun onContenidoChange(valor : String) {
        _estado.update { it.copy(contenido = valor, errores = it.errores.copy(contenido = null))}
    }

    fun validarCasillas() : Boolean {
        val estadoActual = _estado.value
        val errores = PostErrores(
            titulo = if (estadoActual.titulo.isBlank()) "Titulo no puede estar vacio" else null,
            contenido = if (estadoActual.contenido.isBlank()) "Contenido no puede estar vacio" else null,
        )
        val hayErrores = listOfNotNull(
            errores.titulo,
            errores.contenido
        ).isNotEmpty()

        _estado.update {it.copy ( errores = errores) }

        return !hayErrores
    }

    fun crearPost() {
        val estadoActual = _estado.value
        viewModelScope.launch {
            val nuevoPost = Publicacion(
                // usuarioID = estadoActual.usuarioID,
                titulo = estadoActual.titulo,
                contenido = estadoActual.contenido,
                valoracion = 0
            )
            repository.insertarPost(nuevoPost)
        }
    }
}