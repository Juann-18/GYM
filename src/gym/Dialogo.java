/*
nombres: Juan Jose Agudelo Guiterrez
         Juan Joaw Monsale 
version: 1
fecha: 25/03/2025
Crea cuadros para enviar diferentes tipos de mensajes al usuario
*/

//juan Agudelo
package gym;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;


public class Dialogo extends JDialog{
    
    JButton jok = new JButton("ok");
    
    public Dialogo(JDialog padre, String tipo, int ancho, int alto, String titulo, String mensaje){
        super(padre, true);
        crearGUI(tipo, ancho, alto, titulo, mensaje);
    }
    
    public Dialogo(JFrame padre, String tipo, int ancho, int alto, String titulo, String mensaje){
        super(padre, true);
        crearGUI(tipo, ancho, alto, titulo, mensaje);
    }
    
    public void crearGUI(String tipo, int ancho, int alto, String titulo, String mensaje){
        setSize(ancho, alto);
        setLocationRelativeTo(null);
        setUndecorated(true);
        
        JPanel jp = new JPanel(null);
        jp.setLayout(null);     
        jp.setBackground(Color.WHITE);
        jp.setBorder(new LineBorder(Color.LIGHT_GRAY));
        
        JLabel jlTitulo = new JLabel("  " + titulo); // JLabel para mostrar el titulo del dialogo
        jlTitulo.setBounds(0, 0, ancho+2, 30);
        jlTitulo.setFont(new Font("Verdana", Font.PLAIN, 16));
        jp.add(jlTitulo);
        
        JSeparator sep1 = new JSeparator();
        sep1.setBounds(0, 32, ancho, 1);
        sep1.setForeground(Color.LIGHT_GRAY);
        jp.add(sep1);
        
        JLabel icono; // JLabel para mostrar el icono en el dialogo. 
        switch (tipo) { // El icono depende del tipo de dialogo 
            case "ok" -> icono = new JLabel(new ImageIcon(getClass().getResource("../assets/ok-icon.png")));
            case "warning" -> icono = new JLabel(new ImageIcon(getClass().getResource("../assets/warning-icon.png")));
            case "error" -> icono = new JLabel(new ImageIcon(getClass().getResource("../assets/error-icon.png")));
            default -> //info
                icono = new JLabel(new ImageIcon(getClass().getResource("../assets/info-icon.png")));
        }
        
        icono.setBounds(10, 52, 48, 48);
        jp.add(icono);
        
        JLabel jlMensaje = new JLabel(mensaje); // JLabel para mostrar el mensaje del dialogo
        jlMensaje.setBounds(70, 55, ancho-80, alto-120);
        jlMensaje.setFont(new Font("Verdana", Font.PLAIN, 12));
        jlMensaje.setVerticalAlignment(JLabel.TOP);
        jp.add(jlMensaje);
        
        JSeparator sep2 = new JSeparator();
        sep2.setBounds(0, alto-55, ancho, 1);
        sep2.setForeground(Color.LIGHT_GRAY);
        jp.add(sep2);        
        
        add(jp); // adicionar el JPanel con toda la GUI del Dialogo al JWindow
        
        jok.setBounds(ancho-110, alto-45, 100, 35);
        jok.setText("Ok");
        jok.addActionListener((e) ->  {
            setVisible(false);
            dispose();
        });
        jp.add(jok);
        
        setVisible(true); // hacer visible el JWindow
    }
    
}
