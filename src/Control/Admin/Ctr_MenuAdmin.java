
package Control.Admin;

import Vistas.Admin.Estadisticas;
import Vistas.Admin.InfoAdmin;
import Vistas.Admin.MenuAdmin;
import Vistas.Admin.RegistraAdmin;
import Vistas.Admin.RegistrarEntrenador;
import Vistas.InicioSesion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Ctr_MenuAdmin implements ActionListener{
    MenuAdmin r;

    public Ctr_MenuAdmin(MenuAdmin menu) {
        this.r = menu;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(r.agregarClase)){
            RegistrarEntrenador sd = new RegistrarEntrenador(r);
            r.setVisible(false);
        }
        if (e.getSource().equals(r.clasesPendientes)){
            RegistraAdmin nd = new RegistraAdmin(r);
            r.setVisible(false);
        }
        if(e.getSource().equals(r.cancelarClase)){
            Estadisticas nm = new Estadisticas(r);
            r.setVisible(false);
        }
        if(e.getSource().equals(r.infoPer)){
            InfoAdmin sd = new InfoAdmin(r);
            r.setVisible(false);
        }
        if(e.getSource().equals(r.cerrarSe)){
            r.setVisible(false);
            r.dispose();
            InicioSesion ds = new InicioSesion();
        }
    }
    
}
