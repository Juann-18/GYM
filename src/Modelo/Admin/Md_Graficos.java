
package Modelo.Admin;

import Modelo.Conexion;
import java.util.HashMap;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;


public class Md_Graficos {
    
    private Conexion conexion;
    
    public Md_Graficos() {
        this.conexion = new Conexion();
    }
    
    public Map<String, Integer> obtenerDistribucionDocumentos() {
        Map<String, Integer> datos = new HashMap<>();

        // Mapeo de tipos de documento según tu base de datos
        Map<String, String> tiposDocumento = new HashMap<>();
        tiposDocumento.put("Cédula (CC)", "tipo_id = 'Cedula ciudadania'");
        tiposDocumento.put("Tarjeta (TI)", "tipo_id = 'Tarjeta identidad'");
        tiposDocumento.put("Extranjería (CE)", "tipo_id = 'Cedula de extranjeria'");
        tiposDocumento.put("Pasaporte", "tipo_id = 'Pasaporte'");

        if(conexion.conectarMySQL()) {
            try {
                for (Map.Entry<String, String> entry : tiposDocumento.entrySet()) {
                    datos.put(entry.getKey(), conexion.contar("usuario", entry.getValue()));
                }
            } finally {
                conexion.desconectar();
            }
        }
        return datos;
}
    
    

    // Método para obtener datos de entrenadores con más clases
    public Map<String, Integer> obtenerTopEntrenadores(int limite) {
        Map<String, Integer> datos = new HashMap<>();
        String sql = "SELECT u.nombre, COUNT(c.id) as total " +
                   "FROM clase c JOIN usuario u ON c.id_entrenador = u.id " +
                   "WHERE u.tipo = 'Entrenador' " +
                   "GROUP BY u.nombre ORDER BY total DESC LIMIT " + limite;

        if(conexion.conectarMySQL()) {
            try (ResultSet rs = conexion.consulta(sql)) {
                while (rs != null && rs.next()) {
                    datos.put(rs.getString("nombre"), rs.getInt("total"));
                }
            } catch (SQLException e) {
                System.err.println("Error en obtenerTopEntrenadores: " + e.getMessage());
            } finally {
                conexion.desconectar();
            }
        }
        return datos;
    }

    // Método para obtener distribución de tipos de usuario
    public Map<String, Integer> obtenerDistribucionUsuarios() {
        Map<String, Integer> datos = new HashMap<>();
        String[] tipos = {"Cliente", "Entrenador", "Admin"};

        if(conexion.conectarMySQL()) {
            try {
                for (String tipo : tipos) {
                    datos.put(tipo, conexion.contar("usuario", "tipo = '" + tipo + "'"));
                }
                datos.put("Otros", conexion.contar("usuario", 
                    "tipo NOT IN ('Cliente', 'Entrenador', 'Admin')"));
            } finally {
                conexion.desconectar();
            }
        }
        return datos;
    }

    // Método para obtener registros por mes
    public Map<String, Integer> obtenerRegistrosPorMes() {
        Map<String, Integer> datos = new HashMap<>();
        String[] meses = {"Ene", "Feb", "Mar", "Abr", "May", "Jun", 
                         "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"};

        if(conexion.conectarMySQL()) {
            try {
                for (int i = 1; i <= 12; i++) {
                    datos.put(meses[i-1], conexion.contar("usuario", 
                        "MONTH(fecha_registro) = " + i));
                }
            } finally {
                conexion.desconectar();
            }
        }
        return datos;
    }

    // Método para obtener clases por hora del día
    public Map<String, Integer> obtenerClasesPorHora() {
        Map<String, Integer> datos = new HashMap<>();
        String sql = "SELECT HOUR(hora) as hora, COUNT(*) as total " +
                   "FROM clase GROUP BY HOUR(hora) ORDER BY hora";

        if(conexion.conectarMySQL()) {
            try (ResultSet rs = conexion.consulta(sql)) {
                while (rs != null && rs.next()) {
                    datos.put(rs.getInt("hora") + ":00", rs.getInt("total"));
                }
            } catch (SQLException e) {
                System.err.println("Error en obtenerClasesPorHora: " + e.getMessage());
            } finally {
                conexion.desconectar();
            }
        }
        return datos;
    }
}
