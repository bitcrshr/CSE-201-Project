import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DataNormalizer {
	
	public static void main(String[] args) {
		try {
			Scanner is = new Scanner(new File("gamedata.csv"));
			File norm = new File("normalizedgamedata.csv");
			PrintWriter pw = new PrintWriter(norm);
			
			pw.println(is.nextLine());
			String line;
			while (is.hasNextLine()) {
				line = is.nextLine();
				String[] split = line.split("");
				
				boolean flag = false;
				
				for (int i = 0; i < split.length; i++) {
					
					if (split[i].equals("\""))
						flag = !flag;
					
					if (split[i].equals(",") && flag)
						split[i] = "";
				}
				
				for (int i = 0; i < split.length; i++) {
					if (split[i].equals("\""))
						split[i] = "";
				}
				
				String clean = "";
				
				for (String s : split)
					clean += s;
				
				pw.println(clean);
			}
			
			is.close();
			pw.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
