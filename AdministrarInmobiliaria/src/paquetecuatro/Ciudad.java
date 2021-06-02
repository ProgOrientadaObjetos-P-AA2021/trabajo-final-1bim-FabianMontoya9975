/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetecuatro;

import java.io.Serializable;

/**
 *
 * @author reroes
 */
public class Ciudad implements Serializable {

    // atributos
    private String nombreCiudad;
    private String nombreProvincia;

    //Constructor
    public Ciudad(String ciudad, String provincia) {
        nombreCiudad = ciudad;
        nombreProvincia = provincia;
    }

    // métodos establecer
    public void establecerNombreCiudad(String c) {
        nombreCiudad = c;
    }

    public void establecerNOmbreProvincia(String p) {
        nombreProvincia = p;
    }

    // métodos obtener
    public String obtenerNombreCiudad() {
        return nombreCiudad;
    }

    public String obtenerNombreProvincia() {
        return nombreProvincia;
    }
    
    @Override
    public String toString() {
        String cadena = String.format("Información de la Ciudad:\n"
                + " - Nombre de la ciudad: %s\n"
                + " - Nombre de la provincia: %s\n",
                obtenerNombreCiudad(),
                obtenerNombreProvincia());
        return cadena;
    }

}
