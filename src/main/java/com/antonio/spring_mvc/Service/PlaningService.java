package com.antonio.spring_mvc.Service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class PlaningService {

    public void addText(Document document,String title,Font font,int align,boolean setSpace) throws DocumentException {
        Paragraph paragraph=new Paragraph(title,font);
        paragraph.setAlignment(align);
        if(setSpace)
            paragraph.setSpacingAfter(20);
        document.add(paragraph);
    }

    public void addPlaning_Table(Document document) throws DocumentException {
        float column []= {60f,50f,50f};
        PdfPTable table=  new PdfPTable(column);
        table.setHorizontalAlignment(0);
        table.setSpacingAfter(20);
        PdfPCell cell_11=new PdfPCell(new Phrase("Item"));
        table.addCell(cell_11);

        table.addCell("Qty");
        table.addCell("Available");

        table.addCell("Mango");
        table.addCell("2 kg");
        table.addCell("Yes");

        table.addCell("Orange");
        table.addCell("5 kg");
        table.addCell("No");
        document.add(table);

        createList(document);
    }

    public void createList(Document document) throws DocumentException {
        Font font = new Font(Font.FontFamily.TIMES_ROMAN, 14,
                Font.BOLD);
        addText(document,"Auteurs",font,0 ,false);
        List list = new List(List.ORDERED);
        list.add(new ListItem("First item"));
        list.add(new ListItem("Second item"));
        list.add(new ListItem("Third item"));

        document.add(list);
    }

    public void generatePlaning_PDF(HttpServletResponse response) throws DocumentException, IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, baos);
        document.open();

        Font font = new Font(Font.FontFamily.TIMES_ROMAN, 25,
                Font.BOLD);
        document.addTitle("Planing");

        //Add title
        addText(document,"Planing",font,1,true);

        //Add subtitle
        font = new Font(Font.FontFamily.TIMES_ROMAN, 11);
        addText(document,"Date: 14/03/2023-15/03/2023",font,0,false);
        addText(document,"Scenes: Scene1,scene2,scene3",font,0,true);

        //Add content
        font = new Font(Font.FontFamily.TIMES_ROMAN, 17,Font.UNDERLINE);
        addText(document,"Mardi 14 Mars 2023",font,0,true);

        addPlaning_Table(document);
        document.close();

        // Set the response headers
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=hello.pdf");

        // Send the PDF file to the client
        OutputStream out = response.getOutputStream();
        baos.writeTo(out);
        out.flush();
        out.close();
    }

}
