public class CmdAttr extends Command{
	private String idVar;
	private String valor;
	
	public CmdAttr(String idVar,String valor){
		System.out.println("idVar " +idVar);
		this.idVar = idVar;
		System.out.println("valor " +valor);
		this.valor = valor;
	}
	
	public String toJava(){
		return idVar +"="+valor+";";
	}
}
