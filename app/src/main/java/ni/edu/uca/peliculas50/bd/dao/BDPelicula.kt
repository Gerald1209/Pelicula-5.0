package ni.edu.uca.peliculas50.bd.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
//import ni.edu.uca.peliculas50.dao.*
//import ni.edu.uca.peliculas50.entities.*
import ni.edu.uca.peliculas50.bd.entidades.ClasificacionEntity
import ni.edu.uca.peliculas50.bd.entidades.GeneroEntity

interface MainDataBaseProvider{
    fun clasificacionDao() : ClasificacionDao
    fun generoDao(): GeneroDao
}
@Database(
    entities = [ClasificacionEntity::class, GeneroEntity::class],version =2)
abstract class MainDataBase: RoomDatabase(), MainDataBaseProvider {
    abstract override fun clasificacionDao(): ClasificacionDao
    abstract override fun generoDao():GeneroDao


    companion object {
        @Volatile
        private var INSTANCE: MainDataBase? = null
        fun getDataBase(context: Context): MainDataBase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MainDataBase::class.java,
                        "main_db"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}