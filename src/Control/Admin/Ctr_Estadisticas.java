
package Control.Admin;

import Vistas.Admin.Estadisticas;
import Vistas.Admin.Graficos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Ctr_Estadisticas implements ActionListener{
    Estadisticas pre;

    public Ctr_Estadisticas(Estadisticas pre) {
        this.pre = pre;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(pre.volver)){
            pre.setVisible(false);
            pre.dispose();
            pre.sun.setVisible(true);
        }
        if(e.getSource().equals(pre.agregarClase)){
            Graficos ms = new Graficos(pre, 1);
            pre.setVisible(false);
        }
        if(e.getSource().equals(pre.clasesPendientes)){
            Graficos mn = new Graficos(pre, 2);
            pre.setVisible(false);
        }
        if(e.getSource().equals(pre.cancelarClase)){
            Graficos jd = new Graficos(pre, 3);
            pre.setVisible(false);
        }
        if(e.getSource().equals(pre.infoPer)){
            Graficos se = new Graficos(pre, 4);
            pre.setVisible(false);
        }
        if(e.getSource().equals(pre.cerrarSe)){
            Graficos fj = new Graficos(pre, 5);
            pre.setVisible(false);
        }
    }
    
}
