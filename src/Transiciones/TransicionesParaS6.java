/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transiciones;

import java.util.ArrayList;
import pruebajflex.AnalizadorSintactico;
import pruebajflex.NoTerminales;
import pruebajflex.RecolectorDePilas;

/**
 *
 * @author jesfrin
 */
public class TransicionesParaS6 {

    private static int transicionA_Usar = 1;//Numero de transicion que se usara al inicio

    public static ArrayList<String> usarTransicionS6() {
        ArrayList<String> transiciones = new ArrayList<>();
        if (transicionA_Usar == 1) {//Ingresa por primera vez a el metodo
            AnalizadorSintactico.pilasUsadas.add(new RecolectorDePilas(AnalizadorSintactico.pila, "S6"));//Se anade la pila con la que se entra al metodo

        }
        AnalizadorSintactico.desapilarSimaDePila();
        switch (transicionA_Usar) {
            case 1:
                transiciones.add(NoTerminales.S7.toString());
                transiciones.add(NoTerminales.S8.toString());
                break;
            default:
                AnalizadorSintactico.pilasUsadas.remove(AnalizadorSintactico.pilasUsadas.size() - 1);
                AnalizadorSintactico.cambioDePila();
                transicionA_Usar = 1;
                return null;
        }
        AnalizadorSintactico.insertarEnPila(transiciones);//Se isertan en pila los elementos
        transicionA_Usar++;
        return transiciones;
    }
}
