/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebajflex;

import ManejoDeEstructuras.Asignacion;
import ManejoDeEstructuras.Condicional;
import ManejoDeEstructuras.Escritura;
import ManejoDeEstructuras.Estructura;
import ManejoDeEstructuras.ManejadorDeEscritura;
import ManejoDeEstructuras.Repetir;
import Transiciones.TransicionesNoTerminales;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author jesfrin
 */
public class AnalizadorSintactico {

    private static File rutaDeArchivoDeSalida;
    private static ArrayList<RecolectorDePilas> pilasUsadas = new ArrayList<>();//Pilas que se usaro con anterioridad
    private static ArrayList<String> pila = new ArrayList<>();//Pila donde se isertara y eliminaran elementos
    private static ArrayList<Estructura> estructurasFormadas = new ArrayList<>();
    private static ArrayList<Lexema> listaDeLexemasP = new ArrayList<>();
    private static boolean esLaPrimeraVezEntrandoAlMetodo = true;//Verifica que camino se debe tomar si hay multiples caminos, ya que si es la primera vez entrando al metodo se creara una copia de la pila
    private static int posicionDeAnalisis;
    private static String instruccionGuardada;
    private static boolean hayErrores = false;

    public static void realizarAnalisis(ArrayList<Lexema> listaDeLexemas, JTextArea analisisSintacticoTextArea) {
        pila = new ArrayList<>();
        pilasUsadas = new ArrayList<>();
        estructurasFormadas = new ArrayList<>();
        posicionDeAnalisis = 0;
        instruccionGuardada = "";
        esLaPrimeraVezEntrandoAlMetodo = true;
        hayErrores = false;
        pila.add("Z");//Llenar la pila con el simbolo especial 
        pila.add("S");//Llenar la pila con el sibolo inicial de la gramatica
        listaDeLexemasP = listaDeLexemas;
        for (posicionDeAnalisis = 0; posicionDeAnalisis < listaDeLexemas.size();) {

            if (buscarSimboloQuePuedaMoverseSinLectura() != null) {
                switch (buscarSimaDePila()) {//Buscar transicion segun estado no terminal, movimiento automatico
                    case "S":
                        TransicionesNoTerminales.usarTransicionS(posicionDeAnalisis, instruccionGuardada, esLaPrimeraVezEntrandoAlMetodo, "S", analisisSintacticoTextArea);
                        break;
                    case "S1":
                        TransicionesNoTerminales.usarTransicionS(posicionDeAnalisis, instruccionGuardada, esLaPrimeraVezEntrandoAlMetodo, "S1", analisisSintacticoTextArea);
                        break;
                    case "S2":
                        TransicionesNoTerminales.usarTransicionS(posicionDeAnalisis, instruccionGuardada, esLaPrimeraVezEntrandoAlMetodo, "S2", analisisSintacticoTextArea);
                        break;
                    case "S3":
                        TransicionesNoTerminales.usarTransicionS(posicionDeAnalisis, instruccionGuardada, esLaPrimeraVezEntrandoAlMetodo, "S3", analisisSintacticoTextArea);
                        break;
                    case "S4":
                        TransicionesNoTerminales.usarTransicionS(posicionDeAnalisis, instruccionGuardada, esLaPrimeraVezEntrandoAlMetodo, "S4", analisisSintacticoTextArea);
                        break;
                    case "S5":
                        TransicionesNoTerminales.usarTransicionS(posicionDeAnalisis, instruccionGuardada, esLaPrimeraVezEntrandoAlMetodo, "S5", analisisSintacticoTextArea);
                        break;
                    case "S6":
                        TransicionesNoTerminales.usarTransicionS(posicionDeAnalisis, instruccionGuardada, esLaPrimeraVezEntrandoAlMetodo, "S6", analisisSintacticoTextArea);
                        break;
                    case "S7":
                        TransicionesNoTerminales.usarTransicionS(posicionDeAnalisis, instruccionGuardada, esLaPrimeraVezEntrandoAlMetodo, "S7", analisisSintacticoTextArea);
                        break;
                    case "S8":
                        TransicionesNoTerminales.usarTransicionS(posicionDeAnalisis, instruccionGuardada, esLaPrimeraVezEntrandoAlMetodo, "S8", analisisSintacticoTextArea);
                        break;
                    case "Z":
                        desapilarSimaDePila();
                        break;
                }
            } else if (verificarSiPilaEstaVacia()) {
                String tipoDeEstructura = buscarTipoDeEstructura();
                System.out.println("ESTRUCTURA ACEPTADA, TIPO:" + tipoDeEstructura + " " + "ESTRUCUTURA:" + instruccionGuardada);
                analisisSintacticoTextArea.append("ESTRUCTURA ACEPTADA, TIPO" + tipoDeEstructura + " " + instruccionGuardada + "\n");
                if (!hayErrores) {
                    anadirLexemas(listaDeLexemas, tipoDeEstructura);
                }
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
                        String tipoDeEstructura = buscarTipoDeEstructura();
                        System.out.println("ESTRUCTURA ACEPTADA, TIPO" + tipoDeEstructura + " " + instruccionGuardada);
                        analisisSintacticoTextArea.append("ESTRUCTURA ACEPTADA, TIPO" + tipoDeEstructura + " " + instruccionGuardada + "\n");
                        if (!hayErrores) {
                            anadirLexemas(listaDeLexemas, tipoDeEstructura);
                        }
                        pila = new ArrayList<>();
                        pilasUsadas = new ArrayList<>();
                        break;
                    } else if ((posicionDeAnalisis + 1) == listaDeLexemas.size() && !buscarSimaDePila().equals("Z")) {//2)Ya no hay mas que leer y la sima de la pila no era z, no se acepta
                        analisisSintacticoTextArea.append("****************ERROR, ESTRUCTURA ENCONTRADA NO VALIDA EN FILA:" + listaDeLexemas.get(posicionDeAnalisis - 1).getFila() + " " + "COLUMNA:" + listaDeLexemas.get(posicionDeAnalisis - 1).getColumna() + "\n");
                        System.out.println("ERROR LA ESTRUCTURA NO ES VALIDA:" + instruccionGuardada);
                        pila = new ArrayList<>();
                        pilasUsadas = new ArrayList<>();
                        hayErrores = true;
                        break;
                    } else {//3)Aun se puede leer, por lo tanto se aumenta la posicion del arreglo
                        posicionDeAnalisis++;
                    }
                    esLaPrimeraVezEntrandoAlMetodo = true;
                } else {//Se debe visualizar si se pueden tomar otros caminos
                    //Tomar la pila actual y pasarle la pila guardada
                    cambioDePila(analisisSintacticoTextArea);
                }
            }
        }
        System.out.println("FIN DEL ANALISIS SINTACTICO");
        ManejadorDeEscritura nuevaEscritura = new ManejadorDeEscritura(estructurasFormadas, new File(""));
         nuevaEscritura.evaluarEstructuras();
//        for (Estructura estructurasFormada : estructurasFormadas) {
//            if (estructurasFormada instanceof Asignacion) {
//                System.out.println("ASIGNACION");
//                for (Lexema listaDeLexema : estructurasFormada.getListaDeLexemas()) {
//                    System.out.println("LEXEMA:" + listaDeLexema.getLexema());
//                    System.out.println("Token:" + listaDeLexema.getToken());
//                }
//            } else if (estructurasFormada instanceof Escritura) {
//                System.out.println("        ESCRITURA");
//                for (Lexema listaDeLexema : estructurasFormada.getListaDeLexemas()) {
//                    System.out.println("LEXEMA:" + listaDeLexema.getLexema());
//                    System.out.println("Token:" + listaDeLexema.getToken());
//                }
//            } else if (estructurasFormada instanceof Repetir) {
//                System.out.println("        REPETIR");
//                for (Lexema listaDeLexema : estructurasFormada.getListaDeLexemas()) {
//                    System.out.println("LEXEMA:" + listaDeLexema.getLexema());
//                    System.out.println("Token:" + listaDeLexema.getToken());
//                }
//            } else if (estructurasFormada instanceof Condicional) {
//                System.out.println("        CONDICIONAL");
//                for (Lexema listaDeLexema : estructurasFormada.getListaDeLexemas()) {
//                    System.out.println("LEXEMA:" + listaDeLexema.getLexema());
//                    System.out.println("Token:" + listaDeLexema.getToken());
//                }
//            }
//        }
    }

    public static void cambioDePila(JTextArea analisisSintacticoTextArea) {
        if (!pilasUsadas.isEmpty()) {
            ArrayList<String> pilaNueva = new ArrayList<>();//Nueva direccion para pila nueva
            pilaNueva = pilasUsadas.get(pilasUsadas.size() - 1).getPilaActual();
            pila = new ArrayList<>();//Nueva direccion para pila, que tendra los valores anteriores de la pila q se uso anteriormente
            for (String datoDePila : pilaNueva) {
                pila.add(datoDePila);
            }
            esLaPrimeraVezEntrandoAlMetodo = false;//Se cambio a falso para que tome un nuevo camino
            posicionDeAnalisis = pilasUsadas.get(pilasUsadas.size() - 1).getPosicionDeLexema();//El analisis se cambia a la posicion de la pila usada con anterioridad
            instruccionGuardada = pilasUsadas.get(pilasUsadas.size() - 1).getInstruccionActual();//La instruccion vuelve a ser la que se tenia en la pila usada anteriormente
        } else {
            //Se debe comenzar el analisis en la posicion i+1
            //Pila vuelve a llenarse 
            pila = new ArrayList<>();
            pilasUsadas = new ArrayList<>();
            pila.add("Z");//Llenar la pila con el simbolo especial 
            pila.add("S");//Llenar la pila con el sibolo inicial de la gramatica
            esLaPrimeraVezEntrandoAlMetodo = true;
            System.out.println("ERROR LA ESTRUCTURA NO ES VALIDA:" + instruccionGuardada);
            analisisSintacticoTextArea.append("****************ERROR, ESTRUCTURA ENCONTRADA NO VALIDA EN FILA:" + listaDeLexemasP.get(posicionDeAnalisis).getFila() + " " + "COLUMNA:" + listaDeLexemasP.get(posicionDeAnalisis).getColumna() + "\n");
            instruccionGuardada = "";//Reinicio de valores
            hayErrores = true;
            posicionDeAnalisis++;
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

    public static String buscarTipoDeEstructura() {
        int tipoDeEstrucuturaEntero = pilasUsadas.get(0).getOpcionA_Usar();
        switch (tipoDeEstrucuturaEntero) {
            case 1:
                return "ASIGNACION";
            case 2:
                return "ESCRITURA";
            case 3:
                return "REPETIR";
            case 4:
                return "CONDICIONAL";
            default:
                return null;
        }
    }

    public static void anadirLexemas(ArrayList<Lexema> listaDeLexemas, String tipoDeEstructura) {
        int tamanoDeEstructura = instruccionGuardada.split(" ").length;
        int recorridoDeLexemas;
        if (posicionDeAnalisis == tamanoDeEstructura || (posicionDeAnalisis + 1) < listaDeLexemas.size()) {
            recorridoDeLexemas = posicionDeAnalisis - 1;
            System.out.println("POSICION DE ANALISIS IGUAL AL DE LECTURA");
        } else {
            recorridoDeLexemas = posicionDeAnalisis;
            System.out.println("POSICION NO ES IGUAL");
        }

        ArrayList<Lexema> misLexemas = new ArrayList<>();
        for (int i = tamanoDeEstructura; i > 0; i--) {
            misLexemas.add(listaDeLexemas.get(recorridoDeLexemas));
            recorridoDeLexemas--;
            System.out.println("LLENAMOS ARREGLO");
        }
        ArrayList<Lexema> lexemaAuxiliar = new ArrayList<>();
        for (int i = (misLexemas.size() - 1); i >= 0; i--) {
            lexemaAuxiliar.add(misLexemas.get(i));
        }

        switch (tipoDeEstructura) {
            case "ASIGNACION":
                estructurasFormadas.add(new Asignacion(lexemaAuxiliar));
                break;
            case "ESCRITURA":
                estructurasFormadas.add(new Escritura(lexemaAuxiliar));
                break;
            case "REPETIR":
                estructurasFormadas.add(new Repetir(lexemaAuxiliar));
                break;
            case "CONDICIONAL":
                estructurasFormadas.add(new Condicional(lexemaAuxiliar));
                break;
        }
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

    public static File getRutaDeArchivoDeSalida() {
        return rutaDeArchivoDeSalida;
    }

    public static void setRutaDeArchivoDeSalida(File rutaDeArchivoDeSalida) {
        AnalizadorSintactico.rutaDeArchivoDeSalida = rutaDeArchivoDeSalida;
    }
}
