public class CmdAttr extends Command{
	private String idVar;
	private String valor;
	
	public CmdAttr(String idVar,String valor){
		this.idVar = idVar;
		this.valor = valor;
	}
	
	public String toJava(){
		return idVar +"="+valor+";";
	}
}
