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
import ni.edu.uca.peliculas50.bd.adapter.GeneroAdapter
import ni.edu.uca.peliculas50.bd.viewmodels.GeneroViewModels
import ni.edu.uca.peliculas50.databinding.FragmentListaGeneroBinding


class ListaGeneroFragment : Fragment() {
    lateinit var fBinding: FragmentListaGeneroBinding
    private lateinit var viewModel : GeneroViewModels
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fBinding = FragmentListaGeneroBinding.inflate(layoutInflater)
        val adapter = GeneroAdapter()
        val recycleView = fBinding.RcvListaGenero
        recycleView.adapter = adapter
        recycleView.layoutManager =
            LinearLayoutManager(requireContext())
        viewModel =
            ViewModelProvider(this).get(GeneroViewModels::class.java)
        viewModel.lista.observe(viewLifecycleOwner, Observer
        {gen->
            adapter.setData(gen)
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
            BtnAgregarGenero.setOnClickListener {

                it.findNavController().navigate(R.id.nuevo_Genero)
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