package com.yss1.one.util;


import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import org.postgresql.util.StreamWrapper;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import ch.qos.logback.core.net.SyslogOutputStream;

public class Document1 {
//private PdfDocumrnt pdoc;
	
	
public byte[] makeDocument() throws DocumentException, IOException
{
	Document document = new Document(PageSize.A4, 50, 50, 50, 50);
	ByteArrayOutputStream mos= new ByteArrayOutputStream();
	
	//PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream("d:\\"+name+".pdf"));
	PdfWriter writer = PdfWriter.getInstance(document,mos);
	
	document.open();
	Anchor anchorTarget = new Anchor("First page of the document.");
    anchorTarget.setName("BackToTop");
    Paragraph paragraph1 = new Paragraph("Huiii");

    paragraph1.setSpacingBefore(150);

    paragraph1.add(anchorTarget);
    document.add(paragraph1);
    
    Font ft=FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new CMYKColor(0, 255, 0, 0));
    Font ft2=FontFactory.getFont(FontFactory.TIMES, 24, Font.NORMAL, new CMYKColor(255, 255, 0, 0));
    
    document.add(new Paragraph("Some more text on the first page with different color and font type.",ft));
    
    document.add(new Paragraph("Another par. Hoihodfh fdsjokfkhds dfjslkjfds dskjfcdsn ds dskljflkdsf dsfdsksjflkdsf dsfckdsjfcldsf flkdsjfn fkljdfskl",ft2));
    
    Chapter chapter1 = new Chapter(new Paragraph("Ho hoooo",ft2), 1);
    
    Section section1 = chapter1.addSection("Ioooo hoooo");
    
    PdfPTable table=new PdfPTable(4);
    table.setSpacingBefore(25);
    
    table.setSpacingAfter(25);

    PdfPCell c1 = new PdfPCell(new Phrase("Header1"));  

    table.addCell(c1);

    PdfPCell c2 = new PdfPCell(new Phrase("Header2"));

    table.addCell(c2);

    PdfPCell c3 = new PdfPCell(new Phrase("Header3"));

    table.addCell(c3);

    table.addCell("1.1");

    table.addCell("1.2");

    table.addCell("1.3");
    
    table.addCell("1.4");
    table.addCell("1.44");
    
    table.addCell("2.1");
    table.addCell("2.2");
    table.addCell("2.3");
    table.addCell("2.4");

    section1.add(table);
   
    List l = new List(false,false, 10);
    
    l.setListSymbol(new Chunk('*'));
    
    l.add(new ListItem("First item of list"));
     
    l.add(new ListItem("Second item of list"));
     
    section1.add(l);
    
    document.add(section1); 
    document.close();
   // System.out.println(bytes2HexStr(mos.toByteArray()));
    //SyslogOutputStream(mos.toString());
    //save2file(mos.toByteArray(),"d:\\aaa.pdf");
    return mos.toByteArray();
}

public byte[] makeDocument1(String ddata) throws DocumentException, IOException
{
	Document document = new Document(PageSize.A4, 50, 50, 50, 50);
	ByteArrayOutputStream mos= new ByteArrayOutputStream();
	
	//PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream("d:\\"+name+".pdf"));
	PdfWriter writer = PdfWriter.getInstance(document,mos);
	
	document.open();
	Anchor anchorTarget = new Anchor("First page of the document.");
    anchorTarget.setName("BackToTop");
    Paragraph paragraph1 = new Paragraph("Xo СНИЛС="+ddata);

    paragraph1.setSpacingBefore(150);

    paragraph1.add(anchorTarget);
    document.add(paragraph1);
    
    Font ft=FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new CMYKColor(0, 255, 0, 0));
    Font ft2=FontFactory.getFont(FontFactory.TIMES, 24, Font.NORMAL, new CMYKColor(255, 255, 0, 0));
    
    document.add(new Paragraph("Some more text on the first page with different color and font type.",ft));
    
    document.add(new Paragraph("Another par. Hoihodfh fdsjokfkhds dfjslkjfds dskjfcdsn ds dskljflkdsf dsfdsksjflkdsf dsfckdsjfcldsf flkdsjfn fkljdfskl",ft2));
    
    Chapter chapter1 = new Chapter(new Paragraph("Ho hoooo",ft2), 1);
    
    Section section1 = chapter1.addSection("Ioooo hoooo");
    
    PdfPTable table=new PdfPTable(4);
    table.setSpacingBefore(25);
    
    table.setSpacingAfter(25);

    PdfPCell c1 = new PdfPCell(new Phrase("Header1"));  

    table.addCell(c1);

    PdfPCell c2 = new PdfPCell(new Phrase("Header2"));

    table.addCell(c2);

    PdfPCell c3 = new PdfPCell(new Phrase("Header3"));

    table.addCell(c3);

    table.addCell("1.1");

    table.addCell("1.2");

    table.addCell("1.3");
    
    table.addCell("1.4");
    table.addCell("1.44");
    
    table.addCell("2.1");
    table.addCell("2.2");
    table.addCell("2.3");
    table.addCell("2.4");

    section1.add(table);
   
    List l = new List(false,false, 10);
    
    l.setListSymbol(new Chunk('*'));
    
    l.add(new ListItem("First item of list"));
     
    l.add(new ListItem("Second item of list"));
     
    section1.add(l);
    
    document.add(section1); 
    document.close();
   // System.out.println(bytes2HexStr(mos.toByteArray()));
    //SyslogOutputStream(mos.toString());
    //save2file(mos.toByteArray(),"d:\\aaa.pdf");
    return mos.toByteArray();
}





}
