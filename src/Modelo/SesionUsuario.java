package Modelo;

public class SesionUsuario {
    private static SesionUsuario instancia;
    private String idUsuario;
    private String tipoUsuario;
    private String nombre;
    private String email;

    private SesionUsuario() {} // Constructor privado para singleton

    public static SesionUsuario getInstancia() {
        if (instancia == null) {
            instancia = new SesionUsuario();
        }
        return instancia;
    }

    // Métodos para establecer los datos del usuario
    public void iniciarSesion(String id, String tipo, String nombre, String email) {
        this.idUsuario = id;
        this.tipoUsuario = tipo;
        this.nombre = nombre;
        this.email = email;
    }

    public void cerrarSesion() {
        this.idUsuario = null;
        this.tipoUsuario = null;
        this.nombre = null;
        this.email = null;
    }

    // Getters
    public String getIdUsuario() { return idUsuario; }
    public String getTipoUsuario() { return tipoUsuario; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public boolean estaLogueado() { return idUsuario != null; }
}