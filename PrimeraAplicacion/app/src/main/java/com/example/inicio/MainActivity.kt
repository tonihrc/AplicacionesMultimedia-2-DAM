package com.example.inicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var botonPulsar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botonPulsar = this.findViewById(R.id.boton_pulsar)
        botonPulsar.setOnClickListener {
           Snackbar.make(it, "Práctica Completada.", Snackbar.LENGTH_LONG).show()
        }
    }
}