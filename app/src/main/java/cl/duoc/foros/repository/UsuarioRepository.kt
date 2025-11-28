package cl.duoc.foros.repository

import cl.duoc.foros.model.Usuario
import cl.duoc.foros.model.UsuarioDAO

class UsuarioRepository(private val usuarioDAO: UsuarioDAO) {
    suspend fun obtenerUsuarios(): List<Usuario> = usuarioDAO.obtenerUsuarios()
    suspend fun insertar(usuario : Usuario) = usuarioDAO.insertar(usuario)
    suspend fun eliminar(usuario : Usuario) = usuarioDAO.eliminar(usuario)
}