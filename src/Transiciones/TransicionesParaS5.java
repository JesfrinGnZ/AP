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
public class TransicionesParaS5 {

    public static void transiciones(int transicionA_Usar, ArrayList<String> transiciones) {
        switch (transicionA_Usar) {//Se procede a anadir a la lista la combinacion de terminales y no terminales
            case 1:
                transiciones.add(Token.ESCRIBIR.toString());
                transiciones.add(NoTerminales.S1.toString());
                transiciones.add(Token.FIN.toString());
                break;
            case 2:
                transiciones.add(Token.FIN.toString());
                break;
            default:
                AnalizadorSintactico.getPilasUsadas().remove(AnalizadorSintactico.getPilasUsadas().size() - 1);
                AnalizadorSintactico.cambioDePila();
                break;
        }
    }
}
