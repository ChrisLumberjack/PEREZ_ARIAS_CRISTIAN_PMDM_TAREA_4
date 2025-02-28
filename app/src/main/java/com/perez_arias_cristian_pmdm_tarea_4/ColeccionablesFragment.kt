package com.perez_arias_cristian_pmdm_tarea_4

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.VideoView
import androidx.fragment.app.Fragment

class ColeccionablesFragment : Fragment() {

    private lateinit var gemaImage: ImageView
    private lateinit var videoView: VideoView
    private lateinit var bocadillo: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el layout para este fragmento
        val view = inflater.inflate(R.layout.fragment_coleccionables, container, false)

        // Inicializar las vistas
        gemaImage = view.findViewById(R.id.gemaImage)
        videoView = view.findViewById(R.id.videoView)
        bocadillo = view.findViewById(R.id.bocadillo_info)

        // Comprobar si ya se han mostrado los bocadillos
        val sharedPreferences = requireActivity().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
        val isGuideShown = sharedPreferences.getBoolean("guide_shown", false)

        // Si no se han mostrado los bocadillos, los mostramos
        if (!isGuideShown) {
            bocadillo.visibility = View.VISIBLE
        } else {
            bocadillo.visibility = View.GONE
        }

        // Cuando el bocadillo se cierra, marcamos en SharedPreferences que ya ha sido mostrado
        bocadillo.setOnClickListener {
            bocadillo.visibility = View.GONE

            // Guardar en SharedPreferences que ya se mostró el bocadillo
            val editor = sharedPreferences.edit()
            editor.putBoolean("guide_shown", true)
            editor.apply()
        }

        // Configurar el VideoView
        val videoUri = Uri.parse("android.resource://" + requireActivity().packageName + "/" + R.raw.video) // Asegúrate de que el video esté en res/raw/

        gemaImage.setOnClickListener {
            // Cuando se hace clic en la gema, reproducir el video
            playVideo(videoUri)
        }

        return view
    }

    private fun playVideo(videoUri: Uri) {
        // Ocultar la gema
        gemaImage.visibility = View.GONE

        // Mostrar el VideoView
        videoView.visibility = View.VISIBLE

        // Configurar el VideoView
        videoView.setVideoURI(videoUri)

        // Reproducir el video
        videoView.setMediaController(null) // Si no necesitas controles (por ejemplo, para pantalla completa sin botones)
        videoView.start()

        // Configurar lo que sucede cuando el video termina
        videoView.setOnCompletionListener {
            // Volver a la pestaña de coleccionables (o la actividad principal si es necesario)
            // Puede que necesites hacer una navegación después de que termine el video
            Handler(Looper.getMainLooper()).postDelayed({
                // Aquí podrías redirigir a otro fragmento, o hacer algo más
            }, 1000) // Espera 1 segundo antes de redirigir (si es necesario)
        }
    }
}
