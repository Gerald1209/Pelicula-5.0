package ni.edu.uca.peliculas50.bd.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow
import ni.edu.uca.peliculas50.bd.entidades.GeneroEntity

@Dao
interface GeneroDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(genero: GeneroEntity)

    @Query("SELECT * FROM TblGenero")
    suspend fun getAll(): List<GeneroEntity>

    @Query("SELECT * FROM TblGenero")
    fun getAllRealData(): LiveData<List<GeneroEntity>>

    @Query("SELECT * FROM TblGenero WHERE idGenero = :id")
    suspend fun getById(id : Int) : GeneroEntity

    @Update
    suspend fun update(genero: GeneroEntity)

    @Delete
    suspend fun delete(genero: GeneroEntity)

    @Query("Delete from TblGenero")
    suspend fun deleteAll()
}