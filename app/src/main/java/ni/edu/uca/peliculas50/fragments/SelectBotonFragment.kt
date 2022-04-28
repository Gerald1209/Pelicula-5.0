package ni.edu.uca.peliculas50.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import ni.edu.uca.peliculas50.R
import ni.edu.uca.peliculas50.databinding.FragmentSelectBotonBinding

class SelectBotonFragment : Fragment() {

    lateinit var binding: FragmentSelectBotonBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSelectBotonBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        with(binding){

            btnClasificacion.setOnClickListener {
                it.findNavController().navigate(R.id.De_Botones_a_Lista_Clasificacion)
            }

            btnGenero.setOnClickListener {
                it.findNavController().navigate(R.id.De_Botones_a_Lista_Genero)
            }

        }
    }
}