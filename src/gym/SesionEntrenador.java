/*
nombres: Juan Jose Agudelo Guiterrez
         Juan Joaw Monsale 
version: 1
fecha: 25/03/2025
Una vez que se inicie sesion esta seta la ventana que tendra un trabajador
*/

//juan Agudelo
package gym;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SesionEntrenador extends JFrame{
    GYM padre;
    String telefono, nombre, apellido, correo, direccion, tipoident, fechaN,puesto, password;
    double salario;
    public SesionEntrenador(GYM s, String nom, String contra) {
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

    // Método para personalizar la GUI específica de Trabajador
    public void crearGUI() {
        //extrae la informacion del usuario
        boolean encontrado = false;
        for (Object obj : padre.arr) {
            if (obj instanceof Entrenador) {
                System.out.println(obj);
                if (((Entrenador) obj).getNumero().equals(password)) {
                    apellido = ((Entrenador) obj).apellido;
                    telefono = ((Entrenador) obj).telefono;
                    correo = ((Entrenador) obj).correo;
                    direccion = ((Entrenador) obj).direccion;
                    puesto = ((Entrenador) obj).getPuesto();
                    salario = ((Entrenador) obj).getSalario();
                    encontrado = true;
                    System.out.println(nombre);
                    
                }
            }
        }
        
        
        JLabel titulo = new JLabel("Bienvenido Trabajador: " + nombre);
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
