package Vistas.Cliente;

import Control.Cliente.Ctr_Clase;
import Modelo.Cliente.Md_clases;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.table.DefaultTableModel;

public class ClasesPendientes extends JFrame {
    public MenuCliente menu;
    public JTable tablaClases;
    public DefaultTableModel dt;
    public JButton btnVolver;
    

    public ClasesPendientes(MenuCliente menu) {
        this.menu = menu;
        super("Start-Gym - Mis Clases");
        setSize(700, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(new Color(74, 78, 85));
        setLayout(null);
        crearGUI();
        
        // Cargar datos
        Md_clases md = new Md_clases(this);
        md.listadoClases();
        
        setVisible(true);
    }

    public void crearGUI() {
        JLabel titulo = new JLabel("START-GYM - MIS CLASES");
        titulo.setBounds(0, 0, 700, 80);
        titulo.setOpaque(true);
        titulo.setBackground(new Color(74, 78, 85));
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setForeground(new Color(57, 255, 20));
        titulo.setFont(new Font("Impact", Font.BOLD, 40));
        add(titulo);

        JSeparator linea = new JSeparator();
        linea.setBounds(0, 80, 700, 1);
        linea.setForeground(Color.black);
        add(linea);

        // Configurar tabla
        String[] columnas = {"Codigo", "Fecha", "Hora", "Entrenador", "Tipo de Clase"};
        dt = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaClases = new JTable(dt);
        JScrollPane scrollPane = new JScrollPane(tablaClases);
        scrollPane.setBounds(50, 100, 600, 350);
        add(scrollPane);

       

        btnVolver = new JButton("Volver");
        configurarBoton(btnVolver, 400, 470, 150, 30);
        btnVolver.addActionListener(new Ctr_Clase(this));
        add(btnVolver);
        
       
    }

    private void configurarBoton(JButton boton, int x, int y, int width, int height) {
        boton.setBounds(x, y, width, height);
        boton.setBackground(new Color(57, 255, 20));
        boton.setFont(new Font("Arial", Font.BOLD, 14));
        boton.setForeground(Color.BLACK);
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
    }
}