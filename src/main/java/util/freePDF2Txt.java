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
		//����PdfDocumentʵ��
		PdfDocument doc = new PdfDocument();
		//����PDF�ļ�
		doc.loadFromFile("C:\\Users\\zhn17\\Desktop\\˽���ļ�\\ϵͳ����ʦ�̳�.pdf");
		//����StringBuilderʵ��
		StringBuilder sb = new StringBuilder();

		PdfPageBase page;
		//����PDFҳ�棬��ȡÿ��ҳ����ı�����ӵ�StringBuilder����
		for(int i= 0;i<doc.getPages().getCount();i++){
		    page = doc.getPages().get(i);
		    sb.append(page.extractText(true));
		}
//		System.out.println(sb.toString());
		PrintWriter writer;
		try {
		    //��StringBuilder�����е��ı�д�뵽�ı��ļ�
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
