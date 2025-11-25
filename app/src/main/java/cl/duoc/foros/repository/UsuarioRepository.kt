package cl.duoc.foros.repository

import cl.duoc.foros.model.Usuario
import cl.duoc.foros.model.UsuarioDAO

class UsuarioRepository(private val dao: UsuarioDAO) {
    suspend fun obtenerUsuarios(): List<Usuario> = dao.obtenerUsuarios()
    suspend fun insertar(usuario : Usuario) = dao.insertar(usuario)
    suspend fun eliminar(usuario : Usuario) = dao.eliminar(usuario)
}