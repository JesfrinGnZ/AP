/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebajflex;

import java.io.File;

/**
 *
 * @author jesfrin
 */
public class PruebaJflex {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        String path = "/home/jesfrin/NetBeansProjects/PruebaJflex/src/pruebajflex/Lexer.flex";
//        generarLexer(path);
        FramePrincipal nuevo = new FramePrincipal();
        nuevo.setVisible(true);

    }

    public static void generarLexer(String path) {
        File file = new File(path);
        jflex.Main.generate(file);
    }
}
