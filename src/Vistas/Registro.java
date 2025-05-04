
package Vistas;

import Control.Ctr_registro;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;


public class Registro extends JFrame{
    
    public JButton regist = new JButton("Registrarse");
    public JButton inicioSe = new JButton("Inicia Sesion");
    JLabel no = new JLabel("Nombre");
    JLabel ap = new JLabel("Apellido");
    JLabel fech = new JLabel("Fecha nacimiento");
    JLabel tele = new JLabel("Telefono");
    JLabel dire = new JLabel("Direccion");
    JLabel corre = new JLabel("Correo electronico");
    JLabel contr = new JLabel("Contraseña");
    JLabel tpid = new JLabel("Tipo de ID");
    JLabel numID = new JLabel("Numero ID");
    JLabel texini = new JLabel("¿Ya tienes una cuenta?");

    
    public JTextField nom = new JTextField();
    public JTextField ape = new JTextField();
    public JTextField telef = new JTextField();
    public JTextField direc = new JTextField();
    public JTextField correo = new JTextField();
    public JTextField contra = new JTextField();
    public JTextField num = new JTextField();
    public JComboBox<String> tipoId = new JComboBox<>(new String[]{"Selecione tipo de ID","Cedula ciudadania", "Tarjeta identidad", "Cedula de extranjeria","Pasaporte"});
    public JDateChooser fecha = new JDateChooser();
    
    Ctr_registro user_control = new Ctr_registro(this,2);
    
    public InicioSesion m;
    
    public Registro( InicioSesion m){
        this.m = m;
        super("Nuevo usuario");
        setSize(650, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        getContentPane().setBackground(new Color(74,78,85)); //color del fondo
        setLayout(null);
        crearGUI();
        setVisible(true);

    }
    public void crearGUI(){
         no.setForeground(new Color(243, 244, 247));
        ap.setForeground(new Color(243, 244, 247));
        fech.setForeground(new Color(243, 244, 247));
        tele.setForeground(new Color(243, 244, 247));
        dire.setForeground(new Color(243, 244, 247));
        corre.setForeground(new Color(243, 244, 247));
        contr.setForeground(new Color(243, 244, 247));
        tpid.setForeground(new Color(243, 244, 247));
        numID.setForeground(new Color(243, 244, 247));
        
        JLabel titulo = new JLabel("<html>Crear <br> cuenta<html>");
        titulo.setBounds(80, 25, 200, 100);
        titulo.setFont(new Font("Impact", Font.BOLD, 40));
        titulo.setForeground(new Color(57, 255, 20));
        add(titulo);
        
        titulo.setBounds(275, 25, 250, 80); 
        add(titulo);
        no.setBounds(80, 120, 150, 30); // Posición y tamaño para el campo 'no'
        add(no);
        ap.setBounds(80, 170, 150, 30); // Posición y tamaño para el campo 'ap'
        add(ap);
        fech.setBounds(80, 220, 200, 30); // Posición y tamaño para el campo 'fech'
        add(fech);
        tele.setBounds(80, 270, 200, 30); // Posición y tamaño para el campo 'tele'
        add(tele);
        dire.setBounds(80, 320, 300, 30); // Posición y tamaño para el campo 'dire'
        add(dire);
        corre.setBounds(330, 120, 300, 30); // Posición y tamaño para el campo 'corre'
        add(corre);
        contr.setBounds(330, 170, 300, 30); // Posición y tamaño para el campo 'contr'
        add(contr);       
        tpid.setBounds(330, 220, 300, 30); // Posición y tamaño para el campo 'contr'
        add(tpid);        
        numID.setBounds(330, 270, 200, 30);
        add(numID);
        
        regist.setFont(new Font("Quenbach Medium", Font.BOLD, 20));
        regist.setBounds(400, 500, 200, 30); // Posición para 'regist' al lado derecho
        regist.addActionListener(user_control);
        add(regist);
        
        
        nom.setFont(new Font("Quenbach Medium", Font.BOLD, 15));
        nom.setBounds(80, 150, 150, 20); // Posición para 'nom' al lado derecho
        add(nom);
        
        ape.setFont(new Font("Quenbach Medium", Font.BOLD, 15));
        ape.setBounds(80, 200, 150, 20); // Posición para 'ape' al lado derecho
        add(ape);
        
        fecha.setFont(new Font("Quenbach Medium", Font.BOLD, 15));
        fecha.setBounds(80, 250, 150, 20); // Posición para 'fecha' al lado derecho
        add(fecha);
        
        telef.setFont(new Font("Quenbach Medium", Font.BOLD, 15));
        telef.setBounds(80, 300, 150, 20); // Posición para 'telef' al lado derecho
        add(telef);
        
        direc.setFont(new Font("Quenbach Medium", Font.BOLD, 15));
        direc.setBounds(80, 350, 150, 20); // Posición para 'direc' al lado derecho
        add(direc);
        
        correo.setFont(new Font("Quenbach Medium", Font.BOLD, 15));
        correo.setBounds(330, 150, 150, 20); // Posición para 'correo' al lado derecho
        add(correo);
        
        contra.setFont(new Font("Quenbach Medium", Font.BOLD, 15));
        contra.setBounds(330, 200, 150, 20); // Posición para 'contra' al lado derecho
        add(contra);
        
        tipoId.setFont(new Font("Quenbach Medium", Font.BOLD, 15));
        tipoId.setBounds(330, 250, 150, 20); // Posición para 'tipoId' al lado derecho
        add(tipoId);
        
        num.setFont(new Font("Quenbach Medium", Font.BOLD, 15));
        num.setBounds(330, 300, 150, 20);
        add(num);
        
        
        texini.setBounds(20, 500, 200, 20);
        texini.setFont(new Font("Quenbach Medium", Font.BOLD,15));
        texini.setForeground(new Color(243, 244, 247));
        add(texini);
        
        inicioSe.setBounds(190, 500, 150, 20);
        inicioSe.setBackground(new Color(74,78,85));
        inicioSe.setForeground(new Color(57, 255, 20));
        inicioSe.setFont(new Font("Quenbach Medium", Font.BOLD,15));
        inicioSe.addActionListener(user_control);
        add(inicioSe);
    }
    
}
