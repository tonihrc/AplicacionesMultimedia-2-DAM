
//fun nombre ( nombre: Tipo): Retorno{}
//variables se pueden declarar dentro o fuera
//variables de dos tipos VAR - dinamicas - mutables
// vallet - estaticas - no mutables
// tipo nombre = valor

//lateinit es para inicializar una variable despues
lateinit var correo: Any;
var correo2: String? = null

fun main(arg: Array<String>){

    var nombre = "Toni"
    nombre = "Luis"
    val edad = 30
    val dato = true
    val numeros = ArrayList<String>()

    correo = "tonihrc@msn.com"
    println(correo)
    correo = 1
    println(correo)

    correo2 = "Toni"
    println(correo2?.length?: "No hay longitud")


    println(funcionEjemplo(5,3))
    println("El resultado es ${funcionEjemplo(5,7)}")
}
fun funcionEjemplo(param1: Int, param2: Int): Int{
    return param1 + param2
}