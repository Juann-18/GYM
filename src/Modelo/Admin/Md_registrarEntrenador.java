
package Modelo.Admin;

import Control.Admin.Ctr_registraEntrenador;
import Modelo.Conexion;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Md_registrarEntrenador {
    Ctr_registraEntrenador user_control;

    public Md_registrarEntrenador(Ctr_registraEntrenador user_control) {
        this.user_control = user_control;
    }
    public void guardar (ArrayList<String> datos){
        Conexion c = new Conexion();
         if (c.existeEmail(datos.get(3))) {
            JOptionPane.showMessageDialog(null, 
                "El correo electrónico ya está registrado",
                "Error de duplicado", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(c.registraUsuario(datos)) {
            JOptionPane.showMessageDialog(null, "Registro exitoso");
        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar");
        }
            
    }
    
}
