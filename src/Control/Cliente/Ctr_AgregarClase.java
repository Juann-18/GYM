
package Control.Cliente;

import Modelo.Cliente.Md_Cliente;
import Vistas.Cliente.AgregaraClase;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javax.management.modelmbean.ModelMBean;
import javax.swing.JOptionPane;


public class Ctr_AgregarClase implements ActionListener{
    AgregaraClase x;

    public Ctr_AgregarClase(AgregaraClase x) {
        this.x = x;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(x.btnCancelar)) evento_volver();
        
        if(e.getSource().equals(x.btnConfirmar)){
            if(validarDatos()) {
                ArrayList<String> datos = new ArrayList<>();
                
                Date fechaClaseDate = x.fecha.getDate();
                
                LocalDate fechaClaseLocal = fechaClaseDate.toInstant()
                                              .atZone(ZoneId.systemDefault())
                                              .toLocalDate();
                String fechaClaseFormateada = fechaClaseLocal.toString();
                
                
                Date horaDate = (Date) x.timeSpinner.getValue();
                SimpleDateFormat horaFormat = new SimpleDateFormat("HH:mm");
                String horaFormateada = horaFormat.format(horaDate);
                
                datos.add(fechaClaseFormateada);
                datos.add(horaFormateada);
                datos.add((String) x.comboEntrenadores.getSelectedItem());
                
                Md_Cliente clase = new Md_Cliente(this);
                
                clase.guardarClase(datos);
                

                confirmarClase();
            }
            
        }

    }
    
    private boolean validarDatos() {
        // 1. Validar entrenador seleccionado
        if(x.comboEntrenadores.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(x, "Seleccione un entrenador", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        // 2. Validar fecha
        if(x.fecha.getDate() == null) {
            JOptionPane.showMessageDialog(x, "Seleccione una fecha", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        // 3. Validar que la fecha no sea anterior a hoy
        if(x.fecha.getDate().before(new Date())) {
            JOptionPane.showMessageDialog(x, "La fecha no puede ser pasada", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    private void confirmarClase() {
        String idEntrenador = x.getIdEntrenadorSeleccionado();
        Date fecha = x.fecha.getDate();
        Date hora = (Date)x.timeSpinner.getValue();
        
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
        
        // Aquí iría el código para guardar en la base de datos
        JOptionPane.showMessageDialog(x, 
            "Clase agendada con éxito!\n" +
            "Entrenador ID: " + idEntrenador + "\n" +
            "Fecha: " + formatoFecha.format(fecha) + "\n" +
            "Hora: " + formatoHora.format(hora));
        
        evento_volver();
    }
    
    
    
     public void evento_volver() {
        x.setVisible(false);
        x.dispose();
        x.menu.setVisible(true); // mostrar el menu principal
    }
    
    
}
