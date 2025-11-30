package cl.duoc.foros.repository

import android.net.Uri
import cl.duoc.foros.model.Usuario
import cl.duoc.foros.model.UsuarioDAO
import java.net.URI

class UsuarioRepository(private val usuarioDAO: UsuarioDAO) {
    suspend fun obtenerUsuarios(): List<Usuario> = usuarioDAO.obtenerUsuarios()
    suspend fun insertar(usuario : Usuario) = usuarioDAO.insertar(usuario)
    suspend fun eliminar(usuario : Usuario) = usuarioDAO.eliminar(usuario)

    private var perfilActual = Usuario (
        id = 1,
        nombre = "usuario",
        imagenPerfil = null
    )

    fun obtenerUsuario() : Usuario = perfilActual
    fun updateImage(uri: URI?) {
        perfilActual = perfilActual.copy(imagenPerfil = uri as Uri)
    }
}