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
public class Asignacion extends Estructura {

    public Asignacion(ArrayList<Lexema> listaDeLexemas) {
        super(listaDeLexemas);
    }

    public void descomponerIdentificador(ArrayList<Identificador> listaDeIdentificadores) {
        System.out.println("LISTA DE LEXAMAS ENTRANDO");
        for (Lexema lex : getListaDeLexemas()) {
            System.out.println("*/*/*/*/*/*/*/*/:" + lex.getToken());
        }
        String nombreDeIdentificador = getListaDeLexemas().get(0).getToken();
        getListaDeLexemas().remove(0);//Eliminamos ID
        getListaDeLexemas().remove(0);//Eliminamos signo =
        getListaDeLexemas().remove(getListaDeLexemas().size() - 1);//Eliminamos FIN
        System.out.println("LISTA DE LEXEMAS SALIENDO:");
        for (Lexema lex : getListaDeLexemas()) {
            System.out.println("*/*/*/*/*/*/*/*/:" + lex.getToken());
        }

        ArrayList<String> expresion = new ArrayList<>();//Lista de elementos
        for (Lexema lexemaActual : getListaDeLexemas()) {
            if (lexemaActual.getLexema().toString().equals("IDENTIFICADOR")) {//Sustituir los identificadores
                boolean seEncontroId = false;
                for (Identificador identificador : listaDeIdentificadores) {
                    if (lexemaActual.getToken().equals(identificador.getNombre())) {
                        expresion.add(String.valueOf(identificador.getValor()));
                        seEncontroId = true;
                        break;
                    }
                }
                if (!seEncontroId) {
                    expresion.add("0");//Si no existe el identificador
                }
            } else {
                expresion.add(lexemaActual.getToken());
            }
        }

        //Trabajar la expresion
        while (expresionTieneParentesis(expresion)) {
            int posicionDeParentesisAbierto = 0;
            int posicionDeParentesisCerrado = 0;
            ArrayList<String> elementosEnParentesis = new ArrayList<>();
            for (int i = 0; i < expresion.size(); i++) {
                if (expresion.get(i).equals("(")) {
                    posicionDeParentesisAbierto = i;
                } else if (expresion.get(i).equals(")")) {
                    posicionDeParentesisCerrado = i;
                    break;
                }

            }
            for (int i = (posicionDeParentesisAbierto+1); i < posicionDeParentesisCerrado; i++) {
                elementosEnParentesis.add(expresion.get(i));//Los elementos dentro del parentesis
            }

            String resultadoEnParentesis = valuarOperacion(elementosEnParentesis);
            ArrayList<String> expresionAuxiliar = new ArrayList<>();
            for (int i = 0; i < expresion.size(); i++) {
                if (i == posicionDeParentesisAbierto) {
                    expresionAuxiliar.add(resultadoEnParentesis);
                } else if (i > posicionDeParentesisAbierto && i <= posicionDeParentesisCerrado) {
                    //Sin acciones   
                } else {
                    expresionAuxiliar.add(expresion.get(i));
                }
            }
            expresion = new ArrayList<>();
            for (String string : expresionAuxiliar) {
                expresion.add(string);
            }
        }

        String valorDeId = valuarOperacion(expresion);
        listaDeIdentificadores.add(new Identificador(nombreDeIdentificador, Integer.valueOf(valorDeId)));
    }

    private boolean expresionTieneParentesis(ArrayList<String> expresion) {
        boolean expresionTieneParentesis = false;
        for (int i = 0; i < expresion.size(); i++) {
            if (expresion.get(i).equals("(")) {
                expresionTieneParentesis = true;
                break;
            }
        }
        return expresionTieneParentesis;
    }

    private boolean expresionTieneSignoMultiplicacion(ArrayList<String> elementosDeOPeracion) {
        boolean expresionTieneSignoMultiplicacion = false;
        for (String elementoDeOperacion : elementosDeOPeracion) {
            if (elementoDeOperacion.equals("*")) {
                expresionTieneSignoMultiplicacion = true;
                break;
            }
        }
        return expresionTieneSignoMultiplicacion;
    }

    private String valuarOperacion(ArrayList<String> elementosDeOperacion) {
        String valorADevolver = "";

        while (expresionTieneSignoMultiplicacion(elementosDeOperacion)) {
            int posicionDeSigno = 0;
            int valorDeMultiplicacion;
            String valorMultCadena;
            for (int i = 0; i < elementosDeOperacion.size(); i++) {
                if (elementosDeOperacion.get(i).equals("*")) {
                    posicionDeSigno = i;
                    break;
                }
            }

            valorDeMultiplicacion = Integer.parseInt(elementosDeOperacion.get(posicionDeSigno - 1)) * Integer.parseInt(elementosDeOperacion.get(posicionDeSigno + 1));
            valorMultCadena = String.valueOf(valorDeMultiplicacion);
            ArrayList<String> arregloAuxiliar = new ArrayList<>();
            for (int i = 0; i < elementosDeOperacion.size(); i++) {
                if (i == (posicionDeSigno - 1) || i == (posicionDeSigno + 1)) {
                    //Sin acciones
                } else if (i == posicionDeSigno) {
                    arregloAuxiliar.add(valorMultCadena);
                } else {
                    arregloAuxiliar.add(elementosDeOperacion.get(i));
                }
            }
            elementosDeOperacion = new ArrayList<>();
            for (String string : arregloAuxiliar) {
                elementosDeOperacion.add(string);
            }
        }
        int valorDeSuma = 0;
        for (int i = 0; i < elementosDeOperacion.size(); i += 2) {
            valorDeSuma += Integer.valueOf(elementosDeOperacion.get(i));
        }
        valorADevolver = String.valueOf(valorDeSuma);
        return valorADevolver;
    }
}
