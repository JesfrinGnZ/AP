/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transiciones;

import java.util.ArrayList;
import pruebajflex.AnalizadorSintactico;
import pruebajflex.RecolectorDePilas;

/**
 *
 * @author jesfrin
 */
public class TransicionesNoTerminales {

    public static ArrayList<String> usarTransicionS(int posicionDeLexema,boolean primeraVezEnElMetodo, String tipoDeTransicion) {
        ArrayList<String> transiciones = new ArrayList<>();
        ArrayList<String> copiaDePila = new ArrayList<>();
        int transicionA_Usar;
        if (primeraVezEnElMetodo) {//Ingresa por primera vez a el metodo
            for (String valorEnPila : AnalizadorSintactico.getPila()) {
                copiaDePila.add(valorEnPila);
            }
            AnalizadorSintactico.getPilasUsadas().add(new RecolectorDePilas(posicionDeLexema,copiaDePila, tipoDeTransicion, 1));//Se anade la pila con la que se entra al metodo
            transicionA_Usar = 1;
        } else {
            RecolectorDePilas recolectorActual = AnalizadorSintactico.getPilasUsadas().get(AnalizadorSintactico.getPilasUsadas().size() - 1);
            recolectorActual.setOpcionA_Usar(recolectorActual.getOpcionA_Usar() + 1);
            transicionA_Usar = recolectorActual.getOpcionA_Usar();
        }
        AnalizadorSintactico.desapilarSimaDePila();
        switch (tipoDeTransicion) {
            case "S":
                TransicionesParaS.transiciones(transicionA_Usar, transiciones);
                break;
            case "S1":
                TransicionesParaS1.transiciones(transicionA_Usar, transiciones);
                break;
            case "S2":
                TransicionesParaS2.transiciones(transicionA_Usar, transiciones);
                break;
            case "S3":
                TransicionesParaS3.transiciones(transicionA_Usar, transiciones);
                break;
            case "S4":
                TransicionesParaS4.transiciones(transicionA_Usar, transiciones);
                break;
            case "S5":
                TransicionesParaS5.transiciones(transicionA_Usar, transiciones);
                break;
            case "S6":
                TransicionesParaS6.transiciones(transicionA_Usar, transiciones);
                break;
            case "S7":
                TransicionesParaS7.transiciones(transicionA_Usar, transiciones);
                break;
            case "S8":
                TransicionesParaS8.transiciones(transicionA_Usar, transiciones);
                break;
            case "S9":
                TransicionesParaS9.transiciones(transicionA_Usar, transiciones);
                break;
        }
        AnalizadorSintactico.insertarEnPila(transiciones);//Se isertan en pila los elementos
        //AnalizadorSintactico.setEsLaPrimeraVezEntrandoAlMetodo(true);
        return transiciones;
    }

}
