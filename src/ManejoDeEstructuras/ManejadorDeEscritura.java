/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManejoDeEstructuras;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author jesfrin
 */
public class ManejadorDeEscritura {
    
    private ArrayList<Identificador> listaDeIdentificadores;
    private ArrayList<Estructura> listaDeEstructuras;
    private ArrayList<String> instruccionesDeSalida;

    public ManejadorDeEscritura(ArrayList<Identificador> listaDeIdentificadores, ArrayList<Estructura> listaDeEstructuras, File rutaDeSalida) {
        this.listaDeIdentificadores = listaDeIdentificadores;
        this.listaDeEstructuras = listaDeEstructuras;
        instruccionesDeSalida = new ArrayList<>();
        evaluarEstructuras();
    }
    
    public void evaluarEstructuras(){
        for (Estructura estructura : listaDeEstructuras) {
            if(estructura instanceof Escritura){ 
                Escritura nuevaEscritura = new Escritura(estructura.getListaDeLexemas());
                nuevaEscritura.descomponerEscritura(instruccionesDeSalida);
            }else if(estructura instanceof Asignacion){
                Asignacion nuevaAsignacion = new Asignacion(estructura.getListaDeLexemas());
                listaDeIdentificadores.add(nuevaAsignacion.descomponerIdentificador());
            }else if(estructura instanceof Condicional){
                Condicional nuevaCondicion = new Condicional(estructura.getListaDeLexemas());
                nuevaCondicion.descomponerCondicion(instruccionesDeSalida);
            }else if(estructura instanceof Repetir){
                Repetir nuevaRepeticion = new Repetir(estructura.getListaDeLexemas());
                nuevaRepeticion.descomponerRepeticion(instruccionesDeSalida);
            }
        }
        escribirTextoEnArchivo();
    }
    
    public void escribirTextoEnArchivo(){
        for (String string : instruccionesDeSalida) {
            System.out.println(string);
        }
    }

    public ArrayList<Identificador> getListaDeIdentificadores() {
        return listaDeIdentificadores;
    }

    public void setListaDeIdentificadores(ArrayList<Identificador> listaDeIdentificadores) {
        this.listaDeIdentificadores = listaDeIdentificadores;
    }

    public ArrayList<Estructura> getListaDeEstructuras() {
        return listaDeEstructuras;
    }

    public void setListaDeEstructuras(ArrayList<Estructura> listaDeEstructuras) {
        this.listaDeEstructuras = listaDeEstructuras;
    }

}
