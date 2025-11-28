package cl.duoc.foros.repository

import cl.duoc.foros.model.Publicacion
import cl.duoc.foros.model.PublicacionDAO

data class PostRepository(private val PostDao : PublicacionDAO) {
    suspend fun obtenerPosts(): List<Publicacion> = PostDao.obtenerPosts()
    suspend fun insertarPost(publicacion: Publicacion) = PostDao.insertarPost(publicacion)
    suspend fun eliminarPost(publicacion: Publicacion) = PostDao.eliminarPost(publicacion)
}