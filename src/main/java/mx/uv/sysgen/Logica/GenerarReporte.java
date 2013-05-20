/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uv.sysgen.Logica;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
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
       EjecutarReporte();
    }
    public void EjecutarReporte(){
        BD conexion = new BD();
            /*declaramos una variable conn de tipo Connection a la cual le asignaremos el resultado que nos
             devuelbe el metodo Conectar*/
            Connection conn = conexion.conectar(1); 
             try {
        Map parameters = new HashMap();
       // parameters.put("Nombre","Miguel Angel");
        //parameters.put("Nombre","APaterno");
        JasperDesign jp = JRXmlLoader.load("src/main/java/mx/uv/sysgen/Reportes/ReporteGeneraral.jrxml");
        JasperReport report = JasperCompileManager.compileReport(jp);
      JasperPrint print = JasperFillManager.fillReport(report,parameters,conn);
      // Guarda el Reporte automaticamente en un directorio
      //JasperExportManager.exportReportToPdfFile(print,"C:/temp/ReporteGeneral.pdf");
      //Para visualizar el pdf directamente desde java
      JasperViewer.viewReport(print,true);
      

    }
    catch (Exception e) {
        System.out.println("Error al crear el reporte");
      e.printStackTrace();
    }
        
    }
    
}
