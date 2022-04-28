package ni.edu.uca.peliculas50.fragments.agregar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import ni.edu.uca.peliculas50.R
import ni.edu.uca.peliculas50.bd.entidades.ClasificacionEntity
import ni.edu.uca.peliculas50.bd.entidades.GeneroEntity
import ni.edu.uca.peliculas50.bd.viewmodels.ClasificacionViewModels
import ni.edu.uca.peliculas50.bd.viewmodels.GeneroViewModels
import ni.edu.uca.peliculas50.databinding.FragmentNuevaClasificacionBinding
import ni.edu.uca.peliculas50.databinding.FragmentNuevoGeneroBinding

class NuevoGeneroFragment : Fragment() {
    lateinit var fBinding: FragmentNuevoGeneroBinding
    private lateinit var viewModel: GeneroViewModels
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fBinding =
            FragmentNuevoGeneroBinding.inflate(layoutInflater)
        viewModel =
            ViewModelProvider(this).get(GeneroViewModels::class.java)
        fBinding.BtnGuardarGenero.setOnClickListener {
            guardarRegistro()
        }
        return fBinding.root
    }
    private fun guardarRegistro() {
        //val baseDatos = MainBaseDatos.getDataBase(this)
        val nomb = fBinding.itemNombreGenero.text.toString()

        //Crear objeto
        val gen = GeneroEntity(0,true ,nomb)

        //Agregar nuevo usuario
        viewModel.agregarGenero(gen)
        Toast.makeText(requireContext(), "Registro guardado",
            Toast.LENGTH_LONG).show()
        findNavController().navigate(R.id.ir_lista_Genero)
    }
}

