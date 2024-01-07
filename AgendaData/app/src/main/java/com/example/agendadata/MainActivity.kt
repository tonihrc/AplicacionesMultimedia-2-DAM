package com.example.agendadata

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.lifecycleScope
import com.example.agendadata.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonGuardar.setOnClickListener{
            //guardar el nombre y la edad en los data
            lifecycleScope.launch(Dispatchers.IO){
                guardarDatos(binding.editNombre.text.toString(),binding.editEdad.text.toString().toInt())
            }
        }
        binding.botonRecuperar.setOnClickListener{
            val dataFlow: Flow<String> = dataStore.data.map {
                it[stringPreferencesKey("name")] ?: "No hay nombre"
        }
            lifecycleScope.launch(Dispatchers.IO){
                Log.v("data_store",dataFlow.first())
            }
        }
    }
    suspend fun guardarDatos(nombre:String, edad:Int){
        dataStore.edit {
            it[stringPreferencesKey("name")]= nombre
            it[intPreferencesKey("age")]= edad

        }
    }
}