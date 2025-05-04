package Modelo.Cliente;

import Control.Cliente.Ctr_AgregarClase;
import Modelo.Conexion;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Md_Cliente {
    
    private Ctr_AgregarClase clase_control;
    private Conexion conexion;

    public Md_Cliente(Ctr_AgregarClase clase_control) {
        this.clase_control = clase_control;
        this.conexion = new Conexion();
    }
    
    /**
     * Guarda una nueva clase en el sistema
     */
    public boolean guardarClase(ArrayList<String> datos) {
        // Validar datos básicos
        if (datos == null || datos.size() < 4) {
            JOptionPane.showMessageDialog(null, "Datos incompletos para registrar la clase");
            return false;
        }
        
        String idEntrenador = datos.get(0);
        String fecha = datos.get(1);
        
        // Verificar si ya existe una clase para ese entrenador en esa fecha/hora
        if (conexion.existeClaseDia(idEntrenador, fecha)) {
            JOptionPane.showMessageDialog(null, 
                "El entrenador ya tiene una clase programada en esa fecha y hora",
                "Conflicto de horario", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Intentar registrar la clase
        if(conexion.registraClase(datos)) {
            JOptionPane.showMessageDialog(null, 
                "Clase registrada con éxito", 
                "Éxito", 
                JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, 
                "Error al registrar la clase", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    /**
     * Obtiene todas las clases de un cliente
     */
    public ArrayList<String[]> obtenerClases(String idCliente) {
        return conexion.obtenerClasesCliente(idCliente);
    }
    
    /**
     * Cancela una clase existente
     
    public boolean cancelarClase(String idClase) {
        if (conexion.conectarMySQL()) {
            try {
                String sql = "DELETE FROM clases WHERE id = '" + conexion.escapeSQL(idClase) + "'";
                int resultado = conexion.actualizar(sql);
                return resultado > 0;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al cancelar clase: " + e.getMessage());
                return false;
            }
        }
        return false;
    }*/
}