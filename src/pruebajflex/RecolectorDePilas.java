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
    
    private ArrayList<String> pilaActual;
    private String tipoDeTransicion;

    public RecolectorDePilas( ArrayList<String> pilaActual, String tipoDeTransicion) {
        this.pilaActual = pilaActual;
        this.tipoDeTransicion = tipoDeTransicion;
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


    
    
    
}
