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
public class Repetir extends Estructura {

    public Repetir(ArrayList<Lexema> listaDeLexemas) {
        super(listaDeLexemas);
    }

    void descomponerRepeticion(ArrayList<String> instruccionesDeSalida,ArrayList<Identificador> listaDeIdentificadores) {
        int numeroDeRepeticion = 0;
        if (getListaDeLexemas().get(1).getLexema().toString().equals("NUMERO_ENTERO_POSITIVO")) {//Buscar el numero de repeticiones
            numeroDeRepeticion = Integer.parseInt(getListaDeLexemas().get(1).getToken());
        } else {//Era un identificador
            for (Identificador identificador : listaDeIdentificadores) {
                if(identificador.getNombre().equals(getListaDeLexemas().get(1).getToken())){
                    numeroDeRepeticion=identificador.getValor();
                    break;
                }
            }
        }
        //Eliminando partes de estructura
        getListaDeLexemas().remove(0);//Eliminar Repetir
        getListaDeLexemas().remove(1);//Eliminar Numero o id
        getListaDeLexemas().remove(2);//Eliminar iniciar
        getListaDeLexemas().remove(getListaDeLexemas().size() - 1);//Eliminar fin

        ArrayList<Escritura> listaDeEscrituras = new ArrayList<>();
        ArrayList<Lexema> lexemasParaEscritura = new ArrayList<>();
        if (!getListaDeLexemas().isEmpty()) {
            for (int i = 0; i < getListaDeLexemas().size(); i++) {
                lexemasParaEscritura.add(getListaDeLexemas().get(i));
                if (lexemasParaEscritura.size() == 3) {
                    listaDeEscrituras.add(new Escritura(lexemasParaEscritura));
                    lexemasParaEscritura = new ArrayList<>();
                }

            }
            //Se procede a evaluar las escrituras
            for (int i = 0; i < numeroDeRepeticion; i++) {
                for (Escritura escrituraActual : listaDeEscrituras) {
                    escrituraActual.descomponerEscritura(instruccionesDeSalida,listaDeIdentificadores);
                }
            }

        } else {
            //No tiene estrucuturas escritura
        }

    }

}
