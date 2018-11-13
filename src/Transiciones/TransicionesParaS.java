/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transiciones;

import java.util.ArrayList;
import javax.swing.JTextArea;
import pruebajflex.AnalizadorSintactico;
import pruebajflex.NoTerminales;
import pruebajflex.Token;

/**
 *
 * @author jesfrin
 */
public class TransicionesParaS {

    
    public static void transiciones(int transicionA_Usar,ArrayList<String> transiciones,JTextArea analisisSintacticoTextArea){
                switch (transicionA_Usar) {//Se procede a anadir a la lista la combinacion de terminales y no terminales
            case 1://Para asignacion
                transiciones.add(Token.IDENTIFICADOR.toString());
                transiciones.add(Token.SIGNO_IGUAL.toString());
                transiciones.add(NoTerminales.S6.toString());
                transiciones.add(Token.FIN.toString());
                break;
            case 2://Para escritura
                transiciones.add(Token.ESCRIBIR.toString());
                transiciones.add(NoTerminales.S1.toString());
                break;
            case 3://Para repetir
                transiciones.add(Token.REPETIR.toString());
                transiciones.add(NoTerminales.S2.toString());
                break;
            case 4://Para condicional                       
                transiciones.add(Token.SI.toString());
                transiciones.add(NoTerminales.S4.toString());
                break;
            default:
                AnalizadorSintactico.getPilasUsadas().remove(AnalizadorSintactico.getPilasUsadas().size()-1);
                AnalizadorSintactico.cambioDePila(analisisSintacticoTextArea);
                break;
        }
    }
}
