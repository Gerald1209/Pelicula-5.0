package ni.edu.uca.peliculas50.bd.repository
import androidx.lifecycle.LiveData
import ni.edu.uca.peliculas50.bd.dao.ClasificacionDao
import ni.edu.uca.peliculas50.bd.entidades.ClasificacionEntity

class ClasificacionRepository (private val dao: ClasificacionDao) {
    val listado : LiveData<List<ClasificacionEntity>> =
        dao.getAllRealData()
    suspend fun addClasificacion(clasificacion: ClasificacionEntity){
        dao.insert(clasificacion)
    }
    suspend fun updateClasificacion(clasificacion: ClasificacionEntity){
        dao.update(clasificacion)
    }
    suspend fun deleteClasificacion(clasificacion: ClasificacionEntity){
        dao.delete(clasificacion)
    }
    suspend fun deleteAll(){
        dao.deleteAll()
    }
}
