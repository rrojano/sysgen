/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uv.sysgen.Logica;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.Font;
import java.awt.Color;
import java.util.Date;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import mx.uv.sysgen.BD.BD;
import java.text.SimpleDateFormat;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;

public class GenReporte2 {
boolean open = false;
List<String>Valores=new ArrayList<String>();/*Lista que guardara el contenido de mi consulta*/
Date F=new Date();
SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy"); 
Document document = new Document();
Integer tam;
String tablaSe,nom;

public GenReporte2(){
  
 }

 public void GenerarReporte(String TituloR,List<String> ids,String tabla) {
   tablaSe=tabla;
    try {
        nom=TituloR;
      PdfWriter.getInstance(document, new FileOutputStream("src/main/java/mx/uv/sysgen/Reportes/"+nom+".pdf"));//crea el documento
      document.open();//abrimos el documento
      Paragraph Titulo= new Paragraph(TituloR,FontFactory.getFont("arial",20,Color.BLUE));/*ponemos el titulo al documento*/
      Titulo.setAlignment(1);
      document.add(Titulo);
      document.add(new Paragraph("\n"));
      Encabezados(ids); /*llenamos el documento*/
      Contenido(ids);
      document.add(new Paragraph("\n"));
      document.add(new Paragraph("Fecha de creación" + sdf.format(F)));
      String usuario=System.getProperty("user.name");
      document.add(new Paragraph("Creado por el Usuario"+" "+usuario));/*Agregamos el usuario actual al docmuento*/
      verCampos();
      verPdf();/*visualizamos directamente el documento*/
      document.close();/*cerramos el documento*/
  
    } catch (Exception e) {
      e.printStackTrace();
       JOptionPane.showMessageDialog(null,"El sistemo no tiene acceso al archivo porque está siendo utilizado por otro proceso");
    }
    }

  public void Encabezados(List<String>ids) throws DocumentException{
     DefaultListModel model = new DefaultListModel(); 
           tam=ids.size();
           PdfPTable Tabla=new PdfPTable(tam);
           PdfPCell cell = new PdfPCell();
     for( int i=0; i < ids.size(); i++ ) {
              model.addElement(ids.get(i));
            cell = new PdfPCell(new Paragraph((ids.get(i))));
            cell.setBackgroundColor(Color.getHSBColor(224,238,238));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            Tabla.addCell(cell);
        }
     document.add(Tabla);
  }
  public void Contenido(List<String>ids) throws DocumentException {
          DefaultListModel model = new DefaultListModel(); 
            PdfPTable Tabla=new PdfPTable(tam);
            PdfPCell cell = new PdfPCell(); 
         try {
             Configuración config=new Configuración();
             config=config.abrirArchivo();
            BD conexion=new BD();     
            conexion.configuraBD(config.getUsuario(), config.getContraseña(), config.getEsquema(), config.getManejador());
            ResultSet rs=conexion.consulta("SELECT"+" "+" * "+" "+"FROM"+" "+tablaSe);            
        while (rs.next())
        {        
           for(int i=0; i< ids.size();i++){
            model.addElement(ids.get(i));
            cell = new PdfPCell(new Paragraph((rs.getString(ids.get(i)))));
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            Tabla.addCell(cell);
        }
       }
        } catch (SQLException ex) {
            Logger.getLogger(GenReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
         document.add(Tabla);   
         ids.clear();           
 }         
public void verCampos(){
        DefaultListModel model = new DefaultListModel(); 
     for( int i=0; i < Valores.size(); i++ ) {
              model.addElement(Valores.get(i));        
                      System.out.println("Campos"+" "+Valores.get(i)); 
                                           
   }

  }
  /*Metodo que utilizo para abrir directamente el archivo acabe de crear*/
  public void verPdf(){
    try {
     File path =new File("src/main/java/mx/uv/sysgen/Reportes/"+nom+".pdf");
     Desktop.getDesktop().open(path);
     open = true;
}catch (IOException ex) {
     ex.printStackTrace();
      JOptionPane.showMessageDialog(null,"El sistemo no en cuentra el Archivo...");
}
}
}
