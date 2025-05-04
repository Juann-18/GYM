package Modelo;

import Control.Ctr_InicioSesion;

public class Md_login {
    public Ctr_InicioSesion controlador;

    public Md_login(Ctr_InicioSesion controlador) {
        this.controlador = controlador;
    }
    
    public boolean iniciarSesion(String email, String contrasena) {
        Conexion c = new Conexion();
        if (c.autenticarUsuario(email, contrasena)) {
            String[] datosUsuario = c.obtenerDatosUsuario(email);
            if (datosUsuario != null && datosUsuario.length >= 3) {
                SesionUsuario.getInstancia().iniciarSesion(
                    datosUsuario[0], // id
                    datosUsuario[1], // tipo
                    datosUsuario[2], // nombre
                    email
                );
                return true;
            }
        }
        return false;
    }
    
    public String obtenerTipoUsuario(String email) {
        Conexion c = new Conexion();
        return c.obtenerTipoUsuario(email);
    }
}