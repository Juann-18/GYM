
package Control.Entrenador;

import Modelo.SesionUsuario;
import Vistas.Entrenador.ClasesEntrenador;
import Vistas.Entrenador.InfoEntrenador;
import Vistas.Entrenador.MenuEntrenador;
import Vistas.InicioSesion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Ctr_MenuEntrenador implements ActionListener{
    
    MenuEntrenador menu;

    public Ctr_MenuEntrenador(MenuEntrenador menu) {
        this.menu = menu;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(menu.clasPendientes)){
            ClasesEntrenador nm = new ClasesEntrenador(menu);
        }
        if(e.getSource().equals(menu.infoPerso)){
            InfoEntrenador v = new InfoEntrenador(menu);
            menu.setVisible(false);
        }
        if(e.getSource().equals(menu.cerraSe)){
            InicioSesion sesi = new InicioSesion();
            SesionUsuario.getInstancia().cerrarSesion();
            menu.setVisible(false);
            menu.dispose();
        }
    }
    
}
