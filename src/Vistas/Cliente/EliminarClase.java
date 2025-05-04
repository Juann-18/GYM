
package Vistas.Cliente;

import Control.Cliente.Ctr_EliminarClase;
import Vistas.Cliente.MenuCliente;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;



public class EliminarClase extends JFrame{
   
    public MenuCliente menu;
    public JTextField codigo = new JTextField();
    public JButton cancelar = new JButton("Cancelar");
    public JButton eliminar = new JButton("Eliminar");
    Ctr_EliminarClase sc = new Ctr_EliminarClase(this);

    public EliminarClase(MenuCliente menu) {
        this.menu = menu;
        super("Start-Gym");
        setSize(500, 400);
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
        titulo.setBounds(0, 0, 500, 80);
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
        
        
        
        JLabel texCo = new JLabel("Ingrese Codigo de la clase");
        texCo.setBounds(150,130, 200, 20);
        texCo.setFont(new Font("Quicksand Medium", Font.BOLD, 15));
        texCo.setForeground(new Color(243, 244, 247));
        add(texCo);
        
        
        codigo.setBounds(200, 170, 100, 20);
        add(codigo);
        configurarBoton(cancelar,120, 210, 100, 20);
        configurarBoton(eliminar, 260, 210, 100, 20);
        
        cancelar.addActionListener(sc);
        eliminar.addActionListener(sc);
        
        add(cancelar);
        add(eliminar);
        
        
    }
    
    private void configurarBoton(JButton boton, int x, int y, int width, int height) {
        boton.setBounds(x, y, width, height);
        boton.setBackground(new Color(57, 255, 20)); // Color verde brillante
        boton.setFont(new Font("Quicksand Medium", Font.BOLD, 15));
        boton.setForeground(Color.BLACK); // Color del texto
        boton.setFocusPainted(false); // Quitar el borde de enfoque
        boton.setBorderPainted(false); // Quitar el borde
    }
}
