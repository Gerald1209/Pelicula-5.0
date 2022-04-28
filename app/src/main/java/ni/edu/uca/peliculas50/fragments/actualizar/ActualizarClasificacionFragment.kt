package ni.edu.uca.peliculas50.fragments.actualizar

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.lista_clasificacion.*
import ni.edu.uca.peliculas50.R
import ni.edu.uca.peliculas50.bd.entidades.ClasificacionEntity
import ni.edu.uca.peliculas50.bd.viewmodels.ClasificacionViewModels
import ni.edu.uca.peliculas50.databinding.FragmentActualizarClasificacionBinding


class ActualizarClasificacionFragment : Fragment() {
    lateinit var fBinding: FragmentActualizarClasificacionBinding
    private val args by navArgs<ActualizarClasificacionFragmentArgs>()
    private lateinit var viewModel: ClasificacionViewModels
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fBinding =
            FragmentActualizarClasificacionBinding.inflate(layoutInflater)
        viewModel =
            ViewModelProvider(this).get(ClasificacionViewModels::class.java)
        with(fBinding) {

            itemAbreviacion.setText(args.currentClasificacion.abreviacion)
            itemDescripcion.setText(args.currentClasificacion.nombre)
            BtnActualizarClasif.setOnClickListener {
                GuardarCambios()
            }
        }
        //Agregar menu
        setHasOptionsMenu(true)
        return fBinding.root
    }
    private fun GuardarCambios() {
        val abrev = fBinding.itemAbreviacion.text.toString()
        val nomb = fBinding.itemDescripcion.text.toString()

        if(abrev.isNotEmpty() && nomb.isNotEmpty())
        {
            //Crear el objeto
            val clasif =
                ClasificacionEntity(args.currentClasificacion.idClasificacion, abrev, true, nomb)
            //Actualizar
            viewModel.actualizarClasificacion(clasif)
            Toast.makeText(requireContext(), "Registro actualizado",
                Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.actualizar_Lista)
        }
        else
        {
            Toast.makeText(requireContext(), "Debe rellenar todos los campos", Toast.LENGTH_LONG).show()
        }
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater:
    MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        if (item.itemId == R.id.mnuEliminar) {
            eliminarClasificacion()
        }
        return super.onOptionsItemSelected(item)
    }
    private fun eliminarClasificacion() {
        val alerta = AlertDialog.Builder(requireContext())
        alerta.setPositiveButton("Si") { _, _ ->
            viewModel.eliminarClasificacion(args.currentClasificacion)
            Toast.makeText(
                requireContext(),
                "Registro eliminado satisfactoriamente...",
                Toast.LENGTH_LONG
            ).show()
            findNavController().navigate(R.id.actualizar_Lista)
        }
        alerta.setNegativeButton("No") { _, _ ->
            Toast.makeText(
                requireContext(),
                "Operación cancelada...",
                Toast.LENGTH_LONG
            ).show()
        }
        alerta.setTitle("Eliminando ${args.currentClasificacion.abreviacion}")
        alerta.setMessage("¿Esta seguro de eliminar a ${args.currentClasificacion.abreviacion}?")
        alerta.create().show()
    }

}