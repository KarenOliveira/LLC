package llc.filereader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LeitorArquivos {
	public void ler(String filePath) {
		String content = "";
		 try {
			content = new String(Files.readAllBytes(Paths.get(filePath)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println(content);
	}
}
