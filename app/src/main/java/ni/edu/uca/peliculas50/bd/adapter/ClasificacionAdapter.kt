package ni.edu.uca.peliculas50.bd.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ni.edu.uca.peliculas50.bd.entidades.ClasificacionEntity
import ni.edu.uca.peliculas50.databinding.ListaClasificacionBinding
import ni.edu.uca.peliculas50.fragments.lista.ListaClasificacionFragmentDirections

class ClasificacionAdapter: RecyclerView.Adapter<ClasificacionAdapter.ClasificacionHolder>(){
    var listaClasif:List<ClasificacionEntity> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClasificacionHolder{
        val binding = ListaClasificacionBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ClasificacionHolder(binding)
    }

    override fun onBindViewHolder(holder: ClasificacionHolder, position: Int) : Unit =
        holder.bind(listaClasif[position])

    override fun getItemCount(): Int =listaClasif.size

    fun setData(cl: List<ClasificacionEntity>) {
        this.listaClasif = cl
        notifyDataSetChanged()
    }


    inner class ClasificacionHolder(val binding: ListaClasificacionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(cl : ClasificacionEntity){
            with(binding){
                TvIdClasificacion.text = cl.idClasificacion.toString()
                TvAbreviatura.text = cl.abreviacion
                TvNombres.text = cl.nombre

                ClFila.setOnClickListener{
                    val action= ListaClasificacionFragmentDirections.actualizarClasificacion(cl)
                    it.findNavController().navigate(action)
                }
            }
        }
    }
}