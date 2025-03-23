
package gym;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class GYM extends JFrame{
    
    GYM padre;
    JButton iniciarSesion = new JButton("Iniciar sesión");
    JButton registro = new JButton("Regístrate");
    JTextField nombreUsuario = new JTextField();
    JTextField password = new JTextField();
    
    public GYM(){
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
        JLabel titulo = new JLabel("GYM START");
        titulo.setBounds(0, 0, 700, 80);
        titulo.setOpaque(true);
        titulo.setBackground(new Color(74, 78, 85));
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setForeground(new Color(255, 200, 0));  //Color del titulo AMARILLO
        titulo.setFont(new Font("Impact", Font.BOLD, 60)); // Tamaño grande: 
        add(titulo);
        
        JLabel iniciar = new JLabel("Inicar sesión");
        JLabel nom = new JLabel("Nombre:");
        JLabel pass = new JLabel("Contraseña:");
        JLabel texResgistro = new JLabel("¿Es tu primera vez?");
        
        
        iniciar.setBounds(225, 140, 250, 40);
        iniciar.setFont(new Font("Quenbach Medium", Font.BOLD,40));
        iniciar.setForeground(new Color(243, 244, 247));
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
        iniciarSesion.setBackground(new Color(255, 200, 0));
        add(iniciarSesion);
        
        texResgistro.setBounds(20, 500, 250, 20);
        texResgistro.setFont(new Font("Quenbach Medium", Font.BOLD,15));
        texResgistro.setForeground(new Color(243, 244, 247));
        add(texResgistro);
        
        registro.setBounds(170, 500, 110, 20);
        registro.setBackground(new Color(74,78,85));
        registro.setForeground(new Color(255, 200, 0));
        registro.setFont(new Font("Quenbach Medium", Font.BOLD,15));
        add(registro);
    }

   
    public static void main(String[] args) {
        GYM s = new GYM();
    }
    
}
