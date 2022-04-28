package ni.edu.uca.peliculas50.fragments.actualizar

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import ni.edu.uca.peliculas50.R
import ni.edu.uca.peliculas50.bd.entidades.ClasificacionEntity
import ni.edu.uca.peliculas50.bd.entidades.GeneroEntity
import ni.edu.uca.peliculas50.bd.viewmodels.ClasificacionViewModels
import ni.edu.uca.peliculas50.bd.viewmodels.GeneroViewModels
import ni.edu.uca.peliculas50.databinding.FragmentActualizarClasificacionBinding
import ni.edu.uca.peliculas50.databinding.FragmentActualizarGeneroBinding


class ActualizarGeneroFragment : Fragment() {
    lateinit var fBinding: FragmentActualizarGeneroBinding
    private val args by navArgs<ActualizarGeneroFragmentArgs>()
    private lateinit var viewModel: GeneroViewModels
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fBinding =
            FragmentActualizarGeneroBinding.inflate(layoutInflater)
        viewModel =
            ViewModelProvider(this).get(GeneroViewModels::class.java)
        with(fBinding) {

            itemNombreGenero.setText(args.currentGenero.nombre)
            BtnActualizarGenero.setOnClickListener {
                GuardarCambios()
            }
        }
        //Agregar menu
        setHasOptionsMenu(true)
        return fBinding.root
    }
    private fun GuardarCambios() {
        val nomb = fBinding.itemNombreGenero.text.toString()

        if (nomb.isNotEmpty())
        {
            //Crear el objeto
            val gen =
                GeneroEntity(args.currentGenero.idGenero, true, nomb)
            //Actualizar
            viewModel.actualizarGenero(gen)
            Toast.makeText(requireContext(), "Registro actualizado",
                Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.actualizar_ListaGen)
        }
        else
        {
            Toast.makeText(requireContext(), "Debe rellenar todos los campos", Toast.LENGTH_LONG).show()
        }


    }
    override fun onCreateOptionsMenu(menu: Menu, inflater:
    MenuInflater
    ) {
        inflater.inflate(R.menu.delete_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        if (item.itemId == R.id.mnuEliminar) {
            eliminarGenero()
        }
        return super.onOptionsItemSelected(item)
    }
    private fun eliminarGenero() {
        val alerta = AlertDialog.Builder(requireContext())
        alerta.setPositiveButton("Si") { _, _ ->
            viewModel.eliminarClasificacion(args.currentGenero)
            Toast.makeText(
                requireContext(),
                "Registro eliminado satisfactoriamente...",
                Toast.LENGTH_LONG
            ).show()
            findNavController().navigate(R.id.actualizar_ListaGen)
        }
        alerta.setNegativeButton("No") { _, _ ->
            Toast.makeText(
                requireContext(),
                "Operación cancelada...",
                Toast.LENGTH_LONG
            ).show()
        }
        alerta.setTitle("Eliminando ${args.currentGenero.nombre}")
        alerta.setMessage("¿Esta seguro de eliminar a ${args.currentGenero.nombre}?")
        alerta.create().show()
    }
}