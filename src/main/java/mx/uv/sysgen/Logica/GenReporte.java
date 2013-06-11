/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uv.sysgen.Logica;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Font;
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

public class GenReporte {
boolean open = false;
List<String>Valores=new ArrayList<String>();/*Lista que guardara el contenido de mi consulta*/
Document document = new Document();
Integer tam;
String tablaSe;

public GenReporte(){
     
 }
 public void GenerarReporte(String TituloR,List<String> ids,String tabla) {
   tablaSe=tabla;
    try {
     // Document document = new Document();
      PdfWriter.getInstance(document, new FileOutputStream("temporal.pdf"));//crea el documento
      document.open();//abrimos el documento
      document.add(new Paragraph(TituloR,FontFactory.getFont("arial",22,Chunk.ALIGN_CENTER)));/*ponemos el titulo al documento*/
      Encabezados(ids,document); /*llenamos el documento*/
      verCampos();
      verPdf();/*visualizamos directamente el documento*/
      document.close();/*cerramos el documento*/
  
    } catch (Exception e) {
      e.printStackTrace();
    }
    }

  public void Encabezados(List<String>ids,Document document) throws DocumentException{

           DefaultListModel model = new DefaultListModel(); 
            tam=ids.size();
     for( int i=0; i < ids.size(); i++ ) {
              model.addElement(ids.get(i));
            try {
                document.add(new Phrase(ids.get(i)+"      "));
                
            } catch (DocumentException ex) {
                Logger.getLogger(GenReporte.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
     System.out.print(tam);    
     for (int i=1;i<=tam;i++){
     Contenido(i);
     
     }
  }
  public void Contenido(int i) throws DocumentException {
             
         try {
            BD conexion=new BD();     
            Connection conn  = conexion.conectar(1); 
            
            java.sql.Statement st =  conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT"+" "+" * "+" "+"FROM"+" "+tablaSe); 
        while (rs.next())
        {        
           Valores.add(rs.getString(i));
        }
        } catch (SQLException ex) {
            Logger.getLogger(GenReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
       
           DefaultListModel model = new DefaultListModel(); 
           PdfPTable Tabla=new PdfPTable(tam);
           //Integer tam=Valores.size();
          
            for( int j=0; j < Valores.size(); j++ ) {
                    // model.addElement(Valores.get(j));
                    //document.add(new Paragraph(Valores.get(j)+"      "));  /* para agregar texto por parrafo*/
                     Tabla.addCell(new Paragraph(Valores.get(j)+"\n")); /*para agregar una tabla y dentro de las celda agregar las datos*/
              }
            document.add(Tabla);
      Valores.clear();//limpio la lista
      
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
     File path =new File("temporal.pdf");
     Desktop.getDesktop().open(path);
}catch (IOException ex) {
     ex.printStackTrace();
}
  }
 
}
