
package Control.Admin;

import Modelo.Admin.Md_infoAdmin;
import Modelo.Entrenador.Md_infoEntrenador;
import Vistas.Admin.InfoAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Ctr_infoAdmin implements ActionListener{
    
    InfoAdmin info;

    public Ctr_infoAdmin(InfoAdmin info) {
        this.info = info;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(info.cancelar)) evento_volver();
         if(e.getSource().equals(info.confirmar)){
            int respuesta = JOptionPane.showConfirmDialog(
                info,
                "¿Está seguro que desea actualizar su información personal?",
                "Confirmar cambios",
                JOptionPane.YES_NO_OPTION
            );

            if (respuesta == JOptionPane.YES_OPTION) {
                ArrayList<String> datos = new ArrayList<>();
                datos.add(info.nom.getText());
                datos.add(info.ape.getText());
                datos.add(info.correo.getText());
                datos.add(info.contra.getText());
                datos.add(info.telef.getText());
                datos.add(info.direc.getText());
                
                Md_infoAdmin in = new Md_infoAdmin();
                if(in.actualizarInformacion(datos)) {
                    info.menu.actualizarDatos();
                    
                    JOptionPane.showMessageDialog(null, "La informacion se actualizo de forma correcta");
                    evento_volver();
                }
                
                

            }else evento_volver();
        }
        

    }
    public void evento_volver() {
        info.setVisible(false);
        info.dispose();
        info.menu.setVisible(true); // mostrar el menu principal
    }
    
}
