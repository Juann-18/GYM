
package Control.Admin;

import Vistas.Admin.Graficos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Ctr_Graficas implements ActionListener{
    Graficos pr;

    public Ctr_Graficas(Graficos pr) {
        this.pr = pr;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(pr.jbVolver)){
            pr.setVisible(false);
            pr.dispose();
            pr.mp.setVisible(true);
        }

    }
    
}
