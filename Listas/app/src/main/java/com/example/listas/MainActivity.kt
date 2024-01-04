package com.example.listas

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listas.databinding.ActivityMainBinding
import com.example.listas.model.Usuario
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonLogin.setOnClickListener {
            if (binding.editUsuario.text.toString().equals("Admin", true)
                && binding.editPass.text.toString().equals("admin")) {
            val intent = Intent(applicationContext, SecondActivity::class.java)
                intent.putExtra("usuario",Usuario(binding.editUsuario.text.toString(),binding.editPass.text.toString()))
                startActivity(intent)
            } else {
                Snackbar.make(binding.root,"Error en los datos.",Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}