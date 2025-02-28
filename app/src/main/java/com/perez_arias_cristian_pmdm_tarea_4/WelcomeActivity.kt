package com.perez_arias_cristian_pmdm_tarea_4

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome)

        // Establecer los márgenes para los sistemas de barras (estatus y navegación)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Obtener el botón "Comenzar" y la imagen
        val btnStart = findViewById<Button>(R.id.btn_start_welcome)
        val imgWelcome = findViewById<ImageView>(R.id.imgWelcome)

        // Cargar la animación fadeIn para el botón
        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        btnStart.startAnimation(fadeIn)

        // Cargar la animación fadeOut para la imagen
        val fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out)

        // Acción al presionar el botón
        btnStart.setOnClickListener {
            // Iniciar la animación fadeOut en la imagen
            imgWelcome.startAnimation(fadeOut)

            // Esperar a que termine la animación y luego iniciar MainActivity
            fadeOut.setAnimationListener(object : android.view.animation.Animation.AnimationListener {
                override fun onAnimationStart(animation: android.view.animation.Animation?) {
                    // Puedes agregar algún comportamiento aquí cuando comience la animación
                }

                override fun onAnimationRepeat(animation: android.view.animation.Animation?) {
                    // Si la animación se repite, puedes agregar algo aquí
                }

                override fun onAnimationEnd(animation: android.view.animation.Animation?) {
                    // Iniciar MainActivity después de que termine la animación
                    val intent = Intent(this@WelcomeActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()  // Cerrar la actividad WelcomeActivity
                }
            })
        }
    }
}
