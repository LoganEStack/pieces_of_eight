package com.piecesofeight.parser;

public class Lexer {
    private final String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String digits = "0123456789";
    private Dictionary dictionary = new Dictionary();

    String stmt;
    int index;
    char ch;

    public Lexer(String input){
        stmt = input; index=0; ch = nextChar();
    }

    public Token nextToken(){
        do {
            //end of instruction
            if (ch == '$') {
                return new Token(Token.TokenType.EOI, "");
            }
            // if ch is a letter
            else if (Character.isLetter(ch)) {
                String id = concat(letters);
                // Check if it's a verb
                if ( dictionary.isVerb(id) ) {
                    return new Token(Token.TokenType.VERB, id);
                }
                // Check if it's a location
                if (dictionary.isLocation(id) == 1) {
                    return new Token(Token.TokenType.LOCATION, id);
                }
                // Check if it's a location with a space in the name
                if (dictionary.isLocation(id) == 2) {
                    //save index, concat next word, evaluate that word
                    //   to see if the whole thing is a location, restore index
                    int tempIndex = index;
                    ch = nextChar();
                    String id2 = concat(letters);
                    String fullId = id + " " + id2;
                    if (dictionary.isLocation(fullId) == 1) {
                        return new Token(Token.TokenType.LOCATION, fullId);
                    }
                    // if second word does not complete a location, reset index and pass first word down
                    else {
                        index = tempIndex;
                        ch = stmt.charAt(index-1);
                    }
                }
                // Check if it's an object
                if ( dictionary.isObject(id) ) {
                    return new Token(Token.TokenType.OBJECT, id);
                }
                // Check if it's an entity
                if ( dictionary.isEntity(id) ) {
                    return new Token(Token.TokenType.ENTITY, id);
                }
                // Check if it's an adjective
                if ( dictionary.isAdjective(id) ) {
                    return new Token(Token.TokenType.ADJECTIVE, id);
                }
                // Check if it's any other possibility
                if ( dictionary.isOther(id) ) {
                    return new Token(Token.TokenType.OTHER, id);
                }
                // Return invalid token
                return new Token(Token.TokenType.INVALID, id);
            }
            // Skip over whitespace  ????
            else if (ch == ' ') {
                ch = nextChar();
            }
            // If not a valid character or the start of a tag, return INVALID
            else {
                return new Token(Token.TokenType.INVALID, "");
            }
        } while (true);
    }

    // Iterates to next available character
    private char nextChar() {
        char ch = stmt.charAt(index);
        index = index+1;
        return ch;
    }

    // Concat iterates through and stores a string so long as
    // It's in the set of valid characters
    private String concat(String set) {
        StringBuffer r = new StringBuffer("");
        do {
            r.append(ch); ch = nextChar();
        } while (set.indexOf(ch) >= 0);
        return r.toString();
    }

    // Prints an error message
    public void error(String msg) {
        System.err.println("\nError: location " + index + "; " + msg);
        System.exit(1);
    }
}
