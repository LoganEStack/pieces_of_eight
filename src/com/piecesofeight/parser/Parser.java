package com.piecesofeight.parser;

public class Parser {

    Lexer lexer;
    Token token;
    Actions actions;

    public Parser(String input) {
        lexer = new Lexer(input + "$");
        token = lexer.nextToken();
        actions = new Actions();
    }

    // runs the parser
    public int run() {
        String verb = "";
        String adjective = "";
        String noun = "";

        // while the token is not an EOI
        while (token.getTokenType() != Token.TokenType.EOI) {
            // If the token is a verb, scan ahead for the first noun to apply that verb to
            if (token.getTokenType() == Token.TokenType.VERB) {
                verb = token.toString();
            } else if (token.getTokenType() == Token.TokenType.ADJECTIVE) {
                adjective = token.toString();
            } else if (token.getTokenType() == Token.TokenType.LOCATION) {
                noun = token.toString();
            } else if (token.getTokenType() == Token.TokenType.OBJECT) {
                noun = token.toString();
            } else if (token.getTokenType() == Token.TokenType.ENTITY) {
                noun = token.toString();
            } else if (token.getTokenType() == Token.TokenType.INVALID) {
                System.out.println("Invalid token: " + token.toString());
                return 0;
            }

            token = lexer.nextToken();
        }

        // If a verb and noun exist
        if (verb != "" && noun != "") {
            if (verb.equals("move")) { actions.move(noun, adjective); }
            else if (verb.equals("look")) { actions.look(noun, adjective); }
            else if (verb.equals("run")) { actions.run(noun, adjective); }
            else if (verb.equals("listen")) { actions.listen(noun, adjective); }
            else if (verb.equals("speak")) { actions.speak(noun, adjective); }
            else if (verb.equals("climb")) { actions.climb(noun, adjective); }
            else if (verb.equals("sneak")) { actions.sneak(noun, adjective); }
            else if (verb.equals("take")) { actions.take(noun, adjective); }
            else if (verb.equals("throw")) { actions.throw_(noun, adjective); }
            else if (verb.equals("attack")) { actions.attack(noun, adjective); }
            else {
                System.out.println("Command not understood.");
                return 0;
            }
            return 1;
        }
        // If just a verb exists
        else if (verb != "") {
            if (verb.equals("look")) { actions.look(); }
            else if (verb.equals("listen")) { actions.listen(); }
            else if (verb.equals("speak")) { actions.speak(); }
            else if (verb.equals("inventory")) { actions.inventory(); }
            else if (verb.equals("quit")) { actions.quit(); }
            else if (verb.equals("help")) { actions.help(); }
            else {
                System.out.println("Command not understood.");
                return 0;
            }
            return 1;
        }
        else {
            System.out.println("Command not understood.");
            return 0;
        }
    }
}
