package com.perez_arias_cristian_pmdm_tarea_4.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.perez_arias_cristian_pmdm_tarea_4.R
import com.perez_arias_cristian_pmdm_tarea_4.adapter.Mundos

class MundosAdapter(private val mundosList: List<Mundos>) :
    RecyclerView.Adapter<MundosAdapter.MundosViewHolder>() {

    // ViewHolder
    class MundosViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imagenMundo: ImageView = view.findViewById(R.id.imgMundo)
        val nombreMundo: TextView = view.findViewById(R.id.txtNombreMundo)
        val descripcionMundo: TextView = view.findViewById(R.id.txtDescripcionMundo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MundosViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mundo, parent, false)
        return MundosViewHolder(view)
    }

    override fun onBindViewHolder(holder: MundosViewHolder, position: Int) {
        val mundo = mundosList[position]
        holder.imagenMundo.setImageResource(mundo.imagenResId)
        holder.nombreMundo.text = mundo.nombre
        holder.descripcionMundo.text = mundo.descripcion
    }

    override fun getItemCount(): Int {
        return mundosList.size
    }
}
