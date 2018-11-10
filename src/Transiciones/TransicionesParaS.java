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
public class TransicionesParaS {

    
    public static void transiciones(int transicionA_Usar,ArrayList<String> transiciones){
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
                AnalizadorSintactico.getPilasUsadas().remove(AnalizadorSintactico.getPilasUsadas().size()-1);
                AnalizadorSintactico.cambioDePila();
                break;
        }
    }
}
