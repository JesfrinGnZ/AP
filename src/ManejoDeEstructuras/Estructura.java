/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManejoDeEstructuras;

import java.util.ArrayList;
import pruebajflex.Lexema;

/**
 *
 * @author jesfrin
 */
public class Estructura {
    
   private ArrayList<Lexema> listaDeLexemas;

    public Estructura(ArrayList<Lexema> listaDeLexemas) {
        this.listaDeLexemas = listaDeLexemas;
    }

    public ArrayList<Lexema> getListaDeLexemas() {
        return listaDeLexemas;
    }

    public void setListaDeLexemas(ArrayList<Lexema> listaDeLexemas) {
        this.listaDeLexemas = listaDeLexemas;
    }
   
   
}
