package ni.edu.uca.peliculas50.bd.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ni.edu.uca.peliculas50.bd.dao.MainDataBase
import ni.edu.uca.peliculas50.bd.entidades.ClasificacionEntity
import ni.edu.uca.peliculas50.bd.repository.ClasificacionRepository

class ClasificacionViewModels (application: Application):AndroidViewModel(application) {
    val lista : LiveData<List<ClasificacionEntity>>
    private val repository: ClasificacionRepository
    init {
        val clasificacionDao =
            MainDataBase.getDataBase(application).clasificacionDao()
        repository = ClasificacionRepository(clasificacionDao)
        lista = repository.listado
    }
    fun agregarClasificacion(clasificacion: ClasificacionEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addClasificacion(clasificacion)
        }
    }
    fun actualizarClasificacion(clasificacion: ClasificacionEntity){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateClasificacion(clasificacion)
        }
    }
    fun eliminarClasificacion(clasificacion: ClasificacionEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteClasificacion(clasificacion)
        }
    }
    fun eliminarTodo(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAll()
        }
    }
}

