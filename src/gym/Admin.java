/*
nombres: Juan Jose Agudelo Guiterrez
         Juan Joaw Monsale 
version: 1
fecha: 25/03/2025
crear la clases admin para poder almacenar en la arraylist
*/

//juan Monsalve
package gym;

public class Admin extends Entrenador {
    
   
    // Constructor
    public Admin(String telefono, String nombre, String apellido, String numero, String correo, 
                 String direccion, String tipoident, String fechaN, String puesto, double salario, boolean tp) {
        // Llamamos al constructor de la clase padre
        super(telefono, nombre, apellido, numero, correo, direccion, tipoident, fechaN, puesto, salario, tp);
  
    }

    // Métodos propios de Admin

    public String getTelefono() {
        return telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNumero() {
        return numero;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTipoident() {
        return tipoident;
    }

    public String getFechaN() {
        return fechaN;
    }

    public boolean getTipo() {
        return tipo;
    }

   
}
