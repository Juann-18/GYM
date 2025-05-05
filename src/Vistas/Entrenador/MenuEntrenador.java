
package Vistas.Entrenador;

import Control.Entrenador.Ctr_MenuEntrenador;
import Modelo.SesionUsuario;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class MenuEntrenador extends JFrame{
    public String idUsuario;
    public String nombreUsuario;
    public String apellidoUsuario;
    public String emailUsuario;
    public String contrasenaUsuario;
    public String telefonoUsuario;
    public String direccionUsuario;
    
    
    public JButton clasPendientes = new JButton("Clases Pendientes");
    public  JButton infoPerso = new JButton("Informacion Personal");
    public JButton cerraSe = new JButton("Cerrar Sesion");
    
    Ctr_MenuEntrenador ds = new Ctr_MenuEntrenador(this);
    
    
    public MenuEntrenador() {
        this.idUsuario = SesionUsuario.getInstancia().getIdUsuario();
        this.nombreUsuario = SesionUsuario.getInstancia().getNombre();
        this.apellidoUsuario = SesionUsuario.getInstancia().getApellido();
        this.emailUsuario = SesionUsuario.getInstancia().getEmail();
        this.contrasenaUsuario = SesionUsuario.getInstancia().getContrasena();
        this.telefonoUsuario = SesionUsuario.getInstancia().getTelefono();
        this.direccionUsuario = SesionUsuario.getInstancia().getIdUsuario();
        
        super("Start-Gym-entrenador");
        setSize(700, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(new Color(74,78,85)); //color del fondo GRIS
        setLayout(null);
        crearGUI();
        setVisible(true);
    }
    public void crearGUI(){
        JLabel titulo = new JLabel("START-GYM");
        titulo.setBounds(0, 0, 700, 80);
        titulo.setOpaque(true);
        titulo.setBackground(new Color(74, 78, 85));
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setForeground(new Color(57, 255, 20));  //Color del titulo AMARILLO
        titulo.setFont(new Font("Impact", Font.BOLD, 40)); // Tamaño grande: 
        add(titulo);
        
        JSeparator linea = new JSeparator();
        linea.setBounds(0, 80, 700, 1);
        linea.setForeground(Color.black);
        add(linea);
        
        
        configurarBoton(clasPendientes, 200, 150, 300, 40);
        configurarBoton(infoPerso, 200, 220, 300, 40);
        configurarBoton(cerraSe, 200, 290, 300, 40);
        
        clasPendientes.addActionListener(ds);
        infoPerso.addActionListener(ds);
        cerraSe.addActionListener(ds);
        
        add(clasPendientes);
        add(infoPerso);
        add(cerraSe);
        
    }
    
    public void configurarBoton(JButton boton, int x, int y, int width, int height) {
        boton.setBounds(x, y, width, height);
        boton.setBackground(new Color(57, 255, 20)); // Color verde brillante
        boton.setFont(new Font("Quicksand Medium", Font.BOLD, 15));
        boton.setForeground(Color.BLACK); // Color del texto
        boton.setFocusPainted(false); // Quitar el borde de enfoque
        boton.setBorderPainted(false); // Quitar el borde
    }
    
    public void actualizarDatos() {
        this.nombreUsuario = SesionUsuario.getInstancia().getNombre();
        this.apellidoUsuario = SesionUsuario.getInstancia().getApellido();
        this.emailUsuario = SesionUsuario.getInstancia().getEmail();
        this.contrasenaUsuario = SesionUsuario.getInstancia().getContrasena();
        this.telefonoUsuario = SesionUsuario.getInstancia().getTelefono();
        this.direccionUsuario = SesionUsuario.getInstancia().getDireccion();
        
        System.out.println("Datos actualizados: " + nombreUsuario + " " + apellidoUsuario);
    }
    
    
    
}
