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

    public void descomponerEscritura(ArrayList<String> instruccionesDeSalida,ArrayList<Identificador> listaDeIdentificadores) {
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
                boolean seEncontroId=false;
                for (Identificador identificador : listaDeIdentificadores) {
                    if(lexemaA_Escribir.getToken().equals(identificador.getNombre())){
                        instruccionesDeSalida.add(String.valueOf(identificador.getValor()));
                        seEncontroId=true;
                        break;
                    }
                }
                if(!seEncontroId){
                    instruccionesDeSalida.add("0");
                }
                break;
        }
    }

    public static void descomponerEscritura(String instruccion){
        
    }
}
