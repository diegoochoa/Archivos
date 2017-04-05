import java.io.Serializable;

/**
 * Created by Alumnos on 05/04/2017.
 */
public class Laptop implements Serializable {
    private String marca;
    private String modelo;

    public Laptop(String marca, String modelo)
    {
        this.marca = marca;
        this.modelo = modelo;
    }
    @Override
    public String toString()
    {
        return "Laptop de marca: "+marca +" y modelo: " +modelo;
    }
}
