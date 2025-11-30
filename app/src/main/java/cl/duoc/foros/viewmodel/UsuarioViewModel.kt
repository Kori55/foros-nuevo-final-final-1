package cl.duoc.foros.viewmodel

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.duoc.foros.model.Usuario
import cl.duoc.foros.repository.PostRepository
import cl.duoc.foros.repository.UsuarioRepository
// import cl.duoc.foros.repository.UsuarioRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.net.URI

// private val repository : UsuarioRepository
class UsuarioViewModel(private val repository : UsuarioRepository) : ViewModel() {

    private val _estado = MutableStateFlow(UsuarioUIState())
    private val _imagenUri = MutableStateFlow<Uri?>(repository.obtenerUsuario().imagenPerfil)
    val imagenUri: StateFlow<Uri?> = _imagenUri

    val estado : StateFlow<UsuarioUIState> = _estado

    fun onNombreChange(valor : String) {
        _estado.update { it.copy(nombre = valor, errores = it.errores.copy(nombre = null))}
    }

    fun onCorreoChange(valor : String) {
        _estado.update { it.copy(correo = valor, errores = it.errores.copy(correo = null))}
    }

    fun onClaveChange(valor : String) {
        _estado.update { it.copy(clave = valor, errores = it.errores.copy(clave = null))}
    }
    fun onModeradorCheck(valor : Boolean) {
        _estado.update{it.copy ( moderador = valor)}
    }

    fun onTerminosChange(valor : Boolean) {
        _estado.update{it.copy ( aceptaTerminos = valor)}
    }

/*

    fun borrarPost() : Boolean {
        val estadoActual = _estado.value
        val errores = UsuarioErrores(
            moderador = if (!estadoActual.moderador) true else null,
        )
        val hayErrores = listOfNotNull(
            errores.moderador
        ).isNotEmpty()

        _estado.update {it.copy ( errores = errores) }

        return !hayErrores
    }
    */

    fun validarCasillas() : Boolean {
        val estadoActual = _estado.value
        val errores = UsuarioErrores(
            // nombre = if (estadoActual.nombre.isBlank()) "Nombre no puede estar vacio" else null,
            correo = if (!estadoActual.correo.contains("@")) "Correo invalido" else null,
            clave = if (estadoActual.clave.length < 8) "Minimo 8 caracteres" else null,
        )
        val hayErrores = listOfNotNull(
            errores.correo,
            errores.clave
        ).isNotEmpty()

        _estado.update {it.copy ( errores = errores) }

        return !hayErrores
    }

    fun crearUsuario() {
        val estadoActual = _estado.value
        if (validarCasillas()) {
            viewModelScope.launch {
                val nuevoUsuario = Usuario(
                    nombre = estadoActual.nombre,
                    correo = estadoActual.correo,
                    clave = estadoActual.clave,
                    moderador = estadoActual.moderador,
                )
                repository.insertar(nuevoUsuario)
            }
        }
    }

    fun actualizarImagen(uri: URI?) {
        viewModelScope.launch {
            _imagenUri.value = uri as Uri?
            repository.updateImage(uri)
        }
    }


}
