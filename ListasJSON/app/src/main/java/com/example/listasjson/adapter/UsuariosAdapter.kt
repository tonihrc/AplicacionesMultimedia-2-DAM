package com.example.listasjson.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.listasjson.R
import com.example.listasjson.modelo.User
import com.google.android.material.snackbar.Snackbar

class UsuariosAdapter(var lista: ArrayList<User>, var contexto: Context): RecyclerView.Adapter<UsuariosAdapter.MyHoder>(){
    class MyHoder(item: View): RecyclerView.ViewHolder(item){
        var imagen: ImageView
        var nombre: TextView

        init{
            imagen = item.findViewById(R.id.imagen_fila)
            nombre = item.findViewById(R.id.nombre_fila)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHoder {
       val vista: View = LayoutInflater.from(contexto).inflate(R.layout.item_recycler, parent, false)
        return MyHoder(vista)
    }

    override fun getItemCount(): Int {
      return lista.size
    }

    override fun onBindViewHolder(holder: MyHoder, position: Int) {
        val usuario : User = lista.get(position)
        holder.nombre.text = usuario.name
        Glide.with(contexto).load(usuario.picture).into(holder.imagen)
        holder.imagen.setOnClickListener{
            Snackbar.make(holder.imagen, usuario.email, Snackbar.LENGTH_LONG).show()
        }
    }
}

