package cl.duoc.foros.viewmodel

import androidx.lifecycle.ViewModel
import cl.duoc.foros.model.Usuario
import cl.duoc.foros.model.UsuarioErrores
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class UsuarioViewModel : ViewModel() {
    private val _estado = MutableStateFlow(Usuario())

    val estado : StateFlow<Usuario> = _estado

    fun onNombreChange(valor : String) {
        _estado.update { it.copy(nombre = valor, errores = it.errores.copy(nombre = null))}
    }

    fun onCorreoChange(valor : String) {
        _estado.update { it.copy(correo = valor, errores = it.errores.copy(correo = null))}
    }

    fun onClaveChange(valor : String) {
        _estado.update { it.copy(clave = valor, errores = it.errores.copy(clave = null))}
    }

    fun onTerminosChange(valor : Boolean) {
        _estado.update{it.copy ( terminos = valor)}
    }

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

    fun onBoxCLick() {

    }


}
