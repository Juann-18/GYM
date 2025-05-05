
package Vistas.Cliente;

import Control.Cliente.Ctr_InfoPersonal;
import Modelo.SesionUsuario;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class InfoPersonal extends JFrame{
    public MenuCliente menu;
    Ctr_InfoPersonal i = new Ctr_InfoPersonal(this);

    
      JLabel no = new JLabel("Nombre");
    JLabel ap = new JLabel("Apellido");
    JLabel tele = new JLabel("Telefono");
    JLabel dire = new JLabel("Direccion");
    JLabel corre = new JLabel("Correo electronico");
    JLabel contr = new JLabel("Contraseña");


    
    public JTextField nom = new JTextField(menu.nombreUsuario);
    public JTextField ape = new JTextField(menu.apellidoUsuario);
    public JTextField telef = new JTextField(menu.telefonoUsuario);
    public JTextField direc = new JTextField(menu.direccionUsuario);
    public JTextField correo = new JTextField(menu.emailUsuario);
    public JTextField contra = new JTextField(menu.contrasenaUsuario);
    public JButton cancelar = new JButton("Cancelar");
    public JButton confirmar = new JButton("Confirmar");
    
    
    public InfoPersonal(MenuCliente menu) {
        this.menu = menu;
        
        super("Start-Gym-cliente");
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
        
        
         no.setBounds(80, 120, 150, 30); // Posición y tamaño para el campo 'no'
        add(no);
        ap.setBounds(80, 170, 150, 30); // Posición y tamaño para el campo 'ap'
        add(ap);
       
        tele.setBounds(80, 220, 200, 30); // Posición y tamaño para el campo 'tele'
        add(tele);
        dire.setBounds(330, 220, 300, 30); // Posición y tamaño para el campo 'dire'
        add(dire);
        corre.setBounds(330, 120, 300, 30); // Posición y tamaño para el campo 'corre'
        add(corre);
        contr.setBounds(330, 170, 300, 30); // Posición y tamaño para el campo 'contr'
        add(contr);       
               
       
        
        
        nom.setFont(new Font("Quenbach Medium", Font.BOLD, 15));
        nom.setBounds(80, 150, 150, 20); // Posición para 'nom' al lado derecho
        add(nom);
        
        ape.setFont(new Font("Quenbach Medium", Font.BOLD, 15));
        ape.setBounds(80, 200, 150, 20); // Posición para 'ape' al lado derecho
        add(ape);
        
      
        
        telef.setFont(new Font("Quenbach Medium", Font.BOLD, 15));
        telef.setBounds(80, 250, 150, 20); // Posición para 'telef' al lado derecho
        add(telef);
        
        direc.setFont(new Font("Quenbach Medium", Font.BOLD, 15));
        direc.setBounds(330, 250, 150, 20); // Posición para 'direc' al lado derecho
        add(direc);
        
        correo.setFont(new Font("Quenbach Medium", Font.BOLD, 15));
        correo.setBounds(330, 150, 150, 20); // Posición para 'correo' al lado derecho
        add(correo);
        
        contra.setFont(new Font("Quenbach Medium", Font.BOLD, 15));
        contra.setBounds(330, 200, 150, 20); // Posición para 'contra' al lado derecho
        add(contra);
        
       menu.configurarBoton(cancelar, 100, 370, 150, 30);
       menu.configurarBoton(confirmar, 350, 370, 150, 30);
       
       cancelar.addActionListener(i);
       confirmar.addActionListener(i);
       
       add(confirmar);
       add(cancelar);
        

        
        
       
        

         
    }
    
    
    
    
}
