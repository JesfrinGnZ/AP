/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transiciones;

import java.util.ArrayList;
import pruebajflex.AnalizadorSintactico;
import pruebajflex.NoTerminales;

/**
 *
 * @author jesfrin
 */
public class TransicionesParaS6 {

    
    public static void transiciones(int transicionA_Usar, ArrayList<String> transiciones) {
        switch (transicionA_Usar) {
            case 1:
                transiciones.add(NoTerminales.S7.toString());
                transiciones.add(NoTerminales.S8.toString());
                break;
            default:
                AnalizadorSintactico.getPilasUsadas().remove(AnalizadorSintactico.getPilasUsadas().size() - 1);
                AnalizadorSintactico.cambioDePila();
                break;
        }
    }
}
