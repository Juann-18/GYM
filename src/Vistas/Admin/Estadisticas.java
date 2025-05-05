
package Vistas.Admin;

import Control.Admin.Ctr_Estadisticas;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class Estadisticas extends JFrame{
    
    public JButton agregarClase = new JButton("Gradico 1");
    public JButton clasesPendientes = new JButton("Grafico 2");
    public JButton cancelarClase = new JButton("Grafico 3");
    public JButton infoPer = new JButton("Grafico 4");
    public JButton cerrarSe = new JButton("Grafico 5");
    public JButton volver = new JButton("Volver");
    
    public Ctr_Estadisticas a = new Ctr_Estadisticas(this);
    public MenuAdmin sun;
    
    public Estadisticas(MenuAdmin sun){
        this.sun = sun;
        super("Start-Gym");
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
        
        configurarBoton(agregarClase, 200, 150, 300, 40);
        configurarBoton(clasesPendientes, 200, 220, 300, 40);
        configurarBoton(cancelarClase, 200, 290, 300, 40);
        configurarBoton(infoPer, 200, 360, 300, 40);
        configurarBoton(cerrarSe, 200, 430, 300, 40);
        configurarBoton(volver, 40, 430, 150, 30);
        
        
        agregarClase.addActionListener(a);
        clasesPendientes.addActionListener(a);
        cancelarClase.addActionListener(a);
        infoPer.addActionListener(a);
        cerrarSe.addActionListener(a);
        volver.addActionListener(a);
        
        // Agregar botones al frame
        add(agregarClase);
        add(clasesPendientes);
        add(cancelarClase);
        add(infoPer);
        add(cerrarSe);
        add(volver);
        
    }
    
     public void configurarBoton(JButton boton, int x, int y, int width, int height) {
        boton.setBounds(x, y, width, height);
        boton.setBackground(new Color(57, 255, 20)); // Color verde brillante
        boton.setFont(new Font("Quicksand Medium", Font.BOLD, 15));
        boton.setForeground(Color.BLACK); // Color del texto
        boton.setFocusPainted(false); // Quitar el borde de enfoque
        boton.setBorderPainted(false); // Quitar el borde
    }
    
}
