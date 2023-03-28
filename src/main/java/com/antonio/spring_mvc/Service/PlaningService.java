package com.antonio.spring_mvc.Service;

import com.antonio.spring_mvc.model.Acteur;
import com.antonio.spring_mvc.model.Auteur;
import com.antonio.spring_mvc.model.Planning;
import com.antonio.spring_mvc.model.Plateau;
import com.antonio.spring_mvc.planning.PlanningDetails;
import com.antonio.spring_mvc.planning.SuggestPlanning;
import com.itextpdf.layout.element.Table;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class PlaningService {

    public void addText(Document document,String title,Font font,int align,boolean setSpace) throws DocumentException {
        Paragraph paragraph=new Paragraph(title,font);
        paragraph.setAlignment(align);
        if(setSpace)
            paragraph.setSpacingAfter(20);
        document.add(paragraph);
    }

    public void addPlaning_Table(SuggestPlanning planning, PdfPTable table) throws DocumentException {
        for(PlanningDetails planningDetails : planning.getPlanningDetails()){
            table.addCell(planningDetails.getFirstHour().toString());
            table.addCell(planningDetails.getLastHour().toString());

            table.addCell(planningDetails.getAct().getScene_id().getPlateau().getLocation());

            table.addCell(planningDetails.getAct().getActtype_id().getTypename());
            table.addCell(planningDetails.getAct().getAction());
            table.addCell(planningDetails.getAct().getActeur_id().getNom_acteur());

            table.addCell(planningDetails.getAct().getEmotion_id().getEmotionname());
            table.addCell(planningDetails.getAct().getScene_id().getDescription());
            table.addCell(planningDetails.getAct().getScene_id().getFilm().getDescription());
        }
    }


    public void addAuteurs(List<Acteur> acteurs,Document document) throws DocumentException {
        Font font = new Font(Font.FontFamily.TIMES_ROMAN, 14,
                Font.BOLD);
        addText(document,"Auteurs",font,0 ,false);
        com.itextpdf.text.List list = new com.itextpdf.text.List(com.itextpdf.text.List.ORDERED);
        for(Acteur acteur : acteurs){
            list.add(new ListItem(acteur.getNom_acteur()));
        }
        document.add(list);
    }

    public void addPlateaux( List<Plateau> plateaux,Document document) throws DocumentException {
        Font font = new Font(Font.FontFamily.TIMES_ROMAN, 14,
                Font.BOLD);
        addText(document,"Plateaux",font,0 ,false);
        com.itextpdf.text.List list = new com.itextpdf.text.List(com.itextpdf.text.List.ORDERED);
        for(Plateau plateau : plateaux){
            list.add(new ListItem(plateau.getLocation()));
        }
        document.add(list);
    }

    public void generatePlaning_PDF(HttpServletResponse response,List<SuggestPlanning> planning,List<Acteur> acteurs, List<Plateau> plateaux) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=Planing.pdf");

        OutputStream out = response.getOutputStream();
        try{
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
            addText(document,"Du : "+planning.get(0).getDate()+" au "+planning.get(planning.size()-1).getDate(),font,0,false);

            //Add acteur
            addAuteurs(acteurs,document);
            addPlateaux(plateaux,document);

            //Add content
            for(SuggestPlanning plannings : planning){
                font = new Font(Font.FontFamily.TIMES_ROMAN, 17,Font.UNDERLINE);
                addText(document,plannings.getDate().toString(),font,0,true);


                String[] headers={"Debut","Fin","Plateau","Categorie action","Action","Personnage","Emotion","Scene","Film"};
                PdfPTable table=  new PdfPTable(9);
                table.setWidthPercentage(100f);
                table.setHorizontalAlignment(0);
                table.setSpacingAfter(20);

                for(int i=0;i<headers.length;i++)
                    table.addCell(headers[i]);

                addPlaning_Table(plannings,table);
                document.add(table);
            }
            document.close();
            baos.writeTo(out);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            out.flush();
            out.close();
        }
    }
}
