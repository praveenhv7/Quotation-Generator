package com.arbutus.service;

import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import com.arbutus.Quotation.QuotationInputs;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class QuotationPDF {
	String realPath;
	String imageFirst;
	String imageSecond;
	
	public QuotationPDF(String path) {
		// TODO Auto-generated constructor stub
	
	
		realPath=path+"\\Calibri.ttf";
		imageFirst=path+"\\Arbutus_logo.jpg";
		imageSecond=path+"\\Arbutus.jpg";
		
	
	} 
	
	
public  void createPDF(QuotationInputs qtnInputs) {
		
	System.out.println(qtnInputs.getOrderItems().size());
		
	
		Document document = new Document();
		
        Font font= FontFactory.getFont(realPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 11f, Font.NORMAL, BaseColor.BLACK);
        Font font3= FontFactory.getFont(realPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 11f, Font.BOLD, BaseColor.BLACK);
        
	    try {
	        PdfWriter.getInstance(document,
	                new FileOutputStream("E://Stock n quotation//Quotation"+qtnInputs.getQtnNo()+".pdf"));
	        document.open();
            
	        Font font1 = new Font(Font.FontFamily.TIMES_ROMAN  , 18, Font.BOLD);
	        Font font2 = new Font(Font.FontFamily.TIMES_ROMAN);
	        
	        
	        /**
	         * Adding image ARBUTUS in PDF
	         * Author Praveen
	         */
//	        URL url=new URL("http://localhost:8082/Arbutus/PdfRelated/Arbutus.jpg");
	        Image image1 = Image.getInstance(imageSecond);
	        image1.scaleAbsolute(500f,100f);
	        PdfPTable table1=new PdfPTable(1);
	        table1.setWidthPercentage(100);
	        PdfPCell cell=new PdfPCell(image1);
	        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell.setBorderColor(BaseColor.WHITE);
	        table1.setHorizontalAlignment(Element.ALIGN_LEFT);
	        table1.addCell(cell);
	        document.add(table1);
	        // End of Image code
	        
	        
	       /**
	        * Adding TItle Quotation
	        * Author : Praveen     	        
	        */
	        PdfPTable table = new PdfPTable(3); // 3 columns.
	        table.setWidthPercentage(100);
            PdfPCell cell1 = new PdfPCell(new Paragraph("QUOTATION",font1));
            cell1.setColspan(3);
            cell1.setBorderColor(BaseColor.WHITE); 
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table1.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell1);
            document.add(table);
            
            //End of title
            
            
            /**
             * Adding address details
             */
            PdfPTable table2=new PdfPTable(5);
            table2.setWidthPercentage(100);
            PdfPCell cell_t2_1 =new PdfPCell(new Paragraph(qtnInputs.getAddress(),font));
            PdfPCell cell_t2_3=new PdfPCell(new Paragraph(""));
            PdfPCell cell_t2_4=new PdfPCell(new Paragraph(""));
            
            PdfPTable tableNested=new PdfPTable(2);
            PdfPCell cellNes1=new PdfPCell(new Paragraph("Qtn Num:\nDate:",font));
            PdfPCell cellNes2=new PdfPCell(new Paragraph(qtnInputs.getQtnNo()+"\n"+qtnInputs.getDate(),font));
            cellNes1.setBorderColor(BaseColor.WHITE);
            cellNes2.setBorderColor(BaseColor.WHITE);
            tableNested.addCell(cellNes1);
            tableNested.addCell(cellNes2);
            cell_t2_4.addElement(tableNested);
            cell_t2_1.setColspan(2);
            cell_t2_4.setColspan(2);
            cell_t2_1.setBorderColor(BaseColor.WHITE);            
            cell_t2_3.setBorderColor(BaseColor.WHITE);
            cell_t2_4.setBorderColor(BaseColor.WHITE);
            table2.addCell(cell_t2_1);
//            table2.addCell(cell_t2_2);
            table2.addCell(cell_t2_3);
            table2.addCell(cell_t2_4);
            table2.setSpacingBefore(35f);
            table2.setHorizontalAlignment(Element.ALIGN_LEFT);
            document.add(table2);
            //End of address and other part
            
            /**
             * Adding cutomer name
             */
            
            PdfPTable table3 = new PdfPTable(2);
            table3.setWidthPercentage(30);
            table3.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell cell_T3_1=new PdfPCell(new Paragraph("Kind Attn :",font));
            PdfPCell cell_T3_2=new PdfPCell(new Paragraph(qtnInputs.getName(),font));
            cell_T3_1.setBorderColor(BaseColor.WHITE);
            cell_T3_2.setBorderColor(BaseColor.WHITE);
            
            table3.addCell(cell_T3_1);
            table3.addCell(cell_T3_2);
            table3.setSpacingBefore(15f);
            document.add(table3);
            //end
            
            /**
             * 
             */
            
            PdfPTable table4 = new PdfPTable(2);
            float[] columnWidths = {.35f, 2f};
            table4.setWidths(columnWidths);
            table4.setWidthPercentage(100);
            table4.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell cell_T4_1=new PdfPCell(new Paragraph("Subject :",font));
            PdfPCell cell_T4_2=new PdfPCell(new Paragraph(qtnInputs.getSubject(),font));
            cell_T4_1.setBorderColor(BaseColor.WHITE);
            cell_T4_2.setBorderColor(BaseColor.WHITE);
            
            table4.addCell(cell_T4_1);
            table4.addCell(cell_T4_2);
            table4.setSpacingBefore(15f);
            document.add(table4);
            
            /**
             * 
             */
            
            PdfPTable table5 = new PdfPTable(2);
            table5.setWidths(columnWidths);
            table5.setWidthPercentage(100);
            table5.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell cell_T5_1=new PdfPCell(new Paragraph("Refernece :",font));
            PdfPCell cell_T5_2=new PdfPCell(new Paragraph(qtnInputs.getReference(),font));
            cell_T5_1.setBorderColor(BaseColor.WHITE);
            cell_T5_2.setBorderColor(BaseColor.WHITE);
            table5.addCell(cell_T5_1);
            table5.addCell(cell_T5_2);
            table5.setSpacingBefore(15f);
            document.add(table5);
            //End
            
            /**
             * 
             */
            Paragraph para=new Paragraph();
            Chunk data=new Chunk("Dear Sir / Madam,",font); 
            para.add(data);
            para.setAlignment(Element.ALIGN_LEFT);
            para.setFont(font);
            para.setSpacingBefore(10f);
            document.add(para);
            //end
            
            
            /**
             * 
             */
            String text="We acknowldege with thanks in receipt of your above mentioned Enquiry. Further to the same, we are pleased to offer our best price and delivery as per the annexure:";
            Paragraph para1=new Paragraph();
            Chunk data1=new Chunk(text,font); 
            para1.add(data1);
            para1.setAlignment(Element.ALIGN_LEFT);
            para1.setFont(font);
            para1.setSpacingBefore(10f);
            document.add(para1);
            //end
            
            /**
             * 
             */
            PdfPTable table6 = new PdfPTable(2);
            float[] columnWidths1 = {.55f, 2f};
            table6.setWidths(columnWidths1);
            table6.setWidthPercentage(100);
            table6.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell cell_T6_1=new PdfPCell(new Paragraph("Terms and Conditions",font3));
//            PdfPCell cell_T6_2=new PdfPCell(new Paragraph("Our Discussion ",font));
            cell_T6_1.setColspan(2);
//            cell_T6_1.setBorderColor(BaseColor.WHITE);
//            cell_T6_2.setBorderColor(BaseColor.WHITE);
            table6.addCell(cell_T6_1);
//            table6.addCell(cell_T6_2);
            table6.setSpacingBefore(12f);
            document.add(table6);
            
            PdfPTable table7 =createTable("1. PRICE", qtnInputs.getPrice().toString());
            document.add(table7);
            
            PdfPTable table8= createTable("2. SALES TAX","VAT "+qtnInputs.getSalesTax().toString()+"% Extra" );
            document.add(table8);
            
            
            PdfPTable table9=createTable("3. PAYMENT",qtnInputs.getPayment().toString()+"% Advance");
            document.add(table9);
            
            
            PdfPTable table10=createTable("4. FREIGHT CHARGES",qtnInputs.getFreightCharges());
            document.add(table10);
            
            PdfPTable table11=createTable("5. VALIDITY",qtnInputs.getValidity());
            document.add(table11);
            
            PdfPTable table12=createTable("6. NOTE",qtnInputs.getNote());
            document.add(table12);
            
            PdfPTable table13=createTable("7. REMARKS",qtnInputs.getRemarks());
            document.add(table13);
            
            Paragraph para2=createParagraph("We trust our enclosed offer is in the line with your requirment and look Forward your Valued order at the earliest.",10f);
            document.add(para2);
            
            para2=createParagraph("Thanking you and assuring you of our best services.",10f);
            document.add(para2);
            
            para2=createParagraph("Yours Sincerely\nFor ARBUTUS Technologies",25f);
            document.add(para2);
            
            
            para2=createParagraph("Kishore",35f);
            document.add(para2);
            
            
            boolean val=createPage(document,qtnInputs);
            System.out.println(val);
            
            /**
             * 
             */
            
            /*
            table = new PdfPTable(3); // 3 columns.
	        table.setWidthPercentage(100);
            cell1 = new PdfPCell(new Paragraph("ANNEXURE",font1));
            cell1.setColspan(3);
            cell1.setBorderColor(BaseColor.WHITE); 
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table1.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell1);
            table.setSpacingAfter(20f);
            document.add(table);*/
            //end
            
            /**
             * 
             */
            int size=qtnInputs.getOrderItems().size()+1;
            Integer slNum=new Integer(1);
            String[][] text_str=new String[size][9];
            text_str[0][0]="SL No";
            text_str[0][1]="Part No";
            text_str[0][2]="Description";
            text_str[0][3]="Make";
            text_str[0][4]="Qty";
            text_str[0][5]="MOQ";
            text_str[0][6]="SPQ";
            text_str[0][7]="Lead time";
            text_str[0][8]="Unit Price";
            
            //SL No Part No Description Make Qty MOQ SPQ Lead time Unit Price
            
            for(int i=1;i<=qtnInputs.getOrderItems().size();i++)
            {
            	
            	Integer slNumber=i;
            		text_str[i][0]=slNumber.toString();
            		text_str[i][1]=qtnInputs.getOrderItems().get(i-1).getPartNo();
            		text_str[i][2]=qtnInputs.getOrderItems().get(i-1).getDescription();
            		text_str[i][3]=qtnInputs.getOrderItems().get(i-1).getMake();
            		text_str[i][4]=qtnInputs.getOrderItems().get(i-1).getQty().toString();
            		text_str[i][5]=qtnInputs.getOrderItems().get(i-1).getMoq().toString();
            		text_str[i][6]=qtnInputs.getOrderItems().get(i-1).getSpq().toString();
            		text_str[i][7]=qtnInputs.getOrderItems().get(i-1).getLeadtime();
            		text_str[i][8]=qtnInputs.getOrderItems().get(i-1).getUnitPrice().toString();
            	
            	
            }
            System.out.println(text_str[0][1]);
            createTable(qtnInputs.getOrderItems().size(), text_str, document);
            
            
	        document.close();
	    } catch(Exception e){
	      e.printStackTrace();
	    }
	  }
	
	
	 public PdfPTable createTable(String text1,String text2)
	 {
		 Font font= FontFactory.getFont(realPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 11f, Font.NORMAL, BaseColor.BLACK);
		 Font font2= FontFactory.getFont(realPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 11f, Font.BOLD, BaseColor.BLACK);
		 float[] columnWidths1 = {.55f, 2f};
		 
		 try{
		 PdfPTable table = new PdfPTable(2);
         table.setWidths(columnWidths1);
         table.setWidthPercentage(100);
         table.setHorizontalAlignment(Element.ALIGN_LEFT);
         PdfPCell cell_T7_1=new PdfPCell(new Paragraph(text1,font2));
         PdfPCell cell_T7_2=new PdfPCell(new Paragraph(text2,font));
//         cell_T7_1.setBorderColor(BaseColor.WHITE);
//         cell_T7_2.setBorderColor(BaseColor.WHITE);
         table.addCell(cell_T7_1);
         table.addCell(cell_T7_2);
         	 
		 return table;
		 }
		 catch(Exception e){
		      e.printStackTrace();
		    }
		return null;
		 
	 }
	 
	 
	 public Paragraph createParagraph(String text,float value)
	 {
		 Font font= FontFactory.getFont(realPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 11f, Font.NORMAL, BaseColor.BLACK);
		 
		 Paragraph para1=new Paragraph();
         Chunk data1=new Chunk(text,font); 
         para1.add(data1);
         para1.setAlignment(Element.ALIGN_LEFT);
         para1.setFont(font);
         para1.setSpacingBefore(value);
         return para1;
	 }
	 
	 
	 public boolean createPage(Document document,QuotationInputs qtnInputs)
	 {
		 Font font4= FontFactory.getFont(realPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 24f, Font.BOLD, BaseColor.BLUE);
		 Font font= FontFactory.getFont(realPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 11f, Font.NORMAL, BaseColor.BLACK);
		 Font font1 = new Font(Font.FontFamily.TIMES_ROMAN  , 18, Font.BOLD);
		 
		 boolean val=document.newPage();
         System.out.println(val);
         
         try{
         float[] columnWidthsN = {.55f, 2f};
//         URL url=new URL("http://localhost:8082/Arbutus/PdfRelated/Arbutus_logo.jpg");
         Image image2 = Image.getInstance(imageFirst);
//	        image1.scaleAbsolute(100f,100f);
	        PdfPTable table1N=new PdfPTable(2);
	        table1N.setWidthPercentage(100);
	        table1N.setWidths(columnWidthsN);
	        PdfPCell cellN=new PdfPCell(image2);
	        PdfPCell cellN2=new PdfPCell(new Paragraph("ARBUTUS Technologies",font4));
	        cellN.setHorizontalAlignment(Element.ALIGN_RIGHT);
	        cellN.setBorderColor(BaseColor.WHITE);
	        cellN2.setHorizontalAlignment(Element.ALIGN_LEFT);
	        cellN2.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        cellN2.setBorderColor(BaseColor.WHITE);
	        
	        table1N.setHorizontalAlignment(Element.ALIGN_LEFT);
	        table1N.addCell(cellN);
	        table1N.addCell(cellN2);
	        document.add(table1N);
	        
	        float[] columnWidthsN2 = {1f, 1f};
	        PdfPTable table2N=new PdfPTable(2);
	        table2N.setWidthPercentage(30);
	        table2N.setWidths(columnWidthsN2);
	        
	        PdfPCell cellN3=new PdfPCell(new Paragraph("Qtn Num:\nDate:",font));
	        PdfPCell cellN4=new PdfPCell(new Paragraph(qtnInputs.getQtnNo()+"\n"+qtnInputs.getDate(),font));
	        cellN3.setHorizontalAlignment(Element.ALIGN_LEFT);
	        cellN3.setBorderColor(BaseColor.WHITE);
	        cellN4.setHorizontalAlignment(Element.ALIGN_LEFT);
	        cellN4.setBorderColor(BaseColor.WHITE);
	        
	        table2N.setHorizontalAlignment(Element.ALIGN_RIGHT);
	        table2N.addCell(cellN3);
	        table2N.addCell(cellN4);
	        document.add(table2N);
	        
           PdfPTable table = new PdfPTable(3); // 3 columns.
	        table.setWidthPercentage(100);
            PdfPCell cell1 = new PdfPCell(new Paragraph("ANNEXURE",font1));
            cell1.setColspan(3);
            cell1.setBorderColor(BaseColor.WHITE); 
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
//            table.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell1);
            table.setSpacingAfter(20f);
            document.add(table);
	        
	        
	        
	        
	        
         }
         catch(Exception e){
		      e.printStackTrace();
		    }
		return val;
		 
	 }
	 
	 
	 public Document createTable(int size,String[][] text_str,Document doc)
	 {
		 Font font= FontFactory.getFont(realPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 11f, Font.NORMAL, BaseColor.BLACK);
		 Font font2= FontFactory.getFont(realPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 11f, Font.BOLD, BaseColor.BLACK);
		 
		 float[] columnWidths1 = {.7f, 1.5f,1.5f,1.5f,.7f,.7f,.7f,1.5f,1f};
		
		 try{
			 System.out.println("function called");
			 
			 for(int i=0;i<size+1;i++)
			 {
				 PdfPTable table1 = new PdfPTable(9);
				 table1.setWidths(columnWidths1);
				 table1.setWidthPercentage(100);
				 table1.setHorizontalAlignment(Element.ALIGN_LEFT);
				 System.out.println(text_str[0][1]);
				 
				 for(int j=0;j<9;j++)
				 {
				 PdfPCell cell_T7_2=new PdfPCell(new Paragraph(text_str[i][j],font));
				 cell_T7_2.setBorderColor(BaseColor.LIGHT_GRAY);
				 table1.addCell(cell_T7_2);
				 
				 }
				
				 
				doc.add(table1);
			 }
			 
				 
			
			 
			 Paragraph para2=createParagraph("For ARBUTUS Technologies",25f);
	            doc.add(para2);
	            
	            
	            para2=createParagraph("Kishore",35f);
	            doc.add(para2);
         
         
         
         
		 }
		 catch(Exception e){
		      e.printStackTrace();
		    }
		return doc;
		 
	 }
	 
	 

}
	