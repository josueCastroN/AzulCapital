package com.example.azulcapital

import android.os.Bundle
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias a los elementos del layout
        val logo: ImageView = findViewById(R.id.logo)
        val logoText: TextView = findViewById(R.id.logo_text)

        // Animación para mover el logo hacia arriba
        val moveUp = ObjectAnimator.ofPropertyValuesHolder(
            logo,
            PropertyValuesHolder.ofFloat("translationY", -250f),
            PropertyValuesHolder.ofFloat("scaleX", 0.7f),
            PropertyValuesHolder.ofFloat("scaleY", 0.7f)
        )
        moveUp.duration = 1500

        // Animación para mover el texto hacia arriba
        val textMoveUp = ObjectAnimator.ofPropertyValuesHolder(
            logoText,
            PropertyValuesHolder.ofFloat("translationY", -250f),
            PropertyValuesHolder.ofFloat("alpha", 0f)
        // Desvanece el texto
        )
        textMoveUp.duration = 1500

        // Ejecutar la animación y luego abrir la siguiente pantalla
        moveUp.start()
        textMoveUp.start()

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, loginActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000) // Espera 2 segundos antes de cambiar de pantalla
    }

}


