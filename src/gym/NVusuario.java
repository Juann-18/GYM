/*
nombres: Juan Jose Agudelo Guiterrez
         Juan Joaw Monsale 
version: 1
fecha: 25/03/2025
crear una clase que permite crear un objeto de cada tipo de usuario y agregarlo a la arraylist
*/

//Juan jose Monsalve
package gym;

import gym.Dialogo;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class NVusuario extends JFrame {
    GYM padre;
    
    
 
    JButton regist = new JButton("Registrarse");
    JLabel no = new JLabel("Nombre");
    JLabel ap = new JLabel("Apellido");
    JLabel fech = new JLabel("Fecha nacimiento");
    JLabel tele = new JLabel("Telefono");
    JLabel dire = new JLabel("Direccion");
    JLabel corre = new JLabel("Correo electronico");
    JLabel contr = new JLabel("Contraseña");
    JLabel tpid = new JLabel("Tipo de ID");


    
    JTextField nom = new JTextField();
    JTextField ape = new JTextField();
    JTextField fecha = new JTextField();
    JTextField telef = new JTextField();
    JTextField direc = new JTextField();
    JTextField correo = new JTextField();
    JTextField contra = new JTextField();
    JComboBox<String> tipoId = new JComboBox<>(new String[]{"Selecione tipo de ID","Cedula ciudadania", "Tarjeta identidad", "Cedula de extranjeria","Pasaporte"});
    
    
    
    public NVusuario(GYM s){
       
                
        super("Nuevo usuario");
        setSize(650, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        getContentPane().setBackground(new Color(74,78,85)); //color del fondo

        setLayout(null);
        no.setForeground(new Color(243, 244, 247));
        ap.setForeground(new Color(243, 244, 247));
        fech.setForeground(new Color(243, 244, 247));
        tele.setForeground(new Color(243, 244, 247));
        dire.setForeground(new Color(243, 244, 247));
        corre.setForeground(new Color(243, 244, 247));
        contr.setForeground(new Color(243, 244, 247));
        tpid.setForeground(new Color(243, 244, 247));

        
        regist.setFont(new Font("Quenbach Medium", Font.BOLD, 20));
        regist.setBounds(400, 500, 200, 30); // Posición para 'regist' al lado derecho
        add(regist);
        
        nom.setFont(new Font("Quenbach Medium", Font.BOLD, 15));
        nom.setBounds(170, 150, 150, 20); // Posición para 'nom' al lado derecho
        add(nom);
        
        ape.setFont(new Font("Quenbach Medium", Font.BOLD, 15));
        ape.setBounds(170, 200, 150, 20); // Posición para 'ape' al lado derecho
        add(ape);
        
        fecha.setFont(new Font("Quenbach Medium", Font.BOLD, 15));
        fecha.setBounds(200, 250, 150, 20); // Posición para 'fecha' al lado derecho
        add(fecha);
        
        telef.setFont(new Font("Quenbach Medium", Font.BOLD, 15));
        telef.setBounds(170, 300, 150, 20); // Posición para 'telef' al lado derecho
        add(telef);
        
        direc.setFont(new Font("Quenbach Medium", Font.BOLD, 15));
        direc.setBounds(170, 350, 150, 20); // Posición para 'direc' al lado derecho
        add(direc);
        
        correo.setFont(new Font("Quenbach Medium", Font.BOLD, 15));
        correo.setBounds(170, 400, 150, 20); // Posición para 'correo' al lado derecho
        add(correo);
        
        contra.setFont(new Font("Quenbach Medium", Font.BOLD, 15));
        contra.setBounds(170, 450, 150, 20); // Posición para 'contra' al lado derecho
        add(contra);
        
        tipoId.setFont(new Font("Quenbach Medium", Font.BOLD, 15));
        tipoId.setBounds(170, 500, 150, 20); // Posición para 'tipoId' al lado derecho
        add(tipoId);
        
        limpiarCampos();
        
        
       padre = s;
    }
    public void nuevoClient(){
        
        
        JLabel titulo = new JLabel("<html>Crear <br> cuenta<html>");
        titulo.setBounds(80, 25, 200, 100);
        titulo.setFont(new Font("Impact", Font.BOLD, 40));
        titulo.setForeground(new Color(57, 255, 20));
        add(titulo);
        
        titulo.setBounds(275, 25, 250, 80); // Posición y tamaño del título
        add(titulo);

        no.setBounds(80, 150, 150, 30); // Posición y tamaño para el campo 'no'
        add(no);

        ap.setBounds(80, 200, 150, 30); // Posición y tamaño para el campo 'ap'
        add(ap);

        fech.setBounds(80, 250, 200, 30); // Posición y tamaño para el campo 'fech'
        add(fech);

        tele.setBounds(80, 300, 200, 30); // Posición y tamaño para el campo 'tele'
        add(tele);

        dire.setBounds(80, 350, 300, 30); // Posición y tamaño para el campo 'dire'
        add(dire);

        corre.setBounds(80, 400, 300, 30); // Posición y tamaño para el campo 'corre'
        add(corre);

        contr.setBounds(80, 450, 300, 30); // Posición y tamaño para el campo 'contr'
        add(contr);
        
        tpid.setBounds(80, 500, 300, 30); // Posición y tamaño para el campo 'contr'
        add(tpid);
        
        regist.setBounds(400, 500, 200, 30); // Posición para 'regist' al lado derecho
        regist.addActionListener((e) -> {
            GuardarClient();
        });
        add(regist);
        

        
        setVisible(true);
    }
    public void nuevoTrabajador(){
        JLabel titulo = new JLabel("<html>Crear <br> cuenta<html>");
        titulo.setBounds(80, 25, 200, 100);
        titulo.setFont(new Font("Impact", Font.BOLD, 40));
        titulo.setForeground(new Color(57, 255, 20));
        add(titulo);
        
        regist.setFont(new Font("Quenbach Medium", Font.BOLD, 20));
        regist.setBounds(400, 500, 200, 30); // Posición para 'regist' al lado derecho
        regist.addActionListener((e) -> {
           
            guardarTrabajador();
        });
        add(regist);
        
        nom.setFont(new Font("Quenbach Medium", Font.BOLD, 15));
        nom.setBounds(170, 150, 150, 20); // Posición para 'nom' al lado derecho
        add(nom);
        
        ape.setFont(new Font("Quenbach Medium", Font.BOLD, 15));
        ape.setBounds(170, 200, 150, 20); // Posición para 'ape' al lado derecho
        add(ape);
        
        fecha.setFont(new Font("Quenbach Medium", Font.BOLD, 15));
        fecha.setBounds(200, 250, 150, 20); // Posición para 'fecha' al lado derecho
        add(fecha);
        
        telef.setFont(new Font("Quenbach Medium", Font.BOLD, 15));
        telef.setBounds(170, 300, 150, 20); // Posición para 'telef' al lado derecho
        add(telef);
        
        direc.setFont(new Font("Quenbach Medium", Font.BOLD, 15));
        direc.setBounds(170, 350, 150, 20); // Posición para 'direc' al lado derecho
        add(direc);
        
        correo.setFont(new Font("Quenbach Medium", Font.BOLD, 15));
        correo.setBounds(170, 400, 150, 20); // Posición para 'correo' al lado derecho
        add(correo);
        
        contra.setFont(new Font("Quenbach Medium", Font.BOLD, 15));
        contra.setBounds(170, 450, 150, 20); // Posición para 'contra' al lado derecho
        add(contra);
        
        tipoId.setFont(new Font("Quenbach Medium", Font.BOLD, 15));
        tipoId.setBounds(170, 500, 150, 20); // Posición para 'tipoId' al lado derecho
        add(tipoId);
        
        no.setBounds(80, 150, 150, 30); // Posición y tamaño para el campo 'no'
        add(no);

        ap.setBounds(80, 200, 150, 30); // Posición y tamaño para el campo 'ap'
        add(ap);

        fech.setBounds(80, 250, 200, 30); // Posición y tamaño para el campo 'fech'
        add(fech);

        tele.setBounds(80, 300, 200, 30); // Posición y tamaño para el campo 'tele'
        add(tele);

        dire.setBounds(80, 350, 300, 30); // Posición y tamaño para el campo 'dire'
        add(dire);

        corre.setBounds(80, 400, 300, 30); // Posición y tamaño para el campo 'corre'
        add(corre);

        contr.setBounds(80, 450, 300, 30); // Posición y tamaño para el campo 'contr'
        add(contr);
        
        tpid.setBounds(80, 500, 300, 30); // Posición y tamaño para el campo 'contr'
        add(tpid);
        
        setVisible(true);
        
    }
    public void nuevoAdmin(){
        JLabel titulo = new JLabel("<html>Crear <br> cuenta<html>");
        titulo.setBounds(80, 25, 200, 100);
        titulo.setFont(new Font("Impact", Font.BOLD, 40));
        titulo.setForeground(new Color(57, 255, 20));
        add(titulo);
        
        regist.setFont(new Font("Quenbach Medium", Font.BOLD, 20));
        regist.setBounds(400, 500, 200, 30); // Posición para 'regist' al lado derecho
        regist.addActionListener((e) -> {
            guardarAdmin();
        });
        add(regist);
        
        nom.setFont(new Font("Quenbach Medium", Font.BOLD, 15));
        nom.setBounds(170, 150, 150, 20); // Posición para 'nom' al lado derecho
        add(nom);
        
        ape.setFont(new Font("Quenbach Medium", Font.BOLD, 15));
        ape.setBounds(170, 200, 150, 20); // Posición para 'ape' al lado derecho
        add(ape);
        
        fecha.setFont(new Font("Quenbach Medium", Font.BOLD, 15));
        fecha.setBounds(200, 250, 150, 20); // Posición para 'fecha' al lado derecho
        add(fecha);
        
        telef.setFont(new Font("Quenbach Medium", Font.BOLD, 15));
        telef.setBounds(170, 300, 150, 20); // Posición para 'telef' al lado derecho
        add(telef);
        
        direc.setFont(new Font("Quenbach Medium", Font.BOLD, 15));
        direc.setBounds(170, 350, 150, 20); // Posición para 'direc' al lado derecho
        add(direc);
        
        correo.setFont(new Font("Quenbach Medium", Font.BOLD, 15));
        correo.setBounds(200, 400, 150, 20); // Posición para 'correo' al lado derecho
        add(correo);
        
        contra.setFont(new Font("Quenbach Medium", Font.BOLD, 15));
        contra.setBounds(170, 450, 150, 20); // Posición para 'contra' al lado derecho
        add(contra);
        
        tipoId.setFont(new Font("Quenbach Medium", Font.BOLD, 15));
        tipoId.setBounds(170, 500, 150, 20); // Posición para 'tipoId' al lado derecho
        add(tipoId);
        
        no.setBounds(80, 150, 150, 30); // Posición y tamaño para el campo 'no'
        add(no);

        ap.setBounds(80, 200, 150, 30); // Posición y tamaño para el campo 'ap'
        add(ap);

        fech.setBounds(80, 250, 200, 30);
        add(fech);

        tele.setBounds(80, 300, 200, 30); // Posición y tamaño para el campo 'tele'
        add(tele);

        dire.setBounds(80, 350, 300, 30); // Posición y tamaño para el campo 'dire'
        add(dire);

        corre.setBounds(80, 400, 300, 30); // Posición y tamaño para el campo 'corre'
        add(corre);

        contr.setBounds(80, 450, 300, 30); // Posición y tamaño para el campo 'contr'
        add(contr);
        
        tpid.setBounds(80, 500, 300, 30); // Posición y tamaño para el campo 'contr'
        add(tpid);
        
       
        
        setVisible(true);
    }
    
    
    public void GuardarClient(){
        String telef = this.telef.getText();
        String fecha = this.fecha.getText();
        String tipoId = (String) this.tipoId.getSelectedItem();
        String contra = this.contra.getText();
        String correo = this.correo.getText();
        String direc = this.direc.getText();
        String ape = this.ape.getText();
        String nom = this.nom.getText();
        boolean tipoCliente = true;
        
        
        
        
        if (!telef.trim().isEmpty() &&
        !fecha.trim().isEmpty() &&
        tipoId != null && !tipoId.equals("Selecione tipo de ID") &&
        !contra.trim().isEmpty() &&
        !correo.trim().isEmpty() &&
        !direc.trim().isEmpty() &&
        !ape.trim().isEmpty() &&
        !nom.trim().isEmpty()) {
        
            Cliente clien = new Cliente(
            telef,    // telefono
            nom,      // nombre
            ape,      // apellido
            contra,   // contraseña
            correo,   // correo
            direc,    // direccion
            tipoId,   // tipoident
            fecha,
            tipoCliente);        
            padre.arr.add(clien);
            limpiarCampos();
            evento_jb_confirm();
            evento_volver();
            
        } else {
            // Algún campo está vacío
            evento_jb_error();
        }   
    }
    
    public void guardarAdmin(){
        String telef = this.telef.getText();
        String fecha = this.fecha.getText();
        String tipoId = (String) this.tipoId.getSelectedItem();
        String contra = this.contra.getText();
        String correo = this.correo.getText();
        String direc = this.direc.getText();
        String ape = this.ape.getText();
        String nom = this.nom.getText();
        String pues = "Administrador";
        double sala = 15.00;
        boolean tipoCliente = false;
        
        
        if (!telef.trim().isEmpty() &&
        !fecha.trim().isEmpty() &&
        tipoId != null && !tipoId.equals("Selecione tipo de ID") &&
        !contra.trim().isEmpty() &&
        !correo.trim().isEmpty() &&
        !direc.trim().isEmpty() &&
        !ape.trim().isEmpty() &&
        !nom.trim().isEmpty()) {
        Admin ad = new Admin(
            telef,    // telefono
            nom,      // nombre
            ape,      // apellido
            contra,   // contraseña
            correo,   // correo
            direc,    // direccion
            tipoId,   // tipoident
            fecha,    // fechaN
            pues,
            sala,
            tipoCliente
        );        
        padre.arr.add(ad);
        limpiarCampos();
        evento_jb_confirm();
        evento_volver();
            
        } else {
            // Algún campo está vacío
           evento_jb_error();
        }  
    }
    
    public void guardarTrabajador(){
        
        String telef = this.telef.getText();
        String fecha = this.fecha.getText();
        String tipoId = (String) this.tipoId.getSelectedItem();
        String contra = this.contra.getText();
        String correo = this.correo.getText();
        String direc = this.direc.getText();
        String ape = this.ape.getText();
        String nom = this.nom.getText();
        String pues = "Entrenador";
        double sala = 10.00;
        boolean tipoCliente = false;
        
        
        Entrenador trabaj = new Entrenador(
            telef,    // telefono
            nom,      // nombre
            ape,      // apellido
            contra,   // numero (o lo que corresponda a este argumento)
            correo,   // correo
            direc,    // direccion
            tipoId,   // tipoident
            fecha,
            pues,
            sala,
            tipoCliente
        );        
        padre.arr.add(trabaj);
        limpiarCampos();
        evento_volver();
    }
    
    public void evento_volver(){
        setVisible(false); // ocultar la ventana hija
        dispose(); // destruir la ventana hija
        padre.setVisible(true); // mostrar la ventana padre
    }
    public void limpiarCampos() {
    nom.setText("");
    ape.setText("");
    fecha.setText("");
    telef.setText("");
    direc.setText("");
    correo.setText("");
    contra.setText("");
    tipoId.setSelectedIndex(0); // Restablece la selección del JComboBox
    }
    private void evento_jb_confirm() {
        Dialogo dialogo_confirm = new Dialogo(this, // ventana padre
                "ok",           // tipo de dialogo 
                320,            // ancho del dialogo 
                180,            // alto del dialogo 
                "Confirmación", // titulo del dialogo 
                "<html>Se guardo correctamente"); // mensaje del dialogo
    }
    
    private void evento_jb_error() {
        Dialogo dialogo_error = new Dialogo(this, // ventana padre
                "error",        // tipo de dialogo  
                320,            // ancho del dialogo  
                180,            // alto del dialogo
                "Error",        // titulo del dialogo
                "<html>Por favor, llene todos los campos"); // mensaje del dialogo
    }
    
}

    
    
            


    
    
    
    

