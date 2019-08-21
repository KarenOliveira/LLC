public class CmdIf extends Command{
	private String fator1;
	private String opRel;
	private String fator2;

	public CmdIf(String f1,String oRel,String f2){
	System.out.println(f1);			
	System.out.println(f2);
		this.fator1 = f1;
		this.opRel = oRel;
		this.fator2 = f2; 
	}
	public String toJava(){
		return "if("+this.fator1 +" "+this.opRel+" "+this.fator2+" ){";
	}
}
