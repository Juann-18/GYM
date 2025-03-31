/*
nombres: Juan Jose Agudelo Guiterrez
         Juan Joaw Monsale 
version: 1
fecha: 25/03/2025
crear una app de gestion de una gym 
*/

//Juan Jose Agudelo
package gym;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class GYM extends JFrame{
    
    GYM padre;
    private Cliente clienteLogueado;
    
    JButton iniciarSesion = new JButton("Iniciar sesión");
    JButton registro = new JButton("Regístrate");
    JTextField nombreUsuario = new JTextField();
    JTextField password = new JTextField();
    NVusuario obj = new NVusuario(this);
    
    //define el ArrayList 
    ArrayList<Object> arr = new ArrayList<>();
    
    public GYM(){
        //craar la ventana
        super("Inicio De Sesion");
        setSize(700, 600);
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
        titulo.setFont(new Font("Impact", Font.BOLD, 60)); // Tamaño grande: 
        add(titulo);
        
        JLabel iniciar = new JLabel("Inicar sesión");
        JLabel nom = new JLabel("Nombre:");
        JLabel pass = new JLabel("Contraseña:");
        JLabel texResgistro = new JLabel("¿Es tu primera vez?");
        
        
        iniciar.setBounds(225, 140, 250, 40);
        iniciar.setFont(new Font("Quenbach Medium", Font.BOLD,40));
        iniciar.setForeground(new Color(57, 255, 20));
        add(iniciar);
        
        nom.setBounds(200, 190, 100, 40);
        nom.setFont(new Font("Quenbach Medium", Font.BOLD,15));
        nom.setForeground(new Color(243, 244, 247));
        add(nom);
        
        pass.setBounds(200, 290, 100, 40);
        pass.setFont(new Font("Quenbach Medium", Font.BOLD,15));
        pass.setForeground(new Color(243, 244, 247));
        add(pass);
        
        nombreUsuario.setBounds(200, 230, 300, 40);
        add(nombreUsuario);
        
        password.setBounds(200, 330, 300, 40);
        add(password);
        
        iniciarSesion.setBounds(200, 400, 300, 30);
        iniciarSesion.setFont(new Font("Quenbach Medium", Font.BOLD,15));
        iniciarSesion.setBackground(new Color(57, 255, 20));
        iniciarSesion.addActionListener((e) -> {
            login();
        });
        add(iniciarSesion);
        
        texResgistro.setBounds(20, 500, 250, 20);
        texResgistro.setFont(new Font("Quenbach Medium", Font.BOLD,15));
        texResgistro.setForeground(new Color(243, 244, 247));
        add(texResgistro);
        
        registro.setBounds(170, 500, 110, 20);
        registro.setBackground(new Color(74,78,85));
        registro.setForeground(new Color(57, 255, 20));
        registro.setFont(new Font("Quenbach Medium", Font.BOLD,15));
        registro.addActionListener((e) -> {
            setVisible(false);
            //obj.nuevoClient();
            //obj.nuevoTrabajador();
            obj.nuevoAdmin();
        });
        
        add(registro);
    }
    
    //metodo para iniciar sesion
    public void login(){
        String nombre = nombreUsuario.getText();
        String contra = password.getText();
        
        if (!nombre.trim().isEmpty() && !contra.trim().isEmpty()) {
            for (Object obj : arr) {
                if (obj instanceof Cliente) {
                    // Castea el objeto a Cliente
                    Cliente cliente = (Cliente) obj;
                    if (cliente.getNumero().equals(contra) && cliente.nombre.equals(nombre) && ((Cliente) obj).tipo == true ) {
                        setVisible(false); 
                        SesionCliente sesi = new SesionCliente(this, nombre, contra);
                        break;
                    }
                }
                if (obj instanceof Entrenador) {
                    // Castea el objeto a Entrenador
                    Entrenador entrenador = (Entrenador) obj;
                    if (entrenador.getNumero().equals(contra) && entrenador.nombre.equals(nombre) && ((Entrenador) obj).getPuesto() =="Entrenador") {
                        setVisible(false);
                        SesionEntrenador se = new SesionEntrenador(this, nombre, contra);
                        break;
                    }
                }
                 if (obj instanceof Admin) {
                    // Castea el objeto a Entrenador
                    Admin admin = (Admin) obj;
                    if (admin.getNumero().equals(contra) && admin.nombre.equals(nombre) && ((Admin) obj).getPuesto() == "Administrador") {
                        setVisible(false);
                        SesionAdmin ss = new SesionAdmin(this, nombre, contra);
                        break;
                    }
                }
            }
 
        }else {
            evento_jb_error();
        }

    }
    
    
    private void evento_jb_error() {
        Dialogo dialogo_error = new Dialogo(this, // ventana padre
                "error",        // tipo de dialogo  
                320,            // ancho del dialogo  
                180,            // alto del dialogo
                "Error",        // titulo del dialogo
                "<html>Por favor, revisa la contrase o el nombre"); // mensaje del dialogo
    }
    
   
    public static void main(String[] args) {
        GYM s = new GYM();
    }
    
}
