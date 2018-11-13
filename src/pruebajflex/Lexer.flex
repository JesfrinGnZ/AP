package pruebajflex;
import pruebajflex.Token;

%%
%class Lexer
%type Token
%unicode
%line
%column

DIGITO = [0-9]
DIGITO_NATURAL=[1-9]
SEPARADORES = [ \n\r\t]
LETRA=[a-zA-Z]
%{
    Lexema lexemaActual;
    
    public Lexema getLexemaActual(){
        return this.lexemaActual;
    }
    
%}

%%

<YYINITIAL> {
        
	{SEPARADORES} {/* ignoramos */}
        ([0]|({DIGITO_NATURAL}{DIGITO}*)) {lexemaActual = new Lexema(yytext(),Token.NUMERO_ENTERO_POSITIVO, yycolumn+1, yyline +1); return Token.NUMERO_ENTERO_POSITIVO;}
        [-]?([0]|({DIGITO_NATURAL}{DIGITO}*)) {lexemaActual = new Lexema(yytext(),Token.NUMERO_ENTERO_NEGATIVO, yycolumn+1, yyline +1); return Token.NUMERO_ENTERO_NEGATIVO;}

        "ESCRIBIR" {lexemaActual = new Lexema(yytext(),Token.ESCRIBIR, yycolumn+1, yyline +1); return Token.ESCRIBIR;}
        "FIN" {lexemaActual = new Lexema(yytext(),Token.FIN, yycolumn+1, yyline +1); return Token.FIN;}
        "REPETIR"  {lexemaActual = new Lexema(yytext(),Token.REPETIR, yycolumn+1, yyline +1); return Token.REPETIR;}
        "INICIAR"  {lexemaActual = new Lexema(yytext(),Token.INICIAR, yycolumn+1, yyline +1); return Token.INICIAR;}
        "SI"  {lexemaActual = new Lexema(yytext(),Token.SI, yycolumn+1, yyline +1); return Token.SI;}
        "VERDADERO"  {lexemaActual = new Lexema(yytext(),Token.VERDADERO, yycolumn+1, yyline +1); return Token.VERDADERO;}
        "FALSO"  {lexemaActual = new Lexema(yytext(),Token.FALSO, yycolumn+1, yyline +1); return Token.FALSO;}
        "ENTONCES"  {lexemaActual = new Lexema(yytext(),Token.ENTONCES, yycolumn+1, yyline +1); return Token.ENTONCES;}
        ["\""].*["\""] {lexemaActual = new Lexema(yytext(),Token.LITERAL, yycolumn+1, yyline +1); return Token.LITERAL;}
        ([_]|{LETRA}) (({LETRA}|{DIGITO}|[-]|[_])*)? {lexemaActual = new Lexema(yytext(),Token.IDENTIFICADOR, yycolumn+1, yyline +1); return Token.IDENTIFICADOR;}
        [/][/].*["\n"$]    {lexemaActual = new Lexema(yytext(),Token.COMENTARIO_DE_UNA_LINEA, yycolumn+1, yyline +1); return Token.COMENTARIO_DE_UNA_LINEA;}
        "("  {lexemaActual = new Lexema(yytext(),Token.PARENTESIS_ABIERTO, yycolumn+1, yyline +1); return Token.PARENTESIS_ABIERTO;}
        ")"  {lexemaActual = new Lexema(yytext(),Token.PARENTESIS_CERRADO, yycolumn+1, yyline +1); return Token.PARENTESIS_CERRADO;}
        "="  {lexemaActual = new Lexema(yytext(),Token.SIGNO_IGUAL, yycolumn+1, yyline +1); return Token.SIGNO_IGUAL;}
        "*"  {lexemaActual = new Lexema(yytext(),Token.SIGNO_MULTIPLICACION, yycolumn+1, yyline +1); return Token.SIGNO_MULTIPLICACION;}
        "+"  {lexemaActual = new Lexema(yytext(),Token.SIGNO_SUMA, yycolumn+1, yyline +1); return Token.SIGNO_SUMA;}
        . {lexemaActual = new Lexema(yytext(),Token.ERROR, yycolumn+1, yyline +1); return Token.ERROR;}
}
