package ni.edu.uca.peliculas50.bd.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ni.edu.uca.peliculas50.bd.dao.MainDataBase
import ni.edu.uca.peliculas50.bd.entidades.ClasificacionEntity
import ni.edu.uca.peliculas50.bd.entidades.GeneroEntity
import ni.edu.uca.peliculas50.bd.repository.ClasificacionRepository
import ni.edu.uca.peliculas50.bd.repository.GeneroRepository

class GeneroViewModels (application: Application): AndroidViewModel(application) {
    val lista : LiveData<List<GeneroEntity>>
    private val repository: GeneroRepository
    init {
        val generoDao =
            MainDataBase.getDataBase(application).generoDao()
        repository = GeneroRepository(generoDao)
        lista = repository.listado
    }
    fun agregarGenero(genero: GeneroEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addGenero(genero)
        }
    }
    fun actualizarGenero(genero: GeneroEntity){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateGenero(genero)
        }
    }
    fun eliminarClasificacion(genero: GeneroEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteGenero(genero)
        }
    }
    fun eliminarTodo(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAll()
        }
    }
}