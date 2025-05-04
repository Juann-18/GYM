package Modelo.Cliente;

import Modelo.Conexion;

import Vistas.Cliente.ClasesPendientes;

public class Md_clases {
    ClasesPendientes cp;
    Conexion c;
    
    public Md_clases(ClasesPendientes cp) {
        this.cp = cp;
        this.c = new Conexion();
    }
    
    public void listadoClases() {
        String idCliente = Modelo.SesionUsuario.getInstancia().getIdUsuario();
        String sql = "SELECT c.id, c.fecha, c.hora, u.nombre as entrenador, c.nombre as tipo_clase " +
                    "FROM clase c JOIN usuario u ON c.id_entrenador = u.id " +
                    "WHERE c.id_cliente = '" + idCliente + "' " +
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
    
    public boolean cancelarClase(String idClase) {
        String sql = "DELETE FROM clase WHERE id = '" + idClase + "'";
        return c.actualizar(sql);
    }
}