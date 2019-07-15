package llc.analiseLexica;

import java.io.File;
import java.nio.file.Files;
import java.io.IOException;

public class AnalisadorLexico {

    private String[] reservedWords = {"programa","declare","escreva","leia", "inteiros","inicio", "fim"};
    private char[] content;
    private int pos;

    public AnalisadorLexico(String filename) {
        try {
            byte[] bContent = Files.readAllBytes(new File(filename).toPath());
            this.content = new String(bContent).toCharArray();
            this.pos = 0;
        } catch (IOException ex) {
            System.err.println("Erro ao ler arquivo");
        }

    }

    private boolean isReservedWord(String text){
        for (String s: reservedWords){
            if (text.equals(s)){
                return true;
            }
        }
        return false;
    }
    private boolean eof() {
        return pos == content.length;
    }

    private char nextChar() {
        return content[pos++];
    }

    private boolean isLetter(char c) {
        return c >= 'a' && c <= 'z';
    }

    private boolean isBlank(char c) {
        return c == ' ' || c == '\n' || c == '\t' || c == '\r';
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == ':' || c == '=' ; 
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
    
    private boolean isPunctuation(char c){
        return c == '.' || c == ',' || c == ':' || c == '(' || c == ')'|| c == ':' ;
    }

    private void retroceder() {
        pos--;
    }

    public Token nextToken() {
        int s = 0;
        String text = "";
        Token token;
        while (true) {
            if (eof()) {
                return null;
            }
            switch (s) {
                case 0:
                    char c = nextChar();
                    if (isLetter(c)) {
                        s = 1;
                        text += c;
                    } else if (isOperator(c)) {
                        text += c;
                        s = 2;
       			           } else if (isBlank(c)) {
                        s = 0;
                    } else if (isPunctuation(c)) {
                    	text+= c;
                    	s = 3;
                    } else if (isDigit(c)) {
                    	text += c;
                    	s = 4;
                    } else {
                    	return new Token(Token.MSG_ERRO, text);
                    }
                    break;
                case 1:
                    c = nextChar();
                    if (isLetter(c) || isDigit(c)) {
                        s = 1;
                        text += c;
                    } else if (isBlank(c) || isPunctuation(c)) {
                        if (isReservedWord(text)) {
                        	retroceder();
                           return new Token(Token.RESERVERD_WORD, text);
                        }
                        else {
                        	retroceder();
                            return new Token(Token.ID, text);
                        }
                    } else if (isOperator(c)) {
                        retroceder();
                        return new Token(Token.ID, text);
                    } else {
                    	return new Token(Token.MSG_ERRO, text);
                    }
                    break;
                case 2:
                	c = nextChar();
                	if(c == '=' && text.equals(":")) {
                		text += c;
                		return new Token(Token.OPERATOR, text);
                            } else {
                    return new Token(Token.OPERATOR, text);
                            }  
                case 3:
                	c = nextChar();
                	if(c == '=') {
                		s =2 ;
                	}
                	else if (isBlank(c) || isDigit(c) || isLetter(c)||isPunctuation(c)) {
                		retroceder();
                		return new Token(Token.PONTUACTION, text);
                	} 
                	break;
                	
                case 4:
                	c = nextChar();
                	char d = nextChar();
                	if(isDigit(c)) {
                		s = 4;
                		text += c;
                	} else if (c == '.' && isDigit(d)) {
                		s = 5;
                		text += c;
                		text += d;
                		
                	} else if (isBlank(c) || isPunctuation(c)) {
                		retroceder();
                		retroceder();
                		return new Token(Token.INT_NUMBER, text);
                	} else {
                		return new Token(Token.MSG_ERRO, text);
                	}
                	break;
                	
                case 5:
                	c = nextChar();
                	if(isDigit(c)) {
                		s =5;
                		text += c;
                	} else if(isBlank(c)) {
                		retroceder();
                		//text = text.substring(0, text.length() -1);
                		return new Token(Token.INT_NUMBER, text);
                	} else if(isBlank(c) || isPunctuation(c) ) {
                		retroceder();
                		return new Token(Token.FLOAT_NUMBER, text);
                	} else {
                		return new Token(Token.MSG_ERRO, text);
                	}
                	break;
            }
        }
    }
}
