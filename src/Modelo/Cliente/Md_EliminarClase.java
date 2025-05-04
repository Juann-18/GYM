
package Modelo.Cliente;

import Modelo.Conexion;
import Vistas.Cliente.EliminarClase;
import javax.swing.JOptionPane;


public class Md_EliminarClase {
    EliminarClase ds;

    public Md_EliminarClase(EliminarClase ds) {
        this.ds = ds;
    }
    
    public boolean eliminarClase(String idCliente, String idClase){
        Conexion c = new Conexion();
         if (!c.validarClaseDeCliente(idClase, idCliente)) {
            JOptionPane.showMessageDialog(ds,
                "No puedes cancelar esta clase (no existe o no te pertenece)",
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        // Si la validación es exitosa, procedemos a cancelar
        String sql = "DELETE FROM clase WHERE id = '" + c.escapeSQL(idClase) + "'";
        boolean resultado = c.actualizar(sql);
        return resultado;
    }
    
    
    
    
}
