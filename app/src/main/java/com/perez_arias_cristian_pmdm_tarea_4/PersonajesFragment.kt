package com.perez_arias_cristian_pmdm_tarea_4

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.perez_arias_cristian_pmdm_tarea_4.adapter.PersonajeAdapter
import com.perez_arias_cristian_pmdm_tarea_4.adapter.Personajes

class PersonajesFragment : Fragment(R.layout.fragment_personajes) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Obtener las vistas
        val bocadillo = view.findViewById<TextView>(R.id.bocadillo_info)
        val tabLayout = requireActivity().findViewById<TabLayout>(R.id.tab_layout)
        val iconoPersonajes: View? = tabLayout.getTabAt(0)?.view

        // Configurar RecyclerView con lista de personajes
        val personajes = listOf(
            Personajes("Spyro", getString(R.string.spyro), R.drawable.spyro),
            Personajes("Hunter", getString(R.string.hunter), R.drawable.hunter),
            Personajes("Elora", getString(R.string.elora), R.drawable.elora),
            Personajes("Ripto", getString(R.string.ripto), R.drawable.ripto)
        )

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerPersonajes)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = PersonajeAdapter(personajes)

        // Obtener SharedPreferences para verificar si la guía ya ha sido mostrada
        val sharedPreferences = requireContext().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
        val isGuideShown = sharedPreferences.getBoolean("guide_shown", false)

        // Mostrar u ocultar el bocadillo dependiendo del estado de la guía
        if (isGuideShown) {
            bocadillo.visibility = View.GONE
        } else {
            bocadillo.visibility = View.VISIBLE
        }

        // Asegurarnos de que el bocadillo se posicione correctamente
        iconoPersonajes?.post {
            val location = IntArray(2)
            iconoPersonajes.getLocationOnScreen(location)

            val x = location[0] + (iconoPersonajes.width / 2f) - (bocadillo.width / 5f)
            val y = (location[1] - bocadillo.height - 200).toFloat()

            bocadillo.x = x
            bocadillo.y = y
        }

        // Manejar clic en el bocadillo para cambiar a la pestaña "Mundos" y actualizar SharedPreferences
        bocadillo.setOnClickListener {
            bocadillo.visibility = View.GONE
            // Guardar el estado en SharedPreferences para que no se muestre de nuevo


            // Cambiar al fragmento en la posición 1 (Mundos)
            val viewPager2 = requireActivity().findViewById<ViewPager2>(R.id.view_pager)
            viewPager2.currentItem = 1 // Cambiar al fragmento en la posición 1 (Mundos)
        }
    }
}
