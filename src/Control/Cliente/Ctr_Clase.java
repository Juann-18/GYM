
package Control.Cliente;

import Vistas.Cliente.ClasesPendientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Ctr_Clase implements ActionListener{
    ClasesPendientes lu;

    public Ctr_Clase(ClasesPendientes lu) {
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
