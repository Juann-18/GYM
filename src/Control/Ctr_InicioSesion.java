
package Control;

import Modelo.Md_login;
import Modelo.SesionUsuario;
import Vistas.Cliente.MenuCliente;
import Vistas.InicioSesion;
import Vistas.Registro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;


public class Ctr_InicioSesion implements WindowListener,ActionListener{
    public InicioSesion mp;
    public Md_login modelo;
    
    public Ctr_InicioSesion(InicioSesion obj){
        this.modelo = new Md_login(this);
        mp = obj;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(mp.iniciarSesion)){
            String email = mp.correo.getText();
            String contrasena = new String(mp.password.getPassword());
            
            if (email.isEmpty() || contrasena.isEmpty()) {
                JOptionPane.showMessageDialog(null, 
                    "Email y contraseña son obligatorios", 
                    "Error de validación", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (modelo.iniciarSesion(email, contrasena)) {
                String tipoUsuario = SesionUsuario.getInstancia().getTipoUsuario();
                abrirMenuSegunTipo(tipoUsuario);
                mp.dispose();
            } else {
                JOptionPane.showMessageDialog(null, 
                    "Credenciales incorrectas", 
                    "Error de autenticación", 
                    JOptionPane.ERROR_MESSAGE);
            }
            
            
        }
        
        if(e.getSource().equals(mp.registro)){
            Registro r = new Registro(mp);
            mp.setVisible(false);
        }
    }

    
    private void evento_salir() {
        int res = JOptionPane.showConfirmDialog(mp, 
                "Desea realmente salir de la aplicación?", 
                "Confirmación", 
                JOptionPane.YES_NO_OPTION);
        
        if(res == JOptionPane.YES_OPTION)
            System.exit(0);
    }
    private void abrirMenuSegunTipo(String tipoUsuario) {
        
        // Opcional: Configurar permisos según tipo de usuario
        switch(tipoUsuario.toLowerCase()) {
            case "admin":
                // Habilitar todas las funciones
                break;
            case "trabajador":
                // Habilitar funciones limitadas
                break;
            case "cliente":
                // Habilitar solo funciones básicas
                MenuCliente me = new MenuCliente();
                me.setVisible(true);
                break;
        }
    }
    
    
    
    @Override
    public void windowOpened(WindowEvent e) { }

    @Override
    public void windowClosing(WindowEvent e) { 
    evento_salir();
    }

    @Override
    public void windowClosed(WindowEvent e) {  }

    @Override
    public void windowIconified(WindowEvent e) { }

    @Override
    public void windowDeiconified(WindowEvent e) { }

    @Override
    public void windowActivated(WindowEvent e) { }

    @Override
    public void windowDeactivated(WindowEvent e) { }
    



    
}
