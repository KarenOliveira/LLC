public class CmdAttr extends Command{
	private String idVar;
	private String valor;
	

	public CmdAttr(){}
	public CmdAttr(String idVar,String valor){
		this.idVar = idVar;
		System.out.println("idVar: "+idVar);
		this.valor = valor;
		System.out.println("valor: "+valor);
	}
	
	public String toJava(){
		return idVar +"="+valor;
	}
	public void setIdVar(String idVar){
		System.out.println(idVar);
		this.idVar = idVar;
	}
	public void setValor(String valor){
	System.out.println(valor);
		this.valor = valor;
	}
}
