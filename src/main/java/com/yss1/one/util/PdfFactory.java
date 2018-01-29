package com.yss1.one.util;

import java.io.ByteArrayOutputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.yss1.one.dao.LgotaDescrDao;
import com.yss1.one.models.Deyatelnost;
import com.yss1.one.models.LgStaj;
import com.yss1.one.models.LgotaDescription;
import com.yss1.one.models.Man;

@Service
public class PdfFactory {
	private BaseFont baseFont;
	private BaseFont baseFontb;
	private BaseFont baseFonti;
	private BaseFont symbolFont;
	@Autowired
	LgotaDescrDao lgotesDao;
	
	@PostConstruct
	public void init() throws DocumentException, IOException {
		symbolFont = BaseFont.createFont("public/fonts/symbol.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
		baseFont = BaseFont.createFont("public/fonts/times.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
		baseFonti = BaseFont.createFont("public/fonts/timesi.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
		baseFontb = BaseFont.createFont("public/fonts/timesbd.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
	}
	
	private PdfPCell makeCell(BaseColor bk) {
		PdfPCell cell = new PdfPCell();
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorder(Rectangle.BOX);
		cell.setBorderColor(BaseColor.WHITE);
		cell.setBorderWidth(10);
		cell.setBackgroundColor(bk);
		cell.setPadding(10);
		return cell;
	}
	
	public byte[] makeExplanation(Man man) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4, 50, 50, 50, 50);
		// Font font = new Font(baseFont, 14, Font.NORMAL|Font.UNDERLINE, new
		// CMYKColor(255, 255, 0, 0));
		Font font14b = new Font(baseFontb, 14, Font.NORMAL, new CMYKColor(255, 255, 255, 0));
		Font font14i = new Font(baseFonti, 14, Font.NORMAL, new CMYKColor(255, 255, 255, 0));
		Font font14 = new Font(baseFont, 14, Font.NORMAL | Font.UNDERLINE, new CMYKColor(255, 255, 255, 0));
		Font font12 = new Font(baseFont, 12, Font.NORMAL, new CMYKColor(255, 255, 255, 0));
		Font font12i = new Font(baseFonti, 12, Font.NORMAL, new CMYKColor(255, 255, 255, 0));
		Font font12red = new Font(baseFontb, 12, Font.NORMAL, new BaseColor(255, 64, 64));
		Font font10 = new Font(baseFont, 10, Font.NORMAL, new CMYKColor(255, 255, 255, 0));
		Font font10i = new Font(baseFonti, 10, Font.NORMAL, new CMYKColor(255, 255, 255, 0));
		Font font10b = new Font(baseFontb, 10, Font.NORMAL, new CMYKColor(255, 255, 255, 0));
		Font font14sym = new Font(symbolFont, 14, Font.NORMAL, new CMYKColor(255, 255, 255, 0));
		Font font8 = new Font(baseFont, 8, Font.NORMAL, BaseColor.BLACK);
		
		
		ByteArrayOutputStream mos = new ByteArrayOutputStream();
		PdfWriter writer = PdfWriter.getInstance(document, mos);
		document.open();

		
		Paragraph paragraph1 = new Paragraph("Виртуальный прием:", font14);
		paragraph1.setAlignment(Paragraph.ALIGN_CENTER);
		// paragraph1.setSpacingBefore(10);
		document.add(paragraph1);
		PdfPCell cell;
		Phrase ph;
		BaseColor myCol=new BaseColor(190, 190, 255);
		BaseColor pfrCol=new BaseColor(255, 255, 180);
		List<Phrase> text=new ArrayList<>(); 
		
		PdfPTable table = new PdfPTable(2);
		table.setSpacingBefore(10);
		table.setSpacingAfter(25);
		table.setWidths(new float[] { 1, 2 });
		table.setWidthPercentage(100);
				
		
		ph=new Phrase("Здравствуйте!", font10);
		cell = makeCell(myCol);
		
		
		cell.setPadding(10);
		cell.addElement(ph);
		table.addCell(cell);
		
		text.clear();
		cell = makeCell(pfrCol);
		ph=new Phrase("Здравствуйте ", font10);
		text.add(ph);
		ph=new Phrase(man.getFamily()+" "+man.getName()+" "+man.getOtch(), font12red);
		text.add(ph);
		ph=new Phrase("!", font10);
		text.add(ph);
		ph=new Phrase();
		ph.addAll(text);
		cell.addElement(ph);
		table.addCell(cell);
		
		ph=new Phrase("Я хочу пойти на пенсию. Какой размер пенсии у меня будет?", font10);
		cell = makeCell(myCol);
		cell.addElement(ph);
		table.addCell(cell);
		
		text.clear();
		cell = makeCell(pfrCol);
		ph=new Phrase("Давайте рассчитаем предполагаемый размер Вашей пенсии по данным индивидуального (персонифицированного) учета:", font10);
		cell.addElement(ph);
		ph=new Phrase("Пенсия рассчитывается по формуле:",font10);
		cell.addElement(ph);
		ph=new Phrase("Пенсия = Баллы × Стоимость балла + Фиксированная выплата",font10i);
		cell.addElement(ph);
		ph=new Phrase("                                            ______^__________________________^________",font8);
		cell.addElement(ph);  
		ph=new Phrase("                                               устанавливается Правительством РФ",font8);
		cell.addElement(ph);
		ph=new Phrase(man.getIPK(),font12red);
		text.add(ph);
		ph=new Phrase(" * 74,41 + "+man.getFixStr()+" = "+man.getSummStr() +" руб.",font10);
		text.add(ph);
		ph=new Phrase(" ",font10);
		text.add(ph);
		ph=new Phrase();
		ph.addAll(text);
		cell.addElement(ph);
		table.addCell(cell);

		text.clear();
		cell = makeCell(myCol);
		ph=new Phrase("Почему у меня ", font10);
		text.add(ph);
		ph=new Phrase(man.getIPK(), font12red);
		text.add(ph);
		ph=new Phrase(" баллов?", font10);
		text.add(ph);
		ph=new Phrase();
		ph.addAll(text);
		cell.addElement(ph);
		table.addCell(cell);
		
		
		text.clear();
		cell = makeCell(pfrCol);
		ph=new Phrase(man.getIPK(),font12red);
		text.add(ph);
		ph=new Phrase(" = ",font10);
		text.add(ph);
		ph=new Phrase(man.getBall2002(),font12red);
		text.add(ph);
		ph=new Phrase(" + ",font10);
		text.add(ph);
		ph=new Phrase(man.getBall2014(),font12red);
		text.add(ph);
		ph=new Phrase(" + ",font10);
		text.add(ph);
		ph=new Phrase(man.getBall2015(),font12red);
		text.add(ph);
		ph=new Phrase();
		ph.addAll(text);
		cell.addElement(ph);
		ph=new Phrase("Это сумма баллов, накопленная за разные периоды:", font10);
		cell.addElement(ph);
		text.clear();
		ph=new Phrase("S",font14sym);
		text.add(ph);
		ph=new Phrase("баллов",font8);
		text.add(ph);
		ph=new Phrase(" = S",font14sym);
		text.add(ph);
		ph=new Phrase("баллов до 2002г.",font8);
		text.add(ph);
		ph=new Phrase(" + S",font14sym);
		text.add(ph);
		ph=new Phrase("баллов с 2002 по 2014г.",font8);
		text.add(ph);
		ph=new Phrase(" + S",font14sym);
		text.add(ph);
		ph=new Phrase("баллов с 2015г.",font8);
		text.add(ph);
		ph=new Phrase();
		ph.addAll(text);
		cell.addElement(ph);
		table.addCell(cell);
		
		
		cell = makeCell(myCol);
		ph=new Phrase("Почему баллы суммируются за разные периоды?", font10);
		cell.addElement(ph);
		table.addCell(cell);

		cell = makeCell(pfrCol);
		ph=new Phrase("Баллы суммируются за разные периоды в связи с изменением пенсионного законодательства.", font10);
		cell.addElement(ph);
		table.addCell(cell);
		
		text.clear();
		cell = makeCell(myCol);
		ph=new Phrase("Объясниете как насчитали ", font10);
		text.add(ph);
		ph=new Phrase(man.getBall2002(), font12red);
		text.add(ph);
		ph=new Phrase(" баллов?", font10);
		text.add(ph);
		ph=new Phrase();
		ph.addAll(text);
		cell.addElement(ph);
		table.addCell(cell);
		
		text.clear();
		cell = makeCell(pfrCol);
		ph=new Phrase("Сумма баллов до 2002 года (",font10);
		text.add(ph);
		ph=new Phrase("S",font14sym);
		text.add(ph);
		ph=new Phrase("баллов до 2002г.",font8);
		text.add(ph);
		ph=new Phrase(") расчитывается на основании Вашего накопленного пенсионного капиталла до 2002 года. Размер пенсионного капитала зависит:",font10);
		text.add(ph);
		ph=new Phrase();
		ph.addAll(text);
		cell.addElement(ph);
		ph=new Phrase("    * от продолжительности стажа на 01.01.2002 года",font10b);
		cell.addElement(ph);
		ph=new Phrase("    * от размера Вашей средней зароботной платы (ЗП) за 2001-2002 годы или любые 60 месяцев подряд до 2002 года",font10b);
		cell.addElement(ph);
		
		text.clear();
		ph=new Phrase("Ваш трудовой стаж до 2002 года составляет ",font10);
		text.add(ph);
		ph=new Phrase(man.getPeriod2002().getYears()+"",font12red);
		text.add(ph);
		ph=new Phrase("л. ",font10);
		text.add(ph);
		ph=new Phrase(man.getPeriod2002().getMonths()+"",font12red);
		text.add(ph);
		ph=new Phrase("мес. ",font10);
		text.add(ph);
		ph=new Phrase(man.getPeriod2002().getDays()+"",font12red);
		text.add(ph);
		ph=new Phrase("дн. ",font10);
		text.add(ph);
		ph=new Phrase();
		ph.addAll(text);
		cell.addElement(ph);
		
		
		
		table.addCell(cell);
		
		
		
		
		document.add(table);
		document.close();
	    writer.close();
		return mos.toByteArray();
		
	}
	
	public void makeTest(String mess) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4, 50, 50, 50, 50);
		// Font font = new Font(baseFont, 14, Font.NORMAL|Font.UNDERLINE, new
		// CMYKColor(255, 255, 0, 0));
		Font font14b = new Font(baseFontb, 14, Font.NORMAL, new CMYKColor(255, 255, 0, 0));
		Font font14i = new Font(baseFonti, 14, Font.NORMAL, new CMYKColor(255, 255, 0, 0));
		Font font14 = new Font(baseFont, 14, Font.NORMAL | Font.UNDERLINE, new CMYKColor(255, 255, 255, 0));
		Font font12 = new Font(baseFont, 12, Font.NORMAL, new CMYKColor(255, 255, 255, 0));
		Font font10 = new Font(baseFont, 10, Font.NORMAL, new CMYKColor(255, 255, 255, 0));
		Font font8 = new Font(baseFont, 8, Font.NORMAL, BaseColor.BLACK);
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("d:\\" + mess + ".pdf"));
		document.open();
		// Chapter chapter1= new Chapter(new Paragraph("Глава 1",font),1);
		Paragraph paragraph1 = new Paragraph("ИНФОРМАЦИОННАЯ СПРАВКА", font14);
		paragraph1.setAlignment(Paragraph.ALIGN_CENTER);
		// paragraph1.setSpacingBefore(10);
		document.add(paragraph1);
		Date dnow = new Date();
		paragraph1 = new Paragraph(Utils.getFormattedDate(dnow) + "г.           " + "№" + dnow.getTime()
				+ "            ОПФР по Иркутской области", font12);
		paragraph1.setAlignment(Paragraph.ALIGN_LEFT);
		paragraph1.setSpacingBefore(20);
		document.add(paragraph1);

		Paragraph paragraph1b = new Paragraph("шрифт 14 bold Результат расчета пенсии ", font14b);
		// paragraph1.setSpacingBefore(10);
		document.add(paragraph1b);

		Paragraph paragraph1i = new Paragraph("шрифт 14 bold Результат расчета пенсии ", font14i);
		// paragraph1.setSpacingBefore(10);
		document.add(paragraph1i);

		Paragraph paragraph2 = new Paragraph("шрифт 12 Результат расчета пенсии ", font12);
		paragraph2.setSpacingBefore(20);
		document.add(paragraph2);

		Paragraph paragraph3 = new Paragraph("шрифт 10 Результат расчета пенсии ", font10);
		paragraph3.setSpacingBefore(30);
		document.add(paragraph3);

		// chapter1.add(paragraph1);
		// chapter1.add(new Paragraph("русский текст bold",fontb));
		// chapter1.add(new Paragraph("русский текст italic",fonti));

		paragraph1 = new Paragraph("Таблица 1", font8);
		paragraph1.setAlignment(Paragraph.ALIGN_RIGHT);
		paragraph1.setSpacingBefore(20);
		document.add(paragraph1);

		PdfPTable table = new PdfPTable(6);
		table.setSpacingBefore(3);
		table.setSpacingAfter(25);
		// table.setHeaderRows(1);
		// table.setFooterRows(1);
		// table.getDefaultCell().se
		table.setWidths(new float[] { 1, 6, 3, 3, 8, 5 });
		table.setWidthPercentage(100);
		table.getDefaultCell().setBackgroundColor(BaseColor.LIGHT_GRAY);
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(new Phrase("№", font10));
		table.addCell(new Phrase("Работодатель/\nвид деятельности", font10));
		table.addCell(new Phrase("Начало\nпериода", font10));
		table.addCell(new Phrase("Конец\nпериода", font10));
		table.addCell(new Phrase("Характеристика периода", font10));
		table.addCell(new Phrase("Страховые взносы,\nуплаченные работодателем", font10));
		table.getDefaultCell().setBackgroundColor(BaseColor.WHITE);
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
		table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(new Phrase("1.1", font12));
		table.addCell(new Phrase("тело 1.2", font12));
		table.addCell(new Phrase("тело 1.3", font12));
		table.addCell(new Phrase("тело 1.4", font12));
		table.addCell(new Phrase("тело 1.5", font12));
		table.addCell(new Phrase("тело 1.6", font12));
		table.addCell(new Phrase("2.1", font12));
		table.addCell(new Phrase("2.2", font12));
		table.addCell(new Phrase("ло 2.3", font12));
		table.addCell(new Phrase("тело 2.4", font12));
		table.addCell(new Phrase("тело 2.5", font12));
		table.addCell(new Phrase("тело 2.6", font12));

		table.addCell(new Phrase("1", font12));
		table.addCell(new Phrase("футер 2", font12));
		table.addCell(new Phrase("футер 3", font12));
		table.addCell(new Phrase("футер 4", font12));
		table.addCell(new Phrase("футер 5", font12));
		table.addCell(new Phrase("футер 6", font12));
		// chapter1.add(table);
		document.add(table);
		document.close();
		writer.close();
	}

	public byte[] makeCalculation(Man man, long id) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4, 50, 50, 50, 50);
		ByteArrayOutputStream mos = new ByteArrayOutputStream();

		// PdfWriter writer = PdfWriter.getInstance(document,new
		// FileOutputStream("d:\\"+man.getSNILS()+".pdf"));

		PdfWriter writer = PdfWriter.getInstance(document,mos);
		//PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream("d:\\" + (new Date().getTime()) + ".pdf"));

		document.open();
		Font font14b = new Font(baseFontb, 14, Font.NORMAL, BaseColor.BLACK);
		Font font14i = new Font(baseFonti, 14, Font.NORMAL, new CMYKColor(255, 255, 0, 0));
		Font font14u = new Font(baseFont, 14, Font.NORMAL | Font.UNDERLINE, new CMYKColor(255, 255, 255, 0));
		Font font14 = new Font(baseFont, 14, Font.NORMAL, BaseColor.BLACK);
		Font font12 = new Font(baseFont, 12, Font.NORMAL, new CMYKColor(255, 255, 255, 0));
		Font font10 = new Font(baseFont, 10, Font.NORMAL, new CMYKColor(255, 255, 255, 0));
		Font font8 = new Font(baseFont, 8, Font.NORMAL, BaseColor.BLACK);

		Paragraph paragraph1 = new Paragraph("ИНФОРМАЦИОННАЯ СПРАВКА", font14);
		paragraph1.setAlignment(Paragraph.ALIGN_CENTER);
		// paragraph1.setSpacingBefore(10);
		document.add(paragraph1);
		Date dnow = new Date();
		PdfPTable table = new PdfPTable(3);
		table.setSpacingBefore(10);
		table.setSpacingAfter(25);
		table.setWidths(new float[] { 1, 1, 1 });
		table.setWidthPercentage(100);
		table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(new Phrase(Utils.getFormattedDate(dnow) + "г.", font12));
		table.addCell(new Phrase("№" + id, font12));
		table.addCell(new Phrase("ОПФР ____________________", font12));
		document.add(table);

		// личные данные
		table = new PdfPTable(4);
		table.setSpacingBefore(10);
		table.setWidths(new float[] { 5, 2, 1, 2 });
		table.setWidthPercentage(100);
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		table.getDefaultCell().setVerticalAlignment(Element.ALIGN_BOTTOM);
		table.getDefaultCell().setBorder(Rectangle.NO_BORDER);

		table.addCell(new Phrase(man.getFamily() + " " + man.getName() + " " + man.getOtch(), font14));
		table.addCell(new Phrase(man.getBirthDayStr(), font14));
		table.addCell(new Phrase(man.getSex(), font14));
		table.addCell(new Phrase(man.getSNILS(), font14));
		table.getDefaultCell().setVerticalAlignment(Element.ALIGN_TOP);
		table.getDefaultCell().setBorder(Rectangle.TOP);
		table.addCell(new Phrase("ФИО застрахованного лица", font8));
		table.addCell(new Phrase("дата рождения", font8));
		table.addCell(new Phrase("пол", font8));
		table.addCell(new Phrase("снилс", font8));
		document.add(table);

		paragraph1 = new Paragraph("Данные персонифицированного учета", font14b);
		paragraph1.setSpacingBefore(10);
		document.add(paragraph1);
		table = new PdfPTable(2);
		table.setSpacingBefore(10);
		table.setSpacingAfter(25);
		table.setWidthPercentage(100);
		table.setWidths(new float[] { 5, 2 });
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.getDefaultCell().setBorder(Rectangle.NO_BORDER);

		table.addCell(
				new Phrase(String.format("Среднемесячная заработная плата (з/п) за 2000-2001 год - %.2f руб. в месяц",
						man.getSal20012002()), font10));
		table.getDefaultCell().setBorder(Rectangle.BOX);
		if (man.isMax20002001()) {
			table.addCell(new Phrase("Средняя з/п максимальна", font8));
		} else {
			table.addCell(new Phrase(
					"Ваш заработок за 2001-2002 годы не максимально возможный для назначения пенсии. Возможно предоставить з/п за 60 месяцев подряд до 01.01.2002г.",
					font8));
		}
		document.add(table);

		table = new PdfPTable(3);
		table.setWidths(new float[] { 1, 3, 1 });
		table.setWidthPercentage(100);
		table.setSpacingBefore(20);
		table.setSpacingAfter(0);
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
		table.getDefaultCell().setVerticalAlignment(Element.ALIGN_BOTTOM);
		table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
		table.addCell(new Phrase("Данные о периодах работы", font8));
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		table.getDefaultCell().setBorder(Rectangle.BOX);
		table.addCell(new Phrase(
				"Проверьте наличие всех периодов (в т.ч. иных периодов деятельности, полный перечень: ст.12 400ФЗ от 28.12.2013г.) В случае отсутствия возможно донести подтверждающие документы в Пенсионный фонд",
				font8));
		table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(new Phrase("Таблица 1", font8));
		document.add(table);

		table = new PdfPTable(6);
		table.setSpacingBefore(3);
		table.setSpacingAfter(25);
		table.setWidths(new float[] { 1, 10, 3, 3, 4, 3 });
		table.setWidthPercentage(100);
		table.getDefaultCell().setBackgroundColor(BaseColor.LIGHT_GRAY);
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(new Phrase("№", font10));
		table.addCell(new Phrase("Работодатель/\nвид деятельности", font10));
		table.addCell(new Phrase("Начало\nпериода", font10));
		table.addCell(new Phrase("Конец\nпериода", font10));
		table.addCell(new Phrase("Характеристика периода", font10));
		table.addCell(new Phrase("Страховые взносы,\nуплаченные работодателем", font10));
		table.getDefaultCell().setBackgroundColor(BaseColor.WHITE);
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
		table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
		int counter = 0;
		if (man.getMyDeyatelnost()!=null) {
		
		for (Deyatelnost de : man.getMyDeyatelnost()) {
			table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(new Phrase(++counter + "", font10));
			table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(new Phrase(de.getPredprName() + "/" + de.getVidDeyat(), font8));
			table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(new Phrase(Utils.getFormattedDate(de.getdStart()), font10));
			table.addCell(new Phrase(Utils.getFormattedDate(de.getdEnd()), font10));
			table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(new Phrase(de.getHarDeyatStr().length() < 3 ? "" : de.getHarDeyatStr()+"*", font10));
			table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
			table.addCell(new Phrase(de.getSumm() < 0.1f ? "" : String.format("%,.2f", de.getSumm()), font10));
		}
		}
		String lgt="*";
		LgotaDescription ld;
		
		if (man.getLgotes()!=null)
		{
		for (String lg:man.getLgotes())
		{
			ld=lgotesDao.getLgota(lg);
			lgt+=ld.getName()+":"+ld.getFullName()+" ";
		}
		}
		
		if (lgt.length()>1)
		{
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
		table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
		table.getDefaultCell().setColspan(6);
		table.addCell(new Phrase(lgt, font8));
		}
		document.add(table);
		
				
		paragraph1 = new Paragraph("Таблица 2", font8);
		paragraph1.setAlignment(Paragraph.ALIGN_RIGHT);
		paragraph1.setSpacingBefore(15);
		document.add(paragraph1);

		table = new PdfPTable(3);
		table.setSpacingBefore(3);
		table.setSpacingAfter(25);
		table.setWidths(new float[] { 3, 2, 5 });
		table.setWidthPercentage(100);
		table.getDefaultCell().setBackgroundColor(BaseColor.LIGHT_GRAY);
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(new Phrase("Период", font10));
		table.addCell(new Phrase("лет/месяцев/дней", font10));
		table.addCell(new Phrase("характеристика периода", font10));
		table.getDefaultCell().setBackgroundColor(BaseColor.WHITE);
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(new Phrase("Страховой стаж", font10));
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(new Phrase(man.getPeriodAll().toString(), font10));
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(new Phrase("", font10));

		PdfPCell cl = new PdfPCell(new Phrase("Льготный стаж", font10));
		cl.setHorizontalAlignment(Element.ALIGN_LEFT);
		if (man.getMyLgStaj()!=null && man.getMyLgStaj().size() > 0) {
			cl.setRowspan(man.getMyLgStaj().size());
			table.addCell(cl);
			for (LgStaj mls : man.getMyLgStaj()) {
				table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(new Phrase(mls.getPeriod().toString(), font10));
				table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
				table.addCell(new Phrase(mls.getName(), font10));
			}
		} else {
			table.addCell(cl);
			table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(new Phrase("{0 / 0 / 0}", font10));
			table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(new Phrase("", font10));
		}
		table.addCell(new Phrase("Нестраховой стаж", font10));
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(new Phrase(man.getPeriodNS().toString(), font10));
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
		table.addCell(new Phrase("", font10));
		document.add(table);
		paragraph1 = new Paragraph("По данным персонифицированного учета на "+Utils.getFormattedDate(dnow), font14b);
		paragraph1.setSpacingBefore(10);
		document.add(paragraph1);
		
		paragraph1 = new Paragraph("Дата выхода на пенсию наступит "+Utils.getFormattedDate(man.getDatePravDate())+"г.", font12);
		paragraph1.setSpacingBefore(10);
		document.add(paragraph1);
		
		paragraph1 = new Paragraph(String.format("Размер пенсии составит %,.2f руб. из них страховая часть составляет: %,.2f руб., фиксированная: %,.2f руб.",man.getSumm(),man.getPensiya(),man.getFix()), font12);
		paragraph1.setSpacingBefore(10);
		document.add(paragraph1);
		
		table = new PdfPTable(3);
		table.setSpacingBefore(30);
		table.setWidths(new float[] { 3, 1, 2 });
		table.setWidthPercentage(100);
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		table.getDefaultCell().setVerticalAlignment(Element.ALIGN_TOP);
		table.getDefaultCell().setBorder(Rectangle.TOP);
		table.addCell(new Phrase("Должность", font8));
		table.addCell(new Phrase("Подпись", font8));
		table.addCell(new Phrase("ФИО", font8));
		document.add(table);
		
		table = new PdfPTable(3);
		table.setSpacingBefore(30);
		table.setWidths(new float[] { 3, 1, 1 });
		table.setWidthPercentage(100);
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
		table.getDefaultCell().setVerticalAlignment(Element.ALIGN_TOP);
		table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
		table.addCell(new Phrase("Согласен с принятием решения о назначении пенсии по имеющимся в распоряжении территориального органа Пенсионного фонда Российской Федерации сведениям индивидуального (персонифицированного) учета без представления дополнительных документов о стаже и заработке", font8));
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		table.getDefaultCell().setBorder(Rectangle.BOTTOM);
		table.addCell(new Phrase("", font8));
		table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
		table.addCell(new Phrase(man.getFamily()+" "+man.getName().charAt(0)+"."+(man.getOtch().isEmpty()?"":man.getOtch().charAt(0)+"."), font8));
		document.add(table);
		
		document.close();
		//writer.close();
		return mos.toByteArray();
	}

	public byte[] makeDocument(Man man) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4, 50, 50, 50, 50);
		ByteArrayOutputStream mos = new ByteArrayOutputStream();
		
		// PdfWriter writer = PdfWriter.getInstance(document,new
		// FileOutputStream("d:\\"+man.getSNILS()+".pdf"));

		PdfWriter writer = PdfWriter.getInstance(document, mos);

		document.open();
		// BaseFont baseFont = BaseFont.createFont("d:\\times.ttf", BaseFont.IDENTITY_H,
		// BaseFont.NOT_EMBEDDED);
		Font font = new Font(baseFont, 14, Font.NORMAL, new CMYKColor(255, 255, 0, 0));
		Font font8 = new Font(baseFont, 8, Font.NORMAL, BaseColor.BLACK);
		Font font10 = new Font(baseFont, 10, Font.NORMAL, new CMYKColor(255, 255, 255, 0));
		// Font ft=FontFactory.getFont(FontFactory.TIMES, 14, Font.NORMAL, new
		// CMYKColor(0, 0, 0, 0));
		// Font ft2=FontFactory.getFont(FontFactory.TIMES, 24, Font.NORMAL, new
		// CMYKColor(255, 255, 0, 0));
		// Anchor anchorTarget = new Anchor("First page of the document.");
		// anchorTarget.setName("BackToTop");
		Paragraph paragraph1 = new Paragraph("Результат расчета пенсии " + man.getSNILS(), font);
		paragraph1.setSpacingBefore(50);
		document.add(paragraph1);

		// document.add(new Paragraph("Some more text on the first page with different
		// color and font type.",ft));

		// document.add(new Paragraph("Another par. Hoihodfh fdsjokfkhds dfjslkjfds
		// dskjfcdsn ds dskljflkdsf dsfdsksjflkdsf dsfckdsjfcldsf flkdsjfn
		// fkljdfskl",ft2));
		//
		// Chapter chapter1 = new Chapter(new Paragraph("Chapter1"), 1);
		//
		// Section section1 = chapter1.addSection("Section1");

		PdfPTable table = new PdfPTable(2);
		table.setSpacingBefore(25);
		table.setSpacingAfter(25);

		PdfPCell c1 = new PdfPCell(new Phrase("Параметр", font));

		table.addCell(c1);
		PdfPCell c2 = new PdfPCell(new Phrase("Размер", font));
		table.addCell(c2);

		table.addCell(new Phrase("СНИЛС", font));
		table.addCell(new Phrase(man.getSNILS(), font));

		table.addCell(new Phrase("ФИО", font));
		table.addCell(new Phrase(man.getFamily() + " " + man.getName() + " " + man.getOtch(), font));

		table.addCell(new Phrase("Дата рождения", font));
		table.addCell(new Phrase(Utils.getFormattedDate(man.getBirthDayDate()), font));

		table.addCell(new Phrase("Пол", font));
		table.addCell(new Phrase(man.getSex(), font));

		table.addCell(new Phrase("Дата права", font));
		table.addCell(new Phrase(Utils.getFormattedDate(man.getDatePravDate()), font));

		table.addCell(new Phrase("Стаж всего", font));
		table.addCell(new Phrase(man.getPeriodAll().toString(), font));
		

		table.addCell(new Phrase("Стаж на 01.01.2015", font));
		table.addCell(new Phrase(man.getPeriod2015().toString(), font));
		
		

		table.addCell(new Phrase("Стаж на 01.01.2002", font));
		table.addCell(new Phrase(man.getPeriod2002().toString(), font));
		
		
		table.addCell(new Phrase("Стаж на 01.01.1991", font));
		table.addCell(new Phrase(man.getPeriod1991().toString(), font));
		
		
		table.addCell(new Phrase("Отношение зарплат", font));
		table.addCell(new Phrase(String.format("%.3f", man.getkSal()), font));

		table.addCell(new Phrase("ИПК", font));
		table.addCell(new Phrase(String.format("%.3f", man.getIpk()), font));

		table.addCell(new Phrase("Страховая пенсия по старости", font));
		table.addCell(new Phrase(String.format("%.2f", man.getPensiya()), font));

		table.addCell(new Phrase("Фиксированная выплата", font));
		table.addCell(new Phrase(String.format("%.2f", man.getFix()), font));

		table.addCell(new Phrase("Общий размер пенсии", font));
		table.addCell(new Phrase(String.format("%.2f", man.getPensiya() + man.getFix()), font));

		// section1.add(table);

		// List l = new List(false,false, 10);
		//
		// l.setListSymbol(new Chunk('*'));
		//
		// l.add(new ListItem("First item of list"));
		//
		// l.add(new ListItem("Second item of list"));
		//
		// section1.add(l);

		// document.add(chapter1);
		document.add(table);
		
		table = new PdfPTable(3);
		table.setWidths(new float[] { 1, 3, 1 });
		table.setWidthPercentage(100);
		table.setSpacingBefore(20);
		table.setSpacingAfter(0);
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
		table.getDefaultCell().setVerticalAlignment(Element.ALIGN_BOTTOM);
		table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
		table.addCell(new Phrase("Данные о периодах работы", font8));
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(new Phrase("",font8));
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
		table.addCell(new Phrase("Таблица 1", font8));
		document.add(table);

		table = new PdfPTable(6);
		table.setSpacingBefore(3);
		table.setSpacingAfter(25);
		table.setWidths(new float[] { 1, 10, 3, 3, 4, 3 });
		table.setWidthPercentage(100);
		table.getDefaultCell().setBackgroundColor(BaseColor.LIGHT_GRAY);
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.addCell(new Phrase("№", font10));
		table.addCell(new Phrase("Работодатель/\nвид деятельности", font10));
		table.addCell(new Phrase("Начало\nпериода", font10));
		table.addCell(new Phrase("Конец\nпериода", font10));
		table.addCell(new Phrase("Характеристика периода", font10));
		table.addCell(new Phrase("Страховые взносы,\nуплаченные работодателем", font10));
		table.getDefaultCell().setBackgroundColor(BaseColor.WHITE);
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
		table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
		int counter = 0;
		if (man.getMyDeyatelnost()!=null) {
		
		for (Deyatelnost de : man.getMyDeyatelnost()) {
			table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(new Phrase(++counter + "", font10));
			table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(new Phrase(de.getPredprName() + "/" + de.getVidDeyat(), font8));
			table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(new Phrase(Utils.getFormattedDate(de.getdStart()), font10));
			table.addCell(new Phrase(Utils.getFormattedDate(de.getdEnd()), font10));
			table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(new Phrase(de.getHarDeyatStr().length() < 3 ? "" : de.getHarDeyatStr()+"*", font10));
			table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
			table.addCell(new Phrase(de.getSumm() < 0.1f ? "" : String.format("%,.2f", de.getSumm()), font10));
		}
		}
		String lgt="*";
		LgotaDescription ld;
		
		if (man.getLgotes()!=null)
		{
		for (String lg:man.getLgotes())
		{
			ld=lgotesDao.getLgota(lg);
			lgt+=ld.getName()+":"+ld.getFullName()+" ";
		}
		}
		
		if (lgt.length()>1)
		{
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
		table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
		table.getDefaultCell().setColspan(6);
		table.addCell(new Phrase(lgt, font8));
		}
		document.add(table);
		
		document.close();
		writer.close();
		// System.out.println(bytes2HexStr(mos.toByteArray()));
		// SyslogOutputStream(mos.toString());
		// save2file(mos.toByteArray(),"d:\\aaa.pdf");
		return mos.toByteArray();
	}

	public byte[] makeErrorDocument(String snils, String err) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4, 50, 50, 50, 50);
		ByteArrayOutputStream mos = new ByteArrayOutputStream();
		// PdfWriter writer = PdfWriter.getInstance(document, new
		// FileOutputStream("d:\\"+snils+".pdf"));
		// BaseFont baseFont = BaseFont.createFont("d:\\times.ttf", BaseFont.IDENTITY_H,
		// BaseFont.NOT_EMBEDDED);
		Font font = new Font(baseFont, 21, Font.NORMAL);
		PdfWriter writer = PdfWriter.getInstance(document, mos);

		document.open();
		// Anchor anchorTarget = new Anchor("First page of the document.");
		// anchorTarget.setName("BackToTop");
		// Font ft=FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new
		// CMYKColor(0, 0, 0, 0));
		// Font ft2=FontFactory.getFont(FontFactory.TIMES, 24, Font.NORMAL, new
		// CMYKColor(255, 0, 0, 0));
		Paragraph paragraph1 = new Paragraph("Ошибочная ситуация", font);
		// Paragraph paragraph1 = new Paragraph("QQ");
		// paragraph1.setSpacingBefore(150);

		// paragraph1.add(anchorTarget);
		document.add(paragraph1);

		document.add(new Paragraph(err, font));

		// document.add(new Paragraph("Another par. Hoihodfh fdsjokfkhds dfjslkjfds
		// dskjfcdsn ds dskljflkdsf dsfdsksjflkdsf dsfckdsjfcldsf flkdsjfn
		// fkljdfskl",ft2));
		//
		// Chapter chapter1 = new Chapter(new Paragraph("Ho hoooo",ft2), 1);
		//
		// Section section1 = chapter1.addSection("Ioooo hoooo");
		//
		// PdfPTable table=new PdfPTable(4);
		// table.setSpacingBefore(25);
		//
		// table.setSpacingAfter(25);
		//
		// PdfPCell c1 = new PdfPCell(new Phrase("Header1"));
		//
		// table.addCell(c1);
		//
		// PdfPCell c2 = new PdfPCell(new Phrase("Header2"));
		//
		// table.addCell(c2);
		//
		// PdfPCell c3 = new PdfPCell(new Phrase("Header3"));
		//
		// table.addCell(c3);
		//
		// table.addCell("1.1");
		//
		// table.addCell("1.2");
		//
		// table.addCell("1.3");
		//
		// table.addCell("1.4");
		// table.addCell("1.44");
		//
		// table.addCell("2.1");
		// table.addCell("2.2");
		// table.addCell("2.3");
		// table.addCell("2.4");
		//
		// section1.add(table);
		//
		// List l = new List(false,false, 10);
		//
		// l.setListSymbol(new Chunk('*'));
		//
		// l.add(new ListItem("First item of list"));
		//
		// l.add(new ListItem("Second item of list"));
		//
		// section1.add(l);
		//
		// document.add(section1);
		document.close();
		// writer.close();
		// System.out.println(bytes2HexStr(mos.toByteArray()));
		// SyslogOutputStream(mos.toString());
		// save2file(mos.toByteArray(),"d:\\aaa.pdf");
		return mos.toByteArray();
	}

//	public makeExplanation(byte[] ba) {
//		ByteArrayInputStream mis = new ByteArrayInputStream(ba);
//		PdfReader reader = new PdfReader(ba);
//		
//		reader.close();
//}
}
