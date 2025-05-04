
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Conexion {
      Connection conn; // Objeto para la conexion
    Statement stmt;// Objeto para ejecutar la consulta
    ResultSet rs; // Objeto para recuperar los resultados de la consulta

    // datos de conexion 
    String bd = "star-gym";
    String login = "root";
    String password = "";
    String host = "127.0.0.1";

    public Conexion() {
        conn = null;
        stmt = null;
        rs = null;
    }

    public boolean conectarMySQL() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + bd, login, password);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No se encuentra la referencia del conector de MySQL.");
            return false;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al tratar de conectar con la base de datos '" + bd + "'\n" + ex);
            return false;
        }
        return true;
    }

    public boolean desconectar() {
        try {
            conn.close();
            return true;
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Error al tratar de conectar con la base de datos '" + bd + "'");
            return false;
        }
    }
    
    // ajusta la informacion para subir a la base de datos 
    public boolean registraUsuario(ArrayList<String> datos){
        if (conectarMySQL()){
            String sql = "INSERT INTO usuario (tipo, nombre, apellido, email, contrasena, " +
                         "telefono, direccion, tipo_id, numid, fecha_nacimiento, fecha_registro) VALUES ('" +
                         escapeSQL(datos.get(0)) + "','" +  // tipo
                         escapeSQL(datos.get(1)) + "','" +  // nombre
                         escapeSQL(datos.get(2)) + "','" +  // apellido
                         escapeSQL(datos.get(3)) + "','" +  // email
                         escapeSQL(datos.get(4)) + "','" +  // contrasena
                         escapeSQL(datos.get(5)) + "','" +  // telefono
                         escapeSQL(datos.get(6)) + "','" +  // direccion
                         escapeSQL(datos.get(7)) + "','" +  // tipo_id
                         escapeSQL(datos.get(8)) + "','" +  // numid
                         escapeSQL(datos.get(9)) + "','" +  // fecha_nacimiento
                         escapeSQL(datos.get(10)) + "')";    // fecha_registro
            return actualizar(sql);
        }else return false;
        
    }
    private String escapeSQL(String input) {
        if (input == null) return "";
        return input.replace("'", "''");
    }
    
    public boolean existeEmail(String email) {
        if (conectarMySQL()) {
            try {
                String sql = "SELECT COUNT(*) FROM usuario WHERE email = '" + escapeSQL(email) + "'";
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al verificar email: " + e.getMessage());
            } finally {
                desconectar();
            }
        }
        return false;
    }
    
     // sube el usuario a la base de datos
    public boolean actualizar(String sql) {
        boolean resp = false;
            if(conectarMySQL()){
                try {
                    stmt = conn.createStatement();
                    int resultado = stmt.executeUpdate(sql);
                    stmt.close();
                    desconectar();
                    resp = true;
                } catch (SQLException sqle) {
                    desconectar();
                    JOptionPane.showMessageDialog(null, "Error al realizar la actualización.\n" + sqle);
                    resp = false;
                }
                desconectar();
            }
            return resp;
    }
    
    
    public boolean autenticarUsuario(String email, String contrasena) {
    if (conectarMySQL()) {
        try {
            String sql = "SELECT COUNT(*) FROM usuario WHERE email = '" + escapeSQL(email) + 
                         "' AND contrasena = '" + escapeSQL(contrasena) + "'";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al autenticar: " + e.getMessage());
        } finally {
            desconectar();
        }
    }
    return false;
}

    public String[] obtenerDatosUsuario(String email) {
        String[] datos = new String[3]; // id, tipo, nombre
        if (conectarMySQL()) {
            try {
                String sql = "SELECT id, tipo, nombre FROM usuario WHERE email = '" + escapeSQL(email) + "'";
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                if (rs.next()) {
                    datos[0] = rs.getString("id");
                    datos[1] = rs.getString("tipo");
                    datos[2] = rs.getString("nombre");
                    return datos;
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al obtener datos: " + e.getMessage());
            } finally {
                desconectar();
            }
        }
        return null;
    }

    public String obtenerTipoUsuario(String email) {
        if (conectarMySQL()) {
            try {
                String sql = "SELECT tipo FROM usuario WHERE email = '" + escapeSQL(email) + "'";
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                if (rs.next()) {
                    return rs.getString("tipo");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al obtener tipo de usuario: " + e.getMessage());
            } finally {
                desconectar();
            }
        }
        return null;
    }
    
    public ArrayList<String[]> obtenerEntrenadores() {
        ArrayList<String[]> entrenadores = new ArrayList<>();
        if (conectarMySQL()) {
            try {
                String sql = "SELECT id, nombre, apellido FROM usuario WHERE tipo = 'Entrenador'";
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    String[] entrenador = new String[3];
                    entrenador[0] = rs.getString("id"); // ID
                    entrenador[1] = rs.getString("nombre"); // Nombre
                    entrenador[2] = rs.getString("apellido"); // Apellido
                    entrenadores.add(entrenador);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al obtener entrenadores: " + e.getMessage());
            } finally {
                desconectar();
            }
        }
        return entrenadores;
    }

    
    
    
    public boolean existeClaseDia(String idEntrenador, String fecha) {
    if (conectarMySQL()) {
        try {
            String sql = "SELECT COUNT(*) FROM clases WHERE id_entrenador = '" + escapeSQL(idEntrenador) + 
                         "' AND fecha = '" + escapeSQL(fecha) + "'";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al verificar clase: " + e.getMessage());
        } finally {
            desconectar();
        }
    }
    return false;
}

/**
 * Registra una nueva clase en la base de datos
 */
    public boolean registraClase(ArrayList<String> datos) {
        if (conectarMySQL()) {
            try {
                String sql = "INSERT INTO clases (id_entrenador, fecha, hora, id_cliente) VALUES ('" +
                             escapeSQL(datos.get(0)) + "','" +  // id_entrenador
                             escapeSQL(datos.get(1)) + "','" +  // fecha
                             escapeSQL(datos.get(2)) + "','" +  // hora
                             escapeSQL(datos.get(3)) + "')";    // id_cliente
                return actualizar(sql);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al registrar clase: " + e.getMessage());
                return false;
            }
        }
        return false;
    }

    /**
     * Obtiene todas las clases de un cliente específico
     */
    public ArrayList<String[]> obtenerClasesCliente(String idCliente) {
        ArrayList<String[]> clases = new ArrayList<>();
        if (conectarMySQL()) {
            try {
                String sql = "SELECT c.id, u.nombre as entrenador, c.fecha, c.hora " +
                             "FROM clases c JOIN usuario u ON c.id_entrenador = u.id " +
                             "WHERE c.id_cliente = '" + escapeSQL(idCliente) + "' " +
                             "ORDER BY c.fecha, c.hora";
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    String[] clase = new String[4];
                    clase[0] = rs.getString("id");
                    clase[1] = rs.getString("entrenador");
                    clase[2] = rs.getString("fecha");
                    clase[3] = rs.getString("hora");
                    clases.add(clase);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al obtener clases: " + e.getMessage());
            } finally {
                desconectar();
            }
        }
        return clases;
    }
    
    

        
}
