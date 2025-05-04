
package Control.Cliente;

import Modelo.SesionUsuario;
import Vistas.Cliente.AgregaraClase;
import Vistas.Cliente.ClasesPendientes;
import Vistas.Cliente.EliminarClase;
import Vistas.Cliente.InfoPersonal;
import Vistas.Cliente.MenuCliente;
import Vistas.InicioSesion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Ctr_MenuCliente implements ActionListener{
    MenuCliente a;

    public Ctr_MenuCliente(MenuCliente a) {
        this.a = a;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(a.agregarClase)){
            AgregaraClase x = new AgregaraClase(a);
            a.setVisible(false);
        }
        if(e.getSource().equals(a.clasesPendientes)){
            ClasesPendientes m = new ClasesPendientes(a);
            a.setVisible(false);
        }
        if(e.getSource().equals(a.cancelarClase)){
            EliminarClase v = new EliminarClase(a);
            a.setVisible(false);
        }
        if(e.getSource().equals(a.infoPer)){
            InfoPersonal f = new InfoPersonal(a);
            a.setVisible(false);
        }
        if(e.getSource().equals(a.cerrarSe)){
            
            InicioSesion sesi = new InicioSesion();
            SesionUsuario.getInstancia().cerrarSesion();
            a.setVisible(false);
            a.dispose();
            
        }
        
        
        
    }
    
}