/*
nombres: Juan Jose Agudelo Guiterrez
         Juan Joaw Monsale 
version: 1
fecha: 25/03/2025
crear la clases cliente para poder almacenar en la arraylist
*/

//juan Monsalve
package gym;


public class Cliente {
    String telefono, nombre, apellido, numero, correo, direccion, tipoident, fechaN;
    boolean tipo;

    public Cliente(String telefon, String nombr, String apellid, String numer, String corre, String direccio, String tipoiden, String fecha, boolean tp) {
        this.telefono = telefon;
        this.nombre = nombr;
        this.apellido = apellid;
        this.numero = numer;
        this.correo = corre;
        this.direccion = direccio;
        this.tipoident = tipoiden;
        this.fechaN = fecha;
        this.tipo = tp;
    }

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

    @Override
    public String toString() {
        return "Cliente{" + "telefono=" + telefono + ", nombre=" + nombre + ", apellido=" + apellido + ", numero=" + numero + ", correo=" + correo + ", direccion=" + direccion + ", tipoident=" + tipoident + ", fechaN=" + fechaN + ", tipo=" + tipo + '}';
    }

    
    
    
}
