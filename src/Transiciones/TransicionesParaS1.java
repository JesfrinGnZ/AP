/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transiciones;

import java.util.ArrayList;
import javax.swing.JTextArea;
import pruebajflex.AnalizadorSintactico;
import pruebajflex.Token;

/**
 *
 * @author jesfrin
 */
public class TransicionesParaS1 {

 
    public static void transiciones(int transicionA_Usar, ArrayList<String> transiciones,JTextArea analisisSintacticoTextArea) {
        switch (transicionA_Usar) {
            case 1:
                transiciones.add(Token.LITERAL.toString());
                transiciones.add(Token.FIN.toString());
                break;
            case 2:
                transiciones.add(Token.NUMERO_ENTERO_POSITIVO.toString());
                transiciones.add(Token.FIN.toString());

                break;
            case 3:
                transiciones.add(Token.NUMERO_ENTERO_NEGATIVO.toString());
                transiciones.add(Token.FIN.toString());

                break;
            case 4:
                transiciones.add(Token.IDENTIFICADOR.toString());
                transiciones.add(Token.FIN.toString());
                break;
            default:
                AnalizadorSintactico.getPilasUsadas().remove(AnalizadorSintactico.getPilasUsadas().size() - 1);
                AnalizadorSintactico.cambioDePila(analisisSintacticoTextArea);
                break;
        }
    }

}
