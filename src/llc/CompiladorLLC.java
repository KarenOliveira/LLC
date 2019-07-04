package llc;

import llc.filereader.LeitorArquivos;

public class CompiladorLLC {

	public static void main(String[] args) {
		LeitorArquivos leitorArquivos = new LeitorArquivos();
		for (int i = 0; i < args.length; i++) {
			leitorArquivos.ler(args[i]);
		}
		System.out.println("Executou");
	}
}
