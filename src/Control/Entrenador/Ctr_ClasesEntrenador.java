
package Control.Entrenador;

import Vistas.Entrenador.ClasesEntrenador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Ctr_ClasesEntrenador implements ActionListener{
    
    ClasesEntrenador lu;

    public Ctr_ClasesEntrenador(ClasesEntrenador lu) {
        this.lu = lu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(lu.btnVolver)) {
            lu.setVisible(false);
            lu.dispose();
            lu.menu.setVisible(true);// mostrar el menu principal
        }
    }
    
    
}
