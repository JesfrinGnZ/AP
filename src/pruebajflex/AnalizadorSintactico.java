/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebajflex;

import Transiciones.TransicionesParaS;
import Transiciones.TransicionesParaS1;
import Transiciones.TransicionesParaS2;
import Transiciones.TransicionesParaS3;
import Transiciones.TransicionesParaS4;
import Transiciones.TransicionesParaS5;
import Transiciones.TransicionesParaS6;
import Transiciones.TransicionesParaS7;
import Transiciones.TransicionesParaS8;
import Transiciones.TransicionesParaS9;
import java.util.ArrayList;

/**
 *
 * @author jesfrin
 */
public class AnalizadorSintactico {

    public static ArrayList<RecolectorDePilas> pilasUsadas = new ArrayList<>();
    public static ArrayList<String> pila = new ArrayList<>();//Pila donde se isertara y eliminaran elementos

    public static void realizarAnalisisSintactico(ArrayList<Lexema> listaDeLexemas) {
        String instruccionGuardada="";
        pila.add("Z");//Llenar la pila con el simbolo especial 
        pila.add("S");//Llenar la pila con el sibolo inicial de la gramatica
        for (int i = 0; i < listaDeLexemas.size();) {
            if (buscarSimboloQuePuedaMoverseSinLectura()!=null) {//Verificar si existe el movimiento automatico
                switch (buscarSimaDePila()) {
                    case "S":
                        TransicionesParaS.usarTransicionS();
                        break;
                    case "S1":
                        TransicionesParaS1.usarTransicionS1();
                        break;
                    case "S2":
                        TransicionesParaS2.usarTransicionS2();
                        break;
                    case "S3":
                        TransicionesParaS3.usarTransicionS3();
                        break;
                    case "S4":
                        TransicionesParaS4.usarTransicionS4();
                        break;
                    case "S5":
                        TransicionesParaS5.usarTransicionS5();
                        break;
                    case "S6":
                        TransicionesParaS6.usarTransicionS6();
                        break;
                    case "S7":
                        TransicionesParaS7.usarTransicionS7();
                        break;
                    case "S8":
                        TransicionesParaS8.usarTransicionS8();
                        break;
                    case "S9":
                        TransicionesParaS9.usarTransicionS9();
                        break;
                    case "Z":
                        desapilarSimaDePila();
                        break;
                }
            } else if (verificarSiPilaEstaVacia()) {
                System.out.println("PILA VACIA Y CARACTER ACEPTADO");
                //Se acepta y se realiza la dicha accion
            } else {//Tomar el simbolo actual
                if (buscarSimaDePila().equals(listaDeLexemas.get(i).getLexema().toString())) {
                    instruccionGuardada+=listaDeLexemas.get(i).getLexema().toString()+" ";
                    //Desapilar
                    pila.remove(pila.size()-1);
                    //Aumentar al siguiente caracter
                    i++;
                } else {
                    //Se debe visualizar si se pueden tomar otros caminos
                    //Tomar la pila actual y pasarle la pila guardada
                    cambioDePila();
                }
            }
        }

    }

    public static void cambioDePila() {
        if (!pilasUsadas.isEmpty()) {
            pila = pilasUsadas.get(pilasUsadas.size() - 1).getPilaActual();
        } else {
            //Pila vuelve a llenarse 
            pila = new ArrayList<>();
            pilasUsadas = new ArrayList<>();
            pila.add("Z");//Llenar la pila con el simbolo especial 
            pila.add("S");//Llenar la pila con el sibolo inicial de la gramatica
            System.out.println("Error");
            //Mandar mensaje de Error
        }
    }

    public static void insertarEnPila(ArrayList<String> elementoAInsertar) {//Recibe una lista de elementos a insertar en la pila
        int inicioDeElemento = elementoAInsertar.size() - 1;
        for (int i = inicioDeElemento; i >= 0; i--) {
            pila.add(elementoAInsertar.get(i));
        }
    }

    private static String buscarSimaDePila() {
        String sima = null;
        if (!pila.isEmpty()) {
            sima = pila.get(pila.size() - 1);
        }
        return sima;
    }

    public static void desapilarSimaDePila() {
        pila.remove(pila.size() - 1);
    }

    private static boolean verificarSiPilaEstaVacia() {
        return pila.isEmpty();
    }

    /**
     * Verifica si el simbolo en la sima de la pila es un simbolo no terminal
     *
     * @return
     */
    private static String buscarSimboloQuePuedaMoverseSinLectura() {
        String simaDePila = buscarSimaDePila();
        Integer miEntero = 1;
        if (simaDePila.equals("S") || simaDePila.equals("Z")) {//Comprobar si la sima de pila es el simbolo inicia de la gramatica o el simbolo final de la pila
            return simaDePila;
        }
        for (int i = 1; i < 10; i++) {//Comprobar si la sima de pila es un no terminal distinto de los dos anteriores
            String cadenaS = "S" + miEntero.toString();
            if (simaDePila.equals(cadenaS)) {
                return simaDePila;
            } else {
                miEntero++;
            }
        }
        return null;
    }

}
