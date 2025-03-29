
package gym;


public class Admin {
    int telef,fecha;
    String tipoId,contra,correo,direc,ape,nom;

    public Admin(int telef, int fecha, String tipoId, String contra, String correo, String direc, String ape, String nom) {
        this.telef = telef;
        this.fecha = fecha;
        this.tipoId = tipoId;
        this.contra = contra;
        this.correo = correo;
        this.direc = direc;
        this.ape = ape;
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Admin{" + "telef=" + telef + ", fecha=" + fecha + ", tipoId=" + tipoId + ", contra=" + contra + ", correo=" + correo + ", direc=" + direc + ", ape=" + ape + ", nom=" + nom + '}';
    }
    
    
    
    
}
