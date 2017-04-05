import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by Alumnos on 04/04/2017.
 */
public class EjemploArchivos {

    public static void leeAlumno(String nomArchivo)
    {
        File archivo = new File(nomArchivo);

        try{
            FileInputStream flujoEntrada = new FileInputStream(archivo);
            ObjectInputStream objetoEntrada = new ObjectInputStream(flujoEntrada);
            Alumno alumno = (Alumno)objetoEntrada.readObject();
            System.out.println("Alumno leido desde el archivo....");
            System.out.println("Nombre = "+alumno.dimeNombre() + " Clave = " +alumno.dimeClave() + " Laptop: " +alumno.dimePortatil());
            objetoEntrada.close();
        }

        catch(IOException ex ){
            System.out.println(ex.getMessage());
        }
        catch (ClassNotFoundException ex) {
        System.out.println(ex.getMessage());
    }
    }

    //Escribe un objeto "entero" en el archivo
    public static void escribeAlumno(String nomArchivo)
    {
        File archivo = new File(nomArchivo);

        try{
            FileOutputStream flujoSalida = new FileOutputStream(archivo);
            ObjectOutputStream objetoSalida = new ObjectOutputStream(flujoSalida);
            Alumno a1= new Alumno(123456,"Diego", new Laptop("Alienware", "Ni idea"));
            objetoSalida.writeObject(a1);
            objetoSalida.close();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
            System.out.println("Error al escribir el Alumno");
        }
    }

    //Este método propaga la excepción hacia quien lo llame
    public static void leeArchivo(String nombre) throws IOException, FileNotFoundException
    {
        File archivo = null;
        Scanner in = null;

        archivo = new File(nombre);
        in = new Scanner(archivo);

        while(in.hasNextLine())
        {
            //String linea = in.nextLine();
            int linea = in.nextInt();
            System.out.println("Linea: "+linea);
        }
        in.close();
    }

    //Este método atrapa la excepción
    public static void escribeArchivo(String nombre)
    {
        FileWriter archivo=null;
        try{
            archivo = new FileWriter(nombre);
            //archivo.write("Hola mundo");
            //Alumno a1= new Alumno(123456,"Diego");
            //archivo.write(a1.dimeClave());
            //archivo.write(a1.dimeNombre());
            archivo.close();
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }



    public static void main(String [] args)
    {
            System.out.println("Ejemplo de lectura/escritura de archivos");
            escribeAlumno("alumnos.dat");
            leeAlumno("alumnos.dat");
        /*
        try {

        }
        catch(FileNotFoundException ex) {
            //System.out.println("FileNotFoundException");
        }
        catch(IOException ex) {
            //System.out.println("IOException");
        }
        catch(NoSuchElementException ex) {
            //System.out.println("NoSuchElementException");
        }*/

    }
}
