package cl.duoc.foros.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.duoc.foros.model.Publicacion
import cl.duoc.foros.model.Usuario
import cl.duoc.foros.repository.PostRepository
import cl.duoc.foros.repository.UsuarioRepository
import cl.duoc.foros.view.Post
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PostViewModel(private val repository : PostRepository) : ViewModel() {

    private val _estado = MutableStateFlow(Publicacion())

    val estado : StateFlow<Publicacion> = _estado

    fun crearPost() {
        val estadoActual = _estado.value
        viewModelScope.launch {
            val nuevoPost = Publicacion(
                usuarioID = estadoActual.usuarioID,
                contenido = estadoActual.contenido,
                valoracion = estadoActual.valoracion
            )
            repository.insertar(nuevoPost)
        }
    }
}