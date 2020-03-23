package com.piecesofeight.parser;

public class Token {
    public enum TokenType {VERB, OBJECT, LOCATION, ENTITY, ADJECTIVE, OTHER, EOI, INVALID}

    private TokenType type;
    private String val;

    Token (TokenType t, String v) {
        type = t; val = v;
    }

    TokenType getTokenType() {return type;}
    String getTokenValue() {return val;}
}
