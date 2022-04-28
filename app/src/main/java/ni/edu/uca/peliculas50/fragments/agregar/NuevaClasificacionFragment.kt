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
import ni.edu.uca.peliculas50.bd.viewmodels.ClasificacionViewModels
import ni.edu.uca.peliculas50.databinding.FragmentNuevaClasificacionBinding


class NuevaClasificacionFragment : Fragment() {

    lateinit var fBinding: FragmentNuevaClasificacionBinding
    private lateinit var viewModel: ClasificacionViewModels
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fBinding =
            FragmentNuevaClasificacionBinding.inflate(layoutInflater)
        viewModel =
            ViewModelProvider(this).get(ClasificacionViewModels::class.java)
        fBinding.BtnGuardarClasif.setOnClickListener {
            guardarRegistro()
        }
        return fBinding.root
    }
    private fun guardarRegistro() {
        //val baseDatos = MainBaseDatos.getDataBase(this)
        val abrev = fBinding.itemAbreviacion.text.toString()
        val nomb = fBinding.itemDescripcion.text.toString()

        if(abrev.isNotEmpty() && nomb.isNotEmpty())
        {
            //Crear objeto
            val clasif = ClasificacionEntity(0, abrev,true ,nomb)

            //Agregar nuevo usuario
            viewModel.agregarClasificacion(clasif)
            Toast.makeText(requireContext(), "Registro guardado",
                Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.ir_lista_Clasificacion)
        }
        else
        {
            Toast.makeText(requireContext(), "Debe rellenar todos los campos", Toast.LENGTH_LONG).show()
        }


    }
}

