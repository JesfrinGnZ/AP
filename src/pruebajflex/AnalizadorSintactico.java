/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebajflex;

import Transiciones.TransicionesNoTerminales;
import java.util.ArrayList;

/**
 *
 * @author jesfrin
 */
public class AnalizadorSintactico {

    private static ArrayList<RecolectorDePilas> pilasUsadas = new ArrayList<>();//Pilas que se usaro con anterioridad
    private static ArrayList<String> pila = new ArrayList<>();//Pila donde se isertara y eliminaran elementos
    private static boolean esLaPrimeraVezEntrandoAlMetodo = true;//Verifica que camino se debe tomar, si hay multiples caminos
    private static int posicionDeAnalisis;
    private static String instruccionGuardada;

    public static void realizarAnalisis(ArrayList<Lexema> listaDeLexemas) {
        pila = new ArrayList<>();
        pilasUsadas = new ArrayList<>();
        posicionDeAnalisis = 0;
        instruccionGuardada = "";
        esLaPrimeraVezEntrandoAlMetodo=true;
        pila.add("Z");//Llenar la pila con el simbolo especial 
        pila.add("S");//Llenar la pila con el sibolo inicial de la gramatica
        for (posicionDeAnalisis = 0; posicionDeAnalisis < listaDeLexemas.size();) {

            if (buscarSimboloQuePuedaMoverseSinLectura() != null) {
                switch (buscarSimaDePila()) {//Buscar transicion segun estado no terminal, movimiento automatico
                    case "S":
                        TransicionesNoTerminales.usarTransicionS(posicionDeAnalisis, esLaPrimeraVezEntrandoAlMetodo, "S");
                        break;
                    case "S1":
                        TransicionesNoTerminales.usarTransicionS(posicionDeAnalisis, esLaPrimeraVezEntrandoAlMetodo, "S1");
                        break;
                    case "S2":
                        TransicionesNoTerminales.usarTransicionS(posicionDeAnalisis, esLaPrimeraVezEntrandoAlMetodo, "S2");
                        break;
                    case "S3":
                        TransicionesNoTerminales.usarTransicionS(posicionDeAnalisis, esLaPrimeraVezEntrandoAlMetodo, "S3");
                        break;
                    case "S4":
                        TransicionesNoTerminales.usarTransicionS(posicionDeAnalisis, esLaPrimeraVezEntrandoAlMetodo, "S4");
                        break;
                    case "S5":
                        TransicionesNoTerminales.usarTransicionS(posicionDeAnalisis, esLaPrimeraVezEntrandoAlMetodo, "S5");
                        break;
                    case "S6":
                        TransicionesNoTerminales.usarTransicionS(posicionDeAnalisis, esLaPrimeraVezEntrandoAlMetodo, "S6");
                        break;
                    case "S7":
                        TransicionesNoTerminales.usarTransicionS(posicionDeAnalisis, esLaPrimeraVezEntrandoAlMetodo, "S7");
                        break;
                    case "S8":
                        TransicionesNoTerminales.usarTransicionS(posicionDeAnalisis, esLaPrimeraVezEntrandoAlMetodo, "S8");
                        break;
//                    case "S9":
//                        TransicionesNoTerminales.usarTransicionS(posicionDeAnalisis, esLaPrimeraVezEntrandoAlMetodo, "S9");
//                        break;
                    case "Z":
                        desapilarSimaDePila();
                        break;
                }
            } else if (verificarSiPilaEstaVacia()) {
                System.out.println("ESTRUCTURA ACEPTADA:" + instruccionGuardada);
                instruccionGuardada = "";
                if ((posicionDeAnalisis + 1) == listaDeLexemas.size()) {//Se ha terminado la cadena
                    pila = new ArrayList<>();
                    pilasUsadas = new ArrayList<>();
                    pila.add("Z");//Llenar la pila con el simbolo especial 
                    pila.add("S");//Llenar la pila con el sibolo inicial de la gramatica
                    esLaPrimeraVezEntrandoAlMetodo = true;
                    //break;
                } else {//Se pasa al siguiente caracter
                    //posicionDeAnalisis++;
                    pila = new ArrayList<>();
                    pilasUsadas = new ArrayList<>();
                    pila.add("Z");//Llenar la pila con el simbolo especial 
                    pila.add("S");//Llenar la pila con el sibolo inicial de la gramatica
                    esLaPrimeraVezEntrandoAlMetodo = true;
                }
            } else {
                if (buscarSimaDePila().equals(listaDeLexemas.get(posicionDeAnalisis).getLexema().toString())) {//Desapilar elemento terminal, si el elemento coincide con la sima de la pila
                    instruccionGuardada += listaDeLexemas.get(posicionDeAnalisis).getLexema().toString() + " ";
                    pila.remove(pila.size() - 1);
                    //Aumentar al siguiente caracter
                    //Se pueden dar 3 casos:
                    if ((posicionDeAnalisis + 1) == listaDeLexemas.size() && buscarSimaDePila().equals("Z")) {//1)Ya no hay mas que leer y la sima de pila era z, por lo tanto se acepta
                        System.out.println("ESTRUCTURA ACEPTADA:" + instruccionGuardada);
                        pila = new ArrayList<>();
                        pilasUsadas = new ArrayList<>();
                        break;
                    } else if ((posicionDeAnalisis + 1) == listaDeLexemas.size() && !buscarSimaDePila().equals("Z")) {//2)Ya no hay mas que leer y la sima de la pila no era z, no se acepta
                        System.out.println("ERROR LA ESTRUCTURA NO ES VALIDA:" + instruccionGuardada);
                        pila = new ArrayList<>();
                        pilasUsadas = new ArrayList<>();
                        break;
                    } else {//3)Aun se puede leer, por lo tanto se aumenta la posicion del arreglo
                        posicionDeAnalisis++;
                    }
                    esLaPrimeraVezEntrandoAlMetodo = true;
                } else {//Se debe visualizar si se pueden tomar otros caminos
                    //Tomar la pila actual y pasarle la pila guardada
                    cambioDePila();
                }
            }
        }
        System.out.println("FIN DEL ANALISIS SINTACTICO");
    }

    public static void cambioDePila() {
        if (!pilasUsadas.isEmpty()) {
            ArrayList<String> pilaNueva = new ArrayList<>();
            pilaNueva = pilasUsadas.get(pilasUsadas.size() - 1).getPilaActual();
            pila = new ArrayList<>();
            for (String datoDePila : pilaNueva) {
                pila.add(datoDePila);
            }
            esLaPrimeraVezEntrandoAlMetodo = false;
            posicionDeAnalisis = pilasUsadas.get(pilasUsadas.size() - 1).getPosicionDeLexema();
        } else {
            //Se debe comenzar el analisis en la posicion i+1
            //Pila vuelve a llenarse 
            pila = new ArrayList<>();
            pilasUsadas = new ArrayList<>();
            pila.add("Z");//Llenar la pila con el simbolo especial 
            pila.add("S");//Llenar la pila con el sibolo inicial de la gramatica
            esLaPrimeraVezEntrandoAlMetodo = true;
            System.out.println("ERROR LA ESTRUCTURA NO ES VALIDA:" + instruccionGuardada);
            instruccionGuardada = "";
            posicionDeAnalisis++;
            //Mandar mensaje de Error
        }
    }

    public static void insertarEnPila(ArrayList<String> elementoAInsertar) {//Recibe una lista de elementos a insertar en la pila
        int inicioDeElemento = elementoAInsertar.size() - 1;
        for (int i = inicioDeElemento; i >= 0; i--) {
            pila.add(elementoAInsertar.get(i));
        }
    }

    public static String buscarSimaDePila() {
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
    public static String buscarSimboloQuePuedaMoverseSinLectura() {
        String simaDePila = buscarSimaDePila();
        Integer miEntero = 1;
        if (simaDePila == null) {
            return null;
        }
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

    public static ArrayList<RecolectorDePilas> getPilasUsadas() {
        return pilasUsadas;
    }

    public static void setPilasUsadas(ArrayList<RecolectorDePilas> pilasUsadas) {
        AnalizadorSintactico.pilasUsadas = pilasUsadas;
    }

    public static ArrayList<String> getPila() {
        return pila;
    }

    public static void setPila(ArrayList<String> pila) {
        AnalizadorSintactico.pila = pila;
    }

    public static boolean isEsLaPrimeraVezEntrandoAlMetodo() {
        return esLaPrimeraVezEntrandoAlMetodo;
    }

    public static void setEsLaPrimeraVezEntrandoAlMetodo(boolean esLaPrimeraVezEntrandoAlMetodo) {
        AnalizadorSintactico.esLaPrimeraVezEntrandoAlMetodo = esLaPrimeraVezEntrandoAlMetodo;
    }

    public static int getPosicionDeAnalisis() {
        return posicionDeAnalisis;
    }

    public static void setPosicionDeAnalisis(int posicionDeAnalisis) {
        AnalizadorSintactico.posicionDeAnalisis = posicionDeAnalisis;
    }

}