/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uv.sysgen.Logica;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import mx.uv.sysgen.BD.BD;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import sun.jdbc.odbc.ee.DataSource;


/**
 *
 * @author clemente
 */

public class GenerarReporte {
    
    public GenerarReporte(){
 
    }
    /* Método que se utiliza para Compilar y visualizar el archivo jrxml (reporte)*/
    
    public void EjecutarReporte( List<String> ids,String TituloR){
        BD conexion = new BD();
            /*declaramos una variable conn de tipo Connection a la cual le asignaremos el resultado que nos
             devuelbe el metodo Conectar*/
            Connection conn = conexion.conectar(1);            
             try {
        Map parameters = new HashMap();
       parameters.put("Titulo",TituloR); 
       
        /*con esta linea de codigo cargamos el archivo.jrxml */      
          JasperDesign jp = JRXmlLoader.load("src/main/java/mx/uv/sysgen/Reportes/ReporteGeneral.jrxml");
        // jp.getTitle().getElementByKey(TituloR);
        /* compilamos el archivo jrxml y despues de compilarlo se jenera el archivo .jasper*/
        JasperReport report = JasperCompileManager.compileReport(jp);       
       /*después de haber cargado y compilado el archivo jrxml, pocederemos a llenar el reporte con los datos en donde
        report es el archivo .jrxml, en el parametro null van los nombres de los atributos que quieres  que a parescan en el
        reporte y el parametro conn en nustra conexin a la Base de Datos*/
         
      JasperPrint print = JasperFillManager.fillReport(report,parameters,conn);
      /*Con la siguente linea de código Visualizaremos el reporte en una pequeña interfaz, esta interfaz  te permite 
       guardar el reporte en diferentes formatos (pdf, docx, html, rtf, odt, xls) ademas te permite mandar a imprimir el reporte. */
      JasperViewer.viewReport(print,false);
    
     

    }
    catch (Exception e) {
        //System.out.println("Error al crear el reporte");
        JOptionPane.showMessageDialog(null,"No se puede crear el reporte, porque el sistema "
                + "no encuentra la ruta donde se encuentra el Archivo.jrxml ","ERROR",JOptionPane.ERROR_MESSAGE);        
     e.printStackTrace();
    }
      
    }
    
}
