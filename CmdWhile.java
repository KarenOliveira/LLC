public class CmdWhile extends Command {
	private String fator1;
	private String opRel;
	private String fator2;
	private boolean doWhile = false;

	public CmdWhile(String f1,String oRel,String f2, boolean doWhile){
		System.out.println(f1);
		System.out.println(f2);
		this.fator1 = f1;
		this.opRel = oRel;
		this.fator2 = f2; 
		this.doWhile = doWhile;
	}
	public String toJava(){
		if(this.doWhile)
			return "while("+this.fator1 +" "+this.opRel+" "+this.fator2+" );";
		else
			return "while("+this.fator1 +" "+this.opRel+" "+this.fator2+" ){";
	}
}
