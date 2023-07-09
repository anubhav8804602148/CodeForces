package self;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileReadWrite {
	private static String SRC_LOC = "C:\\Users\\Anubhav.Sharma\\Downloads\\working\\src";
	private static String DST_LOC = "C:\\Users\\Anubhav.Sharma\\Downloads\\working\\dest";
	public static void main(String[] args) {
		File srcFolder = new File(SRC_LOC);
		for(File srcFile : srcFolder.listFiles()) {
			File dstFile = new File(DST_LOC+srcFile.getName());
			try(BufferedReader reader = new BufferedReader(new FileReader(srcFile)); FileWriter writer = new FileWriter(dstFile);){
				String line;
				boolean header = true;
				while((line=reader.readLine())!=null) {
					if(header) {
						header=false;
						continue;
					}
					writer.write(line+"\n");					
				}
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
