
package Vistas.Cliente;

import Control.Cliente.Ctr_AgregarClase;
import Modelo.Conexion;
import Modelo.SesionUsuario;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;


public class AgregaraClase extends JFrame{
    
    public MenuCliente menu;
    public JDateChooser fecha = new JDateChooser();
    public JSpinner timeSpinner = new JSpinner();
    public JComboBox<String> comboEntrenadores = new JComboBox<>();
    public JButton btnCancelar = new JButton("Cancelar");
    public JButton btnConfirmar = new JButton("Confirmar");
    ArrayList<String[]> listaEntrenadores = new ArrayList<>();
    
    Ctr_AgregarClase control = new Ctr_AgregarClase(this);

    public AgregaraClase(MenuCliente menu) {
        this.menu = menu;
        
        super("Start-Gym-cliente"+ SesionUsuario.getInstancia().getNombre());
        setSize(700, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(new Color(74,78,85)); //color del fondo GRIS
        setLayout(null);
        crearGUI();
        cargarEntrenadores();
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
        
        JLabel fec = new JLabel("Fecha:");
        fec.setBounds(220,130 , 50,20);
        fec.setFont(new Font("Quicksand Medium", Font.BOLD, 15));
        fec.setForeground(new Color(243, 244, 247));
        add(fec);
        
        fecha.setBounds(220, 150, 200, 20);
        fecha.setDateFormatString("dd/MM/yyyy");
        fecha.getCalendarButton().setBackground(new Color(57, 255, 20));
        fecha.getCalendarButton().setText("Seleccionar");
        fecha.getDateEditor().getUiComponent().setBackground(Color.WHITE);
        add(fecha);
        
        JLabel hor = new JLabel("Hora:");
        hor.setBounds(220,190 , 50,20);
        hor.setFont(new Font("Quicksand Medium", Font.BOLD, 15));
        hor.setForeground(new Color(243, 244, 247));
        add(hor);
        
        SpinnerDateModel timeModel = new SpinnerDateModel();
        timeSpinner = new JSpinner(timeModel);
        timeSpinner.setBounds(220, 210, 100, 25);
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm");
        timeSpinner.setEditor(timeEditor);
        timeSpinner.setValue(new Date());
        add(timeSpinner);
        
        
        JLabel entre = new JLabel("seleccionar Entrenador");
        entre.setBounds(220,250 , 200,20);
        entre.setFont(new Font("Quicksand Medium", Font.BOLD, 15));
        entre.setForeground(new Color(243, 244, 247));
        add(entre);
        
        comboEntrenadores.setBounds(220, 270, 200, 25);
        add(comboEntrenadores);
        
        
        configurarBoton(btnCancelar, 180, 400, 150, 30);
        btnCancelar.addActionListener(control);
        add(btnCancelar);
        
        
        configurarBoton(btnConfirmar, 400, 400, 150, 30);
        btnConfirmar.addActionListener(control);
        add(btnConfirmar);
        
        
    }
    
    
    
    
      private void cargarEntrenadores() {
        Conexion conexion = new Conexion();
        listaEntrenadores = conexion.obtenerEntrenadores();
        
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        
        for (String[] entrenador : listaEntrenadores) {
            String texto = entrenador[1] + " " + entrenador[2] + " (ID: " + entrenador[0] + ")";
            model.addElement(texto);
        }
        
        comboEntrenadores.setModel(model);
        
        if (model.getSize() == 0) {
            JOptionPane.showMessageDialog(this, 
                "No hay entrenadores disponibles", 
                "Advertencia", 
                JOptionPane.WARNING_MESSAGE);
        }
    }
    
    // Método para obtener el ID del entrenador seleccionado
    public String getIdEntrenadorSeleccionado() {
        int index = comboEntrenadores.getSelectedIndex();
        if (index >= 0 && index < listaEntrenadores.size()) {
            return listaEntrenadores.get(index)[0]; // Retorna el ID
        }
        return null;
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
