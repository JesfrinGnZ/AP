/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebajflex;

import java.util.ArrayList;

/**
 *
 * @author jesfrin
 */
public class RecolectorDePilas {
    
    private int posicionDeLexema;//Caracter donde va la lectura
    private String instruccionActual;//Estructura que ya se ha formado
    private ArrayList<String> pilaActual;//Valores de la pila
    private String tipoDeTransicion;//Transicion a la que corresponde el recolector
    int opcionA_Usar;//La transicion que ya ha se ha usado, o con la que se termino un analisis

    public RecolectorDePilas( int posicionDeLexema,String instruccionActual,ArrayList<String> pilaActual, String tipoDeTransicion,int opcionA_Usar) {
        this.instruccionActual = instruccionActual;
        this.pilaActual = pilaActual;
        this.tipoDeTransicion = tipoDeTransicion;
        this.opcionA_Usar=opcionA_Usar;
        this.posicionDeLexema=posicionDeLexema;
    }

    
    public int getPosicionDeLexema() {
        return posicionDeLexema;
    }

    public void setPosicionDeLexema(int posicionDeLexema) {
        this.posicionDeLexema = posicionDeLexema;
    }

    public String getInstruccionActual() {
        return instruccionActual;
    }

    public void setInstruccionActual(String instruccionActual) {
        this.instruccionActual = instruccionActual;
    }
    
    
    public ArrayList<String> getPilaActual() {
        return pilaActual;
    }

    public void setPilaActual(ArrayList<String> pilaActual) {
        this.pilaActual = pilaActual;
    }

    public String getTipoDeTransicion() {
        return tipoDeTransicion;
    }

    public void setTipoDeTransicion(String tipoDeTransicion) {
        this.tipoDeTransicion = tipoDeTransicion;
    }

    public int getOpcionA_Usar() {
        return opcionA_Usar;
    }

    public void setOpcionA_Usar(int opcionA_Usar) {
        this.opcionA_Usar = opcionA_Usar;
    }


    
    
    
}
