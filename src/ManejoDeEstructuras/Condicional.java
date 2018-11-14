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
public class Condicional extends Estructura {

    public Condicional(ArrayList<Lexema> listaDeLexemas) {
        super(listaDeLexemas);
    }

    public void descomponerCondicion(ArrayList<String> instruccionesDeSalida,ArrayList<Identificador> listaDeIdentificadores) {
        if (getListaDeLexemas().get(1).getLexema().toString().equals("VERDADERO")) {

            //Eliminando partes de Condicional
            getListaDeLexemas().remove(0);//Eliminar SI
            getListaDeLexemas().remove(1);//Eliminar VERDADERO
            getListaDeLexemas().remove(2);//Eliminar ENTONCES
            getListaDeLexemas().remove(getListaDeLexemas().size() - 1);//Eliminar FIN

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
            }
            for (Escritura escrituraActual : listaDeEscrituras) {
                escrituraActual.descomponerEscritura(instruccionesDeSalida,listaDeIdentificadores);
            }
        } else {//no se realizaran acciones

        }
    }

}
