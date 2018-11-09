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
public enum Token {
    //Funcionan tanto como tokens como terminales
    ESCRIBIR,
    FIN,
    REPETIR,
    INICIAR,
    SI,
    VERDADERO,
    FALSO,
    ENTONCES,
    IDENTIFICADOR,
    NUMERO_ENTERO_POSITIVO,
    NUMERO_ENTERO_NEGATIVO,
    LITERAL,
    COMENTARIO_DE_UNA_LINEA,
    PARENTESIS_ABIERTO,
    PARENTESIS_CERRADO,
    SIGNO_IGUAL,
    SIGNO_MULTIPLICACION,
    SIGNO_SUMA,
    ERROR;
}
