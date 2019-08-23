public class CmdDeclara extends Command{
	private String variavel;
	private String tipo;

	public CmdDeclara(String variavel,String tipo){
		this.variavel = variavel;
		this.tipo = tipo;
	}
	public String getVariavel(){
		return this.variavel;
	}
	public String getTipo(){
		return this.tipo;
	}
	public String toJava(){
		if(tipo.equals("num")){
			return "int " + this.variavel+";";
		}
		else{
			return "float " + this.variavel+";";
		}
	}	
}
