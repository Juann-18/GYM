
package Vistas;

import Control.Ctr_InicioSesion;
import Vistas.Cliente.MenuCliente;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class InicioSesion extends  JFrame{
    public JButton iniciarSesion = new JButton("Iniciar sesión");
    public JButton registro = new JButton("Regístrate");
    public JTextField correo = new JTextField();
    public JPasswordField password = new JPasswordField();
    
    Ctr_InicioSesion mpn;

    public InicioSesion(){
         //craar la ventana
        super("Inicio De Sesion");
        setSize(700, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(new Color(74,78,85)); //color del fondo GRIS
        setLayout(null);
        
        mpn = new Ctr_InicioSesion(this);
        addWindowListener(mpn);
        
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
        JLabel nom = new JLabel("Correo:");
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
        
        correo.setBounds(200, 230, 300, 40);
        add(correo);
        
        password.setBounds(200, 330, 300, 40);
        add(password);
        
        iniciarSesion.setBounds(200, 400, 300, 30);
        iniciarSesion.setFont(new Font("Quenbach Medium", Font.BOLD,15));
        iniciarSesion.setBackground(new Color(57, 255, 20));
        iniciarSesion.addActionListener(mpn);
        add(iniciarSesion);
        
        texResgistro.setBounds(20, 500, 250, 20);
        texResgistro.setFont(new Font("Quenbach Medium", Font.BOLD,15));
        texResgistro.setForeground(new Color(243, 244, 247));
        add(texResgistro);
        
        registro.setBounds(170, 500, 110, 20);
        registro.setBackground(new Color(74,78,85));
        registro.setForeground(new Color(57, 255, 20));
        registro.setFont(new Font("Quenbach Medium", Font.BOLD,15));
        registro.addActionListener(mpn);
        
        add(registro);
    }
        public static void main(String[] args) {
        InicioSesion a = new InicioSesion();
        //MenuCliente menuCliente = new MenuCliente();
        //menuCliente.setVisible(true);

    }
    
   
    
}
