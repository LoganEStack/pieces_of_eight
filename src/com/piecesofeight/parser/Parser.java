package com.piecesofeight.parser;

import java.util.Stack;

public class Parser {

    Lexer lexer;
    Token token;
    Stack<String> stack = new Stack<String>();

    public Parser(String input){
        lexer = new Lexer(input + "$");
        token = lexer.nextToken();
    }

    //runs the parser
    public void run() {
        String indentation = "";
        //while the token is not an EOI
        while (token.getTokenType() != Token.TokenType.EOI &&
                token.getTokenType() != Token.TokenType.INVALID) {

            //if the token is 1 character, it's a STRING
            if (token.getTokenValue().length() == 1) {
                System.out.println(indentation + token.getTokenValue());
                token = lexer.nextToken();
            }
            //if the token is not a closing tag
            else if (token.getTokenValue().charAt(1) != '/') {
                //if the token is a string
                /*if(token.getTokenType() == Token.TokenType.STRING) {
                    System.out.println(indentation + token.getTokenValue());
                    token = lexer.nextToken();
                }
                //if the token is a keyword
                else if(token.getTokenType() == Token.TokenType.KEYWORD) {
                    System.out.println(indentation + token.getTokenValue());
                    indentation += "  ";
                    //push the value onto a stack
                    stack.push(token.getTokenValue());
                    token = lexer.nextToken();
                }
                //if the token is neither a string nor keyword
                else {
                    error();
                }*/
            }
            //if the token is a closing tag
            else {
                //check the stack to ensure correctness
                match();
                //remove two indentation spaces while preventing bounds error
                if(!indentation.equals(""))
                    indentation = indentation.substring(0,indentation.length() - 2);
                System.out.println(indentation + token.getTokenValue());
                token = lexer.nextToken();
            }
        }
        //if the token is invalid or the stack still has tags remaining, error
        if (token.getTokenType() == Token.TokenType.INVALID) {
            error();
        }
        if (!stack.empty()) {
            error();
        }
    }

    //match performs most of the syntax management
    private void match() {
        String temp = stack.pop();

        //ensures that last stack item (first item pushed) is body tag
        if (stack.empty() && !(temp.equals("<body>")) ) {
            error();
        }
        //li must be surrounded by ul
        if (temp.equals("<li>") && !(stack.peek().equals("<ul>")) ) {
            error();
        }
        //and vice versa
        if (!stack.empty() && !(temp.equals("<li>")) && (stack.peek().equals("<ul>")) ) {
            error();
        }

        temp = "</" + temp.substring(1);

        if (!temp.equals(token.getTokenValue())) {
            error();
        }
    }

    private void error() {
        System.err.println("Syntax error");
        System.exit(1);
    }
}
