package com.example.contador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

private var contador: Int = 0
private lateinit var textoContador: TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        textoContador = findViewById(R.id.texto_contador)

        contador = intent.extras?.getInt("contador") ?:0
        textoContador.text = contador.toString()

        }
    }
