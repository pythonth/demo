package util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class writeToFile {
	public static void main(String[] args) {
		String outputPath = "C:\\Users\\zhn17\\Desktop\\c.txt";
		try {
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(new File(outputPath)),"UTF-8"));
			
			pw.print("这是一段中文");
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
