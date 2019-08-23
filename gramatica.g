class MeuParser extends Parser;
{
	java.util.Map<String, String> mapaVar;
	Programa p;

    public void setPrograma(String name){
      p = new Programa(name);
    }
  
    public Programa getPrograma(){
       return p;
    }
}

prog	: { mapaVar = new java.util.HashMap<String, String>();
          }
          "programa" declara bloco  
	;

declara : "declare" 
              ("dec"|"num") T_Id {mapaVar.put(LT(0).getText(), LT(-1).getText());p.addCommand(new CmdDeclara(LT(0).getText(),LT(-1).getText()));}
              	( 
              		T_virg 
              		("dec"|"num") T_Id {mapaVar.put(LT(0).getText(), LT(-1).getText());p.addCommand(new CmdDeclara(LT(0).getText(),LT(-1).getText()));}
              )* 
           
           T_pontof 
		   {
		      p.setVariaveis(mapaVar);
			  System.out.println("Variable list assembled...");
		   }
	;

bloco   : (cmd)+ "fimprog"
	;

cmd	:  cmdLeia    T_pontof  
	|  cmdEscr    T_pontof
	|  cmdAttr    T_pontof
	|  cmdIf 
        ;   
        

cmdLeia :  "leia" T_ap 
            T_Id       {
            	         if (mapaVar.get(LT(0).getText()) == null){
                            throw new RuntimeException("ERROR ID "+LT(0).getText()+" not declared!");
                         }
			
						 
						 p.addCommand(new CmdLeitura(LT(0).getText(),mapaVar.get(LT(0).getText())));
                       } 
            T_fp
		;

cmdEscr :  "escreva" T_ap ( 
	                        T_texto 
	                        | 

	                        T_Id {
	                        	   if (mapaVar.get(LT(0).getText()) == null){
                                       throw new RuntimeException("ERROR ID "+LT(0).getText()+" not declared!");
                                   }
                                 }  
           
		   
		   )  { p.addCommand(new CmdEscrita(LT(0).getText())); }
		   T_fp
		;

cmdAttr :  T_Id  {	
	                if (mapaVar.get(LT(0).getText()) == null){
	                       throw new RuntimeException("ERROR ID "+LT(0).getText()+" not declared!");
	            	}
                 } 
           T_attr
           expr 
		;
cmdIf : "se" {p.addCommand(new CmdIf(LT(1).getText(),LT(2).getText(),LT(3).getText()));}(fator T_rel fator) "entao" (cmd)+ ("senao" {p.addCommand(new CmdSenao());}(cmd)+ )? | end;

expr    :  termo (( T_soma | T_subt ) termo)*
		;


termo   :  fator (( T_mult | T_divi ) fator)*
		;

fator   :  T_Id 
           {
           	  if (mapaVar.get(LT(0).getText()) == null){
                 throw new RuntimeException("ERROR ID "+LT(0).getText()+" not declared!");
             }
           }  
        |  T_num
	|  T_dec
        |  T_ap expr T_fp
		;
end : "end"{
	p.addCommand(new CmdEnd());
};

class MeuLexer extends Lexer;

options {
	caseSensitive = true;
	k = 7;
}

T_Id		: ('a'..'z' | 'A'..'Z') ('a'..'z'| 'A'..'Z'| '0'..'9')*
		;
T_comm		: "//"
		;
T_num		: ('0'..'9')+
		;
T_soma		: '+'
		;
T_subt		: '-'
		;
T_mult		: '*'
		;
T_divi		: '/'
		;
T_virg		: ','
		;
T_pontof	: '.'
		;
T_ap		: '('
		;
T_fp    	: ')'
		;
T_ac    	: '{'
		;
T_fc		: '}'
		;
T_texto		: '"' ( 'a'..'z' | '0'..'9' | ' ' | 'A'..'Z' )+ '"'
		;
T_attr		: ":="
		;
T_rel		: '<' | '>'|"<="|">="|"!="|"=="
		;
T_dec		: ('0'..'9')+ '.' ('0'..'9')+
		;
T_blank		: ( ' ' | '\n' {newline();}| '\r' | '\t') {_ttype=Token.SKIP;}
		;




