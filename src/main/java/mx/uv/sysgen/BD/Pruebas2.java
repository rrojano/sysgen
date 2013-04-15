/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uv.sysgen.BD;

import java.sql.*;

/**
 *
 * @author Luis Enrique
 */
public class Pruebas2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       /* BD conexion = new BD();
        conexion.conectar(1);
        ResultSet res=conexion.consulta("select * from uno");
         try {
			ResultSetMetaData meta = res.getMetaData();
			//COLUMNAS
			for (int i=1;i<=meta.getColumnCount();i++){
			 System.out.print(meta.getColumnLabel(i));
			 System.out.print(" || ");
			}
			System.out.println("");
			
			while (res.next()){
				for (int i=1;i<=meta.getColumnCount();i++){
					System.out.print(String.valueOf(res.getObject(i)));
					 System.out.print(" || ");
				}
			System.out.println("");				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   */
        FConsultas fc=new FConsultas();
        fc.setVisible(true);
    }
}
