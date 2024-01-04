package com.example.listas.data

import com.example.listas.model.Coche

class DataSet {

    companion object{
        fun getAllModelos(): ArrayList<Coche>{
            val listaCoches = ArrayList<Coche>()
            listaCoches.add(Coche("Mondeo","Ford", 20000, 150, "https://img.remediosdigitales.com/054749/ford-mondeo-2022-04/1366_2000.jpeg"))
            listaCoches.add(Coche("Focus","Ford", 10000, 100, "https://www.ford.es/content/dam/guxeu/es_es/nameplate/focus/2021/overview/overview/3-4-focus-5dr-2021.png/_jcr_content/renditions/cq5dam.web.1280.1280.png"))
            listaCoches.add(Coche("Ibiza","Seat", 22000, 80, "https://motor.elpais.com/wp-content/uploads/2016/07/seat-ibiza-cupra-1000x616.jpg"))
            listaCoches.add(Coche("Leon","Seat", 10000, 110, "https://noticias.coches.com/wp-content/uploads/2017/12/seat_leon-cupra-r-2017_r2.jpg"))
            listaCoches.add(Coche("Fiesta","Seat", 15000, 150, "https://media.ford.com/content/fordmedia/feu/es/es/news/2017/05/16/el-ford-fiesta-fue-el-coche-mas-vendido-en-europa-en-marzo--con-/jcr:content/image.img.881.495.jpg/1500214971677.jpg"))
            listaCoches.add(Coche("C220","Mercedes", 30000, 250,"https://images.ctfassets.net/uaddx06iwzdz/2rdlGXQM59BXorYvxAGH34/54ae90ee010cb260e3cb37acb821acd4/mercedes-benz-c-220-l-02.jpg"))
            listaCoches.add(Coche("Vitto","Mercedes", 50000, 150,"https://e00-elmundo.uecdn.es/assets/multimedia/imagenes/2023/08/23/16927762122311.jpg"))
            return listaCoches
        }
    }


}