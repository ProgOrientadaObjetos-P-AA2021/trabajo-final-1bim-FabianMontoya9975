/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetetres;

import java.io.Serializable;

/**
 *
 * @author reroes
 */
public class Ubicacion implements Serializable {

    // atributos
    private String nombreBarrio;
    private String referencia;
    private String numeroCasa;

    //Constructor
    public Ubicacion(String nombreB, String ref) {
        nombreBarrio = nombreB;
        referencia = ref;
    }

    public Ubicacion(String nombreB, String ref, String numCasa) {
        nombreBarrio = nombreB;
        referencia = ref;
        numeroCasa = numCasa;
    }

    // métodos establecer
    public void establecerNombreBarrio(String nombre) {
        nombreBarrio = nombre;
    }

    public void establecerReferencia(String ref) {
        referencia = ref;
    }

    public void establecerNumeroCasa(String numCasa) {
        numeroCasa = numCasa;
    }

    // métodos obtener
    public String obtenerNombreBarrio() {
        return nombreBarrio;
    }

    public String obtenerReferencia() {
        return referencia;
    }

    public String obtenerNumeroCasa() {
        return numeroCasa;
    }

    @Override
    public String toString() {
        String cadena = String.format("Información de la Ubicación:\n"
                + " - Nombre del Barrio: %s\n"
                + " - Referencia: %s\n"
                + " - Número de casa: %s\n",
                obtenerNombreBarrio(),
                obtenerReferencia(),
                obtenerNumeroCasa());
        return cadena;
    }

}
