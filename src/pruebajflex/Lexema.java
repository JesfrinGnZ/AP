/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebajflex;

/**
 *
 * @author jesfrin
 */
public class Lexema {
    
    private String token;
    private Token lexema;
    private int fila;
    private int columna;

    public Lexema() {
    }

    
    public Lexema(String token, Token lexema, int columna, int fila) {
        this.token = token;
        this.lexema = lexema;
        this.fila = fila;
        this.columna = columna;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Token getLexema() {
        return lexema;
    }

    public void setLexema(Token lexema) {
        this.lexema = lexema;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
    
    
}
