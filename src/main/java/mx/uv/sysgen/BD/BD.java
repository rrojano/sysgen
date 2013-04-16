/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uv.sysgen.BD;

/**
 *
 * @author Luis Enrique
 */

import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.Driver;
public class BD {
public String bd = "algo";//nombre_bd
public String login = "root";//usuario
public String password = "Gamblert77";//contraseña
public String url = "jdbc:mysql://localhost/"+bd;
public int manejador = 1; //MySQL
                      // = 2; //Oracle
                      // = 3; //el otro
Connection conexion = null;


public void conectar(int i) {

try {
  manejador=i;
  if (manejador==1){//MySQL
  Class.forName("com.mysql.jdbc.Driver");  
  conexion = DriverManager.getConnection(url, login, password);}
  else if (manejador==2){//Oracle
  //DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
    //conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:", "PROYECTOBD", password);
  }
  else if (manejador==3){
      //IMPLEMENTAR OTRO
  }
  
  if (conexion != null){
      System.out.println("Conexión a base de datos "+url+" ... Ok");
      mostrarMensaje("Conexión a base de datos "+url+" ... Ok");
      //conexion.close();
      }
  }
  catch(SQLException ex) {
        System.out.println("Hubo un problema al intentar conectarse con la base de datos "+url);
        mostrarMensaje("Hubo un problema al intentar conectarse con la base de datos "+url);
  }
  catch(ClassNotFoundException ex) {
        System.out.println(ex);
        mostrarMensaje(ex.getMessage());
        }
}

public void desconectar(){
    try
    {
      this.conexion.close();
    }
    catch (Exception e) {
    	mostrarMensaje("error al cerrar la conexión");
    }
}

public void insertar(String a) {
      try {
        Statement s = this.conexion.createStatement();
        String sql = a;
        s.executeUpdate(sql);
      }
      catch (Exception e) {
    	  mostrarMensaje("error en la inserción");
        }
}

public ResultSet consulta(String a){
     ResultSet rs = null;
     try
     {
         Statement s = conexion.createStatement(); 
        //String b = "select * from " + a + cond;
        
        System.out.println(a);
        rs = s.executeQuery(a);
     }
     catch (Exception e)
     {
         //String b;
         e.printStackTrace();
        // b = e.getMessage();
    	 mostrarMensaje("Error en la sintaxis de la consulta");
     }
     return rs;
}
public void mostrarMensaje(String mensaje) {
    JOptionPane.showMessageDialog(null, mensaje, "Advertencia",JOptionPane.WARNING_MESSAGE);
 }
}