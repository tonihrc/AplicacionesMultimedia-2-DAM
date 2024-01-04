package com.example.contador

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), OnClickListener{

    private lateinit var botonIncremento: Button
    private lateinit var botonDecremento: Button
    private var botonPasar: Button? = null
    private lateinit var textoContador: TextView;
    private var contador: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        contador = savedInstanceState?.getInt("contador")?:0

        botonPasar = findViewById(R.id.boton_pasar)
        botonIncremento = findViewById(R.id.boton_incremento)
        botonDecremento = findViewById(R.id.boton_decremento)
        textoContador = findViewById(R.id.texto_contador)
        textoContador.text = contador.toString()
        botonIncremento.setOnClickListener(this)
        botonDecremento.setOnClickListener(this)
        botonPasar?.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.boton_incremento -> {
               contador ++
            }
            R.id.boton_decremento -> {
                contador --
            }
            R.id.boton_pasar -> {
                val intent: Intent = Intent(applicationContext, SecondActivity::class.java)
                intent.putExtra("contador", contador)
                startActivity(intent)
            }
        }
        textoContador.text = contador.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("contador", contador)
    }
}