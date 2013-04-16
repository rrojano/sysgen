package mx.uv.sysgen.BD;

import java.io.FileWriter; 
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;



/**
 *
 * @author Luis Enrique
 */
public class ResultSetToXML {
    public static void main(String args[]) throws Exception {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document doc = builder.newDocument();
    Element results = doc.createElement("Results");
    doc.appendChild(results);
    
    
    
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    Connection con = DriverManager
        .getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=c:/access.mdb");
    
    ResultSet rs = con.createStatement().executeQuery("select * from product");

    ResultSetMetaData rsmd = rs.getMetaData();
    int colCount = rsmd.getColumnCount();

    while (rs.next()) {
      Element row = doc.createElement("Row");
      results.appendChild(row);
      for (int i = 1; i <= colCount; i++) {
        String columnName = rsmd.getColumnName(i);
        Object value = rs.getObject(i);
        Element node = doc.createElement(columnName);
        node.appendChild(doc.createTextNode(value.toString()));
        row.appendChild(node);
      }
    }
    DOMSource domSource = new DOMSource(doc);
    TransformerFactory tf = TransformerFactory.newInstance();
    Transformer transformer = tf.newTransformer();
    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
    transformer.setOutputProperty(OutputKeys.METHOD, "xml");
    transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
    StringWriter sw = new StringWriter();
    StreamResult sr = new StreamResult(sw);
    transformer.transform(domSource, sr);

    System.out.println(sw.toString());

    con.close();
    rs.close();
  }
    
  public  String getDocumentAsXml(Document doc)throws TransformerConfigurationException, TransformerException {
    DOMSource domSource = new DOMSource(doc);
    TransformerFactory tf = TransformerFactory.newInstance();
    Transformer transformer = tf.newTransformer();
    //transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION,"yes");
    transformer.setOutputProperty(OutputKeys.METHOD, "xml");
    transformer.setOutputProperty(OutputKeys.ENCODING,"ISO-8859-1");
    // we want to pretty format the XML output
    // note : this is broken in jdk1.5 beta!
    transformer.setOutputProperty
       ("{http://xml.apache.org/xslt}indent-amount", "4");
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    //
    java.io.StringWriter sw = new java.io.StringWriter();
    StreamResult sr = new StreamResult(sw);
    transformer.transform(domSource, sr);
    return sw.toString();
 }
  
    
  public void crearXML(ResultSet rs) throws Exception{
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document doc = builder.newDocument();
    Element results = doc.createElement("Results");
    doc.appendChild(results);
    
    ResultSetMetaData rsmd = rs.getMetaData();
    int colCount = rsmd.getColumnCount();

    while (rs.next()) {
      Element row = doc.createElement("Row");
      results.appendChild(row);
      for (int i = 1; i <= colCount; i++) {
        String columnName = rsmd.getColumnName(i);
        Object value = rs.getObject(i);
        Element node = doc.createElement(columnName);
        node.appendChild(doc.createTextNode(value.toString()));
        row.appendChild(node);
      }
    }
    DOMSource domSource = new DOMSource(doc);
    TransformerFactory tf = TransformerFactory.newInstance();
    Transformer transformer = tf.newTransformer();
    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
    transformer.setOutputProperty(OutputKeys.METHOD, "xml");
    transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
    StringWriter sw = new StringWriter();
    StreamResult sr = new StreamResult(sw);
    transformer.transform(domSource, sr);

    System.out.println(sw.toString());
    creaArchivoXML(sw.toString());
    //System.out.println(getDocumentAsXml(doc));
    rs.close();
  }  
  
  public void creaArchivoXML (String cad)
    {
        JFileChooser manejadorArchivo = null; 
        if( manejadorArchivo == null ) manejadorArchivo = new JFileChooser();
        manejadorArchivo.setFileSelectionMode( JFileChooser.FILES_ONLY );
        int seleccion = manejadorArchivo.showSaveDialog(null);
        if( seleccion == JFileChooser.APPROVE_OPTION ){
            String ruta = "";
            ruta = manejadorArchivo.getSelectedFile().getAbsolutePath();
            ruta=ruta+".xml";
            FileWriter fichero = null;
            PrintWriter pw = null;
            try
            {
                fichero = new FileWriter(ruta);
                pw = new PrintWriter(fichero);
                pw.print(cad);} catch (Exception e) {
                    e.printStackTrace();
                } finally {
                try {
                    // Nuevamente aprovechamos el finally para 
                    // asegurarnos que se cierra el fichero.
                    if (null != fichero){
                        fichero.close();
                        JOptionPane.showMessageDialog(null, "Creación de archivo XML exitosa en "+ruta);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }   
    }  
}
