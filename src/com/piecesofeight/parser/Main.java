package com.piecesofeight.parser;

import com.piecesofeight.core.Player;

public class Main {
    public static void main (String args[]) {

        //testing the lexer
        /*Lexer lex = new Lexer ("listen$");
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
        }*/


        Player player = new Player();

        // testing the parser
        Parser parser = new Parser ("move to main deck");
        parser.run();
    }
}
