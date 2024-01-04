
class Usuario(var nombre: String, var apellido: String) {

    var correo: String? = null

    //para crear un constructor secundario
    constructor(nombre: String, apellido: String, correo: String): this(nombre, apellido) {
        this.correo = correo

    }

    //variables

    //constructores --> primarios, secundarios
    /*
    *si no escribo nada hay un constructor vacio o por defecto
    * si escribo un constructor
    * public Usuario(String nombre){} -> si escribo un constructor el vacio desaparece
    *
     */

    //metodos

}