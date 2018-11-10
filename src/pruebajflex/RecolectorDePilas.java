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
    
    private int posicionDeLexema;
    private ArrayList<String> pilaActual;
    private String tipoDeTransicion;
    int opcionA_Usar;

    public RecolectorDePilas( int posicionDeLexema,ArrayList<String> pilaActual, String tipoDeTransicion,int opcionA_Usar) {
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
