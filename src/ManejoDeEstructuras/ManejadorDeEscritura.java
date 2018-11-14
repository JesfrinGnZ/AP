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

    public ManejadorDeEscritura( ArrayList<Estructura> listaDeEstructuras, File rutaDeSalida) {
        this.listaDeIdentificadores = new ArrayList<>();
        this.listaDeEstructuras = listaDeEstructuras;
        instruccionesDeSalida = new ArrayList<>();
    }
    
    public void evaluarEstructuras(){
        for (Estructura estructura : listaDeEstructuras) {
            if(estructura instanceof Escritura){ 
                Escritura nuevaEscritura = new Escritura(estructura.getListaDeLexemas());
                nuevaEscritura.descomponerEscritura(instruccionesDeSalida,listaDeIdentificadores);
            }else if(estructura instanceof Asignacion){
                ((Asignacion) estructura).descomponerIdentificador(listaDeIdentificadores);
            }else if(estructura instanceof Condicional){
                Condicional nuevaCondicion = new Condicional(estructura.getListaDeLexemas());
                nuevaCondicion.descomponerCondicion(instruccionesDeSalida,listaDeIdentificadores);
            }else if(estructura instanceof Repetir){
                Repetir nuevaRepeticion = new Repetir(estructura.getListaDeLexemas());
                nuevaRepeticion.descomponerRepeticion(instruccionesDeSalida,listaDeIdentificadores);
            }
        }
        escribirTextoEnArchivo();
    }
    
    public void escribirTextoEnArchivo(){
        System.out.println("INSTRUCCIONES***********************************ESCRITURA");
        for (String string : instruccionesDeSalida) {
            System.out.println(string);
        }
        System.out.println("IDENTIFICADORES*************************************");
        for (Identificador listaDeIdentificadore : listaDeIdentificadores) {
            System.out.println("ID:"+listaDeIdentificadore.getNombre()+":"+listaDeIdentificadore.getValor());
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
