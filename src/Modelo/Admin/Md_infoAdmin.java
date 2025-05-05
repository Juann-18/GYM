
package Modelo.Admin;

import Modelo.Conexion;
import Modelo.SesionUsuario;
import java.util.ArrayList;


public class Md_infoAdmin {
    public boolean actualizarInformacion(ArrayList<String> datos) {
        Conexion c = new Conexion();
        if(c.actualizarUsuario(datos)){
            SesionUsuario.getInstancia().actualizarDatos(
                        datos.get(0), // nombre
                        datos.get(1), // apellido
                        datos.get(2), // email
                        datos.get(3), // contraseña
                        datos.get(4), // teléfono
                        datos.get(5));  // dirección
            return true;
            
        }else return false;
        
        
    }
    
}
