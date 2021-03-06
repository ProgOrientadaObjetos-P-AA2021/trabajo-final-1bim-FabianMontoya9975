/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetesiete;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import paquetecuatro.Ciudad;

/**
 *
 * @author josef
 */
public class LeerCiudad {

    private ObjectInputStream entrada;
    private ArrayList<Ciudad> listaCiudad;
    private String nombreArchivo;

    public LeerCiudad(String n) {
        nombreArchivo = n;
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {
            try // abre el archivo
            {
                entrada = new ObjectInputStream(
                        new FileInputStream(n));
            } // fin de try
            catch (IOException ioException) {
                System.err.println("Error al abrir el archivo.");

            } // fin de catch
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerListaCiudad() {
        // 
        listaCiudad = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Ciudad registro = (Ciudad) entrada.readObject();
                    listaCiudad.add(registro);
                } catch (EOFException endOfFileException) {
                    return; // se llegó al fin del archivo

                } catch (IOException ex) {
                    System.err.println("Error al leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se pudo crear el objeto: " + ex);
                } catch (Exception ex) {
                    // System.err.println("No hay datos en el archivo: " + ex);
                    break;
                }
            }
        }

    }

    public ArrayList<Ciudad> obtenerListaCiudad() {
        return listaCiudad;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = "LISTA DE CIUDADES\n\n";
        for (int i = 0; i < obtenerListaCiudad().size(); i++) {
            Ciudad c = obtenerListaCiudad().get(i);
            cadena = String.format("%sCiudad %d:\n - Nombre ciudad: %s\n"
                    + " - Nombre provincia: %s\n\n",
                    cadena, i + 1,
                    c.obtenerNombreCiudad(),
                    c.obtenerNombreProvincia());
        }
        return cadena;
    }

    // cierra el archivo y termina la aplicación
    public void cerrarArchivo() {
        try // cierra el archivo y sale
        {
            if (entrada != null) {
                entrada.close();
            }
            System.exit(0);
        } // fin de try
        catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del método cerrarArchivo

}
