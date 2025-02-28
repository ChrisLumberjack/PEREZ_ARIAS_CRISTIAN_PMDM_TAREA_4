package com.perez_arias_cristian_pmdm_tarea_4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configurar la Toolbar (Navbar)
        val toolbar = findViewById<MaterialToolbar>(R.id.top_navbar)
        setSupportActionBar(toolbar)

        // Configurar el ViewPager2 con TabLayout
        val viewPager2 = findViewById<ViewPager2>(R.id.view_pager)
        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)

        // Lista de títulos de pestañas
        val tabTitles = listOf("Personajes", "Mundos", "Coleccionables")

        // Crear un adaptador para ViewPager2
        val adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int = tabTitles.size
            override fun createFragment(position: Int) = when (position) {
                0 -> PersonajesFragment()
                1 -> MundosFragment()
                else -> ColeccionablesFragment()
            }
        }

        // Asignar adaptador al ViewPager2
        viewPager2.adapter = adapter

        // Sincronizar TabLayout con ViewPager2
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()

        // Cambiar título de la Toolbar al cambiar de pestaña
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                supportActionBar?.title = tabTitles[position]
            }
        })
    }
}
