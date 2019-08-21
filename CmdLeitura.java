public class CmdLeitura extends Command{
	private String idVar;
	private String tipo;
	
	public CmdLeitura(String idVar,String tipo){
		this.idVar = idVar;
		this.tipo = tipo;
	}
	
	public String toJava(){
		if(tipo.equals("num")){
		return idVar + "="+Programa.INPUT+".nextInt();";
		}
		return idVar + "="+Programa.INPUT+".nextFloat();";
	}
}
