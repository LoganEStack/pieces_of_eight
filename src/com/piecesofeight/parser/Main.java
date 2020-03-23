package com.piecesofeight.parser;

public class Main {
    public static void main (String args[]) {

        //testing the lexer
        Lexer lex = new Lexer ("main tun$");
        Token tk = lex.nextToken();
        while (tk.getTokenType() != Token.TokenType.EOI) {
            if (tk.getTokenType() == Token.TokenType.INVALID) {
                System.out.println("Invalid Token!");
            }
            else {
                System.out.println(tk.getTokenValue());
                System.out.println(tk.getTokenType());
            }
            tk = lex.nextToken();
        }

        /* testing the parser
        Parser parser = new Parser ("<body><ul> <li>  test </li></ul><b>hi</b></body>");
        parser.run();
        Parser parser2 = new Parser ("<body> google <b><i><b> yahoo</b></i></b></body>");
        parser2.run();*/
    }
}
