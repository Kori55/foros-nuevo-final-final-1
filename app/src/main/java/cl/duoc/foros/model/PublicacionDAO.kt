
package cl.duoc.foros.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PublicacionDAO {
    @Query("SELECT * FROM posts ORDER BY postID DESC")
    suspend fun obtenerPosts() : List<Publicacion>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarPost(publicacion: Publicacion)

    @Delete
    suspend fun eliminarPost(publicacion: Publicacion)
}