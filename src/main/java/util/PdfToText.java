package util;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import com.itextpdf.awt.geom.Rectangle;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.FilteredTextRenderListener;
import com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.itextpdf.text.pdf.parser.RegionTextRenderFilter;
import com.itextpdf.text.pdf.parser.RenderFilter;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;

public class PdfToText {
	public static void main(String[] args) throws IOException {
		//���txt�ı�
	    String outputPath = "C:\\Users\\zhn17\\Desktop\\��ѧӢ���ļ��ʻ��.txt";
	    PrintWriter writer = new PrintWriter(new FileOutputStream(outputPath));
	    //��ȡPDF�е��ı�
	    String fileName = "C:\\Users\\zhn17\\Desktop\\��ѧӢ���ļ��ʻ��.pdf";

	    readPdf(writer, fileName);//ֱ�Ӷ�ȫPDF��

	    // readPdf_filter(writer,fileName);//��ȡPDF���ĳ������

	}

	public static void readPdf(PrintWriter writer,String fileName) throws IOException{
	    String pageContent = "";
//	    BaseFont bfChinese = BaseFont.createFont("C:\\Windows\\Fonts\\simsun.ttc,1", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);//1 ����ʡ�ԣ�ʡ�Իᱨ���ϴ���
//	    Font fontChinese = new Font(bfChinese, 10, Font.NORMAL);
	    try {
	        PdfReader reader = new PdfReader(fileName);
	        
	        int pageNum = reader.getNumberOfPages();
	        for(int i=1;i<=pageNum;i++){
	            String textFromPage = PdfTextExtractor.getTextFromPage(reader, i);
	            pageContent += textFromPage;//��ȡ��iҳ���ĵ�����
	        //    pageContent += PdfTextExtractor.getTextFromPage(reader, i);//��ȡ��iҳ���ĵ�����
	        }
	        writer.write(pageContent);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }finally{
	        writer.close();
	    }
	}

	public static void readPdf_filter(PrintWriter writer,String fileName){
	    String pageContent = "";
	    try {
	    	//���½�Ϊԭ�㣬�����ֱ������¡��ҡ���
	       // Rectangle rect = new Rectangle(90, 0, 450, 40);
	        Rectangle rect = new Rectangle(0, 0, 450, 850);
	        RenderFilter filter = new RegionTextRenderFilter(rect);
	        PdfReader reader = new PdfReader(fileName);
	        int pageNum = reader.getNumberOfPages();
	        TextExtractionStrategy strategy;
	        for (int i = 1; i <= pageNum; i++) {
	            strategy = new FilteredTextRenderListener(new LocationTextExtractionStrategy(), filter);
	            pageContent +=PdfTextExtractor.getTextFromPage(reader, i, strategy);
	        }
	        writer.write(pageContent);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }finally{
	        writer.close();
	    }
	}
}