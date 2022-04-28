package ni.edu.uca.peliculas50.bd.repository

import androidx.lifecycle.LiveData
import ni.edu.uca.peliculas50.bd.dao.GeneroDao
import ni.edu.uca.peliculas50.bd.entidades.ClasificacionEntity
import ni.edu.uca.peliculas50.bd.entidades.GeneroEntity

class GeneroRepository (private val dao: GeneroDao) {
    val listado : LiveData<List<GeneroEntity>> =
        dao.getAllRealData()
    suspend fun addGenero(genero: GeneroEntity){
        dao.insert(genero)
    }
    suspend fun updateGenero(genero: GeneroEntity){
        dao.update(genero)
    }
    suspend fun deleteGenero(genero: GeneroEntity){
        dao.delete(genero)
    }
    suspend fun deleteAll(){
        dao.deleteAll()
    }
}