package Modelo;

public class SesionUsuario {
    private static SesionUsuario instancia;
    private String idUsuario;
    private String tipoUsuario;
    private String nombre;
    private String apellido;
    private String email;
    private String contrasena;
    private String telefono;
    private String direccion;

    private SesionUsuario() {} // Constructor privado para singleton

    public static SesionUsuario getInstancia() {
        if (instancia == null) {
            instancia = new SesionUsuario();
        }
        return instancia;
    }

    // Métodos para establecer los datos del usuario
    public void iniciarSesion(String id, String tipo, String nombre, String apellido, String email, String contrasena, String telefono, String direccion) {
        this.idUsuario = id;
        this.tipoUsuario = tipo;
        this.apellido = apellido;
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    
    public void actualizarDatos(String nombre, String apellido, String email, 
                              String contrasena, String telefono, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public void cerrarSesion() {
        this.idUsuario = null;
        this.tipoUsuario = null;
        this.nombre = null;
        this.apellido = null;
        this.email = null;
        this.contrasena = null;
        this.telefono = null;
        this.direccion = null;
    }

    // Getters
    public String getIdUsuario() { return idUsuario; }
    public String getTipoUsuario() { return tipoUsuario; }
    public String getNombre() { return nombre; }
    public String getApellido() {return apellido;}
    public String getEmail(){ return email;}
    public String getContrasena() { return contrasena; }
    public String getTelefono() { return telefono;}
    public String getDireccion() { return direccion;}    
    public boolean estaLogueado() { return idUsuario != null; }
    
    
}