public class CmdWhile extends Command{
	private String fator1;
	private String opRel;
	private String fator2;

	public CmdWhile(String f1,String oRel,String f2){
		this.fator1 = f1;
		this.opRel = oRel;
		this.fator2 = f2; 
	}
	public String toJava(){
		return "while("+this.fator1 +" "+this.opRel+" "+this.fator2+" ){";
	}
}
