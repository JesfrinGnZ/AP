/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transiciones;

import java.util.ArrayList;
import pruebajflex.AnalizadorSintactico;
import pruebajflex.NoTerminales;
import pruebajflex.RecolectorDePilas;
import pruebajflex.Token;

/**
 *
 * @author jesfrin
 */
public class TransicionesParaS {

    private static int transicionA_Usar=1;//Numero de transicion que se usara al inicio
    /**
     * Retorna un arreglo el cual contiene los terminales y no terminales que se
     * ingresaran a la pila, segun un camino especificado
     *
     * @return
     */
    public static ArrayList<String> usarTransicionS() {
        ArrayList<String> transiciones = new ArrayList<>();
        if (transicionA_Usar == 1) {//Ingresa por primera vez a el metodo
            AnalizadorSintactico.pilasUsadas.add(new RecolectorDePilas(AnalizadorSintactico.pila, "S"));//Se anade la pila con la que se entra al metodo
        } 
        AnalizadorSintactico.desapilarSimaDePila();
        switch (transicionA_Usar) {//Se procede a anadir a la lista la combinacion de terminales y no terminales
            case 1:
                transiciones.add(Token.IDENTIFICADOR.toString());
                transiciones.add(Token.SIGNO_IGUAL.toString());
                transiciones.add(NoTerminales.S7.toString());
                transiciones.add(NoTerminales.S9.toString());
                break;
            case 2:
                transiciones.add(Token.ESCRIBIR.toString());
                transiciones.add(NoTerminales.S1.toString());
                break;
            case 3:
                transiciones.add(Token.REPETIR.toString());
                transiciones.add(NoTerminales.S2.toString());
                break;
            case 4:
                transiciones.add(Token.SI.toString());
                transiciones.add(NoTerminales.S4.toString());
                break;
            case 5:
                transiciones.add(Token.PARENTESIS_ABIERTO.toString());
                transiciones.add(NoTerminales.S6.toString());
                transiciones.add(Token.PARENTESIS_CERRADO.toString());
                transiciones.add(Token.FIN.toString());
                break;
            case 6:
                transiciones.add(NoTerminales.S7.toString());
                transiciones.add(NoTerminales.S9.toString());
                break;
            default:
                AnalizadorSintactico.pilasUsadas.remove(AnalizadorSintactico.pilasUsadas.size()-1);
                AnalizadorSintactico.cambioDePila();
                transicionA_Usar =1;
                return null;
        }
        AnalizadorSintactico.insertarEnPila(transiciones);//Se isertan en pila los elementos
        transicionA_Usar++;//Aumentar la transicion, asi al volver se usara una distinta
        return transiciones;
    }

    public static int getTransicionA_Usar() {
        return transicionA_Usar;
    }

    public static void setTransicionA_Usar(int transicionA_Usar) {
        TransicionesParaS.transicionA_Usar = transicionA_Usar;
    }

    
}
