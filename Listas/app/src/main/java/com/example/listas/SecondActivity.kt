package com.example.listas

import android.content.Intent
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listas.adapter.AdapterModelos
import com.example.listas.data.DataSet
import com.example.listas.database.DBHelper
import com.example.listas.database.SchemaDB
import com.example.listas.databinding.ActivitySecondBinding
import com.example.listas.model.Coche
import com.example.listas.model.Usuario
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
import com.google.android.material.snackbar.Snackbar



private lateinit var binding: ActivitySecondBinding
private lateinit var adaptadorLista: ArrayAdapter<Coche>
private lateinit var adaptadorModelos: AdapterModelos
private lateinit var openHelper: DBHelper

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        openHelper = DBHelper(applicationContext, SchemaDB.TAB_NAME, 1)
        adaptadorLista = ArrayAdapter(this, android.R.layout.simple_list_item_1, DataSet.getAllModelos())
        //binding.listviewModelos.adapter = adaptadorLista

        adaptadorModelos = AdapterModelos(openHelper.getCoches(),applicationContext)
        binding.recyclerModelos.adapter = adaptadorModelos
        binding.recyclerModelos.layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)

        binding.nombreUsuario.text =(intent.extras?.getSerializable("usuario") as Usuario).nombre
        binding.spinnerMarcas.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val marcaSeleccionada = parent!!.adapter.getItem(position).toString()
                val listaFiltrada = DataSet.getAllModelos().filter { it.marca.equals(marcaSeleccionada, true) }
                adaptadorLista.clear()
                adaptadorLista.addAll(listaFiltrada)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
        binding.botonFiltrar.setOnClickListener{
            //binding.spinnerMarcas.selectedItem
            val coche = Coche("Nuevo","Marca",30000,150, "")
            openHelper.agregarCoche(coche)
            adaptadorModelos.addCoche(coche)
        }
        /*binding.listviewModelos.setOnItemClickListener { parent, view, position, id ->
           //Snackbar.make(binding.root,listaCoches[position].precio.toString(),Snackbar.LENGTH_SHORT).show()
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("coche",DataSet.getAllModelos()[position])
            startActivity(intent)}
        binding.listviewModelos.setOnLongClickListener{
            Snackbar.make(binding.root,"${resources.getString(R.string.mensaje)}",Snackbar.LENGTH_SHORT).show()
            true
        }*/

    }
}
