/*
nombres: Juan Jose Agudelo Guiterrez
         Juan Joaw Monsale 
version: 1
fecha: 25/03/2025
crear la clases entrenador para poder almacenar en la arraylist
*/

//juan Monsalve
package gym;


public class Entrenador extends Cliente{
   
    private String puesto;
    private double salario;

    // Constructor
    public Entrenador(String telefono, String nombre, String apellido, String numero, String correo, 
                      String direccion, String tipoident, String fechaN, String puesto, double salario, boolean tp) {
        super(telefono, nombre, apellido, numero, correo, direccion, tipoident, fechaN, tp);
        this.puesto = puesto;
        this.salario = salario;
    }

    // Métodos propios

    public String getPuesto() {
        return puesto;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return "Trabajador{" + "puesto=" + puesto + ", salario=" + salario + '}';
    }
    
    
}
