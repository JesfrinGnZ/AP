/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transiciones;

import java.util.ArrayList;
import pruebajflex.AnalizadorSintactico;
import pruebajflex.NoTerminales;
import pruebajflex.Token;

/**
 *
 * @author jesfrin
 */
public class TransicionesParaS6 {

    public static void transiciones(int transicionA_Usar, ArrayList<String> transiciones) {
        switch (transicionA_Usar) {
            case 1:
                transiciones.add(Token.PARENTESIS_ABIERTO.toString());
                transiciones.add(NoTerminales.S7.toString());
                transiciones.add(Token.PARENTESIS_CERRADO.toString());
                break;
            case 2:
                transiciones.add(Token.PARENTESIS_ABIERTO.toString());
                transiciones.add(NoTerminales.S7.toString());
                transiciones.add(Token.PARENTESIS_CERRADO.toString());
                transiciones.add(NoTerminales.S8.toString());

                break;
            case 3:
                transiciones.add(NoTerminales.S7.toString());
                AnalizadorSintactico.setEsLaPrimeraVezEntrandoAlMetodo(true);
                break;
            default:
                AnalizadorSintactico.getPilasUsadas().remove(AnalizadorSintactico.getPilasUsadas().size() - 1);
                AnalizadorSintactico.cambioDePila();
                break;
        }
    }
}
