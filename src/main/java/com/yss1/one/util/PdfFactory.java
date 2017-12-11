package com.yss1.one.util;


import java.awt.Color;
import java.io.ByteArrayOutputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.w3c.dom.css.CSSPrimitiveValue;
import org.w3c.dom.css.RGBColor;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.TabStop.Alignment;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.yss1.one.models.Man;


@Service
public class PdfFactory {
private BaseFont baseFont;
private BaseFont baseFontb;
private BaseFont baseFonti;

@PostConstruct
public void init() throws DocumentException, IOException {
	baseFont = BaseFont.createFont("public/fonts/times.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
	baseFonti = BaseFont.createFont("public/fonts/timesi.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
	baseFontb = BaseFont.createFont("public/fonts/timesbd.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
}
public void makeTest(String mess) throws DocumentException, IOException {
	Document document = new Document(PageSize.A4, 50, 50, 50, 50);
    //Font font = new Font(baseFont, 14, Font.NORMAL|Font.UNDERLINE, new CMYKColor(255, 255, 0, 0));
    Font font14b = new Font(baseFontb, 14, Font.NORMAL, new CMYKColor(255, 255, 0, 0));
    Font font14i = new Font(baseFonti, 14, Font.NORMAL, new CMYKColor(255, 255, 0, 0));
    Font font14 = new Font(baseFont, 14, Font.NORMAL|Font.UNDERLINE, new CMYKColor(255, 255,  255, 0));
    Font font12 = new Font(baseFont, 12, Font.NORMAL, new CMYKColor(255, 255, 255, 0));
    Font font10 = new Font(baseFont, 10, Font.NORMAL, new CMYKColor(255, 255, 255, 0));
    Font font8 = new Font(baseFont, 8, Font.NORMAL, BaseColor.BLACK);
	PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream("d:\\"+mess+".pdf"));
	document.open();
	//Chapter chapter1= new Chapter(new Paragraph("Глава 1",font),1);
	Paragraph paragraph1 = new Paragraph("ИНФОРМАЦИОННАЯ СПРАВКА",font14);
	paragraph1.setAlignment(Paragraph.ALIGN_CENTER);
	//paragraph1.setSpacingBefore(10);
	document.add(paragraph1);
	Date dnow=new Date();    
	paragraph1 = new Paragraph(Utils.getFormattedDate(dnow)+"г.           "+"№"+dnow.getTime()+"            ОПФР по Иркутской области",font12);
	paragraph1.setAlignment(Paragraph.ALIGN_LEFT);
    paragraph1.setSpacingBefore(20);
    document.add(paragraph1);
    
	Paragraph paragraph1b = new Paragraph("шрифт 14 bold Результат расчета пенсии ",font14b);
	//paragraph1.setSpacingBefore(10);
	document.add(paragraph1b);
	
	Paragraph paragraph1i = new Paragraph("шрифт 14 bold Результат расчета пенсии ",font14i);
	//paragraph1.setSpacingBefore(10);
	document.add(paragraph1i);
	
	
	    Paragraph paragraph2 = new Paragraph("шрифт 12 Результат расчета пенсии ",font12);
	    paragraph2.setSpacingBefore(20);
	    document.add(paragraph2);
	    
	    Paragraph paragraph3 = new Paragraph("шрифт 10 Результат расчета пенсии ",font10);
	    paragraph3.setSpacingBefore(30);
	    document.add(paragraph3);
	    
//    chapter1.add(paragraph1);
//    chapter1.add(new Paragraph("русский текст bold",fontb));
//    chapter1.add(new Paragraph("русский текст italic",fonti));
	
	paragraph1 = new Paragraph("Таблица 1",font8);
	paragraph1.setAlignment(Paragraph.ALIGN_RIGHT);
	paragraph1.setSpacingBefore(20);
	document.add(paragraph1);
	
    PdfPTable table=new PdfPTable(6);
    table.setSpacingBefore(3);
    table.setSpacingAfter(25);
    //table.setHeaderRows(1);
    //table.setFooterRows(1);
    //table.getDefaultCell().se
    table.setWidths(new float[] {1,6,3,3,8,5});
    table.setWidthPercentage(100);
    table.getDefaultCell().setBackgroundColor(BaseColor.LIGHT_GRAY);
    table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
    table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
    table.addCell(new Phrase("№",font10));
    table.addCell(new Phrase("Работодатель/\nвид деятельности",font10));
    table.addCell(new Phrase("Начало\nпериода",font10));
    table.addCell(new Phrase("Конец\nпериода",font10));
    table.addCell(new Phrase("Характеристика периода",font10));
    table.addCell(new Phrase("Страховые взносы,\nуплаченные работодателем",font10));
    table.getDefaultCell().setBackgroundColor(BaseColor.WHITE);
    table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
    table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
    table.addCell(new Phrase("1.1",font12));
    table.addCell(new Phrase("тело 1.2",font12));
    table.addCell(new Phrase("тело 1.3",font12));
    table.addCell(new Phrase("тело 1.4",font12));
    table.addCell(new Phrase("тело 1.5",font12));
    table.addCell(new Phrase("тело 1.6",font12));
    table.addCell(new Phrase("2.1",font12));
    table.addCell(new Phrase("2.2",font12));
    table.addCell(new Phrase("ло 2.3",font12));
    table.addCell(new Phrase("тело 2.4",font12));
    table.addCell(new Phrase("тело 2.5",font12));
    table.addCell(new Phrase("тело 2.6",font12));
    
    table.addCell(new Phrase("1",font12));
    table.addCell(new Phrase("футер 2",font12));
    table.addCell(new Phrase("футер 3",font12));
    table.addCell(new Phrase("футер 4",font12));
    table.addCell(new Phrase("футер 5",font12));
    table.addCell(new Phrase("футер 6",font12));
    //chapter1.add(table);
	document.add(table);
    document.close();
    writer.close();
}


public byte[] makeExplanation(Man man) throws DocumentException, IOException
{
	Document document = new Document(PageSize.A4, 50, 50, 50, 50);
	ByteArrayOutputStream mos= new ByteArrayOutputStream();
	
	//PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream("d:\\"+man.getSNILS()+".pdf"));
	
	
	PdfWriter writer = PdfWriter.getInstance(document,mos);
	
	document.open();
	//BaseFont baseFont = BaseFont.createFont("d:\\times.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
    Font font14 = new Font(baseFont, 14, Font.NORMAL, new CMYKColor(0,0, 0, 0));
    Font font10 = new Font(baseFont, 10, Font.NORMAL, new CMYKColor(0, 0, 0, 0));
    Font font12 = new Font(baseFont, 12, Font.NORMAL, new CMYKColor(0, 0, 0, 0));
    
	//Font ft=FontFactory.getFont(FontFactory.TIMES, 14, Font.NORMAL, new CMYKColor(0, 0, 0, 0));
    //Font ft2=FontFactory.getFont(FontFactory.TIMES, 24, Font.NORMAL, new CMYKColor(255, 255, 0, 0));
	//Anchor anchorTarget = new Anchor("First page of the document.");
    //anchorTarget.setName("BackToTop");
    Paragraph paragraph1 = new Paragraph("шрифт 14 Результат расчета пенсии "+man.getSNILS(),font14);
    paragraph1.setSpacingBefore(50);
    document.add(paragraph1);
    
    Paragraph paragraph2 = new Paragraph("шрифт 12 Результат расчета пенсии "+man.getSNILS(),font12);
    paragraph2.setSpacingBefore(50);
    document.add(paragraph2);
    
    Paragraph paragraph3 = new Paragraph("шрифт 10 Результат расчета пенсии "+man.getSNILS(),font10);
    paragraph3.setSpacingBefore(50);
    document.add(paragraph3);
    
    //document.add(new Paragraph("Some more text on the first page with different color and font type.",ft));
    
    //document.add(new Paragraph("Another par. Hoihodfh fdsjokfkhds dfjslkjfds dskjfcdsn ds dskljflkdsf dsfdsksjflkdsf dsfckdsjfcldsf flkdsjfn fkljdfskl",ft2));
//    
//   Chapter chapter1 = new Chapter(new Paragraph("Chapter1"), 1);
//    
//    Section section1 = chapter1.addSection("Section1");
    
    PdfPTable table=new PdfPTable(2);
    table.setSpacingBefore(25);
    table.setSpacingAfter(25);

    
//    PdfPCell c1 = new PdfPCell(new Phrase("Параметр",font));
//    
//    table.addCell(c1);
//    PdfPCell c2 = new PdfPCell(new Phrase("Размер",font));
//    table.addCell(c2);
//
//    table.addCell(new Phrase("СНИЛС",font));
//    table.addCell(new Phrase(man.getSNILS(),font));
//
//    table.addCell(new Phrase("ФИО",font));
//    table.addCell(new Phrase(man.getFamily()+" "+man.getName()+" "+man.getOtch(),font));
//    
//    table.addCell(new Phrase("Дата рождения",font));
//    table.addCell(new Phrase(Utils.getFormattedDate(man.getBirthDayDate()),font));
//    
//    table.addCell(new Phrase("Пол",font));
//    table.addCell(new Phrase(man.getSex(),font));
//    
//    table.addCell(new Phrase("Дата права",font));
//    table.addCell(new Phrase(Utils.getFormattedDate(man.getDatePravDate()),font));
//    
//    table.addCell(new Phrase("Стаж всего",font));
//    table.addCell(new Phrase(man.getPeriodAll().toString(),font));
//    
//    table.addCell(new Phrase("Стаж на 01.01.2015",font));
//    table.addCell(new Phrase(man.getPeriod2015().toString(),font));
//    
//    table.addCell(new Phrase("Стаж на 01.01.2002",font));
//    table.addCell(new Phrase(man.getPeriod2002().toString(),font));
//    
//    table.addCell(new Phrase("Стаж на 01.01.1991",font));
//    table.addCell(new Phrase(man.getPeriod1991().toString(),font));
//    
//    table.addCell(new Phrase("Отношение зарплат",font));
//    table.addCell(new Phrase(String.format("%.3f", man.getkSal()),font));
//    
//    table.addCell(new Phrase("ИПК",font));
//    table.addCell(new Phrase(String.format("%.3f", man.getIpk()),font));
//    
//    table.addCell(new Phrase("Страховая пенсия по старости",font));
//    table.addCell(new Phrase(String.format("%.2f", man.getPensiya()),font));
//    
//    table.addCell(new Phrase("Фиксированная выплата",font));
//    table.addCell(new Phrase(String.format("%.2f", man.getFix()),font));
//    
//    table.addCell(new Phrase("Общий размер пенсии",font));
//    table.addCell(new Phrase(String.format("%.2f", man.getPensiya()+man.getFix()),font));
    
    

   // section1.add(table);
   
//    List l = new List(false,false, 10);
//    
//    l.setListSymbol(new Chunk('*'));
//    
//    l.add(new ListItem("First item of list"));
//     
//    l.add(new ListItem("Second item of list"));
//     
//    section1.add(l);
    
    //document.add(chapter1); 
    document.add(table);
    document.close();
    writer.close();
   // System.out.println(bytes2HexStr(mos.toByteArray()));
    //SyslogOutputStream(mos.toString());
    //save2file(mos.toByteArray(),"d:\\aaa.pdf");
    return mos.toByteArray();
}


public byte[] makeDocument(Man man) throws DocumentException, IOException
{
	Document document = new Document(PageSize.A4, 50, 50, 50, 50);
	ByteArrayOutputStream mos= new ByteArrayOutputStream();
	
	//PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream("d:\\"+man.getSNILS()+".pdf"));
	
	
	PdfWriter writer = PdfWriter.getInstance(document,mos);
	
	document.open();
	//BaseFont baseFont = BaseFont.createFont("d:\\times.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
    Font font = new Font(baseFont, 14, Font.NORMAL, new CMYKColor(255, 255, 0, 0));
    
	//Font ft=FontFactory.getFont(FontFactory.TIMES, 14, Font.NORMAL, new CMYKColor(0, 0, 0, 0));
    //Font ft2=FontFactory.getFont(FontFactory.TIMES, 24, Font.NORMAL, new CMYKColor(255, 255, 0, 0));
	//Anchor anchorTarget = new Anchor("First page of the document.");
    //anchorTarget.setName("BackToTop");
    Paragraph paragraph1 = new Paragraph("Результат расчета пенсии "+man.getSNILS(),font);
    paragraph1.setSpacingBefore(50);
 
    document.add(paragraph1);
    
    //document.add(new Paragraph("Some more text on the first page with different color and font type.",ft));
    
    //document.add(new Paragraph("Another par. Hoihodfh fdsjokfkhds dfjslkjfds dskjfcdsn ds dskljflkdsf dsfdsksjflkdsf dsfckdsjfcldsf flkdsjfn fkljdfskl",ft2));
//    
//   Chapter chapter1 = new Chapter(new Paragraph("Chapter1"), 1);
//    
//    Section section1 = chapter1.addSection("Section1");
    
    PdfPTable table=new PdfPTable(2);
    table.setSpacingBefore(25);
    table.setSpacingAfter(25);

    
    PdfPCell c1 = new PdfPCell(new Phrase("Параметр",font));
    
    table.addCell(c1);
    PdfPCell c2 = new PdfPCell(new Phrase("Размер",font));
    table.addCell(c2);

    table.addCell(new Phrase("СНИЛС",font));
    table.addCell(new Phrase(man.getSNILS(),font));

    table.addCell(new Phrase("ФИО",font));
    table.addCell(new Phrase(man.getFamily()+" "+man.getName()+" "+man.getOtch(),font));
    
    table.addCell(new Phrase("Дата рождения",font));
    table.addCell(new Phrase(Utils.getFormattedDate(man.getBirthDayDate()),font));
    
    table.addCell(new Phrase("Пол",font));
    table.addCell(new Phrase(man.getSex(),font));
    
    table.addCell(new Phrase("Дата права",font));
    table.addCell(new Phrase(Utils.getFormattedDate(man.getDatePravDate()),font));
    
    table.addCell(new Phrase("Стаж всего",font));
    table.addCell(new Phrase(man.getPeriodAll().toString(),font));
    
    table.addCell(new Phrase("Стаж на 01.01.2015",font));
    table.addCell(new Phrase(man.getPeriod2015().toString(),font));
    
    table.addCell(new Phrase("Стаж на 01.01.2002",font));
    table.addCell(new Phrase(man.getPeriod2002().toString(),font));
    
    table.addCell(new Phrase("Стаж на 01.01.1991",font));
    table.addCell(new Phrase(man.getPeriod1991().toString(),font));
    
    table.addCell(new Phrase("Отношение зарплат",font));
    table.addCell(new Phrase(String.format("%.3f", man.getkSal()),font));
    
    table.addCell(new Phrase("ИПК",font));
    table.addCell(new Phrase(String.format("%.3f", man.getIpk()),font));
    
    table.addCell(new Phrase("Страховая пенсия по старости",font));
    table.addCell(new Phrase(String.format("%.2f", man.getPensiya()),font));
    
    table.addCell(new Phrase("Фиксированная выплата",font));
    table.addCell(new Phrase(String.format("%.2f", man.getFix()),font));
    
    table.addCell(new Phrase("Общий размер пенсии",font));
    table.addCell(new Phrase(String.format("%.2f", man.getPensiya()+man.getFix()),font));
    
    

   // section1.add(table);
   
//    List l = new List(false,false, 10);
//    
//    l.setListSymbol(new Chunk('*'));
//    
//    l.add(new ListItem("First item of list"));
//     
//    l.add(new ListItem("Second item of list"));
//     
//    section1.add(l);
    
    //document.add(chapter1); 
    document.add(table);
    document.close();
    writer.close();
   // System.out.println(bytes2HexStr(mos.toByteArray()));
    //SyslogOutputStream(mos.toString());
    //save2file(mos.toByteArray(),"d:\\aaa.pdf");
    return mos.toByteArray();
}

public byte[] makeErrorDocument(String snils,String err) throws DocumentException, IOException
{
	Document document = new Document(PageSize.A4, 50, 50, 50, 50);
	ByteArrayOutputStream mos= new ByteArrayOutputStream();
	//PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("d:\\"+snils+".pdf"));
    //BaseFont baseFont = BaseFont.createFont("d:\\times.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
    Font font = new Font(baseFont, 21, Font.NORMAL);
	PdfWriter writer = PdfWriter.getInstance(document,mos);
	
	document.open();
//	Anchor anchorTarget = new Anchor("First page of the document.");
//    anchorTarget.setName("BackToTop");
//    Font ft=FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new CMYKColor(0, 0, 0, 0));
//    Font ft2=FontFactory.getFont(FontFactory.TIMES, 24, Font.NORMAL, new CMYKColor(255, 0, 0, 0));
    Paragraph paragraph1 = new Paragraph("Ошибочная ситуация",font);
	//Paragraph paragraph1 = new Paragraph("QQ");
    //paragraph1.setSpacingBefore(150);

//    paragraph1.add(anchorTarget);
    document.add(paragraph1);
    
        
    document.add(new Paragraph(err,font));
    
//    document.add(new Paragraph("Another par. Hoihodfh fdsjokfkhds dfjslkjfds dskjfcdsn ds dskljflkdsf dsfdsksjflkdsf dsfckdsjfcldsf flkdsjfn fkljdfskl",ft2));
//    
//    Chapter chapter1 = new Chapter(new Paragraph("Ho hoooo",ft2), 1);
//    
//    Section section1 = chapter1.addSection("Ioooo hoooo");
//    
//    PdfPTable table=new PdfPTable(4);
//    table.setSpacingBefore(25);
//    
//    table.setSpacingAfter(25);
//
//    PdfPCell c1 = new PdfPCell(new Phrase("Header1"));  
//
//    table.addCell(c1);
//
//    PdfPCell c2 = new PdfPCell(new Phrase("Header2"));
//
//    table.addCell(c2);
//
//    PdfPCell c3 = new PdfPCell(new Phrase("Header3"));
//
//    table.addCell(c3);
//
//    table.addCell("1.1");
//
//    table.addCell("1.2");
//
//    table.addCell("1.3");
//    
//    table.addCell("1.4");
//    table.addCell("1.44");
//    
//    table.addCell("2.1");
//    table.addCell("2.2");
//    table.addCell("2.3");
//    table.addCell("2.4");
//
//    section1.add(table);
//   
//    List l = new List(false,false, 10);
//    
//    l.setListSymbol(new Chunk('*'));
//    
//    l.add(new ListItem("First item of list"));
//     
//    l.add(new ListItem("Second item of list"));
//     
//    section1.add(l);
//    
//    document.add(section1); 
    document.close();
    //writer.close();
   // System.out.println(bytes2HexStr(mos.toByteArray()));
    //SyslogOutputStream(mos.toString());
    //save2file(mos.toByteArray(),"d:\\aaa.pdf");
    return mos.toByteArray();
}








}
