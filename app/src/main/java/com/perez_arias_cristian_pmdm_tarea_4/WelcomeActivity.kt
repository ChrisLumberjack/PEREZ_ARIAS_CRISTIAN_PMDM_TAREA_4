package com.perez_arias_cristian_pmdm_tarea_4

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
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

        // Obtener SharedPreferences
        val sharedPreferences: SharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)

        // Referencias a los elementos de la UI
        val btnStartTutorial = findViewById<Button>(R.id.btn_start_tutorial)
        val btnSkipTutorial = findViewById<Button>(R.id.btn_scape_tutorial)
        val imgWelcome = findViewById<ImageView>(R.id.imgWelcome)

        // Configurar animaciones
        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        val fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out)
        btnStartTutorial.startAnimation(fadeIn)

        // Botón para iniciar el tutorial (guarda false en SharedPreferences)
        btnStartTutorial.setOnClickListener {
            saveGuidePreference(false)  // Guardar que el tutorial debe mostrarse
            startMainActivity(imgWelcome, fadeOut)  // Iniciar MainActivity con animación
        }

        // Botón para saltar el tutorial (guarda true en SharedPreferences)
        btnSkipTutorial.setOnClickListener {
            saveGuidePreference(true)  // Guardar que el tutorial NO debe mostrarse
            startMainActivity(imgWelcome, fadeOut)  // Iniciar MainActivity con animación
        }
    }

    private fun saveGuidePreference(isGuideShown: Boolean) {
        val sharedPreferences: SharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean("guide_shown", isGuideShown)
        editor.apply()
    }

    private fun startMainActivity(imgWelcome: ImageView, fadeOut: android.view.animation.Animation) {
        imgWelcome.startAnimation(fadeOut)

        fadeOut.setAnimationListener(object : android.view.animation.Animation.AnimationListener {
            override fun onAnimationStart(animation: android.view.animation.Animation?) {}
            override fun onAnimationRepeat(animation: android.view.animation.Animation?) {}
            override fun onAnimationEnd(animation: android.view.animation.Animation?) {
                val intent = Intent(this@WelcomeActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        })
    }
}
