
package Control.Cliente;

import Modelo.Cliente.Md_EliminarClase;
import Vistas.Cliente.EliminarClase;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Ctr_EliminarClase implements ActionListener{
    EliminarClase w;

    public Ctr_EliminarClase(EliminarClase w) {
        this.w = w;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource().equals(w.cancelar)) evento_volver();
        if(e.getSource().equals(w.eliminar)){
            Md_EliminarClase del = new Md_EliminarClase(w);
            del.eliminarClase(w.menu.idUsuario, w.codigo.getText());
            w.codigo.setText("");
            evento_volver();
        }
        

    }
    public void evento_volver() {
        w.setVisible(false);
        w.dispose();
        w.menu.setVisible(true); // mostrar el menu principal
    }
    
}
