package util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;


public class freePDF2Txt {
	public static void main(String[] args) {
		//创建PdfDocument实例
		PdfDocument doc = new PdfDocument();
		//加载PDF文件
		doc.loadFromFile("C:\\Users\\zhn17\\Desktop\\私人文件\\系统分析师教程.pdf");
		//创建StringBuilder实例
		StringBuilder sb = new StringBuilder();

		PdfPageBase page;
		//遍历PDF页面，获取每个页面的文本并添加到StringBuilder对象
		for(int i= 0;i<doc.getPages().getCount();i++){
		    page = doc.getPages().get(i);
		    sb.append(page.extractText(true));
		}
//		System.out.println(sb.toString());
		PrintWriter writer;
		try {
		    //将StringBuilder对象中的文本写入到文本文件
			String filePath = "C:\\Users\\zhn17\\Desktop\\c.txt";
			writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(new File(filePath)),"UTF-8"));
		    writer.write(sb.toString());
		    writer.flush();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		doc.close();
	}
}
