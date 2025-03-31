/*
nombres: Juan Jose Agudelo Guiterrez
         Juan Joaw Monsale 
version: 1
fecha: 25/03/2025
Una vez que se inicie sesion esta sera la ventana que tendra un administrador
*/

//juan Agudelo
package gym;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class SesionAdmin extends JFrame{
    GYM padre;
    String telefono, nombre, apellido, correo, direccion, tipoident, fechaN,puesto, password;
    double salario;
    boolean tipo;
    
    public SesionAdmin(GYM s, String nom, String contra){
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
    public void crearGUI() {
        
        boolean encontrado = false;
        for (Object obj : padre.arr) {
            if (obj instanceof Admin) {
                System.out.println(obj);
                if (((Admin) obj).getNumero().equals(password)) {
                    apellido = ((Admin) obj).apellido;
                    telefono = ((Admin) obj).telefono;
                    correo = ((Admin) obj).correo;
                    direccion = ((Admin) obj).direccion;
                    puesto = ((Admin) obj).getPuesto();
                    salario = ((Admin) obj).getSalario();
                    encontrado = true;
                    System.out.println(nombre);
                    
                }
            }
        }
        
        
        JLabel titulo = new JLabel("Bienvenido Administrador: " + nombre);
        titulo.setBounds(0, 0, 700, 80);
        titulo.setOpaque(true);
        titulo.setBackground(new Color(74, 78, 85));
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setForeground(new Color(255, 153, 51)); // Diferente color para trabajadores
        titulo.setFont(new Font("Arial", Font.BOLD, 50));
        add(titulo);

        // Aquí puedes agregar componentes exclusivos para trabajadores
        // Ejemplo: Botones para gestionar clientes
    }
}
