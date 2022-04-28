package ni.edu.uca.peliculas50.bd.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow
import ni.edu.uca.peliculas50.bd.entidades.ClasificacionEntity

@Dao
interface ClasificacionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(clasificacion: ClasificacionEntity)

    @Query("SELECT * FROM TblCalasificacion")
    suspend fun getAll(): List<ClasificacionEntity>

    @Query("SELECT * FROM TblCalasificacion")
    fun getAllRealData(): LiveData<List<ClasificacionEntity>>

    @Query("SELECT * FROM TblCalasificacion WHERE idClasificacion = :id")
    suspend fun getById(id : Int) : ClasificacionEntity

    @Update
    suspend fun update(clasificacion: ClasificacionEntity)

    @Delete
    suspend fun delete(clasificacion: ClasificacionEntity)

    @Query("Delete from TblCalasificacion")
    suspend fun deleteAll()


}