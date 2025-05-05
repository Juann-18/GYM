
package Control.Admin;

import Modelo.Admin.Md_registrarEntrenador;
import Modelo.Md_registro;
import Vistas.Admin.MenuAdmin;
import Vistas.Admin.RegistrarEntrenador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;


public class Ctr_registraEntrenador implements ActionListener{
    RegistrarEntrenador np;
    public String tipo;
    int nu;

    public Ctr_registraEntrenador(RegistrarEntrenador np, int nu) {
        this.np = np;
        this.nu = nu;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(np.inicioSe)) evento_volver();
        if (e.getSource().equals(np.regist)){
                        if (np.nom.getText().isEmpty() || 
                np.ape.getText().isEmpty() || 
                np.correo.getText().isEmpty() || 
                np.contra.getText().isEmpty() || 
                np.telef.getText().isEmpty() ||
                np.direc.getText().isEmpty() ||
                np.tipoId.getSelectedItem() == null || // Verifica que se haya seleccionado un item
                np.num.getText().isEmpty() || // Validar número de identificación
                np.fecha.getDate() == null) { // Validar fecha de nacimiento seleccionada

                JOptionPane.showMessageDialog(null, 
                    "Todos los campos son obligatorios", 
                    "Error de validación", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
                String email = np.correo.getText();
                if (!validarFormatoEmail(email)) {
                JOptionPane.showMessageDialog(null, 
                    "El formato del correo electrónico no es válido\n" +
                    "Ejemplo válido: usuario@dominio.com",
                    "Error de validación", 
                    JOptionPane.ERROR_MESSAGE);
                return;
             }

            
            
            
            

            
            ArrayList<String> datos = new ArrayList<>();
            //System.out.println("Control.Ctr_registro.actionPerformed()");
            if (nu == 1) tipo = "Cliente";
            if (nu == 2) tipo = "Entrenador";
            if (nu == 3) tipo = "Admin";
            
             //impleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
             //String fechaRegistro = sdf.format(new Date());
            String fechaRegistro = LocalDate.now().toString();
            
            // 2. Manejo mejorado de fecha de nacimiento con JDateChooser
            Date fechaNacimientoDate = np.fecha.getDate();
            if (fechaNacimientoDate == null) {
                JOptionPane.showMessageDialog(null, 
                    "Debe seleccionar una fecha de nacimiento válida",
                    "Error de fecha", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Convertir Date a LocalDate (Java 8+)
            LocalDate fechaNacimientoLocal = fechaNacimientoDate.toInstant()
                                              .atZone(ZoneId.systemDefault())
                                              .toLocalDate();

            // Validar que la fecha no sea futura
            if (fechaNacimientoLocal.isAfter(LocalDate.now())) {
                JOptionPane.showMessageDialog(null, 
                    "La fecha de nacimiento no puede ser futura",
                    "Error de fecha", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validar edad mínima (ej: 12 años)
            if (fechaNacimientoLocal.plusYears(12).isAfter(LocalDate.now())) {
                JOptionPane.showMessageDialog(null, 
                    "Debe tener al menos 12 años para registrarse",
                    "Edad insuficiente", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Formatear fecha para MySQL (YYYY-MM-DD)
            String fechaNacimientoFormateada = fechaNacimientoLocal.toString();

            datos.add(tipo);
            datos.add(np.nom.getText());
            datos.add(np.ape.getText());
            datos.add(np.correo.getText());
            datos.add(np.contra.getText());
            datos.add(np.telef.getText());
            datos.add(np.direc.getText());
            datos.add((String) np.tipoId.getSelectedItem());
            datos.add(np.num.getText());
            datos.add(fechaNacimientoFormateada);
            datos.add(fechaRegistro);
            datos.add("1");
            
            Md_registrarEntrenador modelo = new Md_registrarEntrenador(this);
            modelo.guardar(datos);
            evento_volver();
          
        }
        
            


    }
    private boolean validarFormatoEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return email != null && email.matches(regex);
    }
    public void evento_volver() {
        np.setVisible(false);
        np.dispose();
        np.menu.setVisible(true); // mostrar el menu principal
    }
    
    
    
}
