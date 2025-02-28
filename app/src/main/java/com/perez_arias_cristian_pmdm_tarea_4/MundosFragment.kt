package com.perez_arias_cristian_pmdm_tarea_4

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayout
import com.perez_arias_cristian_pmdm_tarea_4.adapter.Mundos
import com.perez_arias_cristian_pmdm_tarea_4.adapter.MundosAdapter

class MundosFragment : Fragment(R.layout.fragment_mundos) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Obtener las vistas
        val textMundos = view.findViewById<TextView>(R.id.text_mundos)
        val gifSpyro = view.findViewById<ImageView>(R.id.gif_spyro)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerMundos)
        val bocadillo = view.findViewById<TextView>(R.id.bocadillo_info)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val mundosList = listOf(
            Mundos("Artisans", getString(R.string.artisans), R.drawable.artesans),
            Mundos("Peace Keepers", getString(R.string.peace_keepers), R.drawable.peace),
            Mundos("Magic Crafters", getString(R.string.magic_crafters), R.drawable.magic_crafters),
            Mundos("Beast Makers", getString(R.string.beast_makers), R.drawable.beast_makers),
            Mundos("Dream Weavers", getString(R.string.dream_weavers), R.drawable.dream_weavers)
        )

        // Configurar el adapter del RecyclerView
        val adapter = MundosAdapter(mundosList)
        recyclerView.adapter = adapter

        // Cargar animaciones
        val fadeIn = AnimationUtils.loadAnimation(requireContext(), R.anim.fade_in)
        val slideUp = AnimationUtils.loadAnimation(requireContext(), R.anim.slide_up)

        textMundos.visibility = View.VISIBLE
        gifSpyro.visibility = View.VISIBLE

        // Verificar si la guía ya fue mostrada a través de SharedPreferences
        val sharedPreferences = requireContext().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
        val isGuideShown = sharedPreferences.getBoolean("guide_shown", false)

        // Mostrar u ocultar el bocadillo dependiendo del estado de la guía
        if (isGuideShown) {
            bocadillo.visibility = View.GONE
            textMundos.visibility = View.GONE
            gifSpyro.visibility = View.GONE
        } else {
            bocadillo.visibility = View.VISIBLE
        }

        // Posicionar el bocadillo respecto al icono de personajes en el TabLayout
        val tabLayout = requireActivity().findViewById<TabLayout>(R.id.tab_layout)
        val iconoPersonajes: View? = tabLayout.getTabAt(0)?.view

        if (iconoPersonajes != null) {
            iconoPersonajes.post {
                val location = IntArray(2)
                iconoPersonajes.getLocationOnScreen(location)

                val x = location[0] + (iconoPersonajes.width / 2f) - (bocadillo.width / 80f)
                val y = (location[1] - bocadillo.height - 280).toFloat()

                bocadillo.x = x
                bocadillo.y = y
            }
        }

        bocadillo.setOnClickListener {
            // Ocultar el bocadillo y guardar el estado en SharedPreferences
            bocadillo.visibility = View.GONE


            // Cambiar al fragmento "Mundos"
            val viewPager2 = requireActivity().findViewById<ViewPager2>(R.id.view_pager)
            viewPager2.currentItem = 2 // Cambiar al fragmento en la posición 2 (Coleccionables)
        }

        // Aplicar animación al TextView cuando el fragmento se muestre
        textMundos.startAnimation(fadeIn)

        // Reproducir un sonido cuando el fragmento se carga
        val mediaPlayer = MediaPlayer.create(requireContext(), R.raw.sound_effect) // Asegúrate de agregar el archivo en 'res/raw/'
        mediaPlayer.start()

        // Configurar un Easter Egg animado (cambio de posición al presionar el texto)
        textMundos.setOnClickListener {
            val easterEggSound = MediaPlayer.create(requireContext(), R.raw.easter_egg_sound)
            easterEggSound.start()

            // Iniciar animación de movimiento (por ejemplo, desplazamiento hacia arriba)
            textMundos.startAnimation(slideUp)

            // Configuración del Easter Egg: hacer algo divertido, como cambiar el texto
            textMundos.text = "¡Entraste en los Mundos de Spyro the Dragon! 🎉"
            textMundos.setTextColor(resources.getColor(android.R.color.holo_green_light))
            textMundos.setTextColor(resources.getColor(android.R.color.holo_green_light))

            // Reproducir un sonido de Easter Egg (opcional)

            textMundos.visibility = View.GONE
            gifSpyro.visibility = View.VISIBLE
            bocadillo.visibility = View.VISIBLE
            Glide.with(requireContext()).asGif().load(R.drawable.spyro_gif1).into(gifSpyro)

            Handler(Looper.getMainLooper()).postDelayed({
                gifSpyro.visibility = View.GONE
            }, 5000)
        }
    }
}
