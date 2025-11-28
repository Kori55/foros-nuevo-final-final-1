package cl.duoc.foros.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Usuario::class, Publicacion::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun usuarioDao() : UsuarioDAO
    abstract fun publicacionDao() : PublicacionDAO

    companion object {
        @Volatile
        private var INSTANCE : AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "mi_basedatos.db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}