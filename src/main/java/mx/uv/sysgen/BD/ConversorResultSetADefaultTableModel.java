/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */ 
package mx.uv.sysgen.BD;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis Enrique
 */
public class ConversorResultSetADefaultTableModel {

public static void rellena(ResultSet rs, DefaultTableModel modelo){
   configuraColumnas(rs, modelo);
   vaciaFilasModelo(modelo);
   anhadeFilasDeDatos(rs, modelo);
}

private static void anhadeFilasDeDatos(ResultSet rs, DefaultTableModel modelo){
   int numeroFila = 0;
    try{
    while (rs.next()){
          Object[] datosFila = new Object[modelo.getColumnCount()];
          for (int i = 0; i < modelo.getColumnCount(); i++)
              datosFila[i] = rs.getObject(i + 1);
              modelo.addRow(datosFila);
              numeroFila++;
    }
    rs.close();
    }
    catch (Exception e) {
          e.printStackTrace();
    }
}

private static void vaciaFilasModelo(DefaultTableModel modelo){
   try{
      while (modelo.getRowCount() > 0) {
             modelo.removeRow(0);
      } 
   }
      catch (Exception e){
            e.printStackTrace();
      }
}

public static void configuraColumnas(ResultSet rs, DefaultTableModel modelo){
   try{
       try{
           ResultSetMetaData metaDatos = rs.getMetaData();
           int numeroColumnas = metaDatos.getColumnCount();
           Object[] etiquetas = new Object[numeroColumnas];
           for (int i = 0; i < numeroColumnas; i++){
               etiquetas[i] = metaDatos.getColumnLabel(i + 1);
               modelo.setColumnIdentifiers(etiquetas);
           }
       }catch (Exception e) {
           e.printStackTrace();
       }
   }
   catch (Exception e)
   {
       e.printStackTrace();
   }
}
}

