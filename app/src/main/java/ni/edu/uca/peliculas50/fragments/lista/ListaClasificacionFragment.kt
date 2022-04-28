package ni.edu.uca.peliculas50.fragments.lista

import ni.edu.uca.peliculas50.R
import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ni.edu.uca.peliculas50.bd.adapter.ClasificacionAdapter
import ni.edu.uca.peliculas50.bd.viewmodels.ClasificacionViewModels
import ni.edu.uca.peliculas50.databinding.FragmentListaClasificacionBinding

class ListaClasificacionFragment : Fragment() {
    lateinit var fBinding: FragmentListaClasificacionBinding
    private lateinit var viewModel : ClasificacionViewModels
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fBinding = FragmentListaClasificacionBinding.inflate(layoutInflater)
        val adapter = ClasificacionAdapter()
        val recycleView = fBinding.RcvListaClasificacion
        recycleView.adapter = adapter
        recycleView.layoutManager =
            LinearLayoutManager(requireContext())
        viewModel =
            ViewModelProvider(this).get(ClasificacionViewModels::class.java)
        viewModel.lista.observe(viewLifecycleOwner, Observer
        {clasi->
            adapter.setData(clasi)
        })
        //Agregar el menu
        setHasOptionsMenu(true)
        return fBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState:
    Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }
    private fun setupViews() {
        with(fBinding) {
            BtnAgregarClasificacion.setOnClickListener {

                it.findNavController().navigate(R.id.nueva_Clasificacion)
            }
        }
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater:
    MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        if (item.itemId == R.id.mnuEliminar) {
            eliminarTodo()
        }
        return super.onOptionsItemSelected(item)
    }
    private fun eliminarTodo() {
        val alerta = AlertDialog.Builder(requireContext())
        alerta.setPositiveButton("Si") { _, _ ->
            viewModel.eliminarTodo()
            Toast.makeText(
                requireContext(),
                "Registros eliminados satisfactoriamente...",
                Toast.LENGTH_LONG
            ).show()
        }
        alerta.setNegativeButton("No") { _, _ ->
            Toast.makeText(
                requireContext(),
                "Operación cancelada...",
                Toast.LENGTH_LONG
            ).show()
        }
        alerta.setTitle("Eliminando todos los registro")
        alerta.setMessage("¿Esta seguro de eliminar los registros?")
                alerta.create().show()
    }

}