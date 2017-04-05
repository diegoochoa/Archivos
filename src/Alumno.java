import java.io.Serializable;

/**
 * Created by Alumnos on 05/04/2017.
 */
public class Alumno implements Serializable {
    private int clave;
    private String nombre;
    private Laptop portatil;

    public Alumno(int c, String n,Laptop portatil){
        this.clave=c;
        this.nombre=n;
        this.portatil=portatil;
    }

    public String dimePortatil()
    {
        return portatil.toString();
    }

    public String dimeNombre(){
        return nombre;
    }

    public int dimeClave(){
        return clave;
    }
}
