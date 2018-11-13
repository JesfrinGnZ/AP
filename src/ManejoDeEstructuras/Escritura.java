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
public class Escritura extends Estructura {

    public Escritura(ArrayList<Lexema> listaDeLexemas) {
        super(listaDeLexemas);
    }

    public void descomponerEscritura(ArrayList<String> instruccionesDeSalida) {
        Lexema lexemaA_Escribir = getListaDeLexemas().get(1);
        switch (lexemaA_Escribir.getLexema()) {
            case LITERAL:
                String literalSinComilas = lexemaA_Escribir.getToken().replace("\"", "");
                instruccionesDeSalida.add(literalSinComilas+"\n");
                break;
            case NUMERO_ENTERO_POSITIVO:
                instruccionesDeSalida.add(lexemaA_Escribir.getToken()+"\n");
                break;
            case NUMERO_ENTERO_NEGATIVO:
                instruccionesDeSalida.add(lexemaA_Escribir.getToken()+"\n");
                break;
            case IDENTIFICADOR:
                break;
        }
    }

}
