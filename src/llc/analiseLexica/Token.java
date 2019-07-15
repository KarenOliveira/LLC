package llc.analiseLexica;

public class Token {

    public static final int ID             = 0;
    public static final int INT_NUMBER     = 1;
    public static final int FLOAT_NUMBER   = 2;
    public static final int OPERATOR       = 3;
    public static final int RESERVERD_WORD = 4;
    public static final int PONTUACTION    = 5;
    public static final int MSG_ERRO = 6;
    
    private int id;
    private String text, erro;

    public Token() {
        id = 0;
        text = "";
    }

    public Token(int id, String text) {
        this.id = id;
        this.text = text;
    }
   

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String str) {
        this.text = str;
    }

    public String getText() {
        return this.text;
    }
    
    public String toString(){
        return "<"+id+","+text+">";
    }
}
