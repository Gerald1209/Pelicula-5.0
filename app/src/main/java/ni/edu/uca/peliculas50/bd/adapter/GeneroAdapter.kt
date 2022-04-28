package ni.edu.uca.peliculas50.bd.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import ni.edu.uca.peliculas50.bd.entidades.GeneroEntity
import ni.edu.uca.peliculas50.databinding.ListaGeneroBinding
import ni.edu.uca.peliculas50.fragments.lista.ListaClasificacionFragmentDirections
import ni.edu.uca.peliculas50.fragments.lista.ListaGeneroFragment
import ni.edu.uca.peliculas50.fragments.lista.ListaGeneroFragmentDirections

class GeneroAdapter: RecyclerView.Adapter<GeneroAdapter.GeneroHolder>(){
    var listaGen:List<GeneroEntity> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GeneroHolder {
        val binding = ListaGeneroBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return GeneroHolder(binding)
    }

    override fun onBindViewHolder(holder: GeneroHolder, position: Int) : Unit =
        holder.bind(listaGen[position])

    override fun getItemCount(): Int =listaGen.size

    fun setData(gn: List<GeneroEntity>) {
        this.listaGen = gn
        notifyDataSetChanged()
    }


    inner class GeneroHolder(val binding: ListaGeneroBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(gn: GeneroEntity){
            with(binding){
                TvIdGenero.text = gn.idGenero.toString()
                TvNombreGen.text = gn.nombre


                ClFilaGen.setOnClickListener{
                    val action= ListaGeneroFragmentDirections.actualizarGenero(gn)
                    it.findNavController().navigate(action)
                }
            }
        }
    }
}