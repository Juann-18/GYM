/*
nombres: Juan Jose Agudelo Guiterrez
         Juan Joaw Monsale 
version: 1
fecha: 25/03/2025
Una vez que se inicie sesion esta sera la ventana que tendra un Cliente
*/

//juan Agudelo
package gym;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class SesionCliente extends JFrame{
     
    String telefono, nombre, apellido, correo, direccion, tipoident, fechaN, password;
    GYM padre;
    public SesionCliente(GYM s,String nom, String contra){
        padre = s;  
        nombre = nom;
        password = contra;

        
        super("START-GYM");
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
        
        if (padre.arr == null || padre.arr.isEmpty()) {
        System.out.println("Error: La lista está vacía o no inicializada.");
        return;
        }
        //extraer la informacion del usuario
        boolean encontrado = false;
        for (Object obj : padre.arr) {
            if (obj instanceof Cliente) {
                System.out.println(obj);
                if (((Cliente) obj).getNumero().equals(password)) {
                    apellido = ((Cliente) obj).apellido;
                    telefono = ((Cliente) obj).telefono;
                    correo = ((Cliente) obj).correo;
                    direccion = ((Cliente) obj).direccion;
                    encontrado = true;
                    System.out.println(nombre);
                    
                }
            }
        }
        
        JLabel titulo = new JLabel("Bienvenido  " + nombre);
        titulo.setBounds(0, 0, 700, 80);
        titulo.setOpaque(true);
        titulo.setBackground(new Color(74, 78, 85));
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setForeground(new Color(57, 255, 20));  //Color del titulo AMARILLO
        titulo.setFont(new Font("Impact", Font.BOLD, 60)); // Tamaño grande: 
        add(titulo);

    }
}
