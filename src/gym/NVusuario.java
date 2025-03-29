
package gym;

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
        no.setForeground(new Color(57, 255, 20));
        add(no);

        ap.setBounds(80, 200, 150, 30); // Posición y tamaño para el campo 'ap'
        ap.setForeground(new Color(57, 255, 20));
        add(ap);

        fech.setBounds(80, 250, 200, 30);
        fech.setForeground(new Color(57, 255, 20));// Posición y tamaño para el campo 'fech'
        add(fech);

        tele.setBounds(80, 300, 200, 30); // Posición y tamaño para el campo 'tele'
        tele.setForeground(new Color(57, 255, 20));
        add(tele);

        dire.setBounds(80, 350, 300, 30); // Posición y tamaño para el campo 'dire'
        dire.setForeground(new Color(57, 255, 20));
        add(dire);

        corre.setBounds(80, 400, 300, 30); // Posición y tamaño para el campo 'corre'
        corre.setForeground(new Color(57, 255, 20));
        add(corre);

        contr.setBounds(80, 450, 300, 30); // Posición y tamaño para el campo 'contr'
        contr.setForeground(new Color(57, 255, 20));
        add(contr);
        
        tpid.setBounds(80, 500, 300, 30); // Posición y tamaño para el campo 'contr'
        tpid.setForeground(new Color(57, 255, 20));
        add(tpid);
        
        regist.addActionListener((e) -> {
            GuardarClient();
        });
        
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
        
        for (Admin object : padre.arr){
            String campos [] = new String[5];
            campos[0] = object.tipoId+"";
            campos[1] = object.ape;
            campos[2] = object.nom;
            campos[3] = object.contra;
            campos[4] = object.direc;
            System.out.println(campos);
        }
    }
    
}
    
            


    
    
    
    

