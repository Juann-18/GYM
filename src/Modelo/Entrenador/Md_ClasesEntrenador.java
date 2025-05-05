
package Modelo.Entrenador;

import Modelo.Conexion;
import Vistas.Entrenador.ClasesEntrenador;


public class Md_ClasesEntrenador {
    ClasesEntrenador cp;
    Conexion c;

    public Md_ClasesEntrenador(ClasesEntrenador cp) {
        this.cp = cp;
        c = new Conexion();
    }
    
    
    
    public void listadoClases() {
        String idCliente = Modelo.SesionUsuario.getInstancia().getIdUsuario();
        String sql = "SELECT c.id, c.fecha, c.hora, u.nombre as entrenador, c.nombre as tipo_clase " +
                    "FROM clase c JOIN usuario u ON c.id_entrenador = u.id " +
                    "WHERE c.id_entrenador = '" + idCliente + "' " +
                    "AND (c.fecha > CURDATE() OR (c.fecha = CURDATE() AND c.hora > CURTIME())) " +
                    "ORDER BY c.fecha, c.hora";
        
        String registros[][] = c.consultaMatriz(sql);
        if(registros != null){
            for (String[] r : registros) {
                cp.dt.addRow(r);
            }
            c.desconectar();
        }
    }
    
}
